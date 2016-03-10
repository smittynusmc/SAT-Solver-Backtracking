
package src_Tucker.sat_solver2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author Adam Tucker
 *
 */
public class SAT_Driver { 

	public static int numLiterals = 0;
	public static int numClauses = 0;
	public static Formula project;
	public static Timer process = new Timer ();
	public static Timer solution = new Timer ();

	/**
	 * This main method tests the setup of the Literal & Status classes
	 * input provided in the form
	 * p cnf 4 3
	 * 1 2 0
	 * -2 3 4 0
	 * -1 -3 -4 0
	 * 
	 */
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a file directory \n"
				+ "Copy the file path/address and paste it in the command line");
		String directory = sc.nextLine();
		sc.close();


		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println("Current file is " + file);
				process.start();
				init(file);
				solution.start();
				
				project.begin();
				
				process.stop();
				solution.stop();
				System.out.println("Time for the entire process is " + process.getDuration() + " milliseconds");
				System.out.println("Time for the solution is " + solution.getDuration() + " milliseconds \n");
			}
		}

		//State test = new State(numLiterals);
		//System.out.println(test);

		//for(int i=1;i<16;i++)
		//{
			//test.next();
		//}

	}

	private static void init (File file) {
		//Local Variable 
		String [] tokens = null;
		int j = 0;
		numLiterals = 0;
		numClauses = 0;
		try (BufferedReader br = new BufferedReader (new FileReader (file.toString()))) {
			String line = "";
			if (!br.ready()) {
				throw new StatisticDataNotFoundException (file.toString());
			}
			else {
				while(br.ready()){
					line = br.readLine();
					if(line.startsWith("c")){
						continue;
					}
					else if(line.startsWith("p cnf")){
						tokens = line.split(" ");
						for (int i = 0; i < tokens.length;i++){
							if (tokens[i].matches("[0-9]+")){
								if (numLiterals == 0) {
									numLiterals = Integer.parseInt(tokens[i]);
								}
								else {
									numClauses = Integer.parseInt(tokens[i]);
								}
							}
						}
						project = new Formula (numClauses, numLiterals);
					}
					else {
						tokens = line.split(" ");
						for (int i = 0; i < tokens.length-1; i++) {
							if (tokens[i].matches("-?\\d+(\\.\\d+)?")){
								project.add(new Literal (Integer.parseInt(tokens[i])), j);
							}
						}
						j++;
					}
				}
			}
		}
		catch (IOException | IllegalArgumentException | StatisticDataNotFoundException e) {
			e.printStackTrace();
		} 
	}


}
