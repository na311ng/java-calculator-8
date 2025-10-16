package util;

import java.util.regex.Pattern;

public class DelimiterExtractor {
    public static class Result {
        public final String numbers;
        public final String delimiterRegex;

        public Result(String numbers, String delimiterRegex) {
            this.numbers = numbers;
            this.delimiterRegex = delimiterRegex;
        }
    }

    private static final String BASE_REGEX = "(,|:)";

    public Result extract(String input) {
        if(input.startsWith("//")){
            int newlineIndex = input.indexOf('\n');
            if(newlineIndex < 0){
                throw new IllegalArgumentException("invalid input");
            }

            String header = input.substring(2, newlineIndex);
            if(header.length() != 1){
                throw new IllegalArgumentException("invalid input");
            }

            String custom = Pattern.quote(header);
            String numbers = input.substring(newlineIndex + 1);
            String regex = BASE_REGEX + "|" + custom;
            return new Result(numbers, regex);
        }

        if(input.startsWith("//")){
            throw new IllegalArgumentException("invalid input");
        }
        return new Result(input, BASE_REGEX);
    }
}
