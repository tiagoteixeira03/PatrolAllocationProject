package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for processing user parameters.
 */
public class ProcessUserParameters {

    /**
     * Processes the command-line arguments provided by the user.
     * 
     * @param args The command-line arguments.
     * @return An array of processed arguments.
     * @throws IOException If there is an error reading the input file.
     * @throws IllegalArgumentException If invalid arguments are provided.
     */
    public static String[] processArgs(String[] args) throws IOException {
        // Check if arguments are provided
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided.");
        }

        // List to store processed arguments
        List<String> processedArgsList = new ArrayList<>();
        // List to store matrixC values from file
        List<String> matrixC = new ArrayList<>();
        // String to store matrixC values as a single string
        String stringMatrixC = new String();

        // Check if the first argument is "-f" indicating file input
        if (args[0].equals("-f")) {
            if (args.length != 2) {
                throw new IllegalArgumentException("File path not provided.");
            }
            String filePath = args[1];
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int paramCounter = 0;
                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    // Split the line by whitespace and process each parameter
                    for (String param : line.split("\\s+")) {
                        paramCounter++;
                        if (paramCounter <= 8) {
                            processedArgsList.add(param);
                        } else {
                            matrixC.add(param);
                        }
                    }
                }
                // Join matrixC values into a single string separated by "-"
                stringMatrixC = String.join("-", matrixC);
            }
        // Check if the first argument is "-r" indicating random matrix generation
        } else if (args[0].equals("-r")) {
            for (int i = 1; i < args.length; i++) {
                processedArgsList.add(args[i]);
            }
            // Add a placeholder for random matrix generation
            stringMatrixC = "RANDOM_MATRIX";
        } else {
            throw new IllegalArgumentException("Invalid option provided.");
        }

        // Add the matrixC string to the processed arguments list
        processedArgsList.add(stringMatrixC);

        // Convert the processed arguments list to an array
        String[] processedArgs = new String[processedArgsList.size()];
        processedArgs = processedArgsList.toArray(processedArgs);

        return processedArgs;
    }
}
