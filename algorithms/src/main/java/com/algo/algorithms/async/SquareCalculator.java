package com.algo.algorithms.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {


    public Future<Integer> calculate(Integer input) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            if(input%2==1)Thread.sleep(1000);
            return input * input;
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future1=null;
        for(int i=1;i<10;i++){
            //future1 = squareCalculator.calculate(i);
            System.out.println(squareCalculator.calculateSync(i));
        }
        //Integer result1 = future1.get();



    }
    private int calculateSync(int n) throws InterruptedException{
        if(n%2==1)Thread.sleep(1000);
        return n*n;
    }
}
