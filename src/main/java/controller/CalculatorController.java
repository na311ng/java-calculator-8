package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Calculator;
import model.StringParser;
import util.DelimiterExtractor;
import util.Validator;
import view.ConsoleView;

public class CalculatorController {
    private final ConsoleView view = new  ConsoleView();
    private final StringParser parser = new  StringParser(new DelimiterExtractor(), new Validator());
    private final Calculator calculator = new Calculator();

    public void run(){
        try{
            view.printPrompt();
            String input = Console.readLine();

            int result = calculator.sum(parser.parse(input));
            view.printResult(result);
        }catch(IllegalArgumentException e){
            view.printError(e.getMessage());
        }finally{
            Console.close();
        }
    }
}
