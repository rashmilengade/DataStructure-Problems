package com.example;

public class MedianTwoSortedArray {
    static int[] a =    new int[]{3,4,7,900};
    static int[] b =    new int[]{1,2,13,15};

    public static int findMin(int a,int b)
    {
        return a < b ? a:b;
    }

    public static int findMax(int a, int b)
    {
        return a > b ? a:b;
    }
    public static double findMedian(int n, int m)
    {
        int min = 0, max = n, i=0,j=0;
        double median=0;
        while (min <= max)
        {
            i=(min+max)/2;
            j=((n+m+1)/2) -i;

            if (i<n && j>0 && b[j-i] > a[i])
            {
                min= i+1;
            }
            else if(i>0 && j<m && b[j] < a[i-1])
            {
                max=i-1;
            }
            else
            {
                if(i==0)
                    median = b[j-1];
                else if(j==0)
                    median = a[i-1];
                else
                    median = findMax(a[i-1],b[j-1]);
                break;
            }
        }

        //if number of elements in the combined array is odd
        if((n+m)%2==1)
        {
            return median;
        }
        if(i==n)
        {
            return (median +b[j]/2.0);
        }
        if(j == m)
        {
            return (median +a[i]/2.0);
        }

        return (median + findMin(a[i],b[j]))/2.0;
    }
    public static void main(String[] args) {
        int m = a.length;
        int n = b.length;

        if (n < m)
            System.out.println("The median is : "+ findMedian(n,m));
        else
            System.out.println("The median is : "+ findMedian(m,n));
    }
}
