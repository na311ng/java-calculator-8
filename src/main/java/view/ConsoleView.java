package view;

public class ConsoleView {
    public void printPrompt(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
    public void printResult(int value){
        System.out.println("결과 : "+value);
    }
    public void printError(String message){
        System.out.println("[ERROR] " + message);
    }
}
