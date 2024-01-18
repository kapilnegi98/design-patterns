package designpatterns.behavioral.chainofresponsibility.Logger;

/**
 * @author Kapil Negi
 */
public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR, "Error thrown");
        logProcessor.log(LogProcessor.INFO, "This is info");
        logProcessor.log(LogProcessor.DEBUG, "Debugging...");
    }
}
