package RPG;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;

public class World extends Room{
	public World(int ID) {
		super(ID);
	}

	@Override
	public void RoomPainter(GameContainer Gamec, StateBasedGame game, Graphics g) {
	}

	@Override
	void RoomInit(GameContainer GameC, StateBasedGame game){
	  useBlackBackGround();

	                                                                                              addLayout(new LayoutGroundZeroWall1(2,7,0));   addLayout(new LayoutGroundZeroWall1(3,7,5));   addLayout(new LayoutGroundZeroWall1(4,7,0));
	  /*(0,8) null*/                                addLayout(new LayoutGroundZeroWall1(1,8,7));  addLayout(new LayoutGroundZeroFloor1(2,8,0));  addLayout(new LayoutGroundZeroFloor1(3,8,0));  addLayout(new LayoutGroundZeroFloor1(4,8,0));  addLayout(new LayoutGroundZeroFloor1(5,8,2));	                                                 
	  /*(0,9) null*/                                addLayout(new LayoutGroundZeroWall1(1,9,7));  addLayout(new LayoutGroundZeroFloor1(2,9,0));  addLayout(new LayoutGroundZeroFloor1(3,9,0));  addLayout(new LayoutGroundZeroFloor1(4,9,0));  addLayoutNotDrawn(5,9);
	  /*(0,10) null*/                               addLayout(new LayoutGroundZeroWall1(1,10,7)); addLayout(new LayoutGroundZeroFloor1(2,10,0)); addLayout(new LayoutGroundZeroFloor1(3,10,1)); addLayout(new LayoutGroundZeroFloor1(4,10,1)); addLayout(new LayoutGroundZeroWall1(5,10,3));
	  /*(0,11) null*/                               addLayout(new LayoutGroundZeroWall1(1,11,7)); addLayoutNotDrawn(2,11);                       addLayoutNotDrawn(3,11);                       addLayoutNotDrawn(4,11);                       addLayout(new LayoutGroundZeroWall1(5,11,2));
	  /*(0,12) null*/                               addLayout(new LayoutGroundZeroWall1(1,12,6)); addLayout(new LayoutGroundZeroWall1(2,12,1));  addLayout(new LayoutGroundZeroWall1(3,12,1));  addLayout(new LayoutGroundZeroWall1(4,12,1));  addLayout(new LayoutGroundZeroWall1(5,12,4));/**/addLayout(new LayoutGroundZeroWall1(10,12,5));
	  /*(0,13) null*/                                              
	  /*(0,14) null*/
	  /*(0,15) null*/                                                                                                                                                                                                                                                                       /**/                                              /**/ addLayout(new LayoutGroundZeroFloor1(8,15,1)); /**/                      addLayout(new LayoutGroundZeroFloor1(10,15,0)); 
	  /*(0,16) null*/                                                                                                                                                                                                                                                                                                                                                
	  /*(0,17) null*/
	  /*(0,18) null*/                                                                              /**/   addLayout(new LayoutGroundZeroFloor1(19,18,0));
	  /*(0,19) null*/
      addLayout(new LayoutGroundZeroWall1(0,20,7)); addLayout(new LayoutGroundZeroFloor1(1,20,0));/**/addLayout(new LayoutGroundZeroFloor1(10,20,0));addLayout(new LayoutGroundZeroFloor1(19,20,0));
      /*(0,21) null*/
      /*(0,22) null*/addLayout(new LayoutGroundZeroFloor1(8,22,1));addLayout(new LayoutGroundZeroFloor1(12,22,1));addLayout(new LayoutGroundZeroFloor1(19,22,2));
      /*(0,23) null*/addLayout(new LayoutGroundZeroWall1(0,23,7));addLayout(new LayoutGroundZeroFloor1(2,23,0));addLayout(new LayoutGroundZeroFloor1(4,23,2));addLayout(new LayoutGroundZeroFloor1(6,23,0));addLayout(new LayoutGroundZeroFloor1(14,23,0));addLayout(new LayoutGroundZeroFloor1(16,23,0));addLayout(new LayoutGroundZeroFloor1(18,23,2));addLayout(new LayoutGroundZeroFloor1(20,23,2)); addLayout(new LayoutGroundZeroFloor1(22,23,0));addLayout(new LayoutGroundZeroFloor1(24,23,0));
	  addLayout(new LayoutGroundZeroWall1(0,24,7));addLayout(new LayoutGroundZeroFloor1(19,24,1));
	  /*(0,25) null*/
	  /*(0,26) null*/addLayout(new LayoutGroundZeroFloor1(19,26,0));
	  /*(0,27) null*/
	  /*(0,28) null*/addLayout(new LayoutGroundZeroFloor1(19,28,0));
	  /*(0,29) null*/
	  /*(0,30) null*/addLayout(new LayoutGroundZeroFloor1(19,30,0));
	  /*(0,31) null*/
	  /*(0,32) null*/addLayout(new LayoutGroundZeroFloor1(19,32,1));
	  /*(0,33) null*/
	  /*(0,34) null*/addLayout(new LayoutGroundZeroFloor1(19,34,0));
	  /*(0,35) null*/
	  /*(0,36) null*/addLayout(new LayoutGroundZeroFloor1(19,36,0));
	  /*(0,37) null*/
	  /*(0,38) null*/addLayout(new LayoutGroundZeroFloor1(19,38,0));
	  /*(0,39) null*/
	  /*(0,40) null*/addLayout(new LayoutGroundZeroFloor1(19,40,0));
	  /*(0,41) null*/
	  /*(0,42) null*/addLayout(new LayoutGroundZeroFloor1(19,42,0));
	  
	  entities.add(0,new NPCTetman(3,8));
	}
}
/* Henrik Valve
 * 04.11.2012
 * 09.11.2012
 * 06.12.2012
 * 08.12.2012
 * 15.12.2012
 * 27.12.2012
 * 19.02.2013
 * 20.02.2013
 * 03.03.2013
 * 14.03.2013
 * 15.03.2013
 * 16.03.2013
 * 17.03.2013
 * 18.03.2013
 * 19.03.2013
 * 21.03.2013
 * 22.03.2013
 * 25.03.2013
 * 26.03.2013
 * 27.03.2013
 * 20.04.2013
 * 21.03.2013
 * 15.05.2013
 * 16.05.2013
 * 18.05.2013
 * 23.05.2013
 */
