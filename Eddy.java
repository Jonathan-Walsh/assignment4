/* CRITTERS <Eddy.java>
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

//Eddy is explosive. He blows up and reproduces after 20 turns
public class Eddy extends Critter
{
	private int dir;
	private int turns;
	
	public Eddy()
	{
		dir = Critter.getRandomInt(8);
		turns =0;
	}
	
	public String toString(){return "E";}
	public boolean fight(String not_used){return true;}
	public void doTimeStep()
	{
		walk(dir);
		if(turns>20)
		{
			for(int i=0;i<4;i++)
			{
				Eddy child = new Eddy();
				reproduce(child, Critter.getRandomInt(8));
			}
		}
	}
}
