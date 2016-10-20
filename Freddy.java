/* CRITTERS <Freddy.java>
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
package assignment4;

//Freddy is fast. He likes to run.
public class Freddy extends Critter
{
	private int dir;
	
	public Freddy()
	{
		dir = Critter.getRandomInt(8);
	}
	
	public String toString(){return "F";}
	public boolean fight(String not_used)
	{
		return true;
	}
	public void doTimeStep()
	{
		run(dir);
		run(dir);
		run(dir);
	}
}
