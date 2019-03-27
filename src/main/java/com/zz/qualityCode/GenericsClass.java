package com.zz.qualityCode;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

class Food{
    public Food() {
    }
}

public class GenericsClass<T> {
    private T t;

    public T[] gettArray() {
        return tArray;
    }

    private T[] tArray;

    public GenericsClass(){
        try {
            Class.forName("java.lang.Integer");
            t = (T) Class.forName("com.zz.qualityCode.Food").newInstance();
            tArray = (T[]) Array.newInstance(Class.forName("com.zz.qualityCode.Food") , 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer e = 0;
        Food[] arr = (Food[]) new GenericsClass().gettArray();
        System.out.println(arr.length);


    }
}
