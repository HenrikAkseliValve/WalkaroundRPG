package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class LayoutGroundZeroFloor1 extends Layout {
	public LayoutGroundZeroFloor1(){
		this(-1,-1,-1);
	}
	
	public LayoutGroundZeroFloor1(int layoutX,int layoutY,int index){
		this(layoutX*30f,layoutY*20f,index);
	}
	
	public LayoutGroundZeroFloor1(float _x, float _y, int _index) {
		super(_x, _y,_index);
	}

	@Override
	public SpriteSet getSet() {
		return SpriteSet.GroundZeroFloor;
	}

	@Override
	public void init(GameContainer gameC,Room room){
		super.init(gameC, room);
		drew = getSprite(index);	
	}

	@Override
	public void draw(Graphics g){
//	drew.draw(x,y);
		g.drawImage(drew, x, y);
	}

	@Override
	public boolean isAlwaysDown() {
		return true;
	}
}
/* Henrik Valve
 * 19.02.2013
 * 20.02.2013
 * 15.03.2013
 * 16.03.2013
 * 17.04.2013
 * 10.06.2013
 * 16.07.2013
 */
