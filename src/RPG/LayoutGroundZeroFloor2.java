package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class LayoutGroundZeroFloor2 extends Layout {

	LayoutGroundZeroFloor2(int _x, int _y){
		super(_x,_y,1);
	}
	
	@Override
	public void init(GameContainer gameC,Room room) {
		super.init(gameC, room);
		drew = getSprite(1);
	}

	@Override
	void draw(Graphics g) {
		drew.draw(x,y);
	}

	@Override
	public SpriteSet getSet() {
		return SpriteSet.GroundZeroFloor;
	}

	@Override
	public boolean isAlwaysDown() {
		return true;
	}

}
/* Henrik Valve
 * 20.02.2013
 * 15.03.2013
 * 16.03.2013
 * 17.04.2013
 * 10.06.2013
 * 16.07.2013
 */
