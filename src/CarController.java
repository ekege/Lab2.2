import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
	private CarModel model;
	private CarView view;
	int gasAmount = 0;


	public CarController(CarModel model, CarView view) {
		this.model = model;
		this.view = view;
		initControls();
	}

	private void initControls() {

		view.gasSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				gasAmount = (int) ((JSpinner)e.getSource()).getValue();
			}
		});

		view.gasButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.gas(gasAmount);
			}
		});

		view.brakeButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.brake(gasAmount);
			}
		} );
		view.turboOnButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.turboOn();
			}
		} );
		view.turboOffButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.turboOff();
			}
		} );
		view.liftBedButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.liftBed();
			}
		} );
		view.lowerBedButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.lowerBed();
			}
		} );
		view.startButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.start();
			}
		});
		view.stopButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.stop();
			}
		});
		view.addCarButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addRandomCar();
			}
		});
		view.removeCarButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeCar();
			}

		});

	}
}


