package com.coderm.basics.javaBasics.day01.array;

/**
 * œﬂ–‘≤È’“
 */
public class linearSearch {
    public static void main(String[] args) {
        String arr[] = {"aa", "bb", "cc", "dd"};
        Boolean isFound = false;

        String find = "ee";

        for (int i=0; i<arr.length; i++) {
            if (find.equals(arr[i])) {
                System.out.println("success,location is:"+i);
                isFound = true;
                break;
            }
        }
        if (isFound == false) {
            System.out.println("fail");
        }
    }
}
