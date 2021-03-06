package com.katermar.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by katermar on 6/8/2017.
 */
public class Dictionary {
    private final Set<String> dictionary;
    private final Set<String> prefixes;

    public Dictionary(Set<String> dictionary, Set<String> prefixes) {
        this.dictionary = dictionary;
        this.prefixes = prefixes;
    }

    public Dictionary(String[] dictionary, String[] prefixes) {
        this.dictionary = new HashSet<>(Arrays.asList(dictionary));
        this.prefixes = new HashSet<>(Arrays.asList(prefixes));
    }

    public Dictionary(String[] dictionary) {
        this.dictionary = new HashSet<>(Arrays.asList(dictionary));
        this.prefixes = new HashSet<>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                prefixes.add(word.substring(0, i));
            }
        }
    }

    public Dictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
        this.prefixes = new HashSet<>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                prefixes.add(word.substring(0, i));
            }
        }
    }

    public boolean isPrefix(String prefix){
      return prefixes.contains(prefix);
    }

    public boolean isWord(String word) {
        return dictionary.contains(word);
    }
}
