package com.katermar.assignment5;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Created by katermar on 7/8/2017.
 */
public class AlphabetDiscovering {
    /*
     * static Class to scan all letters from the given List of words
     */
    private static class LetterScanner {
        /*
         * Method to make a graph of letters from the given dictionary
         * ------------------------------------------------------------
         * @param words - given list of words like dictionary
         * @param ordering - an object of the class Ordering whitch helps to create the graph
         */
        public void scan(List<String> words, Ordering ordering) {
            if (words.size() > 1) {
                for (int i = 1; i < words.size(); ++i) {
                    String firstWord = words.get(i - 1);
                    String secondWord = words.get(i);
                    int minLength = Math.min(firstWord.length(), secondWord.length());
                    for (int j = 0; j < minLength; ++j) {
                        if (firstWord.charAt(j) != secondWord.charAt(j)) {
                            ordering.onOrderedPair(firstWord.charAt(j), secondWord.charAt(j));
                            break;
                        }
                    }
                }
            }
        }
    }

    /*
     * Class to solve the problem, which does topological sort in existing graph
     */
    public static class Ordering {
        private final Map<Character, Vertex> vertexMap = new HashMap<>();

        /*
         * Method to start the process of ordering. It scans the given wordlist and creates a graph
         * --------------------------------------------------------
         * @param words - given dictionary in unknown language
         * --------------------------------------------------------
         * @return initialised Ordering object with a graph
         */
        public static Ordering seedWords(List<String> words) {
            Ordering o = new Ordering();
            LetterScanner letterScanner = new LetterScanner();
            letterScanner.scan(words, o);
            return o;
        }

        /*
         * Method to do topological sort of the graph
         * ------------------------------------------
         * @return list of the found characters - unknown alphabet
         */
        public List<Character> topologicalOrdering() {
            Set<Vertex> unmarked = new HashSet<>(vertexMap.values());
            Set<Vertex> visiting = new HashSet<>();
            Set<Vertex> visited = new HashSet<>();

            List<Character> ordered = new LinkedList<>();
            while (!unmarked.isEmpty()) {
                Vertex v = unmarked.iterator().next();
                visitVertex(v, unmarked, visiting, visited, ordered);
            }

            Collections.reverse(ordered);
            return ordered;
        }

        /*
         * Method, which does the main part of topological sort.
         * It visits vertexes of the given graph.
         * ------------------------------------------------
         * @param v - vertex to visit
         * @param unmarked - set of unmarked vertex
         * @param visiting - set of vising vertex
         * @param visited - set of visited vertex
         * @ordered - list of ordered characters
         */
        private static void visitVertex(Vertex v, Set<Vertex> unmarked, Set<Vertex> visiting,
                                  Set<Vertex> visited, List<Character> ordered) {
            if (visiting.contains(v)) {
                throw new IllegalArgumentException("Cyclic graph. No ordering possible.");
            }

            if (unmarked.remove(v)) {
                visiting.add(v);
                for (Vertex n : v.getNeighbours()) {
                    visitVertex(n, unmarked, visiting, visited, ordered);
                }
                visiting.remove(v);
                visited.add(v);
                ordered.add(v.getValue());
            }
        }

        void onOrderedPair(char u, char v) {
            vertexMap.computeIfAbsent(u, Vertex::new).addEdgeTo(vertexMap.computeIfAbsent(v, Vertex::new));
        }
    }
}
