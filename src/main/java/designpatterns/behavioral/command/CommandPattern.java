package designpatterns.behavioral.command;

import java.util.Stack;

/**
 * @author Kapil Negi
 */

// Invoker  ->  Command  -> Receiver



    //Receiver
class Light{
    void lightON(){
        System.out.println("light on");
    }

    void lightOFF(){
        System.out.println("light OFF");
    }
}


//Command
interface Command{
    public void execute();
    public void undo();
}


class LightOnCommand implements Command{
    Light light;
    LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.lightON();
    }

    @Override
    public void undo() {
        light.lightOFF();
    }
}
class LightOFFCommand implements Command{
    Light light;
    LightOFFCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.lightOFF();
    }
    public void undo() {
        light.lightON();
    }
}


//Invoker
class RemoteController{

    // better to create a class CommandHistory with push pop methods
    Stack<Command> commandHistory;

    public RemoteController(){
        this.commandHistory = new Stack<>();
    }
    Command command;

    void setCommand(Command command){
        this.command = command;
        commandHistory.push(command);
    }
    void pressButton(){
        command.execute();
    }
    void undo(){
        if(!commandHistory.isEmpty()){
            Command command = commandHistory.pop();
            command.undo();
        }
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        /*If we directly call the reveiver from client there are problems:
        * 1. lack of abstraction/ tight coupling: process of turning on light is simple but let say we
        * want to add more commands/steps then client have to know each step
        * 2. We can easily add new commands without any change in any other code Open/Close principle
        * 3. undo/redo can be implemented
        * */



        RemoteController remoteController = new RemoteController();
        Command lightONCommand = new LightOnCommand(new Light());
        remoteController.setCommand(lightONCommand);
        remoteController.pressButton();
    }

}

