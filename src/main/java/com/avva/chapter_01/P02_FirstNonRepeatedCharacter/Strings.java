package com.avva.chapter_01.P02_FirstNonRepeatedCharacter;

import java.util.Arrays;

public class Strings {

    // http://www.alansofficespace.com/unicode/unicd99.htm
    private static final int EXTENDED_ASCII_CODES = 256; // can be increased to 65535

    public Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static char firstNonRepeatedCharacterV1(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (ch == str.charAt(j) && i !=j) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }
        for (int flag : flags) {
            System.out.print(flag + ", ");
        }


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }
}
