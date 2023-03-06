package RPG;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSetGroundZeroFloor extends SpriteSet {

	public SpriteSetGroundZeroFloor() {
		super(3);
	}

	@Override
	public void load() {
		try{  
			sprites[0]=new Image("resources/FloorGroundZero2.png");
			sprites[1]=new Image("resources/FloorGroundZero3.png");
			sprites[2]=new Image("resources/FloorGroundZero4.png");
		}
		catch(SlickException e){
			e.printStackTrace();
		}
	}

}
/* Henrik Valve
 * 19.02.2013
 * 20.02.2013
 * 03.03.2013
 * 17.03.2013
 * 21.03.2013
 */
