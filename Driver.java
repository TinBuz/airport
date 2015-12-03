import java.io.*;
import java.util.Random;
public class Driver {
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * The main method. Runs the entire application.
     * Prompts for the initial number of runways with unique names and adds the new runways to a collection of runways.
     * loops the main menu of the application and runs the menu uptions until the user promts it to stop with option #9.
     */
    public static void main(String[] args) throws IOException {
        /**
         * Some explanation: unclearedPlanes is a queue because the pool of uncleared planes clearly has a FIFO setup.
         * One may think a queue would also be optimal for the collection of runways, however I disagree. While it's useful for 
         * clearing planes for takeoff in a round-robin fashion, it is not useful when checking which runway a plane in the pool
         * of uncleared planes belongs to while still keeping track of the current runway to clear a plane for takeoff from. As such,
         * logistically it seemed better to use a list for the runways and use an int to keep track of the current runway.
         */
        Queue<Plane> unclearedPlanes = new Queue<Plane>();
        List<Runway> runways = new List<Runway>();
        Random rand = new Random();
        int currentRunwayIndex, planesTakenOff;
        currentRunwayIndex = planesTakenOff = 0;
        
        System.out.println("Please enter the initial number of runways: ");
        int numRunways = Integer.parseInt(reader.readLine());
        for(int i = 1; i<=numRunways; i++){
            System.out.println("Please enter the UNIQUE name of runway #" + i + ":");
            runways.add(new Runway(reader.readLine()));
        }
        
        boolean escape = true;
        while(escape) {
            System.out.println("Select from the following menu: \n1." +
                               "\n2. \n3. \n4. "
                               + "\n5. \n6. ");

            try {
                switch(Integer.parseInt(reader.readLine().trim())) {
                case 9:
                    escape = false;
                    System.out.println("gUESS YOU'RE WALKING THEN.");
                    break;

                case 1:
                    option1(runways);
                    break;

                case 2:
                    if(rand.nextInt() == 0)
                        unclearedPlanes.add(runways.get(currentRunwayIndex).dequeuePlane());
                    else{
                        runways.get(currentRunwayIndex).dequeuePlane();
                        planesTakenOff++;
                    }
                    currentRunwayIndex = (currentRunwayIndex+1) % runways.size();

                case 3:
                    option3(runways, unclearedPlanes);
                    break;

                case 4:
                    option4(runways);
                    break;

                case 5:
                    option5(runways);
                    break;
                    
                case 6:
                    option6(runways);
                    break;
                    
                case 7:
                    option7(unclearedPlanes);
                    break;
                    
                case 8:
                    option8(planesTakenOff);
                    break;

                default:
                    System.out.println("Invalid selection!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Method to run menu option #1
     */
    private static void option1() throws IOException{
        if(runways.isEmpty())
            System.out.println("There are no runways for the plane to enter!");
        else{
            System.out.println("Please enter the plane's flight number: ");
            int flightNumber = Integer.parseInt(reader.readLine());
            System.out.println("Please enter the plane's destination: ");
            String dest = reader.readLine();
            System.out.println("Please enter the name of the runway the plane will enter: ");
            String runway = reader.readLine();
            boolean isLegit = false;
            int indexOfRunway;
            for(int i = 0; i<runways.size(); i++){
                if(runways.get(i).getName().equals(runway)){
                    isLegit = true;
                    i = runways.size();
                    indexOfRunway = i;
                }
            }
            if(isLegit){
                runways.get(indexOfRunway).add(new Plane(flightNumber, dest, runways.get(indexOfRunway)));
            }
            else{
                System.out.println("Invalid runway.");
            }
            
        }
    }

    /**
     * Method to run menu option #3
     */
    private static void option3(List<Runway> runways, Queue<Plane> unclearedPlanes) {
        
    }
    private static void option4(List<Runway> runways) {
        System.out.println("Please enter a UNIQUE runway name: ");
        runways.add(new Runway(reader.readLine()));
    }

    private static void option5(List<Runway> runways) {
        System.out.println("Please enter the name of the runway to be closed: ");
        String runway = reader.readLine();
        int runwayIndex = -1;
        for(int i = 0; i<runways.size(); i++){
            if(runways.get(i).getName().equals(runway)){
                runwayIndex = i;
                i = runways.size();
            }
        }
        if(runwayIndex<0){ 
            System.out.println("Runway does not exist!");
        }
        else if(!runways.get(runwayIndex).isEmpty()){
            System.out.println("You can't close that runway yet, there are still planes on it waiting to take off!")
        }
        else{
            runways.remove(runwayIndex);
            System.out.println("Runway removed.");
        }
    }
    
    private static void option6(List<Runway> runways){
        for(int i = 0; i<runways.size(); i++ ){
            Runway current = runways.get(i);
            System.out.println("Runway " + current.getName() + ": ");
            for(int j = 0; j<current.size(); j++){
                System.out.println("\tPlane # " + j + ": " + current.get(j).getInfo());
            }
        }
    }
    
    private static void option7(Queue<Plane> planes){
        for(int i = 0; i<planes.size(), i++){
            Plane current = planes.peek();
            System.out.println("Plane #" + (i+1) +": " + current.getInfo();
            planes.enqueue(planes.dequeue());
        }
    }
    
    private static void option8(int planesTakenOff){
        System.out.println(planesTakenOff + " planes have taken off");
    }
    
    
  }
