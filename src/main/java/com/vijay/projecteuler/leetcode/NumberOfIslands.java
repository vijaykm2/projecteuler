package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IslandNode {
    IslandNode right;
    IslandNode bottom;
    IslandNode left;
    IslandNode top;
}
class Island {
    IslandNode root;
}

@Component
public class NumberOfIslands implements CommandLineRunner {
    Set<String> visitedCells = new HashSet<>();
    void createIsland(char[][] grid, int i, int j, IslandNode root){
        char top = i-1 >-1 ? grid[i-1][j] : '0';
        char right = j+1 <grid[i].length ? grid[i][j+1] : '0';
        char left = j-1 >-1 ? grid[i][j-1] : '0';
        char bottom = i+1 < grid.length ? grid[i+1][j] : '0';
        if(right == '0'){
            visitedCells.add(i+","+(j+1));
        }if(left == '0'){
            visitedCells.add(i+","+(j-1));
        }if(top == '0'){
            visitedCells.add((i-1)+","+j);
        }if(bottom == '0'){
            visitedCells.add((i+1)+","+j);
        }
        // right node
        if(right == '1' && !visitedCells.contains(i+","+(j+1))){
            visitedCells.add(i+","+(j+1));
            root.right = new IslandNode();
            createIsland(grid, i, j+1, root.right);
        }
        // left node
        if(left == '1' && !visitedCells.contains(i+","+(j-1))){
            visitedCells.add(i+","+(j-1));
            root.left = new IslandNode();
            createIsland(grid, i, j-1, root.left);
        }
        // bottom node
        if(bottom =='1' && !visitedCells.contains((i+1)+","+j)){
            visitedCells.add((i+1)+","+j);
            root.bottom = new IslandNode();
            createIsland(grid, i+1, j, root.bottom);
        }
        // top node
        if(top =='1' && !visitedCells.contains((i-1)+","+j)){
            visitedCells.add((i-1)+","+j);
            root.top = new IslandNode();
            createIsland(grid, i-1, j, root.top);
        }

    }
    public int numIslands(char[][] grid) {
        List<IslandNode> roots = new ArrayList<>();
        IslandNode root = null;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[i].length; j++){
                if(!visitedCells.contains(i+","+j)){
                    if(grid[i][j] == '1'){
                        root = new IslandNode();
                        visitedCells.add(i+","+j);
                        createIsland(grid, i,j, root);
                        roots.add(root);
                    }
                }
            }
        }
        return roots.size();
    }
    @Override
    public void run(String... args) throws Exception {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println("grod length"+grid.length);
        System.out.println("grod[0] length"+grid[0].length);
       // System.out.println("number of islands = "+numIslands(grid));
        char[][] grid2 = new char[][]{
                {'1','0','0','1','1','1','0','1','1','0','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','1','1','0','0','1','0','0','0','1','0','1','0','1','0','0','1','0'},
                {'0','0','0','1','1','1','1','0','1','0','1','1','0','0','0','0','1','0','1','0'},
                {'0','0','0','1','1','0','0','1','0','0','0','1','1','1','0','0','1','0','0','1'},
                {'0','0','0','0','0','0','0','1','1','1','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','0','0','1','0','1','0','1','1','0','0','0','0','0','0','1','0','1'},
                {'0','0','0','1','0','0','0','1','0','1','0','1','0','1','0','1','0','1','0','1'},
                {'0','0','0','1','0','1','0','0','1','1','0','1','0','1','1','0','1','1','1','0'},
                {'0','0','0','0','1','0','0','1','1','0','0','0','0','1','0','0','0','1','0','1'},
                {'0','0','1','0','0','1','0','0','0','0','0','1','0','0','1','0','0','0','1','0'},
                {'1','0','0','1','0','0','0','0','0','0','0','1','0','0','1','0','1','0','1','0'},
                {'0','1','0','0','0','1','0','1','0','1','1','0','1','1','1','0','1','1','0','0'},
                {'1','1','0','1','0','0','0','0','1','0','0','0','0','0','0','1','0','0','0','1'},
                {'0','1','0','0','1','1','1','0','0','0','1','1','1','1','1','0','1','0','0','0'},
                {'0','0','1','1','1','0','0','0','1','1','0','0','0','1','0','1','0','0','0','0'},
                {'1','0','0','1','0','1','0','0','0','0','1','0','0','0','1','0','1','0','1','1'},
                {'1','0','1','0','0','0','0','0','0','1','0','0','0','1','0','1','0','0','0','0'},
                {'0','1','1','0','0','0','1','1','1','0','1','0','1','0','1','1','1','1','0','0'},
                {'0','1','0','0','0','0','1','1','0','0','1','0','1','0','0','1','0','0','1','1'},
                {'0','0','0','0','0','0','1','1','1','1','0','1','0','0','0','1','1','0','0','0'}
        };

        System.out.println("grod length"+grid.length);
        System.out.println("grod[0] length"+grid[0].length);
        System.out.println("number of islands = "+numIslands(grid2));

    }
}
