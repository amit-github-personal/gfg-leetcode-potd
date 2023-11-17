package com.example.challanges.leetcode75;

import java.util.Stack;

/*

Tag: Medium

Problem Statement.


We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 */
public class AsteroidCollision {

    public static void main(String[] args) {
        for (int e: solveWithStack(new int[]{10,2,-5}) ) {
            System.out.print(e + " ");
        }
    }

    /*

    Example 1:

    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Example 2:

    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:

    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

     */


    public static int[] solveWithStack(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(stack.isEmpty() || asteroids[i] >= 0){
                stack.push(asteroids[i]);
            }else{
                if(stack.peek() < 0){
                    stack.push(asteroids[i]);
                }else if(stack.peek() == -asteroids[i]){
                    stack.pop();
                }else if(stack.peek() > -asteroids[i]){
                    continue;
                }else{
                    while(!stack.isEmpty() && stack.peek() >= 0 && stack.peek() < -asteroids[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek() == -asteroids[i]){
                        stack.pop();
                    }else if(!stack.isEmpty() && stack.peek() > -asteroids[i]){
                        continue;
                    }else{
                        stack.push(asteroids[i]);
                    }
                }

            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }


}
