package com.c7n.jwt.jose4j;

public class JwtStarter {

    public static void main(String[] args) throws Exception {
        JwtHelloWorldExample jwtHelloWorldExample = new JwtHelloWorldExample();
        jwtHelloWorldExample.run();

        JwtCodeExample jwtCodeExample = new JwtCodeExample();
        String jwt = jwtCodeExample.generateJwt();
        jwtCodeExample.consumeJwt(jwt);
        jwtCodeExample.twoPassConsumeJwt(jwt);
    }
}
