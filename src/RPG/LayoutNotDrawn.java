package RPG;

import org.newdawn.slick.Graphics;

public class LayoutNotDrawn extends Layout{

	public LayoutNotDrawn(float _x, float _y){
	  super(_x, _y,0);
	}

	@Override
	public boolean isAlwaysDown() {
	  return false;
	}

	@Override
	void draw(Graphics g) {}

	@Override
	public SpriteSet getSet() {
	  return null;
	}
	
	@Override
	public boolean isdrawn(){
	  return false;
	}

}
/* Henrik Valve
 * 23.03.2013
 * 17.04.2013
 * 10.06.2013
 * 16.07.2013
 */
