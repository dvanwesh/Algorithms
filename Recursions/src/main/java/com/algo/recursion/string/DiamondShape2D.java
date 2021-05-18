package com.algo.recursion.string;
/**
 * given OD Number print Diamond pattern of stars recursively
 * @author vdatla
 * 
 * 1 5 		2
 * 3 5 		1 2 3
 *
 */
public class DiamondShape2D {
public static void main(String[] args) {
	int n=12;
	printDiamond(n,1,true);
}

private static void printDiamond(int n,int k,boolean isFirstHalf) {
	if(k<1) return;
	if(k>n) {
		k=k-2;
		printDiamond(n, k-2,false);
		return;
	}
	for(int i=0;i<n;i++){
		if(i==n/2 || (i>=(n/2-((k-1)/2))&&i<=(n/2+((k-1)/2)))){
			System.out.print("*");
		}
		else{
			System.out.print(" ");
		}
	}
	System.out.println();
	if(isFirstHalf){
		printDiamond(n, k+2,true);
	}
	else{
		printDiamond(n, k-2,false);
	}
	
	
}
}
