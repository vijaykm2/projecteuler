package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@Component
public class MinMeetingRooms implements CommandLineRunner {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        if(intervals.length == 1){
            return 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        queue.add(intervals[0][1]);
        for(int i = 1;i< intervals.length;i++){
            if(intervals[i][0]>=queue.peek()){
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
