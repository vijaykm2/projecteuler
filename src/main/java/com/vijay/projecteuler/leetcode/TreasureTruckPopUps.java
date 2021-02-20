package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

class TreasureTruckPupup {
    TreasureTruckPupup right;
    TreasureTruckPupup bottom;
    TreasureTruckPupup left;
    TreasureTruckPupup top;
}
@Component
public class TreasureTruckPopUps implements CommandLineRunner {
    Set<String> visitedCells = new HashSet<>();
    void createTreasureTruckPopup(List<List<Integer>> grid, int i, int j, TreasureTruckPupup root){
        Integer top = i-1 >-1 ? grid.get(i-1).get(j) : 0;
        Integer right = j+1 <grid.get(i).size() ? grid.get(i).get(j+1) : 0;
        Integer left = j-1 >-1 ? grid.get(i).get(j-1) : 0;
        Integer bottom = i+1 < grid.size() ? grid.get(i+1).get(j) : 0;
        if(right == 0){
            visitedCells.add(i+","+(j+1));
        }if(left == 0){
            visitedCells.add(i+","+(j-1));
        }if(top == 0){
            visitedCells.add((i-1)+","+j);
        }if(bottom == 0){
            visitedCells.add((i+1)+","+j);
        }
        // right node
        if(right == 1 && !visitedCells.contains(i+","+(j+1))){
            visitedCells.add(i+","+(j+1));
            root.right = new TreasureTruckPupup();
            createTreasureTruckPopup(grid, i, j+1, root.right);
        }
        // left node
        if(left == 1 && !visitedCells.contains(i+","+(j-1))){
            visitedCells.add(i+","+(j-1));
            root.left = new TreasureTruckPupup();
            createTreasureTruckPopup(grid, i, j-1, root.left);
        }
        // bottom node
        if(bottom ==1 && !visitedCells.contains((i+1)+","+j)){
            visitedCells.add((i+1)+","+j);
            root.bottom = new TreasureTruckPupup();
            createTreasureTruckPopup(grid, i+1, j, root.bottom);
        }
        // top node
        if(top ==1 && !visitedCells.contains((i-1)+","+j)){
            visitedCells.add((i-1)+","+j);
            root.top = new TreasureTruckPupup();

            createTreasureTruckPopup(grid, i-1, j, root.top);
        }

    }
    int numberAmazonTreasureTrucks(int rows, int column,
                                   List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        if(grid == null || grid.size() == 0){
            return 0;
        }
        List<TreasureTruckPupup> roots = new ArrayList<>();
        TreasureTruckPupup root = null;
        for(int i = 0; i<grid.size();i++){
            for(int j = 0; j<grid.get(i).size(); j++ ){
                if(!visitedCells.contains((i+","+j))){
                    if (grid.get(i).get(j) ==1){
                        root = new TreasureTruckPupup();
                        visitedCells.add(i+","+j);
                        createTreasureTruckPopup(grid, i, j, root);
                        roots.add(root);
                    }
                }
            }
        }
        return roots.size();
    }
    @Override
    public void run(String... args) throws Exception {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(new Integer[]{1,1,0,0}));
        grid.add(Arrays.asList(new Integer[]{0,0,1,0}));
        grid.add(Arrays.asList(new Integer[]{0,0,0,0}));
        grid.add(Arrays.asList(new Integer[]{1,0,1,1,}));
        grid.add(Arrays.asList(new Integer[]{1,1,1,1}));
        System.out.println("**** Number of treasure truckpopups");
        System.out.println(numberAmazonTreasureTrucks(5, 4, grid));
    }
}
