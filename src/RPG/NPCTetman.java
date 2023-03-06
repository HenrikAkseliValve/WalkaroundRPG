package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class NPCTetman extends Entity{

	NPCTetman(int _x,int _y){
		super(_x,_y,3);
		addBehavior(new BehaviorLookAround(this,200),0);
		addBehavior(new BehaviorWalk(this,320),1);
		addBehavior(new BehaviorWalkAtPoint(this),2);
	}

	@Override
	public void init(GameContainer gameC,Room room){
		super.init(gameC, room);
		drew=getAnimation(0);
	}

	@Override
	public void draw(Graphics g){
//		drew.draw(x,y-39);
		g.drawAnimation(drew, x, y-39);
	}

	@Override
	public SpriteSet getSet(){
		return SpriteSet.Tetman;
	}
}
/* Henrik Valve
 * 04.11.2012
 * 08.12.2012
 * 27.12.2012
 * 28.12.2012
 * 29.12.2012
 * 04.01.2013
 * 26.01.2013
 * 01.02.2013
 * 07.02.2013
 * 11.02.2013
 * 15.03.2013
 * 17.03.2013
 * 17.04.2013
 * 18.04.2013
 * 21.04.2013
 * 10.06.2013
 */
