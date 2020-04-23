// FILE:     BooleanExpressions.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: Tests out various boolean expressions
// REFERENCE: 
// COMMENTS: 
// REQUIRES:
// LAST MOD: 24th March 2020

import java.util.*;

public class BooleanExpressions
{
    public static void main(String[] args)
    {
        // public static final double TOL = 0.0001;
        final double TOL = 0.0001;
        String susan, jane;
        double steve, tony;
        int luke, scott, lucas;
        char john, matthew;

        // (a) decide if susan is the same as "sarah"
        susan = "sarah";

        System.out.println(susan == "sarah"); 
        System.out.println(susan.equals("sarah"));

        // (b) decide if lucas is an even number and scott is an odd number
        lucas = 2;
        scott = 3;
        
        System.out.println(((lucas % 2) == 0 ) && ((scott % 2) != 0));
   
        // (c) decide if john or matthew are equal to the letter 'S'
        john = 'S';
        matthew = 'M';
        System.out.println((john == 'S') || (matthew == 'S'));  
      
        // (d) decide if jane starts with the letter 'V'
        jane = "Vase";
        System.out.println(jane.charAt(0) == 'V'); 

        // (e) decide if john is the same as matthew
        // john and matthew are already initialised
        System.out.println(john == matthew); 

        // (f) decide if steve is the same as tony 
        steve = 130.0;
        tony = 130.1;
        
        System.out.println(steve == tony); 

        // (g) decide if luke is positive or steve is between 25.0 and 125.0 inclusive
        luke = 100;
        System.out.println((luke >= 0) || ((steve >= 25.0) && (steve <= 125.0))); 
    }
}
