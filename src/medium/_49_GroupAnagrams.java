package medium;

import java.util.*;

public class _49_GroupAnagrams {
    public static final int[] primes = {
            2,  3,  5,  7,  11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101
    };
    public List<List<String>> groupAnagrams_UsePrime(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>((int)(strs.length / 0.75));
        List<List<String>> res = new ArrayList<>(strs.length);
        for(String str: strs){
            int product = 1;
            for (int i = 0; i < str.length(); i++) {
                int j = str.charAt(i) - 'a';
                product *= primes[j];
            }
            List<String> list = map.get(product);
            if (list == null){
                list = new ArrayList<>();
                map.put(product, list);
                res.add(list);
            }
            list.add(str);
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<String> l = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>((int)(strs.length / 0.75));
        for(String str: strs){
            int bit = 0, sum = 0, product = 1;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int j = c - 'a';
                bit |= (1 << j);
                sum += (j + 1);
                product *= (j + 1);
            }
            String hash = String.valueOf(bit) + sum + product;
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.size());
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        _49_GroupAnagrams ga = new _49_GroupAnagrams();
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] input2 = {"ell", "del"};

        String[] input = input1;
        List<List<String>> res = ga.groupAnagrams(input);
        for(List<String> list: res){
            for(String str: list){
                System.out.print(str + ",");
            }
            System.out.println();
        }

        System.out.println();
        res = ga.groupAnagrams_UsePrime(input);
        for(List<String> list: res){
            for(String str: list){
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
}
