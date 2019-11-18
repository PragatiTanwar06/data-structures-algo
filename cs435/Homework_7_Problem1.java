package com.pragati.cs435;

import java.util.Scanner;

/**
 * Created by pragati on 17/11/19.
 */
public class Homework_7_Problem1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt();

        int []srcPosition = new int[2];
        srcPosition[0] = sc.nextInt();
        srcPosition[1] = sc.nextInt();

        int []destPosition = new int[2];
        destPosition[0] = sc.nextInt();
        destPosition[1] = sc.nextInt();

        int[][] grid = new int[dim][dim];

        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(sc.next().equals("X"))
                    grid[i][j] = 2;
                else
                    grid[i][j] = 1;
            }
        }

        int cost = dijkstra(grid,srcPosition,destPosition,dim);
        System.out.println(cost);

    }

    private static int dijkstra(int[][] grid, int[] srcPosition, int[] destPosition,int dim) {

        boolean isVisited[][] = new boolean[dim][dim];
        int vertex[][] = new int[dim][dim];

        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                vertex[i][j] = Integer.MAX_VALUE;

            }
        }

        vertex[srcPosition[0]][srcPosition[1]] = 0;

        while(isVisited[destPosition[0]][destPosition[1]]!=true){

            int[] minPosition = getMin(vertex,dim,isVisited);
            isVisited[minPosition[0]][minPosition[1]] = true;

            vertex = checkForAllAdjMoves(vertex,grid,dim,minPosition,isVisited);

        }
        return vertex[destPosition[0]][destPosition[1]];
    }

    private static boolean isInRange(int i, int j, int dim){

        if(i>=0 && i<dim && j>=0 && j<dim)
            return true;

        return false;
    }

    private static int[][] checkForAllAdjMoves(int[][] vertex, int[][] grid,int dim,int[] minPosition,boolean[][] isVisited) {

        int i = minPosition[0];
        int j = minPosition[1];

        int srcDistance = vertex[i][j];

        //for moving up
        if(isInRange(i-1,j,dim) && !isVisited[i-1][j] && vertex[i-1][j]>(srcDistance+grid[i-1][j])){
            vertex[i-1][j] = srcDistance+grid[i-1][j];
        }
        //for moving down
        if(isInRange(i+1,j,dim) && !isVisited[i+1][j] && vertex[i+1][j]>(srcDistance+grid[i+1][j])){
            vertex[i+1][j] = srcDistance+grid[i+1][j];
        }
        //for moving left
        if(isInRange(i,j-1,dim) && !isVisited[i][j-1] && vertex[i][j-1]>(srcDistance+grid[i][j-1])){
            vertex[i][j-1] = srcDistance+grid[i][j-1];
        }
        //for moving right
        if(isInRange(i,j+1,dim) && !isVisited[i][j+1] && vertex[i][j+1]>(srcDistance+grid[i][j+1])){
            vertex[i][j+1] = srcDistance+grid[i][j+1];
        }
        //for moving diagonal right up
        if(isInRange(i-1,j+1,dim) && !isVisited[i-1][j+1] && vertex[i-1][j+1]>(srcDistance+grid[i-1][j+1])){
            vertex[i-1][j+1] = srcDistance+grid[i-1][j+1];
        }
        //for moving diagonal left up
        if(isInRange(i-1,j-1,dim) && !isVisited[i-1][j-1] && vertex[i-1][j-1]>(srcDistance+grid[i-1][j-1])){
            vertex[i-1][j-1] = srcDistance+grid[i-1][j-1];
        }
        //for moving diagonal down left
        if(isInRange(i+1,j-1,dim) && !isVisited[i+1][j-1] && vertex[i+1][j-1]>(srcDistance+grid[i+1][j-1])){
            vertex[i+1][j-1] = srcDistance+grid[i+1][j-1];
        }
        //for moving diagonal down right
        if(isInRange(i+1,j+1,dim) && !isVisited[i+1][j+1] && vertex[i+1][j+1]>(srcDistance+grid[i+1][j+1])){
            vertex[i+1][j+1] = srcDistance+grid[i+1][j+1];
        }

        return vertex;
    }

    private static int[] getMin(int[][] vertex,int dim,boolean[][] isVisited) {

        int minCost = Integer.MAX_VALUE;

        int minPosition[] = new int[2];

        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(minCost > vertex[i][j] && !isVisited[i][j]){
                    minPosition[0] = i;
                    minPosition[1] = j;
                    minCost = vertex[i][j];
                }
            }
        }

        return minPosition;
    }

}
