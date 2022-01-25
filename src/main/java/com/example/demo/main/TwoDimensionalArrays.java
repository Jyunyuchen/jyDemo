package com.example.demo.main;

public class TwoDimensionalArrays {

	public static void main(String[] args) {
		int[][] twoDimArr = { { 1, 2, 3 }, 
				              { 4, 5, 6 } 
		                    };
		
		for(int i = 0; i < twoDimArr.length; i++) { 
            for(int j = 0; j < twoDimArr[0].length; j++) {
            	System.out.printf("twoDimArr[%d][%d]=%d\n",i,j,twoDimArr[i][j]); 
            }     
        } 

	}//end main

}
