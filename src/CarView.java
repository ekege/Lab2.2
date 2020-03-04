import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import vehicle.views.Observer;
import vehicles.PanelCars;
import vehicles.Vehicle;




///**
//* This class represents the full view of the MVC pattern of your car simulator.
//* It initializes with being center on the screen and attaching it's controller in it's state.
//* It communicates with the Controller by calling methods of it when an action fires of in
//* each of it's components.
//**/


public class CarView extends JFrame implements Observer {

	/**
	 * 
	 */
	private String versionNumber = "1.2";
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDHT = 800;
	private static final int FRAME_HEIGHT = 800;

	PanelCars panelCars;

	JPanel viewPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel gasPanel = new JPanel();

	JSpinner gasSpinner = new JSpinner();

	JLabel gasLabel = new JLabel("Amount of gas");

	JButton gasButton = new JButton("Gasa");
	JButton brakeButton = new JButton("Brake");
	JButton turboOnButton = new JButton("<html><center>Saab<br/>Turbo On</center></html>");
	JButton turboOffButton = new JButton("<html><center>Saab<br/>Turbo Off</center></html>");
	JButton liftBedButton = new JButton("<html><center>Scania<br/>Raise Bed</center></html>");
	JButton lowerBedButton = new JButton("<html><center>Scania<br/>Lower Bed</center></html>");
	JButton startButton = new JButton("Start all cars");
	JButton stopButton = new JButton("Stop all cars");
	JButton addCarButton = new JButton("<html><center>Add<br/>Car</center></html>");
	JButton removeCarButton = new JButton("<html><center>Remove<br/>Car</center></html>");

	// Constructor
	public CarView(CarModel cars){
		panelCars = new PanelCars(cars.cars, FRAME_WIDHT, FRAME_HEIGHT-240);
		initComponents(panelCars);
	}
	
	
	private void initComponents(PanelCars panelCars) {
		
		setTitle("CarSim " + versionNumber);
		setSize(new Dimension(FRAME_WIDHT, FRAME_HEIGHT));
		setLayout(new FlowLayout(FlowLayout.LEFT , 0, 0));
		// Get the computer screen resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Center the frame
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		// Make the frame visible
		setVisible(true);
		// Make sure the frame exits when "x" is pressed
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        add(panelCars);
        add(controlPanel);
		
		controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		controlPanel.add(gasPanel);
		controlPanel.add(buttonPanel);
		controlPanel.add(startButton);
		controlPanel.add(stopButton);
		
		
		SpinnerModel spinnerModel =
				new SpinnerNumberModel(0, //initial value
						0, //min
						100, //max
						1);//step
		gasSpinner = new JSpinner(spinnerModel);
		
		gasPanel.setLayout(new BorderLayout());
		
		gasPanel.add(gasLabel, BorderLayout.PAGE_START);
		gasPanel.add(gasSpinner, BorderLayout.PAGE_END);


		buttonPanel.setLayout(new GridLayout(2,8));
		buttonPanel.setPreferredSize(new Dimension((FRAME_WIDHT/2)+50, 200));
		buttonPanel.setBackground(Color.CYAN);

		buttonPanel.add(gasButton, 0);
		buttonPanel.add(turboOnButton, 1);
		buttonPanel.add(liftBedButton, 2);
		buttonPanel.add(addCarButton, 3);
		buttonPanel.add(brakeButton, 4);
		buttonPanel.add(turboOffButton, 5);
		buttonPanel.add(lowerBedButton, 6);
		buttonPanel.add(removeCarButton, 7);
		

		startButton.setBackground(Color.blue);
		startButton.setForeground(Color.green);
		startButton.setPreferredSize(new Dimension((FRAME_WIDHT/5)-30,200));

		stopButton.setBackground(Color.red);
		stopButton.setForeground(Color.black);
		stopButton.setPreferredSize(new Dimension((FRAME_WIDHT/5)-30,200));

	}

	@Override
	public void update(ArrayList<Vehicle> cars) {
		panelCars.display(cars);
		
	}

}