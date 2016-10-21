/* CRITTERS <Main.java>
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Jonathan Walsh
 * jlw4699
 * 16450
 * Tim Yoder
 * tjy263
 * 16450
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4; // cannot be in default package
import java.util.Scanner;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        
       
        controller(kb);
        
        /* Write your code above */
        System.out.flush();

    }
    
    /**
     * Controls the program
     * Implements a variety of commands that the user can input
     * Method returns when user enters 'quit'
     * @param kb : Keyboard input, allows user to enter commands with keyboard
     * @throws InvalidCritterException 
     * 
     */
    public static void controller(Scanner kb) {
    	boolean run = true;
    	
    	while (run) {
    	//Get input
    		System.out.print("critters> ");
    		String input = kb.nextLine();
    		String[] inputs = input.split(" ");
    	//Determine what the user input
    		if (input.equals("quit")) { 
    			run = false;
    		}
    		else if (inputs[0].equals("show")) {
    			if (inputs.length == 1) {
    				Critter.displayWorld();
    			}
    			else {
    				System.out.println("error processing: " + input);
    			}
    		}
    		else if (inputs[0].equals("step")) {		
    			stepCommand(input, inputs);
    		}
    		else if (inputs[0].equals("make")) {	
    			makeCommand(input, inputs);
    		}
    		else if (inputs[0].equals("seed")) {	
    			seedCommand(input, inputs);
    		}
    		else if (inputs[0].equals("stats") && inputs.length == 2) {		//TODO: Implement STAGE3 functionality
    			statsCommand(input, inputs);
    		}
    		else {			
    			System.out.println("invalid command: " + input);
    		}
    	}
    }
    
    /** Implements the actions performed when the user enters "step ~~~"
     * Returns nothing, just prints to the console
     * @param inputs : An array of the Strings input the user, should be ["step",<count>]
     */
    public static void stepCommand(String input, String[] inputs) {
    //If user just wants to perform one time step
    	if (inputs.length == 1) {
    		Critter.worldTimeStep();
    	}
    //If the user specifies number of time steps
    	else if (inputs.length == 2) {
    		try {
    			int numSteps = Integer.parseInt(inputs[1]);
    			if (numSteps > -1) {
    				for (int i = 0; i < numSteps; i++) {
        				Critter.worldTimeStep();
        			}
    			}
    			else {
    				System.out.println("error processing: " + input);
    			}
    		}
    		catch (NumberFormatException e) {
    			System.out.println("error processing: " + input);
    		}
    	}
    //If the user gives too many inputs
    	else {
    		System.out.println("error processing: " + input);
    	}
    }
    
    /** Implements the actions performed when the user enters "make ~~~ ~~~"
     * Returns nothing, just prints to the console
     * @param inputs : An array of the Strings input the user, should be ["make",<Critter type>,<count>]
     */
    public static void makeCommand(String input, String[] inputs) {
    	//If user just gives the name of the Critter
		if (inputs.length == 2) {
			try {
				Critter.makeCritter(inputs[1]);
			}
			catch (InvalidCritterException e1) {
				System.out.println("error processing: " + input);
			}
		}
	//If user just gives the name and number of Critter
		else if (inputs.length == 3) {
			try {
				int numCritters = Integer.parseInt(inputs[2]);
				if (numCritters > -1) {
					for (int i = 0; i < numCritters; i++) {
						Critter.makeCritter(inputs[1]);
					}
				}
				else {
					System.out.println("error processing: " + input);
				}
			}
			catch (InvalidCritterException e2) {
				System.out.println("error processing: " + input);
			}
			catch (NumberFormatException e3) {
				System.out.println("error processing: " + input);
			}
		}
	//If user gives too many inputs
		else {
			System.out.println("error processing: " + input);
		}
    }
    
    /** Implements the actions performed when the user enters "seed ~~~"
     * Returns nothing, just prints to the console
     * @param inputs : An array of the Strings input the user, should be ["seed",<seed number>]
     */
    public static void seedCommand(String input, String[] inputs) {
    	if (inputs.length == 2) {
			try {
				long numSeed = Long.parseLong(inputs[1]);
				Critter.setSeed(numSeed);
			}
			catch (NumberFormatException e) {
				System.out.println("error processing: " + input);
			}
		}
		else {
			System.out.println("error processing: " + input);
		}
    }
    
    /** Implements the actions performed when the user enters "stats ~~~"
     * Returns nothing, just prints to the console
     * @param inputs : An array of the Strings input the user, should be ["stats",<Critter type>]
     */
    public static void statsCommand(String input, String[] inputs) {
    	if (inputs.length != 2) {
    		System.out.println("error processing: " + input);
    		return;
    	}
    	
    	try {
    		java.util.List<Critter> instances = Critter.getInstances(inputs[1]);
    		Class<?> critter_class = Class.forName(myPackage + "." + inputs[1]);
    		Class<?>[] types = {java.util.List.class};
			Method runstats = critter_class.getMethod("runStats", java.util.List.class);
			runstats.invoke(null, instances);
		}
		catch (ClassNotFoundException e1){
			System.out.println("error processing: " + input);
		}
		catch (IllegalAccessException e2) {		//Class.newInstance() exception
			System.out.println("error processing: " + input);
		}
    	catch (InvalidCritterException e3) {
    		System.out.println("error processing: " + input);
    	}
    	catch (NoSuchMethodException e4) {
    		System.out.println("error processing: " + input);
    	}
    	catch (InvocationTargetException e5) {
    		System.out.println("error processing: " + input);	
    	}
    }
    
}
