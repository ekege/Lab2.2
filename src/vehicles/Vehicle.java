package vehicles;


import java.awt.*;


public abstract class Vehicle implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    public Point position;
    protected Direction direction = Direction.EAST;


    protected enum Direction {WEST, NORTH, EAST, SOUTH}


    public Vehicle(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Returns the number of doors of the vehicle.
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    public String getModelName() {
        return this.modelName;
    }

    /**
     * Returns the engine power of the vehicle.
     * @return enginePower
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the vehicle.
     * @return currentSpeed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    /**
     * Returns the color of the vehicle.
     * @return color
     */
    public Color getColor(){
        return color;
    }

    public Point getPosition () {
        return this.position;
    }

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed of the vehicle to 0.1.
     *
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed of the vehicle to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the speed factor of the vehicle.
     * @return speedFactor
     */
    protected abstract double speedFactor();

    /**
     * Increments the speed of the vehicle.
     * @param amount the amount to increment.
     */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decrements the speed of the vehicle.
     * @param amount the amount to decrement.
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Increments the speed. Calls function incrementSpeed with amounts between 0 and 1.
     * @param amount the amount to increment.
     * @throws IllegalArgumentException if amount is not in range [0,1].
     */
    public void gas(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Argument must be in the range [0,1]");
        else
            incrementSpeed(amount);
    }
    /**
     * Decrements the speed. Calls function decrementSpeed with amounts between 0 and 1.
     * @param amount the amount to decrement.
     * @throws IllegalArgumentException if amount is not in range [0,1].
     */
    public void brake(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Argument must be in the range [0,1]");
        else
            decrementSpeed(amount);
    }

    /**
     * Returns the direction of the vehicle.
     * @return direction
     */
    public Enum<?> getDirection() {
        return direction;
    }

    public void setPosition(int x, int y) {
        position.move(x,y);
    }
    /**
     * Changes the location of the vehicle by the amount of current speed and according to the direction.
     */
    @Override
	public void move() {
        switch(direction) {
            case WEST:
                position.x -= currentSpeed;
                break;
            case NORTH:
                position.y -= currentSpeed;
                break;
            case EAST:
                position.x += currentSpeed;
                break;
            case SOUTH:
                position.y += currentSpeed;
                break;
        }
    }

    /**
     * Turns the vehicle left by decreasing the direction to a number between 3 and 0.
     */
    @Override
	public void turnLeft() {
        switch(direction) {
            case WEST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
        }
    }
    /**
     * Turns the vehicle left by increasing the direction to a number between 0 and 3.
     */
    @Override
	public void turnRight() {
        switch(direction) {
            case WEST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
        }
    }

}
