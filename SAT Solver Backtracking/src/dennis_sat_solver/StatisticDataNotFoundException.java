package src_Tucker.sat_solver2;

import java.time.LocalDate;

/**
 * Custom exception class for if Statistical Data is not found
 * 
 * @author Adam Tucker
 * @version 07/09/15
 *
 */
public class StatisticDataNotFoundException extends Exception {

	/**
	 * The serial version UID for the Class
	 */
	private static final long serialVersionUID = -6901453528768199052L;

	private String file_name;



	/**
	 * Constructor for the class
	 * @param file_name The filename for an error message
	 */
	public StatisticDataNotFoundException(String file_name) {
		this.file_name = file_name;
	}



	/**
	 * Method toString for the Class
	 * @return The error message
	 */
	@Override
	public String toString () {
		return "*****" + file_name + " was not found @ " + LocalDate.now() + "*****";
	}


}
