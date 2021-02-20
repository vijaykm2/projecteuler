package com.vijay.projecteuler;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER startRow
     *  3. INTEGER startCol
     *  4. INTEGER endRow
     *  5. INTEGER endCol
     */
   public static Set<String> getVisitableBoxes(int arrSize, int row, int col){
       Set<String> boxes = new HashSet<>();
       if(row+2 <=arrSize-1 && col+1<=arrSize-1){
           boxes.add((row+2)+""+(col+1));
       }
       if(row+2 <=arrSize-1 && col-1>=0){
           boxes.add((row+2)+""+(col-1));
       }
       if(row-2 >= 0 && col+1<=arrSize-1){
           boxes.add((row-2)+""+(col+1));
       }
       if(row-2 >= 0 && col-1>=0){
           boxes.add((row-2)+""+(col+1));
       }


       if(col+2 <=arrSize-1 && row+1<=arrSize-1){
           boxes.add((row+1)+""+(col+2));
       }
       if(col+2 <=arrSize-1 && row-1>=0){
           boxes.add((row-1)+""+(col+2));
       }
       if(col-2 >= 0 && row+1<=arrSize-1){
           boxes.add((row+1)+""+(col-2 ));
       }
       if(col-2 >= 0 && row-1>=0){
           boxes.add((row+1)+""+(col-2 ));
       }
       return boxes;
   }
    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        // Write your code here
      String root = ""+startRow+""+startCol;
      String end = ""+endRow+""+endCol;
        Set<String> visited = new HashSet<>();
        Queue<String> bfsQueue = new LinkedList<>();

        visited.add(root);
        bfsQueue.add(root);
        int steps = 0;
        boolean found = false;
        while(!bfsQueue.isEmpty()){
            String box = bfsQueue.remove();
            if(box.equals(end)){
                found = true;
                break;
            }
            int[] boxint = Arrays.stream(box.split("")).mapToInt(i ->Integer.valueOf(i)).toArray();
            Set<String> visitables = getVisitableBoxes(n,boxint[0],boxint[1]);
            boolean newLevel = true;

            for (String visitable: visitables
                 ) {
                if(!visited.contains(visitable)) {
                    visited.add(visitable);
                    bfsQueue.add(visitable);
                    if(newLevel) {
                        steps++;
                        newLevel = false;
                    }
                }
            }


        }
        if(!found){
            return -1;
        }else{
            return steps;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int startRow = Integer.parseInt(bufferedReader.readLine().trim());

        int startCol = Integer.parseInt(bufferedReader.readLine().trim());

        int endRow = Integer.parseInt(bufferedReader.readLine().trim());

        int endCol = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.minMoves(n, startRow, startCol, endRow, endCol);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
