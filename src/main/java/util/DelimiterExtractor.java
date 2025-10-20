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
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            boolean literalNewline = false;

            if (newlineIndex == -1) {
                newlineIndex = input.indexOf("\\n");
                literalNewline = true;
            }

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("[ERROR] 커스텀 구분자 형식이 잘못되었습니다.");
            }

            String header = input.substring(2, newlineIndex);
            if (header.length() != 1) {
                throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 한 글자여야 합니다.");
            }

            String custom = Pattern.quote(header);
            String numbers = input.substring(newlineIndex + (literalNewline ? 2 : 1));
            String regex = BASE_REGEX + "|" + custom;
            return new Result(numbers, regex);
        }

        if (input.contains("//")) {
            throw new IllegalArgumentException("[ERROR] '//'는 입력 맨 앞에서만 사용할 수 있습니다.");
        }

        return new Result(input, BASE_REGEX);
    }
}
