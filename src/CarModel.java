
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import vehicle.views.Observer;
import vehicle.views.Subject;
import vehicles.*;

public class CarModel implements Subject {
	/**
	 * 
	 */
	private ArrayList<Observer> observers = new ArrayList<>();
	ArrayList<Vehicle> cars = new ArrayList<>();
	private final int delay = 50;
	Timer timer = new Timer(delay, new TimerListener());
	int offset = 100;


	public void addCar(Vehicle car){
		int y = cars.size() * offset;
		car.position = new Point(0, y);
		cars.add(car);
		notifyObservers();
	}

	public void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (Vehicle car : cars) {
			car.gas(gas);
		}
	}
	public void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (Vehicle car : cars) {
			car.brake(brake);
		}
	}

	public void start() {
		for (Vehicle car : cars) {
			car.startEngine();
		}
	}

	public void stop() {
		for (Vehicle car : cars) {
			car.stopEngine();
		}
	}

	public void turboOn(){
		for (Vehicle car : cars) {
			if (car.getModelName() == "Saab95")
				((Saab95) car).setTurboOn();
		}
	}

	public	void turboOff(){
		for (Vehicle car : cars) {
			if (car.getModelName() == "Saab95")
				((Saab95) car).setTurboOff();
		}
	}

	public	void liftBed() {
		for (Vehicle car : cars) {
			if (car.getModelName() == "Scania")
				((Scania) car).increaseBedAngle(30);
		}
	}

	public	void lowerBed() {
		for (Vehicle car : cars) {
			if (car.getModelName() == "Scania")
				((Scania) car).decreaseBedAngle(30);
		}
	}


	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Vehicle car : cars) {
				car.move();
				if (car.getPosition().getX() < 0 || car.getPosition().getX() > 800) {
					car.turnLeft();
					car.turnLeft();
				}
				if (car.getPosition().getY() < 0 || car.getPosition().getY() > 800) {
					car.turnLeft();
					car.turnLeft();
				}
				notifyObservers();
			}
		}

	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);

	}
	@Override
	public void notifyObservers() {
		for (Observer observer : observers)
			observer.update(cars);
	}
}

