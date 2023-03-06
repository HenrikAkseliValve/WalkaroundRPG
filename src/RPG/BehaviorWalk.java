package RPG;

import org.newdawn.slick.state.StateBasedGame;

public class BehaviorWalk extends Behavior {
	/**Bigger the number less change walk to happen*/
	private int allChanges;

	BehaviorWalk(Entity _entity,int changesToWalk) {
		super(_entity);
		allChanges = changesToWalk;
	}

	@Override
	public boolean canBehave() {
		return !entity.animationGoingOn;
	}

	@Override
	public void behaveNow(StateBasedGame game){
		int r = random.nextInt(allChanges);
		switch(r){
		case 1:	if(!IsCollision((int)entity.x/30,(int)(entity.y/20)+1,game)){
							entity.moveTo(entity.x,entity.y+20f);
							break;
						}
		case 2:	if(!IsCollision((int)entity.x/30,(int)(entity.y/20)-1,game)){
						entity.moveTo(entity.x,entity.y-20f);
						break;
						}
		case 3:	if(!IsCollision((int)(entity.x/30)-1,(int)entity.y/20,game)){
							entity.moveTo(entity.x-30f,entity.y);
							break;
						}
		case 4:if(!IsCollision((int)(entity.x/30)+1,(int)entity.y/20,game)){
						entity.moveTo(entity.x+30f,entity.y);
						break;
					 }
		case 5:	if(!IsCollision((int)entity.x/30,(int)(entity.y/20)+2,game)&&!IsCollision((int)entity.x/30,(int)(entity.y/20)+1,game)){
							entity.moveTo(entity.x,entity.y+40f);
							break;
						}
		case 6:	if(!IsCollision((int)entity.x/30,(int)(entity.y/20)-2,game)&&!IsCollision((int)entity.x/30,(int)(entity.y/20)-1,game)){
							entity.moveTo(entity.x,entity.y-40f);
							break;
						}
		case 7:	if(!IsCollision((int)(entity.x/30)-2,(int)entity.y/20,game)&&!IsCollision((int)(entity.x/30)-1,(int)entity.y/20,game)){
							entity.moveTo(entity.x-60f,entity.y);
							break;
						}
		case 8:	if(!IsCollision((int)(entity.x/30)+2,(int)entity.y/20,game)&&!IsCollision((int)(entity.x/30)+1,(int)entity.y/20,game)){
							entity.moveTo(entity.x+60f,entity.y);
							break;
						}
						break;
		}
	}
	}
/* Henrik Valve
 * 07.02.2013
 * 11.02.2013
 * 19.02.2013
 * 20.02.2013
 * 24.02.2013
 * 17.03.2013
 * 22.03.2013
 * 23.02.2013
 * 10.06.2013
 */
