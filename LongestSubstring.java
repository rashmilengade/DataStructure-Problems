package com.example;

import java.util.HashSet;

public class LongestSubstring {
    public static int longestSubstringLength(String s)
    {
        int i=0,j=0,max=0;
        HashSet<Character> hashSet = new HashSet<>();
        while (j < s.length())
        {
            if(!hashSet.contains(s.charAt(j)))
            {
                hashSet.add(s.charAt(j));
                j++;
                max = Math.max(hashSet.size(),max);
            }
            else
            {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "yashesh";
        int l = longestSubstringLength(s);
        System.out.println(s + " Longest substring length: " + l);
    }
}
