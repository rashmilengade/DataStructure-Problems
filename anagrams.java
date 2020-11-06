package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class anagrams {
    static boolean areAnagrams(char[] str1, char[] str2)
    {
        int l1 = str1.length;
        int l2 = str2.length;
        if (l1 != l2)
        {
            return false;
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i=0; i<l1; i++)
        {
            if(str1[i] != str2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //char str1[] = {'s','i','l','e','n','t'};
        //char str2[] = {'l','i','s','t','e','n'};
        char str1[] = {'s','i','l','e','n','t'};
        char str2[] = {'l','i','s','t'};
        if(areAnagrams(str1,str2))
        {
            System.out.println("The two strings are anagrams");
        }
        else
        {
            System.out.println("The two Strings are not anagrams");
        }
    }
}
