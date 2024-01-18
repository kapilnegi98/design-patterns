package designpatterns.creational.abstractfactory;

/**
 * @author Kapil Negi
 */
interface Button{
    void print();
}
class WindowsButton implements Button{

    @Override
    public void print() {
        System.out.println("Print Windows Button...");
    }
}
class MacButton implements Button{

    @Override
    public void print() {
        System.out.println("Print Mac Button...");
    }
}
interface Checkbox{
    void print();
}
class WindowsCheckbox implements Checkbox{
    @Override
    public void print() {
        System.out.println("Print Windows Checkbox...");
    }
}
class MacCheckbox implements Checkbox{
    @Override
    public void print() {
        System.out.println("Print Mac Checkbox...");
    }
}
interface GuiFactory{
    Button createButton();
    Checkbox createCheckbox();
}
class MacFactory implements  GuiFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
class WindowsFactory implements  GuiFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
class Application{
    private Button button;
    private Checkbox checkbox;
    Application(GuiFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    void print(){
        button.print();
        checkbox.print();
    }
}
public class AbstractFactory {
    private static Application configureApplication() {
        Application app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }
    public static void main(String[] args) {
        Application app = configureApplication();
                app.print();
    }
}
