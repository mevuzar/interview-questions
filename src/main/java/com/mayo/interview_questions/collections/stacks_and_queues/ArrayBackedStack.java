package com.mayo.interview_questions.collections.stacks_and_queues;

import java.util.EmptyStackException;

/**
 * @author yoav @since 10/30/16.
 */
public class ArrayBackedStack<T> {

    int startPosition;
    int endPosition;
    private T[] backingArray;

    public ArrayBackedStack(T[] backingArr, int startPos, int endPos) {
        startPosition = startPos;
        endPosition = endPos;
        backingArray = backingArr;
    }

    public T pop() throws EmptyStackException {
        for (int i = endPosition; i < startPosition; i--) {
            if(backingArray[i] != null){
                T result = backingArray[i];
                backingArray[i] = null;
                return result;
            }
        }

        throw new EmptyStackException();
    }

    public void push(T t) throws FullStackException{
        for (int i = startPosition; i < endPosition; i++) {
            if(backingArray[i] == null){
                backingArray[i] = t;
                return;
            }
        }

        throw new FullStackException();
    }


}

