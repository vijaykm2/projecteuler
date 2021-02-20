package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

class Server{
    int val;
    Server right;
    Server bottom;
    Server left;
    Server top;
}
//@Component
public class UpdateServersNumDays implements CommandLineRunner {
    int days = 0;
    Set<String> visitedCells = new HashSet<>();


    int minimumDays(int rows, int columns, List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        visitedCells = new HashSet<>();
        boolean hasZero = false;
        for(List<Integer> row: grid){
            hasZero = hasZero || row.contains(0);
        }
        if(!hasZero){
            return days;
        }
        Queue<Server> cells = new LinkedList();

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(!visitedCells.contains(i+','+j) && grid.get(i).get(j) ==1){
                    visitedCells.add(i+","+j);
                    if(i-1 >=0 && grid.get(i-1).get(j) ==0){
                        visitedCells.add((i-1)+","+j);

                        grid.get(i-1).set(j,1);

                    }
                    if(i+1<grid.size() && grid.get(i+1).get(j) ==0){
                        visitedCells.add((i+1)+","+j);

                        grid.get(i+1).set(j,1);
                    }
                    if(j+1< grid.get(i).size() && grid.get(i).get(j+1) ==0){
                        visitedCells.add(i+","+(j+1));

                        grid.get(i).set(j+1, 1);
                    }
                    if(j-1>=0 && grid.get(i).get(j-1) ==0){
                        visitedCells.add(i+","+(j-1));

                        grid.get(i).set(j-1, 1);
                    }
                }
            }
        }
        days++;
        return minimumDays(rows,columns,grid);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Min days: ");
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(new Integer[]{1,1,0,0}));
        grid.add(Arrays.asList(new Integer[]{0,0,1,0}));
        grid.add(Arrays.asList(new Integer[]{0,0,0,0}));
        grid.add(Arrays.asList(new Integer[]{1,0,1,1,}));
        grid.add(Arrays.asList(new Integer[]{1,1,1,1}));
        System.out.println(minimumDays(4,4,grid));

    }
}
