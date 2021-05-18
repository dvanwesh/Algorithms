package com.algo.algorithms.matrix;

import java.util.Arrays;

/*
We are given a row wise sorted matrix of size r*c,
we need to find the median of the matrix given.
It is assumed that r*c is always odd.
https://github.com/Dedalus-Stephen/Find-median-of-row-wise-sorted-matrix
 */
public class MedianOfMatrix {
    public static void main(String[] args) {
        int[] ar=new int[]{4,7,9,56,78};
        System.out.println(Arrays.binarySearch(ar,9));
        int n=Arrays.binarySearch(ar,8);
        System.out.println(n+"----"+(Math.abs(n)-1));
        n=Arrays.binarySearch(ar,100);
        System.out.println(n+"----"+(Math.abs(n)-1));
        n=Arrays.binarySearch(ar,1);
        System.out.println(n+"----"+(Math.abs(n)-1));
    }
}
