package com.authtools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution {
    public static List<String> bitpattern(List<Integer> num) {
        int l = num.size();
        String s1 = "", s2 = "";
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            s1 += "0";
            s2 += "0";
        }
        StringBuilder s11 = new StringBuilder(s1);
        StringBuilder s22 = new StringBuilder(s2);
        for (int i = 0; i < l; i++) {
            if (map.containsKey(num.get(i))) {
                s11.setCharAt(i, '1');
                s22.setCharAt(map.get(num.get(i)), '1');
                map.put(num.get(i), i);

            } else {
                map.put(num.get(i), i);
            }

        }
        List<String> result = new ArrayList<String>(2);
        s1 = s11.toString();
        s2 = s22.toString();
        result.add(s1);
        result.add(s2);
        return result;

    }

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(2);
        num.add(1);

        List<String> bitPatterns = bitpattern(num);

        System.out.println("Earlier Occurrences: " + bitPatterns.get(0));
        System.out.println("Later Occurrences: " + bitPatterns.get(1));
    }
}
