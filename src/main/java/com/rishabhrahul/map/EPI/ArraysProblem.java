package com.rishabhrahul.map.EPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class ArraysProblem implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {

        return o1.compareTo(o2);
    }
static List<String> getProblemList(){

    return List.of("Dutch National Flag");
}

    /**
     * things that this problem can have?
     * 1. group by
     */

   int DutchNationalFlag(List<Character> list, int l, int r ){

       int pivot = new Random().nextInt(r-l+1) + l;
       char pivotVal = list.get(pivot);

       int low= l-1;
       int runner = l;
       while (runner < r){
           if(compare(list.get(runner),pivotVal) < 0){
               System.out.println("runner "+ list.indexOf(runner)+ " pivot value "+ Character.toString(pivotVal) + " low"+low);
               low++;

               swap(list, runner, low);


           }

            runner++;
       }
       System.out.println(list);
       System.out.println(low);
       System.out.println(list.get(runner));
       System.out.println(list.get(pivot));
     swap(list,   low+1, pivot);

    return low+1;

    }

    void QuickSort(List<Character> list, int l, int r){
        if(l < r){
         int p =     DutchNationalFlag(list, l, r);
         QuickSort(list, l, p-1);
         QuickSort(list, p + 1, r);
        }
    }


    public static void main(String[] args) {
        ArraysProblem problem = new ArraysProblem();
        List<Character> l = new ArrayList<>();
        l.add('A');
        l.add('Z');
        l.add('C');
        l.add('B');
        l.add('E');
        l.add('D');



           problem.QuickSort(l,0,l.size()-1);//.forEach(System.out::println);
        System.out.println(l);
    }



}
