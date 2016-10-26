package com.mayo.interview_questions.collections.linked_lists;

import java.util.LinkedList;

/**
 * @author yoav @since 10/26/16.
 */
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T t) {
        data = t;

    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}

