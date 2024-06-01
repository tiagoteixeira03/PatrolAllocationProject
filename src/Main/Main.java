package Main;
import java.io.IOException;

/**
 * The main class that starts the simulation.
 */
public class Main {
    /**
     * The main method that starts the simulation.
     * 
     * @param args The command-line arguments provided to the program.
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
