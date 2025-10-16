package model;

import util.DelimiterExtractor;
import util.Validator;

import java.util.List;

public class StringParser {
    private final DelimiterExtractor delimiterExtractor;
    private final Validator validator;

    public StringParser(DelimiterExtractor delimiterExtractor, Validator validator) {
        this.delimiterExtractor = delimiterExtractor;
        this.validator = validator;
    }

    public List<Integer> parse(String input){
        if(input == null || input.isEmpty()){
            return List.of();
        }
        return List.of(); // TODO: implement parsing in next step
    }
}
