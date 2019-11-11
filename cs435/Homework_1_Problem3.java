package com.pragati.cs435;

import java.util.*;

/**
 * Created by pragati on 11/11/19.
 */
public class Homework_1_Problem3 {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList();

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        for(int i=0;i<size;i++){
            array.add(sc.nextInt());
        }

        Collections.sort(array);
        Collections.reverse(array);

        int sum = 0;

        for(int i=0;i<size;i++){

            if((i+1)%3!=0)
            {
                sum += array.get(i);
            }
        }
        System.out.println(sum);
    }
}