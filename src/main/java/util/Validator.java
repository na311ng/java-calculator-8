package util;

public class Validator {
    public void validateToken(String token){
        if(token.isEmpty()){
            throw new IllegalArgumentException("token is empty");
        }
        if(!token.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("token is not digit : " + token);
        }

        int value = Integer.parseInt(token);
        if(value < 0){
            throw new IllegalArgumentException("token value is negative");
        }
    }
}
