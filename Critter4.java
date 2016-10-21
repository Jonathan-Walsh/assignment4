/* CRITTERS <Critter4.java>
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
 * Critter4 (Bob) is peaceful. Instead of making war Bob makes love
 * Bob walks aimlessly looking for food so that he may, someday, reproduce
 * If Bob encounters another Critter, he knows he is not willing to fight
 *   And thus tries to reproduce before (unwillingly) fighting
 *   He is even scared of Algae, and reproduces in its presence as well
*/
public class Critter4 extends Critter
{
	private int dir;
	
	public Critter4()
	{
		dir = Critter.getRandomInt(8);
	}
	
	public String toString(){return "4";}
	public boolean fight(String not_used)
	{
		
		Critter4 child = new Critter4();
		int g = Critter.getRandomInt(8);
		reproduce(child,g);
		return false;
	}
	public void doTimeStep()
	{
		walk(dir);
		dir = Critter.getRandomInt(8);
	}
}
