package com.tns.day6;
import java.util.*;

public class Asterisks {
	    public static void main(String[] args) {
	        int rows = 5;
	        
	        // Upper half
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < rows - i; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	        
	        // Lower half
	        for (int i = 2; i <= rows; i++) {
	            for (int j = 0; j < i; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    
	}
	}

	   

