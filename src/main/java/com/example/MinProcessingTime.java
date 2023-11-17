package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/*

You have n processors each having 4 cores and n * 4 tasks that need to be executed such that each core should perform
only one task.

Given a 0-indexed integer array processorTime representing the time at which each processor becomes available for the
first time and a 0-indexed integer array tasks representing the time it takes to execute each task, return the minimum time when all of the tasks have been executed by the processors.

Note: Each core executes the task independently of the others.

 */
public class MinProcessingTime {


    public static void main(String[] args) {
        System.out.println(minProcessingTime(Arrays.asList(8, 10), Arrays.asList(2,2,3,1,8,7,4,5)));
    }

    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks, (a, b) -> b - a);
        Collections.sort(processorTime);

        int res = Integer.MIN_VALUE;
        int pointer = 0;
        for(int i = 0; i < processorTime.size(); i++) {
            int thisProcessor = processorTime.get(i);
            int maxThisProcessor = 0;
            int k = pointer;
            for(; k < Math.min(pointer + 4, tasks.size()); k++) {
                maxThisProcessor = Math.max(thisProcessor + tasks.get(k), maxThisProcessor);
            }
            pointer = k;
            res = Math.max(maxThisProcessor, res);
        }

        return res;
    }
}
