package com.c7n.jwt;

import lombok.extern.log4j.Log4j2;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.*;
import org.jose4j.lang.JoseException;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

/**
 * JSON Web Token is a compact URL-safe means of representing claims/attributes to be transferred between two parties.
 * This example demonstrates producing and consuming a signed JWT
 */
@Log4j2
public class JwtCodeExample {

    private RsaJsonWebKey rsaJsonWebKey;

    public JwtCodeExample() {
        try {
            // Generate an RSA key pair, which will be used for signing and verification of the JWT, wrapped in a JWK
            rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
            // Give the JWK a Key ID (kid), which is just the polite thing to do
            rsaJsonWebKey.setKeyId("k1");
        } catch (JoseException e) {
            log.error("生成key失败");
            e.printStackTrace();
        }
    }

    public String generateJwt() throws JoseException {
        // Create the Claims, which will be the content of the JWT
        JwtClaims claims = new JwtClaims();
        claims.setIssuer("Issuer");  // who creates the token and signs it
        claims.setAudience("Audience"); // to whom the token is intended to be sent
        claims.setExpirationTimeMinutesInTheFuture(10); // time when the token will expire (10 minutes from now)
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setNotBeforeMinutesInThePast(2); // time before which the token is not yet valid (2 minutes ago)
        claims.setSubject("subject"); // the subject/principal is whom the token is about
        claims.setClaim("email", "mail@example.com"); // additional claims/attributes about the subject can be added
        List<String> groups = Arrays.asList("group-one", "other-group", "group-three");
        claims.setStringListClaim("groups", groups); // multi-valued claims work too and will end up as a JSON array

        // A JWT is a JWS and/or a JWE with JSON claims as the payload.
        // In this example it is a JWS so we create a JsonWebSignature object.
        JsonWebSignature jws = new JsonWebSignature();

        // The payload of the JWS is JSON content of the JWT Claims
        jws.setPayload(claims.toJson());

        // The JWT is signed using the private key
        jws.setKey(rsaJsonWebKey.getPrivateKey());

        // Set the Key ID (kid) header because it's just the polite thing to do.
        // We only have one key in this example but a using a Key ID helps
        // facilitate a smooth key rollover process
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());

        // Set the signature algorithm on the JWT/JWS that will integrity protect the claims
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        // Sign the JWS and produce the compact serialization or the complete JWT/JWS
        // representation, which is a string consisting of three dot ('.') separated
        // base64url-encoded parts in the form Header.Payload.Signature
        // If you wanted to encrypt it, you can simply set this jwt as the payload
        // of a JsonWebEncryption object and set the cty (Content Type) header to "jwt".
        String jwt = jws.getCompactSerialization();

        // Now you can do something with the JWT. Like send it to some other party
        // over the clouds and through the interwebs.
        log.info("Generate JWT: " + jwt);
        return jwt;
    }

    public void consumeJwt(String jwt) throws MalformedClaimException {
        // Use JwtConsumerBuilder to construct an appropriate JwtConsumer, which will
        // be used to validate and process the JWT.
        // The specific validation requirements for a JWT are context dependent, however,
        // it typically advisable to require a (reasonable) expiration time, a trusted issuer, and
        // and audience that identifies your system as the intended recipient.
        // If the JWT is encrypted too, you need only provide a decryption key or
        // decryption key resolver to the builder.
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() // the JWT must have an expiration time
                .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
                .setRequireSubject() // the JWT must have a subject claim
                .setExpectedIssuer("Issuer") // whom the JWT needs to have been issued by
                .setExpectedAudience("Audience") // to whom the JWT is intended for
                .setVerificationKey(rsaJsonWebKey.getKey()) // verify the signature with the public key
                .setJwsAlgorithmConstraints( // only allow the expected signature algorithm(s) in the given context
                        AlgorithmConstraints.ConstraintType.WHITELIST, AlgorithmIdentifiers.RSA_USING_SHA256) // which is only RS256 here
                .build(); // create the JwtConsumer instance

        try {
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            log.info("JWT validation succeeded! " + jwtClaims);
        } catch (InvalidJwtException e) {
            // InvalidJwtException will be thrown, if the JWT failed processing or validation in anyway.
            // Hopefully with meaningful explanations(s) about what went wrong.
            log.info("Invalid JWT! " + e);

            // Programmatic access to (some) specific reasons for JWT invalidity is also possible
            // should you want different error handling behavior for certain conditions.

            // Whether or not the JWT has expired being one common reason for invalidity
            if (e.hasExpired()) {
                log.info("JWT expired at " + e.getJwtContext().getJwtClaims().getExpirationTime());
            }

            // Or maybe the audience was invalid
            if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID)) {
                log.info("JWT had wrong audience: " + e.getJwtContext().getJwtClaims().getAudience());
            }
        }
    }

    /**
     * In some cases you won't have enough information to set up your JWT consumer without cracking open
     * the JWT first. For example, in some contexts you might not know who issued the token without looking
     * at the "iss" claim inside the JWT.
     * This can be done efficiently and relatively easily using two JwtConsumers in a "two-pass" validation
     * of sorts - the first JwtConsumer parses the JWT and the second one does the actual validation.
     * @param jwt String
     */
    public void twoPassConsumeJwt(String jwt) throws Exception {
        // Build a JwtConsumer that doesn't check signatures or do any validation
        JwtConsumer firstPassJwtConsumer = new JwtConsumerBuilder()
                .setSkipAllValidators()
                .setDisableRequireSignature()
                .setSkipSignatureVerification()
                .build();

        // The first JwtConsumer is basically just used to parse the JWT into a JwtContext object.
        JwtContext jwtContext = firstPassJwtConsumer.process(jwt);

        // From the JwtContext we can get the issuer, or whatever else we might need,
        // to lookup or figure out the kind of validation policy to apply
        String issuer = jwtContext.getJwtClaims().getIssuer();

        // Just using the same key here but you might, for example, have a JWKS URIs configured for
        // each issuer, which you'd use to set up a HttpsJwksVerificationKeyResolver
        Key verificationkey = rsaJsonWebKey.getKey();

        // And set up the allowed/expected algorithms
        AlgorithmConstraints algorithmConstraints = new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
                AlgorithmIdentifiers.RSA_USING_SHA256, AlgorithmIdentifiers.RSA_USING_SHA384);

        // Using info from the JwtContext, this JwtConsumer is set up to verify
        // the signature and validate the claims.
        JwtConsumer secondPassJwtConsumer = new JwtConsumerBuilder()
                .setExpectedIssuer(issuer)
                .setVerificationKey(verificationkey)
                .setRequireExpirationTime()
                .setAllowedClockSkewInSeconds(30)
                .setRequireSubject()
                .setExpectedAudience("Audience")
                .setJwsAlgorithmConstraints(algorithmConstraints)
                .build();

        // Finally using the second JwtConsumer or actually validate the JWT. This operates on
        // the JwtContext from the first processing pass, which avoids redundant parsing/processing.
        secondPassJwtConsumer.processContext(jwtContext);
        log.info("JWT Two-pass success: {}", jwtContext.getJwtClaims());
    }
}
