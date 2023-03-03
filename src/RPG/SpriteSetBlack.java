package RPG;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSetBlack extends SpriteSet {

	SpriteSetBlack() {
		super(2);
	}

	@Override
	public void load() {
	  try{   
	    sprites[0]=new Image("resources/Black30X20.png");
	    sprites[1]=sprites[0].getScaledCopy(10f);
	  }
	  catch(SlickException e){
		e.printStackTrace();		  
	  }
	}

}
/* Henrik Valve
 * 18.03.2013
 * 19.03.2013
 */

