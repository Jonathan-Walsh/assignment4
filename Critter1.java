/* CRITTERS <Critter1.java>
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

/**
 * Critter1(Dave) is angry.
 * He is always looking to fight, and thus never backs down from a
 *     challenge by another Critter
 * Dave also does not have time to reproduce
 * He is so focused on fighting that he does not think about changing direction
 *    Each Dave Critter picks a direction and runs in that direction every turn
*/
public class Critter1 extends Critter
{
	private int dir;
	
	public Critter1()
	{
		dir = Critter.getRandomInt(8);
	}
	
	public String toString(){return "1";}
	public boolean fight(String not_used){return true;}
	public void doTimeStep()
	{
		run(dir);
	}
}
