package RPG;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;


public abstract class SpecialRendering{
	/**how long special is drew*/
	private long timeAmount=-1;

	/**Actual time to stop*/
	private long time;

	/**What ever it is first time tellSpecial will be run*/
	private int init = -1;
	
	/**This is run at draw special*/
	abstract void tellSpecial(Graphics g);
	
	
	/**Set how long special is drew. If amount is zero or less will be rendered with out time limit*/
	public void setTimeAmount(long amountOfMilliseconds){
	timeAmount = amountOfMilliseconds;
	}
	/**Adds time to time*/
	public void addTime(long amountOfMilliseconds){
		time += amountOfMilliseconds;
	}

	/**mend to be cast at room in render method to be drew*/
	public void drawSpecial(GameContainer gameC,Graphics g){
		if(init == -1){
			init = 0;
			time = gameC.getTime() + timeAmount;
		}
		if(time<=gameC.getTime()){
			init = 1;
		}
		else{
			tellSpecial(g);
		}
	}

	/**Should drawSpecial run*/
	public boolean doIDraw(){
		if(init==1) return false;
		return true;
	}
}
/* Henrik Valve
 * 04.02.2013
 * 06.02.2013
 * 07.02.2013
 * 10.06.2013
 */
