public class Driver {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

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
                    option1();
                    break;

                case 2:
                    option2();
                    break;

                case 3:
                    option3();
                    break;

                case 4:
                    option4();
                    break;

                case 5:
                    option5();
                    break;
                    
                case 6:
                    option6();
                    break;
                    
                case 7:
                    option7();
                    break;
                    
                case 8:
                    option8();
                    break;

                default:
                    System.out.println("Invalid selection!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void option1() throws IOException{

    }

    private static void option2() throws IOException {

    }

    private static void option3() {

    }
    private static void option4() {

    }

    private static void option5() {

    }
    
    private static void option6(){
    
    }
    
    private static void option7(){
    
    }
    
    private static void option8(){
    
    }
    
    
  }
