package com.mayo.interview_questions.collections.stacks_and_queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yoav @since 10/30/16.
 *         Describe how you could use a single array to implement three stacks
 */
public class Create3StacksFromArray {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        List<ArrayBackedStack<Integer>> result = getStacks(arr, 90);
        System.out.println(result);
    }

    public static List<ArrayBackedStack<Integer>> getStacks(Integer[] backingArray, int requestedCount) {
        List<ArrayBackedStack<Integer>> result = new ArrayList<>();
        int div = backingArray.length/requestedCount;
        int end = backingArray.length;
        int start = end - div;
        while(start > 0){
            result.add(new ArrayBackedStack<Integer>(backingArray, start, end));
            end = start - 1;
            start = end - div;
        }

        result.add(new ArrayBackedStack<Integer>(backingArray, 0, end));

        return result;
    }

}

