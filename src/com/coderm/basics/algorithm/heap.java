package com.coderm.basics.algorithm;

import java.util.PriorityQueue;

public class heap {
    //    public static class Acomp implements Comparator<Integer>{
    //    	public int compare(Integer arg0, Integer arg1){
    //    		return arg1 - arg0;
    //    	}
    //		}



    public static void main(String[] args){
        PriorityQueue<Integer> heap =  new PriorityQueue<Integer>( );

        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(5);
        heap.add(3);
        heap.add(9);
        heap.add(8);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
