package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class LayoutGroundZeroWall1 extends Layout {
	public LayoutGroundZeroWall1(int layoutX,int layoutY,int index){
		this(layoutX*30f,layoutY*20f,index);
	}
	
	public LayoutGroundZeroWall1(float _x, float _y,int _index){
		super(_x, _y,true,_index);
	}

	@Override
	public void init(GameContainer gameC,Room room) {
		super.init(gameC, room);
		drew = getSprite(index);	
	}

	@Override
	void draw(Graphics g) {
//	drew.draw(x, y-35);
		g.drawImage(drew, x, y-35);
	}

	@Override
	public SpriteSet getSet() {
		return SpriteSet.GroundZeroWall;
	}

	@Override
	public boolean isAlwaysDown(){
		return false;
	}
}
/* Henrik Valve
 * 03.03.2013
 * 15.03.2013
 * 16.03.2013
 * 17.03.2013
 * 17.04.2013
 * 18.04.2013
 * 10.06.2013
 * 16.07.2013
 */
