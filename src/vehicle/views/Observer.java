package vehicle.views;

import java.util.ArrayList;

import vehicles.Vehicle;

public interface Observer {

	public void update(ArrayList<Vehicle> cars);
}