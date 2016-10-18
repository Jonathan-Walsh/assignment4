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
