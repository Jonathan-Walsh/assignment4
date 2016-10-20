/* CRITTERS <Dave.java>
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

//Dave is angry. He wants to fight and never reproduces.
public class Dave extends Critter
{
	private int dir;
	
	public Dave()
	{
		dir = Critter.getRandomInt(8);
	}
	
	public String toString(){return "D";}
	public boolean fight(String not_used){return true;}
	public void doTimeStep()
	{
		run(dir);
	}
}
