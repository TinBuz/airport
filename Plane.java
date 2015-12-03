public class Plane{

    private int flightNumber;
    private String destination;
    private Runway runway;

    public Plane(int flightNumber, String destination, Runway runway){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.runway = runway;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public String getDestination(){
        return destination;
    }

    public Runway getRunway(){
        return runway;
    }

    public String getInfo(){
        return "Flight number " + flightNumber + " going to " + destination + " taking off from runway " + runway.getName();
    }
}
