package com.pragati.hackerrank;

import java.util.Arrays;

/**
 * Created by pragati on 16/09/19.
 */

public class HackerString {


    public static boolean hacker(String str1,String str2){

        if(Math.abs(str1.length()- str2.length())==1)
            return checkInsert(str1,str2);

        else if(Math.abs(str1.length()- str2.length())==0)
            return checkReplace(str1,str2);

        else
            return false;
    }


    private static boolean checkReplace(String str1, String str2) {

        char c1[] = str1.toCharArray();
        char c2[] = str2.toCharArray();
        boolean flag=false;

        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i=0;i<str1.length();i++){

            if(c1!=c2){
                if(flag)
                    return false;

                flag = true;
            }
        }
        return true;
    }

    private static boolean checkInsert(String str1, String str2) {

        int a = (int) 'a';
        int z = (int) 'z';
        boolean flag=false;

        int len = z-a;
        int []a1 = new int[len];
        int []a2 = new int[len];

        a1 = convertToInt(str1,len);
        a2 = convertToInt(str2,len);

        for(int i=0;i<len;i++){
            if(a1[i]!=a2[i]){
                if(flag){
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    private static int[] convertToInt(String str,int len) {

        int[] a = new int[len];

        for(int i=0;i<str.length();i++){
            int val = (int) str.charAt(i);
            a[val-'a']++;
        }

        return a;
    }


    public static void main(String[] args){
        HackerString obj = new HackerString();

        System.out.println(obj.hacker("bake","pale"));
    }
}
