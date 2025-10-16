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

        var result = delimiterExtractor.extract(input);
        String[] tokens = result.numbers.split(result.delimiterRegex, -1);
        List<Integer> parsed = new ArrayList<>(tokens.length);
        for(String raw : tokens){
            String token = raw.trim();
            validator.validateToken(token);
            parsed.add(Integer.parseInt(token));
        }
        return parsed;
    }
}
