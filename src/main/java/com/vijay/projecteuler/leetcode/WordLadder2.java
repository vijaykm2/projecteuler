package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WordLadder2 implements CommandLineRunner {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)){
            return result;
        }
        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<Pair<String, String>>  visitedActual = new LinkedList<>();
        visitedActual.add(new Pair(beginWord, beginWord));
        while (!visitedActual.isEmpty()){
            Pair<String, String> node = visitedActual.remove();
            String word = node.getKey();
            String actual = node.getValue();
        }

        return result;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside Word ladder ;;");
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});

    }
}
