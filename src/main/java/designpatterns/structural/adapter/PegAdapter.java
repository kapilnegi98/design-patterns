package designpatterns.structural.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kapil Negi
 */

class RoundPeg{
    double radius;
    public RoundPeg(){}
    public RoundPeg(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
}

class RoundHole{
    double radius;
    public RoundHole(double radius){
        this.radius = radius;
    }
    public boolean fit(RoundPeg roundPeg){
       return roundPeg.getRadius() <= this.radius;
    }
}
class SquarePegAdapter extends RoundPeg{
    SquarePeg squarePeg;
    public SquarePegAdapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }
    @Override
    public double getRadius(){
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2));
        return result;
    }
}
class SquarePeg{
    double width;
    public SquarePeg(double radwidthius){
        this.width = width;
    }
    public double getWidth(){
        return this.width;
    }
}

public class PegAdapter {
    public static void main(String[] args) throws IOException {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(4);
        System.out.println(roundHole.fit(roundPeg));

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        roundHole.fit(smallSqPegAdapter);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String s = br.readLine();
        System.out.print("Enter input: " + s);
    }
}
