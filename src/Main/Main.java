package Main;

/**
 * The main class responsible for starting the simulation.
 */
public class Main {
	/**
     * The main method that starts the simulation.
     * 
     * @param args the command-line arguments provided to the program
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateFactories factory = new CreateFactories();
		factory.initializeComponents(args);
	}
}