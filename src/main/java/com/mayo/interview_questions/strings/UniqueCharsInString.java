package com.mayo.interview_questions.strings;

/**
 * @author yoav @since 10/25/16.
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * can not use additional data structures?
 */
public class UniqueCharsInString {
    public static void main(String[] args){
//        for(Character s: "hello".toCharArray()){
//            System.out.println(s.hashCode());
//        }
        System.out.println(isUniqueChars("hello"));
    }

    public static boolean isUniqueCharsBitwise(String str) {
        int checker = 0;
         for (int i = 0; i < str.length(); ++i) {
             int val = str.charAt(i) - 'a';
             if ((checker & (1 << val)) > 0) return false;
             checker |= (1 << val);
            }
        return true;
         }

    public static boolean isUniqueChars(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    return false;
                }
            }

        }

        return true;
    }
}
