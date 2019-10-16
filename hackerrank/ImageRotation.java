package com.pragati.hackerrank;

/**
 * Created by pragati on 13/10/19.
 */
public class ImageRotation{

    public static int[][] imageRotation(int[][] a){

        int n= a.length;
        for(int i=0;i<n/2;i++)
        {
            int k=n-1-i;
            int offset = i;
            int count = k-offset;
            for(int j=k;j>0 & count>0 ;j--,count--)
            {
                int temp = a[k][j];
                a[k][j] = a[offset][k];
                a[offset][k] = a[i][offset];
                a[i][offset]=a[j][i];
                a[j][i]=temp;

                offset++;
            }
        }

        return a;
    }

    public static void main(String[] args){

        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        a = imageRotation(a);

        int n = a.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
