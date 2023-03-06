package RPG;

import org.newdawn.slick.state.StateBasedGame;

public class BehaviorLookAround extends Behavior {
	/**Bigger the number less change turn to happen*/
	private int allChanges;
	
	public BehaviorLookAround(Entity _entity,int changesToTurn){
		super(_entity);
		allChanges = changesToTurn;
	}
	
	@Override
	public boolean canBehave(){
		return !entity.animationGoingOn;
	}
	
	@Override
	public void behaveNow(StateBasedGame game){
		int r = random.nextInt(allChanges);
		switch(r){
		case 1:entity.drew=entity.getAnimation(0);break;
		case 2:entity.drew=entity.getAnimation(2);break;
		case 3:entity.drew=entity.getAnimation(4);break;
		case 4:entity.drew=entity.getAnimation(6);break;
		}
	}

}
/* Henrik Valve
 * 07.02.2013
 * 11.02.2013
 */
