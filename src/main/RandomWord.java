package main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String word, champion = null;
        int count = 0;

        while(!StdIn.isEmpty()){
            word = StdIn.readString();
            count ++;
            if(StdRandom.bernoulli(1/count))
                champion = word;
        }
        System.out.println(champion);


    }
}