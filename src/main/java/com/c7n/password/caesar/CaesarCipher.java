package com.c7n.password.caesar;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

/**
 * 在密码学中，恺撒密码（英语：Caesar cipher），或称恺撒加密、恺撒变换、变换加密，是一种最简单且最广为人知的加密技术。
 * 它是一种替换加密的技术，明文中的所有字母都在字母表上向后（或向前）按照一个固定数目进行偏移后被替换成密文。
 * 例如，当偏移量是3的时候，所有的字母A将被替换成D，B变成E，以此类推。
 * 这个加密方法是以罗马共和时期恺撒的名字命名的，当年恺撒曾用此方法与其将军们进行联系。
 */
public class CaesarCipher {

    static char[] caesarUpperCaseDictionary = new char[26];
    static char[] caesarLowerCaseDictionary = new char[26];

    static Range<Character> upperCaseRange = Range.between('A', 'Z');
    static Range<Character> lowerCaseRange = Range.between('a', 'z');

    static {
        char c1 = 'a';
        char c2 = 'A';
        for (int i = 0; i < 26; i++) {
            caesarUpperCaseDictionary[i] = (char) (c2 + i);
            caesarLowerCaseDictionary[i] = (char) (c1 + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(caesarLowerCaseDictionary);
        System.out.println(caesarUpperCaseDictionary);

        String input = "Lfnzx ozqnzx hfjxfw";
        int offset = 5;

        System.out.println(decrypt(input, offset));
    }

    public static String encrypt(String input, int offset) {
        StringBuilder r = new StringBuilder();
        for (char c : input.toCharArray()) {
            char result = processCharacter(c, offset, new OperationAdd());
            r.append(result);
        }
        return r.toString();
    }

    public static String decrypt(String input, int offset) {
        StringBuilder r = new StringBuilder();
        for (char c : input.toCharArray()) {
            char result = processCharacter(c, offset, new OperationMinus());
            r.append(result);
        }
        return r.toString();
    }

    private static char processCharacter(char c, int offset, IntOperation intOperation) {
        if (upperCaseRange.contains(c)) {
            int i = ArrayUtils.indexOf(caesarUpperCaseDictionary, c);
            return caesarUpperCaseDictionary[intOperation.operate(i + 26, offset) % 26];
        } else if (lowerCaseRange.contains(c)) {
            int i = ArrayUtils.indexOf(caesarLowerCaseDictionary, c);
            return caesarLowerCaseDictionary[intOperation.operate(i + 26, offset) % 26];
        } else {
            return c;
        }
    }

    interface IntOperation {
        int operate(int a, int b);
    }

    static class OperationAdd implements IntOperation {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    }

    static class OperationMinus implements IntOperation {

        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    }
}
