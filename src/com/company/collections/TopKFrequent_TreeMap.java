package com.company.collections;

import java.util.*;

public class TopKFrequent_TreeMap {

    class WordCount {
        String word;
        int count;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordCount wordCount = (WordCount) o;
            return Objects.equals(word, wordCount.word);
        }

        public WordCount(String word) {
            this.word = word;
        }

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, count);
        }
    }
    // return k most appeared word
    public List<String> topKFrequent(String[] words, int k) {
        // insert : O(1)
        List<WordCount> wordCounts = new ArrayList<>();
        for (String word : words) {
            WordCount temp = new WordCount(word);
            int oldIndex = wordCounts.indexOf(temp);
            if (oldIndex < 0) {
                temp.count = 0;
                wordCounts.add(temp);
            } else {
                temp.count = wordCounts.get(oldIndex).count + 1;
                wordCounts.set(oldIndex, temp);
            }
        }
        wordCounts.sort(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                if (o1.count != o2.count) {
                    return o2.count - o1.count;
                } else {
                    return o1.word.compareTo(o2.word);
                }
            }
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(wordCounts.get(i).word);
        }
        return ans;
        // get : O(logn)

        // sum : O(nlogn)

        // 1. HashMap: O(n^2)
        // 2. TreeMap: O(nlogn)
    }

    public static void main(String[] args){
        List<String> ans = new TopKFrequent_TreeMap().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println("ans = " + ans.toString());
    }

    /**
     * 优先级队列方案
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentProrityQueue(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
