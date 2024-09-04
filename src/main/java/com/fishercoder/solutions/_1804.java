package com.fishercoder.solutions.secondthousand;

public class _1804 {
    public static class Solution1 {
        public static class Trie {
            class TrieNode {
                int count;
                int wordsCount;
                TrieNode[] children;

                public TrieNode() {
                    this.children = new TrieNode[26];
                }

                boolean isWord;
            }

            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = this.root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    if (node.children[c - 'a'].count < 0) {
                        node.children[c - 'a'].count = 0;
                    }
                    node.children[c - 'a'].count++;
                    node = node.children[c - 'a'];
                }
                node.isWord = true;
                if (node.wordsCount < 0) {
                    node.wordsCount = 0;
                }
                node.wordsCount++;
            }

            public int countWordsEqualTo(String word) {
                TrieNode node = this.root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        return 0;
                    }
                    node = node.children[c - 'a'];
                }
                return node.isWord ? node.wordsCount : 0;
            }

            public int countWordsStartingWith(String prefix) {
                TrieNode node = this.root;
                for (char c : prefix.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        return 0;
                    }
                    node = node.children[c - 'a'];
                }
                return Math.max(node.count, 0);
            }

            public void erase(String word) {
                TrieNode node = this.root;
                for (char c : word.toCharArray()) {
                    node.children[c - 'a'].count--;
                    node = node.children[c - 'a'];
                }
                node.wordsCount--;
            }
        }
    }
}
