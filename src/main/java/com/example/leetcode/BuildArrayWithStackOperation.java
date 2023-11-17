package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 *
 * @Tag: Medium
 * @Date: 3 Nov 2023
 *
 * Problem Statement
 *
 * You are given an integer array target and an integer n.
 *
 * You have an empty stack with the two following operations:
 *
 *     "Push": pushes an integer to the top of the stack.
 *     "Pop": removes the integer on the top of the stack.
 *
 * You also have a stream of the integers in the range [1, n].
 *
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
 *
 *     If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
 *     If the stack is not empty, pop the integer at the top of the stack.
 *     If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
 *
 * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
 */
public class BuildArrayWithStackOperation {

    public static void main(String[] args) {
        BuildArrayWithStackOperation buildArrayWithStackOperation = new BuildArrayWithStackOperation();
        System.out.println(buildArrayWithStackOperation.buildArray(new int[]{1, 3}, 3));
    }

    public List<String> buildArray(int[] target, int n) {

        //target = [1,3], n = 3   stack

        //[1, 3]
        List<String> response = new ArrayList<>();

        AtomicInteger targetPointer = new AtomicInteger(0);
//        Stack<Integer> stack = new Stack<>();
//        var pointer = 1;
//
//        while( pointer <= n && targetPointer < target.length) {
//            stack.push(pointer++);
//            response.add("Push");
//            if(stack.peek() == target[targetPointer]) {
//                targetPointer++;
//            } else {
//                stack.pop();
//                response.add("Pop");
//            }
//        }

        AtomicInteger top = new AtomicInteger(-1);
        IntStream.range(1, n + 1).forEach(el -> {
            response.add("Push");
            top.set(el);

            if(targetPointer.intValue() < target.length) {
                if(top.intValue() == target[targetPointer.intValue()]) {
                    targetPointer.getAndIncrement();
                } else {
                    response.add("Pop");
                }
            }
        });

        return response;
    }
}
