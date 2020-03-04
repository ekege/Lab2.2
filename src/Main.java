import vehicles.CarFactory;

public class Main {

    public static CarModel initCars(){
        CarModel model = new CarModel();

        model.addCar(CarFactory.createVolvo240());
        model.addCar(CarFactory.createSaab95());
        model.addCar(CarFactory.createScania());

        return model;

    }

    public static void main(String[] args) {
        CarModel model = initCars();
        CarView view = new CarView(model);
        new CarController(model, view);
        model.registerObserver(view);
        model.timer.start();
    }

}