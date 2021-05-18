package com.algo.recursion.string;

import java.util.Arrays;

public class Fibonacci {
public static void main(String[] args) {
	System.out.println(getIterativeFibonacci(6));
	System.out.println(Arrays.toString(getIterativeFibonacciArray(6)));
	System.out.println(getRecursiveFibonacci(0,1,6));
}

private static int[] getIterativeFibonacciArray(int n) {
	int[] fib=new int[n+1];
	fib[0]=0;
	fib[1]=1;
	for(int i=2;i<=n;i++) {
		fib[i]=fib[i-1]+fib[i-2];
	}
	return fib;
}

private static int getRecursiveFibonacci(int n1,int n2,int n) {
	if(n==1) return n2;
	return getRecursiveFibonacci(n2,n1+n2,n-1);
}

private static int getIterativeFibonacci(int n) {
	int a=0,b=1;
	if(n==0) return a;
	for(int i=2;i<=n;i++) {
		int tmp=a+b;
		a=b;
		b=tmp;
	}
	return b;
}
}
