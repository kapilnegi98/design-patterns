package designpatterns.structural.decorator;

/**
 * @author Kapil Negi
 */
abstract class Pizza{
    public String description = "Base Pizza";
    public String getDescription(){
        return description;
    }
    public abstract long getCost();
}
class Margherita extends Pizza{
    public Margherita(){
        description = "Margherita";
    }
    @Override
    public long getCost() {
        return 100;
    }
}
class FarmHouse extends Pizza{
    public FarmHouse(){
        description = "FarmHouse";
    }
    @Override
    public long getCost() {
        return 200;
    }
}
abstract class Condiments extends Pizza{
    @Override
    public abstract String getDescription();
}
class Cheese extends Condiments{
    Pizza pizza;
    Cheese(Pizza pizza){
        this.pizza = pizza;
    }
    public String getDescription(){
        return pizza.getDescription() + ", Cheese";
    }
    @Override
    public long getCost() {
        return pizza.getCost() + 10;
    }
}
class Veggies extends Condiments{
    Pizza pizza;
    Veggies(Pizza pizza){
        this.pizza = pizza;
    }
    public String getDescription(){
        return pizza.getDescription() + ", Veggies";
    }
    @Override
    public long getCost() {
        return pizza.getCost() + 20;
    }
}
public class Decorator {
    public static void main(String[] args) {
        //want FarmHouse with double extra cheese + extra veggies
        Pizza pizza = new FarmHouse();
        pizza = new Cheese(pizza);
        pizza = new Cheese(pizza);
        pizza = new Veggies(pizza);
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
    }
}
