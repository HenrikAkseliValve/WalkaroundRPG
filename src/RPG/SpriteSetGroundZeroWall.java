package RPG;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSetGroundZeroWall extends SpriteSet {
	SpriteSetGroundZeroWall(){
		super(8);
	}

	@Override
	public void load() {
		try{   
			sprites[0]=new Image("resources/WallGroundZero1.png");//up
			sprites[1]=new Image("resources/WallGroundZero2.png");
			sprites[2]=new Image("resources/WallGroundZero3.png");
			sprites[3]=new Image("resources/WallGroundZero4.png");
			sprites[4]=new Image("resources/WallCornerGroundZero1.png");
			sprites[5]=new Image("resources/WallGroundZero5.png");//up
			sprites[6]=sprites[4].getFlippedCopy(true, false);
			sprites[7]=sprites[2].getFlippedCopy(true, false);
		}
		catch(SlickException e){
		e.printStackTrace();
		}
	}

}
/* Henrik Valve
 * 17.03.2013
 * 19.03.2013
 * 21.03.2013
 * 26.03.2013
 * 20.04.2013
 */
