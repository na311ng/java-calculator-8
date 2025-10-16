package model;

import util.DelimiterExtractor;
import util.Validator;

import java.util.ArrayList;
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

        DelimiterExtractor.Result result = delimiterExtractor.extract(input);

        String[] tokens = result.numbers.split(result.delimiterRegex);
        List<Integer> parsed = new ArrayList<>();

        for(String token : tokens){
            String trimmed = token.trim();
            validator.validateToken(trimmed);
            parsed.add(Integer.parseInt(trimmed));
        }
        return parsed;
    }
}
