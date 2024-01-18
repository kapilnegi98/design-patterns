package designpatterns.creational.factory;

interface Button{
    void onClick();
    void render();
}
class HtmlButton implements  Button{

    @Override
    public void onClick() {
        System.out.println("HTML button clicked");
    }

    @Override
    public void render() {
        System.out.println("Rendering HTML button...");
        onClick();
    }
}
class WindowButton implements  Button{

    @Override
    public void onClick() {
        System.out.println("Window button clicked");
    }

    @Override
    public void render() {
        System.out.println("Rendering Window button...");
        onClick();
    }
}
abstract class Dialog{
    void renderButton(){
        Button button = createButton();
        button.render();
    }
    abstract Button createButton();
}
class HtmlDialog extends Dialog{

    @Override
    Button createButton() {
        return new HtmlButton();
    }
}
class WindowDialog extends Dialog{

    @Override
    Button createButton() {
        return new WindowButton();
    }
}
public class Factory {
    private static Dialog dialog;
    public static void main(String[] args) {
        configure("window");
        dialog.renderButton();
    }
    static Dialog configure(String type){
        if(type == "window"){
            return new WindowDialog();
        }else {
            return new HtmlDialog();
        }
    }

}
