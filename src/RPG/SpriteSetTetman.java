package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSetTetman extends SpriteSet{
	SpriteSetTetman(){
	  super(12,8);
	}

	@Override
	public void load(){
	  try{
		
	    sprites[0] = new Image("resources/TetManF1.png");
        sprites[1] = new Image("resources/TetmanFW1.png");
	    sprites[2] = new Image("resources/TetmanFW2.png");
	    sprites[3] = new Image("resources/TetmanFW3.png");
	    sprites[4] = new Image("resources/TetmanB1.png");
	    sprites[5] = new Image("resources/TetmanBW1.png");
	    sprites[6] = new Image("resources/TetmanBW2.png");
	    sprites[7] = new Image("resources/TetmanBW3.png");
	    sprites[8] = new Image("resources/TetmanS1.png");
	    sprites[9] = new Image("resources/TetmanSW1.png");
	    sprites[10] = new Image("resources/TetmanSW2.png");
	    sprites[11] = new Image("resources/TetmanSW3.png");

	    anims[0] = new Animation(true);
	    anims[0].addFrame(sprites[0],200);
	    anims[1] = new Animation(true);
	    anims[1].addFrame(sprites[2],200);
	    anims[1].addFrame(sprites[1],200);
	    anims[1].addFrame(sprites[3],200);
	    anims[1].addFrame(sprites[1],200);
	    anims[2] = new Animation(true);
	    anims[2].addFrame(sprites[4],200);
	    anims[3] = new Animation(true);
	    anims[3].addFrame(sprites[6],200);
	    anims[3].addFrame(sprites[5],200);
	    anims[3].addFrame(sprites[7],200);
	    anims[3].addFrame(sprites[5],200);
	    anims[4] = new Animation(true);
	    anims[4].addFrame(sprites[8],200);
	    anims[5] = new Animation(true);
	    anims[5].addFrame(sprites[9],175);
	    anims[5].addFrame(sprites[11],175);
	    anims[5].addFrame(sprites[10],175);
	    anims[5].addFrame(sprites[11],175);
	    anims[6] = new Animation(true);
	    anims[6].addFrame(sprites[8].getFlippedCopy(true,false),200);
	    anims[7] = new Animation(true);
	    anims[7].addFrame(sprites[9].getFlippedCopy(true,false),175);
	    anims[7].addFrame(sprites[11].getFlippedCopy(true,false),175);
	    anims[7].addFrame(sprites[10].getFlippedCopy(true,false),175);
	    anims[7].addFrame(sprites[11].getFlippedCopy(true,false),175);
	  }
	  catch(SlickException e){
        e.printStackTrace();		  
	  }
	}
}
/* Henrik Valve
 * 27.12.2012
 * 28.12.2012
 * 29.12.2012
 * 03.01.2013
 * 26.01.2013
 * 01.02.2013
 * 07.02.2013
 * 19.02.2013
 * 11.04.2013
 */
