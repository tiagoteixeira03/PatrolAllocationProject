package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessUserParameters {

    public static String[] processArgs(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided.");
        }

        List<String> processedArgsList = new ArrayList<>();
        List<String> matrixC = new ArrayList<>(); 
        String stringMatrixC = new String();

        if (args[0].equals("-f")) {
            // Read from file
            if (args.length != 2) {
                throw new IllegalArgumentException("File path not provided.");
            }
            String filePath = args[1];
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int paramCounter = 0;
                while ((line = br.readLine()) != null) {
                    // Split the line by whitespace and add to processedArgsList or matrixC
                	for (String param : line.split("\\s+")) {
                    	paramCounter++;
                    	if(paramCounter <= 8) {
                    		processedArgsList.add(param);
                    	}
                    	else {
                    		matrixC.add(param);
                    	}
                    }
                }
                stringMatrixC = String.join("-", matrixC);
            }
        } else if (args[0].equals("-r")) {
            // Read from command-line args
        	for (int i = 1; i < args.length; i++) {
        	    processedArgsList.add(args[i]);
        	}
            // Add a placeholder for random matrix generation
            stringMatrixC = "RANDOM_MATRIX";
        } else {
            throw new IllegalArgumentException("Invalid option provided.");
        }
        
        processedArgsList.add(stringMatrixC);
        
        // Convert List to Array
        String[] processedArgs = new String[processedArgsList.size()];
        processedArgs = processedArgsList.toArray(processedArgs);

        return processedArgs;
    }
}
