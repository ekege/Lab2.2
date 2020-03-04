import vehicles.CarFactory;

public class Main {
	
	final static int FRAME_HEIGHT = 800;
	final static int FRAME_WIDHT = 800;

    public static CarModel initCars(){
        CarModel model = new CarModel(FRAME_HEIGHT, FRAME_WIDHT);

        model.addCar(CarFactory.createVolvo240());
        model.addCar(CarFactory.createSaab95());
        model.addCar(CarFactory.createScania());

        return model;

    }

    public static void main(String[] args) {
        CarModel model = initCars();
        CarView view = new CarView(model, FRAME_HEIGHT, FRAME_WIDHT);
        new CarController(model, view);
        model.registerObserver(view);
        model.timer.start();
    }

}