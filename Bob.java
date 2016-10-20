/* CRITTERS <Bob.java>
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

//Bob is peaceful. Instead of making war Bob makes love
public class Bob extends Critter
{
	private int dir;
	
	public Bob()
	{
		dir = Critter.getRandomInt(8);
	}
	
	public String toString(){return "B";}
	public boolean fight(String not_used)
	{
		Bob child = new Bob();
		int g = Critter.getRandomInt(8);
		reproduce(child,g);
		return false;
	}
	public void doTimeStep()
	{
		run(dir);
	}
}
