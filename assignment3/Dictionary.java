package com.katermar.assignment3;

import java.util.HashSet;

/**
 * Created by katermar on 6/8/2017.
 */
public class Dictionary {
    private HashSet<String> dictionary = new HashSet<>();
    private HashSet<String> prefixes = new HashSet<>();

    public boolean isPrefix(String prefix){
      return prefixes.contains(prefix);
    }

    public boolean isWord(String word) {
        return dictionary.contains(word);
    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }

    public HashSet<String> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(HashSet<String> prefixes) {
        this.prefixes = prefixes;
    }
}
