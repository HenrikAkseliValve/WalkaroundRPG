package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class EntityObject{
	/**Coordinates of the object*/
	float x,y;
	/**Width and height of the images that object uses right then*/
	int middleX,middleY;
	/**Does object collide with others*/
	boolean collision=true;
	/**Basic information sent to this constructor*/
	EntityObject(float _x,float _y,boolean collision){
		x=_x;
		y=_y;
		this.collision=collision;
	}
	/**Gives sprite of given index form SpriteSet used by object*/
	Image getSprite(int index){
		return getSet().getSprite(index);
	}
	/**Gives animation of given index form SpriteSet used by object*/
	Animation getAnimation(int index){
		return getSet().getAnimation(index);
	}
	/**Objects initialization has to be put here. (Method runs at main loop)*/
	abstract void init(GameContainer gameC,Room room);
	/**How object is drew at screen has to be put here. (Method runs at main loop)*/
	abstract void draw(Graphics g);
	/**Object SpriteSet has to be here as return value*/
	public abstract SpriteSet getSet();
	/**Is EntityObject drawn at to the screen*/
	public boolean isdrawn(){
		return true;
	}

}
/* Henrik Valve
 * 08.12.2012 (wrong)
 * 27.7.2012
 * 27.12.2012
 * 29.12.2012
 * 01.02.2013
 * 07.02.2013
 * 11.02.2013
 * 18.02.2013
 * 19.02.2013
 * 15.03.2013
 * 23.03.2013
 * 17.04.2013
 * 10.06.2013
 */
