package RPG;

import org.lwjgl.Sys;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class RPGmain extends StateBasedGame{
	public static void main(String[] args){
      AppGameContainer appgc;
	  try{
	    appgc=new AppGameContainer(new RPGmain());
	    appgc.setDisplayMode(1265,500,false);
		appgc.setTargetFrameRate(60);
		appgc.start();
	  }
	  catch(SlickException e){
		Sys.alert("Display error", e.getMessage());
	  }
      System.exit(0);
	}
    RPGmain(){
	  super("FunRPG");
	  addState(new RoomTitle(0));
	  addState(new World(3));
	}
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
	  enterState(3);
	}
}
/* Henrik Valve
 * 02.11.2012
 * 04.11.2012
 * 18.03.2013
 * 19.03.2013
 * 11.04.2013
 * 16.04.2013
 * 08.05.2013
 * 16.05.2013
 * 18.05.2013
 * 19.05.2013
 * 24.05.2013
 */
