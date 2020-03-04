package vehicles;


import java.awt.*;


/**
 * Represents a car of type "Saab 95"
 */
public class Saab95 extends Car {

	private boolean turboOn;

	public Saab95(){
		super(2, Color.red, 125, "Saab95");
		turboOn = false;
	}

	/**
	 * Returns the speed factor as a product of the turbo.
	 * @return speedFactor
	 */
	@Override
	protected double speedFactor(){
		double turbo = 1;
		if(turboOn) turbo = 1.2;
		return getEnginePower() * 0.01 * turbo;
	}

	/**
	 * Sets turbo to on.
	 */
	public void setTurboOn(){
		turboOn = true;
	}

	/**
	 * Sets turbo to off.
	 */
	public void setTurboOff(){
		turboOn = false;
	}


}
