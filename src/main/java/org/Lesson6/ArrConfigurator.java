package org.Lesson6;
import org.slf4j.LoggerFactory;
import java.util.logging.*;


public class ArrConfigurator {
    private static final Logger logger = Logger.getLogger(ArrConfigurator.class.getName());
    public int[] arrayReturner(int[] arr){

        int size = arr.length%4;
        int diference = arr.length - size;
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i]=arr[diference+i];
        }
        return newArr;
    }


}
