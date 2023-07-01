package org.Lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2,2,2};
       ArrConfigurator arConf = new ArrConfigurator();
        System.out.println(Arrays.toString(arConf.arrayReturner(arr)));


    }



}