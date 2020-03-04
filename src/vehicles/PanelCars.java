package vehicles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import vehicle.views.DisplayCars;

public class PanelCars extends JPanel implements DisplayCars {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Vehicle> cars;
	BufferedImage carImages;

	public PanelCars(ArrayList<Vehicle> cars, int x, int y) {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, y));
		this.setBackground(Color.green);
		this.cars = cars;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (Vehicle car: cars) 
				g.drawImage(carImages = ImageIO.read(PanelCars.class.getResourceAsStream("pics\\"+car.getModelName()+".jpg")), (int) car.getPosition().getX(), (int) car.getPosition().getY(), null);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void display(ArrayList<Vehicle> cars) {
		this.cars = cars;
		this.repaint();		
	}

}
