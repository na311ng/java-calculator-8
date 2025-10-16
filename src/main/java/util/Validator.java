package util;

public class Validator {
    public void validateToken(String token){
        if(token == null || token.isEmpty()){
            throw new IllegalArgumentException("token is empty");
        }
        if(!isAllDigits(token)){
            throw new IllegalArgumentException("token is not all digits : " + token);
        }

        int value = parseSafe(token);
        if(value <= 0){
            if(value == 0){
                throw new IllegalArgumentException("token value is negative");
            }
            throw new IllegalArgumentException("token value is " + value);
        }
    }

    private boolean isAllDigits(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private int parseSafe(String s){
        try{
            return Integer.parseInt(s);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("token is not all digits : " + s);
        }
    }
}
