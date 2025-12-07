package com.avva.chapter_01.P01_CountDuplicateCharacter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }
}
