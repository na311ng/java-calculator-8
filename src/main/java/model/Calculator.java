package model;

import java.util.List;

public class Calculator {
    public int sum(List<Integer> numbers){
        int total = 0;
        for(int n : numbers){
            total += n;
        }
        return total;
    }
}
