package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public abstract class Layout implements InterfaceDraw{
  /**Layouts*/
  /**Layout of LayoutGroundZeroFloor1*/
  public static LayoutGroundZeroFloor1 floor1= new LayoutGroundZeroFloor1();
  /**Image that is drew*/
  protected Image drew;
  /**index of sprite*/
  protected int index;
  /**Layout's id*/
  int layoutId=0;

    /**Collision is false. Useful when creating tiles*/
	public Layout(float _x,float _y,int _index){
	  this(_x,_y,false,_index);
	}
	
	/**Collision can be also chosen*/
	public Layout(float _x, float _y, boolean collision,int _index){
	  super(_x, _y, collision);
	  index=_index;
	}
	
	/**Does Layout to be drawn always below entities*/
	public abstract boolean isAlwaysDown();

	@Override
	public void init(GameContainer gameC, Room room) {}
}
/* Henrik Valve
 * 18.02.2013
 * 19.02.2013
 * 03.03.2013
 * 14.03.2013
 * 15.03.2013
 * 16.03.2013
 * 23.03.2013
 * 16.07.2013
 * 17.07.2013
 */
