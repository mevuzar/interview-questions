package com.mayo.interview_questions.collections.linked_lists;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yoav @since 10/26/16.
 */
public class NodeListUtils{
    public static LinkedList<LinkedListNode<String>> getLinkedListNodes(LinkedList<LinkedListNode<String>> linkedNodeList) {
        LinkedList<LinkedListNode<String>> resultList = new LinkedList<>();
        LinkedListNode<String> tmp = linkedNodeList.getFirst();
        resultList.add(tmp);
        while (tmp.hasNext()) {
            resultList.add(tmp.next);
            tmp = tmp.next;
        }
        return resultList;
    }

    public static LinkedList<LinkedListNode<String>> generateLinkedNodeList(ArrayList<String> arr) {
        LinkedList<LinkedListNode<String>> linkedNodeList = new LinkedList<>();


        arr.forEach(t -> linkedNodeList.add(new LinkedListNode<String>(t)));


        for (int i = 0; i < linkedNodeList.size() - 1; i++) {
            linkedNodeList.get(i).next = linkedNodeList.get(i + 1);
        }
        return linkedNodeList;
    }

}
