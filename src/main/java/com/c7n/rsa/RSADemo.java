package com.c7n.rsa;

import java.security.*;

import java.security.interfaces.RSAPrivateKey;

import java.security.interfaces.RSAPublicKey;

import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

import java.util.Map;

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;


/**
 * Created by dragon on 2019/6/17.
 */
public class RSADemo {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";


    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        Map<String, Object> keyMap;
//        try {
//            keyMap = initKey();
//            String publicKey = getPublicKey(keyMap);
//            System.out.println(publicKey);
//            String privateKey = getPrivateKey(keyMap);
//            System.out.println(privateKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Map<String, String> keyMap = RSAUtils.createKeys(1024);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
//        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKyBFhCj55pO4FZ51cZxaHZB+8cfdv59U9NZ1+RaEVhbXilElw0iscSsihxpovsOAG2qEQyCPZqocg7/bwePJ5UCAwEAAQ==";
//        String privateKey = "MIIBnjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIxeWFWAsCBU4CAggAMBQGCCqGSIb3DQMHBAjlFgArvDaMQQSCAVgT8CyT7+lNmvYC9sD7hy+X8VNthO4tS/2L/NjJ2rZf0aqHpQxMPxqz+cvgFJ//4Au0u6fxLMermhun2sc9VLTGJeK9MNlYRgcvAF3fGY8Cpwp8Tqj+7ksP1vEtgLAizeqmyhjCuVw+AMjUBfOxmnGslk0I+A4pTpYIaAztbE5CouDApp/yCaAhlhE+HJP4PFlo92llcvWCvkwdr/+LmcRqDE1n+vscBN/NXls12bMOwwTyRansUGrbusU0t+SEjmjIL8DjjCzkSnuC9+fD+aYnC+Mjr8v9b738qC1pxm7q8Ie5eOJFiqE6/w54e0xdtmgSejQiC3085znn5HotRq7zoD7vhbfzpl8KygWHIZPnJdkUKjqLTSFAektcjD+Ry6nlQSHIK6voU+K2CfndfPCyLYeUeUDuudkEZZ8j2JyCuNOhis+uJSmBocV2gRbZ02zWI2F7aQJpA==";

        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);

        System.out.println("公钥加密——私钥解密");
        String str = "站在大明门前守卫的禁卫军，事先没有接到\n" +
                "有关的命令，但看到大批盛装的官员来临，也就\n" +
                "以为确系举行大典，因而未加询问。进大明门即\n" +
                "为皇城。文武百官看到端门午门之前气氛平静，\n" +
                "城楼上下也无朝会的迹象，既无几案，站队点名\n" +
                "的御史和御前侍卫“大汉将军”也不见踪影，不免\n" +
                "心中揣测，互相询问：所谓午朝是否讹传？";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RSAUtils.publicEncrypt(str, RSAUtils.getPublicKey(publicKey));
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtils.privateDecrypt(encodedData, RSAUtils.getPrivateKey(privateKey));
        System.out.println("解密后文字: \r\n" + decodedData);

    }

    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }


    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }


    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }
}
