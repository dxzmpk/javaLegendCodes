package com.company.collections;

class Trie {

    final Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {

    }

    class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;

        /**
         *
         * @param n the position to insert Node into
         * @return the Node added
         */
        Node addChildIfAbsent(int n) {
            if (children[n] == null) {
                children[n] = new Node();
            }
            return children[n];
        }

        void addEndIfAbsent(int n) {
            Node nNode = addChildIfAbsent(n);
            nNode.isEnd = true;
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        int i;
        // curNode should be initialized to root
        Node cur = root;
        for (i = 0; i < charArray.length; i++) {
            int charOrder = charArray[i] - 'a';
            // for all the char, insert into the cur node
            if (i == charArray.length - 1) {
                cur.addEndIfAbsent(charOrder);
                return;
            } else {
                cur = cur.addChildIfAbsent(charOrder);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int charOrder = c - 'a';
            cur = cur.children[charOrder];
            if (cur == null) {
                return false;
            }
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            int charOrder = c - 'a';
            cur = cur.children[charOrder];
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("res = " + trie.search("apple"));// 返回 True
        System.out.println("res = " + trie.search("app"));     // 返回 False
        System.out.println("res = " + trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println("res = " + trie.search("app"));     // 返回 True
    }

}




/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
