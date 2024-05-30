package Main;
import java.io.IOException;

public class Main {
    /**
     * The main method that starts the simulation.
     * 
     * @param args the command-line arguments provided to the program
     */
    public static void main(String[] args) {
        try {
            String[] processedArgs = ProcessUserParameters.processArgs(args);
            CreateFactories factory = new CreateFactories();
            factory.initializeComponents(processedArgs);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid arguments: " + e.getMessage());
        }
    }
}
