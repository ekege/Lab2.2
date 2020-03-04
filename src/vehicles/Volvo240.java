package vehicles;


import java.awt.*;


/**
 * Represents a car of type "Volvo 240"
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    /**
     * Returns the speed factor as a product of the trimFactor.
     * @return speedFactor
     */
    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public boolean isTransportable() {
        return true;
    }


}
