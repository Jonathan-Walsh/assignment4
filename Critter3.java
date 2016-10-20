/* CRITTERS <Critter3.java>
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

/*Critter3 (Freddy) is fast. He likes to run.
 * He has a set square path, and makes loop after loop on the same path
 * If he encounters another Critter, he stays to fight
 *    so that the Critter is eliminated from his running path
 * Freddy will only reproduce if his child will be strong,
 *    So he waits until he can give his baby as much energy
 *    as he had when he was born
 * The baby is placed down and right so that they will not run into each other
*/
public class Critter3 extends Critter
{
	private int dir;
	private int[] dirPath = {0,2,4,6};
	private int count;
	
	public Critter3()
	{
		dir = dirPath[0];
		count = 0;
	}
	
	public String toString(){return "3";}
	
	public boolean fight(String not_used)
	{
		return true;
	}
	
	public void doTimeStep()
	{
		run(dir);
		count++;
		count %= dirPath.length;
		dir = dirPath[count];
		if (getEnergy() > 2 * Params.start_energy) {
			Critter3 baby = new Critter3();
			reproduce(baby, 7);
		}
	}
}
