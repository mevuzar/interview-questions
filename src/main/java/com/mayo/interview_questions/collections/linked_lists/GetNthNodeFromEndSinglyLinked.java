package com.mayo.interview_questions.collections.linked_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author yoav @since 10/26/16.
 */
public class GetNthNodeFromEndSinglyLinked {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("a", "a", "b", "c", "d", "e", "E", "E", "a", "f"));
        LinkedList<LinkedListNode<String>> linkedNodeList = NodeListUtils.generateLinkedNodeList(arr);
        LinkedListNode<String> nth = nthToLast(linkedNodeList.getFirst(), 3);
        System.out.println(nth);
    }

    public static <T> LinkedListNode<T> nthToLast(LinkedListNode<T> head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) { // skip n‐1 steps ahead
            if (p2 == null) {
                return null; // not found since list size < n
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}


