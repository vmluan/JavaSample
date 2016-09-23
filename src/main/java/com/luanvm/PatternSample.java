package com.luanvm;

import java.util.regex.Pattern;

/**
 * Created by Luan on 9/12/2016.
 * This class contains somme Pattern samples
 */
public class PatternSample {
    /*
        Method is to check if a string contains numeric only or not.
     */
    public boolean containNumbersOnly(String source){
        boolean result = false;
        Pattern pattern = Pattern.compile(".*[^0-9].[^0-9]*"); // It is not correct
        result = pattern.matcher(source).matches();
        if(!result){
            System.out.println(source  + " is a number");
        }else
            System.out.println(source  + " is a String");
        return result;
    }
    /*
    Correct method
     */
    public boolean containNumbersIncludeFloat(String source){
        boolean result = false;
        Pattern pattern = Pattern.compile("\\d+"); //correct pattern for integer. incorrect for float number. \d is a digit in [0-9]. + means repeat more times.
        pattern = Pattern.compile("[0-9]+"); //correct pattern for integer only. incorrect for float number.
//		pattern = Pattern.compile(".*[0-9]*."); //incorrect pattern

        pattern = Pattern.compile("[0-9]+.[0-9]+"); //correct pattern for both float and integer.
        pattern = Pattern.compile("\\d+.\\d+"); //correct pattern for both float and integer.

        result = pattern.matcher(source).matches();
        if(result){
            System.out.println("\"" + source + "\""  + " is a number");
        }else
            System.out.println("\"" + source + "\""  + " is a String");
        return result;
    }
    public static void main(String[] args){
        PatternSample obj = new PatternSample();
        obj.containNumbersOnly("12345a");
        obj.containNumbersOnly("12345");
        obj.containNumbersOnly("12345.10");
        obj.containNumbersOnly("12345.1a");

        System.out.println("==================");

        obj.containNumbersIncludeFloat("12345a");
        obj.containNumbersIncludeFloat("12345");
        obj.containNumbersIncludeFloat("12345.10");
        obj.containNumbersIncludeFloat("12345.1a");
    }
}
