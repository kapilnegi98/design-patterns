package designpatterns.behavioral.chainofresponsibility;



/**
 * @author Kapil Negi
 */

class Currency {

    private int amount;

    public Currency(int amt){
        this.amount=amt;
    }

    public int getAmount(){
        return this.amount;
    }
}

abstract class DispenseChain{
    private DispenseChain next;
        private int value;
        DispenseChain(int value){
            this.value = value;
        }
    public static DispenseChain link(DispenseChain first, DispenseChain... chain) {
        DispenseChain head = first;
        for (DispenseChain nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }
    abstract boolean dispense(Currency cur);

    boolean checkNext(Currency currency) {
        if (next == null) {
            return true;
        }
       return next.dispense(currency);
    }
}
/**
 * ConcreteHandler. Checks whether there are too many failed login requests.
 */
class Dollar50Dispenser extends DispenseChain {
    Dollar50Dispenser(int value) {
        super(value);
    }

    @Override
    public boolean dispense(Currency cur) {
        if(cur.getAmount() >= 50){
            int num = cur.getAmount()/50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing "+num+" 50$ note");
            if(remainder !=0) return this.checkNext(new Currency(remainder));
        }else{
            return this.checkNext(cur);
        }
        return true;
    }
}
class Dollar20Dispenser extends DispenseChain {
    Dollar20Dispenser(int value) {
        super(value);
    }

    @Override
    public boolean dispense(Currency cur) {
        if(cur.getAmount() >= 20){
            int num = cur.getAmount()/20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing "+num+" 50$ note");
            if(remainder !=0) return this.checkNext(new Currency(remainder));
        }else{
            return this.checkNext(cur);
        }
        return true;
    }
}
public class COR {
    public static void main(String[] args) {
        DispenseChain dispenseChain = DispenseChain.link(new Dollar50Dispenser(50),
                new Dollar20Dispenser(20));
        dispenseChain.dispense(new Currency(100));
    }
}

