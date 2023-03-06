package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSetFusgo extends SpriteSet {

	SpriteSetFusgo() {
		super(16, 8);
	}

	@Override
	public void load() {
		try {
			sprites[0] = new Image("resources/FusgoF1.png");
			sprites[1] = new Image("resources/FusgoFW1.png");
			sprites[2] = new Image("resources/FusgoFW2.png");
			sprites[3] = new Image("resources/FusgoFW3.png");
			sprites[4] = new Image("resources/FusgoB1.png");
			sprites[5] = new Image("resources/FusgoBW1.png");
			sprites[6] = new Image("resources/FusgoBW2.png");
			sprites[7] = new Image("resources/FusgoBW3.png");
			sprites[8] = new Image("resources/FusgoL1.png");
			sprites[9] = new Image("resources/FusgoLW1.png");
			sprites[10] = new Image("resources/FusgoLW2.png");
			sprites[11] = new Image("resources/FusgoLW3.png");
			sprites[12] = new Image("resources/FusgoR1.png");
			sprites[13] = new Image("resources/FusgoRW1.png");
			sprites[14] = new Image("resources/FusgoRW2.png");
			sprites[15] = new Image("resources/FusgoRW3.png");
		
			anims[0] = new Animation(true);
			anims[0].addFrame(sprites[0],200);
			anims[1] = new Animation(true);
			anims[1].addFrame(sprites[1],190);
			anims[1].addFrame(sprites[2],190);
			anims[1].addFrame(sprites[1],190);
			anims[1].addFrame(sprites[3],190);
			anims[2] = new Animation(true);
			anims[2].addFrame(sprites[4],200);
			anims[3] = new Animation(true);
			anims[3].addFrame(sprites[5],190);
			anims[3].addFrame(sprites[6],190);
			anims[3].addFrame(sprites[5],190);
			anims[3].addFrame(sprites[7],190);
			anims[4] = new Animation(true);
			anims[4].addFrame(sprites[8],200);
			anims[5] = new Animation(true);
			anims[5].addFrame(sprites[9],165);
			anims[5].addFrame(sprites[11],165);
			anims[5].addFrame(sprites[10],165);
			anims[5].addFrame(sprites[11],165);
			anims[6] = new Animation(true);
			anims[6].addFrame(sprites[12],200);
			anims[7] = new Animation(true);
			anims[7].addFrame(sprites[13],165);
			anims[7].addFrame(sprites[15],165);
			anims[7].addFrame(sprites[14],165);
			anims[7].addFrame(sprites[15],165);
		}
		catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
/* Henrik Valve
 * 26.03.2013
 * 29.03.2013
 * 21.04.2013
 * 27.04.2013
 * 03.05.2013
 */
