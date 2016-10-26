package com.mayo.interview_questions.collections.linked_lists;

import java.util.*;

/**
 * @author yoav @since 10/26/16.
 *         Write code to remove duplicates from an unsorted linked list.
 *         FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("a", "a", "b", "c", "d", "e", "E", "E", "a", "f"));


        LinkedList<String> linkedList = new LinkedList<>(arr);
        LinkedList<LinkedListNode<String>> linkedNodeList = NodeListUtils.generateLinkedNodeList(arr);
        removeDuplicatesWithBuffer(linkedList);
        System.out.println(linkedList);
        removeDuplicatesNoBuffer(linkedNodeList.getFirst());
        LinkedList<LinkedListNode<String>> resultList = NodeListUtils.getLinkedListNodes(linkedNodeList);
        System.out.println(resultList);

    }



    public static <T> void removeDuplicatesWithBuffer(LinkedList<T> list) {
        Set<T> set = new HashSet<>();

        ListIterator<T> iterator = list.listIterator();

        while (iterator.hasNext()) {
            T item = iterator.next();
            if (set.contains(item)) {
                iterator.remove();
            } else {
                set.add(item);
            }
        }
    }

    public static void removeDuplicatesWithBuffer(LinkedListNode n) {
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        while (n != null) {
            if (table.containsKey(n.data)) previous.next = n.next;
            else {
                table.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void removeDuplicatesNoBuffer(LinkedListNode head) {
        if (head == null) return;
        LinkedListNode previous = head;
        LinkedListNode current = previous.next;
        while (current != null) {
            LinkedListNode runner = head;
            while (runner != current) { // Check for earlier dups
                if (runner.data == current.data) {
                    LinkedListNode tmp = current.next; // remove current
                    previous.next = tmp;
                    current = tmp; // update current to next node
                    break; // all other dups have already been removed
                }
                runner = runner.next;
            }
            if (runner == current) { // current not updated ‐ update now
                previous = current;
                current = current.next;
            }
        }
    }


}

