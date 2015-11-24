public class Plane{

    private int flightNumber;
    private String destination;
    private Queue runway;
    private boolean isCleared;

    public Plane(int flightNumber, String destination, Queue runway, boolean isCleared){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.runway = runway;
        this.isCleared = isCleared;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public String getDestination(){
        return destination;
    }

    public Queue getRunway(){
        return runway;
    }

    public void setCleared(boolean isCleared){
        this.isCleared = isCleared;
    }

    public boolean isCleared(){
        return isCleared;
    }
}
