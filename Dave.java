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
