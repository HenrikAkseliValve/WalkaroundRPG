package RPG;

import org.newdawn.slick.state.StateBasedGame;

public class BehaviorWalkAtPoint extends Behavior {
   /**is behavior run on these coordinates*/
   boolean time=false;

	BehaviorWalkAtPoint(Entity _entity) {
	  super(_entity);
	}

	@Override
	public boolean canBehave(){
	  if(entity.moveX==entity.x&&entity.moveY==entity.y){
		time=false;
	  }
	  return (false)&&(!time);
	}

	@Override
	public void behaveNow(StateBasedGame game){
      entity.moveTo(4,4);
      time=true;
	}

}
/* Henrik Valve
 * 17.03.2013
 */
