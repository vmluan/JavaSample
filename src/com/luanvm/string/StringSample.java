package com.luanvm.string;
/*
 * This class contains some sample about String manipulation
 */
public class StringSample {

    // compare equal and '==' operator
    public void compareEqualAndDoubleEquals(){
        String a = "abc";
        String b = "abc";

        //in this case, abc is store at String Pool, so both a and b refers to the same object that has value is abc
        // so a == b will return true
        // a.equal return true of course as both has the same value. It does not care reference.

        if(a.equals(b)){
            System.out.println("a equals b by equals method" );
        }
        if(a==b){
            System.out.println("a ==b ");
        }
    }

    public static void main(String[] args){
        StringSample obj = new StringSample();
        obj.compareEqualAndDoubleEquals();
    }
}
