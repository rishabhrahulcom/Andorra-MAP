package com.rishabhrahul.map.EPI;

import java.util.Arrays;

public class BS {

    int binarySearch(int [] array, int key){

        if(array == null || array.length == 0){
            return -1;
        }
        int low = 0;
        int high = array.length - 1;


        while(low <= high){
            int mid = low+( high-low)/2;

            if(array[mid] == key){
                return mid;
            }
            else if(array[mid] < key){
                // lies on left side
            low = mid+1;
            }
            else if(array[mid] > key){
                high = mid-1;
            }

        }
return -1;
    }

    int  binarySearchDecreasing(int[] array, int key){
        if(array == null || array.length == 0){
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int mid = low+( high-low)/2;
            if(array[mid] == key){
                return mid;
            }
            // [high        mid            low]
            // [start       mid            end]
            if(key < array[mid] ){
                low = mid+1;
            }
            else if(key > array[mid] ){
                high = mid-1;
            }

        }
    return -1;
    }
    public static void main(String[] args) {
        int [] array =  {1,2,3,4,5,6,7,8,9};
        BS bs = new BS();
        int [] sec = {0,8,7,6,5,4,3,2,1};
        System.out.println(bs.binarySearchDecreasing(sec, 2));
    }
}
