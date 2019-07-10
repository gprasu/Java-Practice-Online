package com.sample;
import java.util.ArrayList;
import java.util.Arrays;
 
public class MyTestClas{
 
	static boolean  sum_combinations_recursive(ArrayList<Integer> inputNumbers, int targetSum, ArrayList<Integer> partialNumbers) {
 
	       int sum = 0;
	     	       
	       //calculate summation of partial numbers
	       for (int x: partialNumbers) {	 
   	   
	    	   sum += x;
 
	       }    
	      
	       //check if summation of partial numbers is equal to sum target
	       if (sum == targetSum)
	            System.out.println("sum("+Arrays.toString(partialNumbers.toArray())+")="+targetSum);
	       
	       //if we sum is greater than the target sum then why to continue 
	       if (sum >= targetSum){
 
	    	   //ends the current method invocation
	    	   return false;
	       }	            
	       
	       //add the remaining numbers in the partial number list 
	       for(int i=0;i<inputNumbers.size();i++) {	  
  	   
	             ArrayList<Integer> remainingNumbers = new ArrayList<Integer>();
 
	             int n = inputNumbers.get(i);	
            
	             for (int j=i+1; j<inputNumbers.size();j++) {
 
	            	 remainingNumbers.add(inputNumbers.get(j));
	             }
	             
	             ArrayList<Integer> partialNumbersList = new ArrayList<Integer>(partialNumbers);
 
	             partialNumbersList.add(n);
 
	             //recursive call
	             sum_combinations_recursive(remainingNumbers,targetSum,partialNumbersList);
	       }
		return false;
 
	    }
	    static void sum_combinations(ArrayList<Integer> inputNumbers, int targetSum) {
 
	    	sum_combinations_recursive(inputNumbers,targetSum,new ArrayList<Integer>());
 
	    }
 
	    public static void main(String args[]) {
 
	        Integer[] inputNumbers = {19 ,9 ,19 ,14 ,4 ,6 ,8 ,8 ,8 ,2 ,7 ,13 ,17 ,2 ,1 ,14 ,9 ,17 ,17 ,15};
	       // sum([19, 9, 19, 14, 4, 6, 8, 2, 2, 1, 9])=93
 
	        int targetSum = 93;
 
	        sum_combinations(new ArrayList<Integer>(Arrays.asList(inputNumbers)),targetSum);
 
	    }
 
}
