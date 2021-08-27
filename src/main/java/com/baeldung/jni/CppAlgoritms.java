package com.baeldung.jni;

public class CppAlgoritms {

   /* static {
        System.loadLibrary("native");
    }*/
/*
    public static void main(String[] args) {

      // int i=  new CppAlgoritms().levenshtein("omer","ogmer");
       // System.out.println(i);
           }
*/
    public native int  levenshtein(String str1,String str2);


}