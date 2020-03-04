
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
	Random rand = new Random();
	private final int delay = 50;
	Timer timer = new Timer(delay, new TimerListener());
	int offset = 100;
	private final int FRAME_HEIGHT;
	private final int FRAME_WIDHT;


	public CarModel(int FRAME_HEIGHT, int FRAME_WIDHT) {
		this.FRAME_HEIGHT = FRAME_HEIGHT;
		this.FRAME_WIDHT = FRAME_WIDHT;
	}

	public void addCar(Vehicle car){
		int y = cars.size() * offset;
		car.position = new Point(0, y);
		cars.add(car);
		notifyObservers();
	}


	public void addRandomCar() {
		int n = rand.nextInt(3);
		if (cars.size() < 10)
			switch(n) {
			case 0:
				addCar(CarFactory.createVolvo240());
				break;
			case 1:
				addCar(CarFactory.createSaab95());
				break;
			case 2:
				addCar(CarFactory.createScania());
				break;
			} 
	}


	void removeCar() {
		if (cars.size() > 0)
			cars.remove(cars.size()-1);
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
			moveCar();
			notifyObservers();
		}
	}


	public void moveCar() {
		for (Vehicle car : cars) {
			car.move();				
			if (car.getPosition().getX() < 0 || car.getPosition().getX() > FRAME_WIDHT-100) {
				car.turnLeft();
				car.turnLeft();
			}
			if (car.getPosition().getY() < 0 || car.getPosition().getY() > FRAME_HEIGHT-100) {
				car.turnLeft();
				car.turnLeft();
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

