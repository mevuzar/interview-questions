package com.mayo.interview_questions.strings;

/**
 * @author yoav @since 10/25/16.
 *         Write code to reverseWithAdditionalDataStructures a C-Style String. (C-String means that “abcd” is represented as five
 *         characters, including the null character.)
 */
public class CStyleStringReverse {
    public static void main(String[] args) {
        char[] reversed = reverseInPlace("1234567890\0".toCharArray());

        System.out.println(String.format("result(%d): %s", reversed.length, new String(reversed)));
    }

    public static String reverseWithAdditionalDataStructures(String str) {
        StringBuilder builder = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }

        builder.append('\0');
        String result = builder.toString();
        return result;
    }


    public static char[] reverseInPlace(char[] str) throws IllegalArgumentException{
        if(str[str.length-1] == '\0'){


        for (int i = 0, j = str.length -1; i < str.length/2; i++, j--) {
           char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }


        return str;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

//    void reverseWithAdditionalDataStructures(String str) {
//        int end = 0;
//        char tmp;
//        if (str != null) {
//            while (end != str.length()) {
//                ++end;
//            }
//            --end;
//            while (str < end) {
//                tmp = str;
//                str++ =*end;
//                end-- = tmp;
//            }
//        }
//    }
}
