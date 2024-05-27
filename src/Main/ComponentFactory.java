package Main;

/**
 * Interface for component factories that are responsible for initializing components.
 */
public interface ComponentFactory {
	/**
     * Initializes the component with the specified arguments.
     * 
     * @param args the arguments used to initialize the component
     */
	void initialize(String[] args);
}
