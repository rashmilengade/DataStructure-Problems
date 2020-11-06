package com.example;

class LongestPalindrome {
    public static String longestPal(String s)
    {
        if (s == null)
            return "";
        int start=0,end=0;
        for (int i=0; i< s.length(); i++)
        {
            int l1 = expandFromCenter(s,i,i);
            int l2 = expandFromCenter(s,i,i+1);
            int l = Math.max(l1,l2);
            if (l > end - start) {
                start = i - ((l - 1) / 2);
                end = i + (l / 2);
            }
        }
        return s.substring(start,end+1);
    }
    public static int expandFromCenter(String s, int left, int right)
    {
        if (s == null || left > right) return 0;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right ++;
        }
        return right - left +1;
    }

    public static void main(String[] args) {
        String pal = longestPal("earfafabbarrrae");
        System.out.println(pal);
    }
}
