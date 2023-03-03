package RPG;

import java.util.Random;

import org.newdawn.slick.state.StateBasedGame;

public abstract class Behavior{
  /**Java's Random class for randomness*/
  protected Random random = new Random();
  /**Entity that uses this behavior*/
  protected Entity entity;
    
    Behavior(Entity _entity){
      entity = _entity;
    }
  
    /**Is certain attributes happened to run behaveNow*/
    public abstract boolean canBehave();
    
    /**How to behave*/
    public abstract void behaveNow(StateBasedGame game);
    
    /**Gives back boolean is the there collision at the way. If layout coordinates are less than zero
     * true returned*/
    protected boolean IsCollision(int layoutX,int layoutY,StateBasedGame game){
      if(layoutX<0||layoutY<0){
    	return true;
      }
      Layout layout = ((Room)(game.getCurrentState())).layouts[layoutX][layoutY];
      if(layout==null){
    	return true;
      }
      return layout.collision;
    }
}
/* Henrik Valve
 * 01.02.2013
 * 07.02.2013
 * 22.03.2013
 */
