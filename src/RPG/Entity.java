package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity extends EntityObject {
  
  /**Entities Behaviors*/
  private Behavior[] behaviors;
  /**Animation that is drew*/
  protected Animation drew;
  /**Is entity performing long animation*/
  protected boolean animationGoingOn=false;
  /**Integer coordinates were to move*/
  protected int moveX,moveY;
  /**Is character between layouts. 1 is down, 2 is up, 3 is right, 4 is left, 0 is waiting*/
  private byte ismoving;
  /**Indexs which of Room class drawing ArrayList this entity is in*/
  private int drawingIndexY;
  
    Entity(int layoutX,int layoutY,int behaviorIndex){
	  this((float)layoutX*30,(float)layoutY*20,behaviorIndex);
	  drawingIndexY=layoutY;
    }

	Entity(float _x,float _y,int behaviorIndex){
	  super(_x,_y,true);
	  behaviors = new Behavior[behaviorIndex];
	  moveX =(int)x;
	  moveY =(int)y;
	}
	
	/**checks all the entitiy's behaviors and if allowed runs that behavior */
	public void behavior(StateBasedGame game,int delta){
	  for(int i=0;i<behaviors.length;i++){
		if(behaviors[i].canBehave()){
		  behaviors[i].behaveNow(game);
		}
	  }
	  Room room = (Room) game.getCurrentState();
	  float dx = (moveX-x)/30;
	  float dy = (moveY-y)/20;
	  if(dx<1.25&&dx>0.75){
		room.layouts[moveX/30][moveY/20].collision=true;
		room.layouts[(moveX/30)-1][moveY/20].collision=false;
	  }
	  if(dy<1.25&&dy>0.75){
		room.layouts[moveX/30][moveY/20].collision=true;
	    room.layouts[moveX/30][(moveY/20)-1].collision=false;
	  }
	  if(dx>-1.25&&dx<-0.75){
		room.layouts[moveX/30][moveY/20].collision=true;
		room.layouts[(moveX/30)+1][moveY/20].collision=false;
	  }
	  if(dy>-1.25&&dy<-0.75){
		room.layouts[moveX/30][moveY/20].collision=true;
	    room.layouts[moveX/30][(moveY/20)+1].collision=false;
	  }
	  
	  if(dx<2.25&&dx>1.75){
		room.layouts[(moveX/30)-1][moveY/20].collision=true;
		room.layouts[(moveX/30)-2][moveY/20].collision=false;
	  }
	  if(dy<2.25&&dy>1.75){
		room.layouts[moveX/30][(moveY/20)-1].collision=true;
	    room.layouts[moveX/30][(moveY/20)-2].collision=false;
	  }
	  if(dx>-2.25&&dx<-1.75){
		room.layouts[(moveX/30)+1][moveY/20].collision=true;
		room.layouts[(moveX/30)+2][moveY/20].collision=false;
	  }
	  if(dy>-2.25&&dy<-1.75){
		room.layouts[moveX/30][(moveY/20)+1].collision=true;
	    room.layouts[moveX/30][(moveY/20)+2].collision=false;
	  }
	  
	  if(moveX!=x){
        if(moveX<x&&(ismoving==0||ismoving==3)){
          if(moveX >= x - 0.045*delta){
            x = moveX;
        	animationGoingOn = false;
        	drew = getAnimation(4);
        	ismoving=0;
          }
          else{
            x-=0.045*delta;
	        if(drew != getAnimation(5)){
		      drew = getAnimation(5);
		    }
	        if((moveX-x)/30>-2.25&&(moveX-x)/30<-2&&room.layouts[moveX/30][moveY/30].collision){
	          moveX+=30;
	        }
            ismoving=3;
          }
        }
        if(moveX>x&&(ismoving==0||ismoving==4)){
          if(moveX <= x + 0.045*delta){
            x = moveX;
        	animationGoingOn = false;
        	drew = getAnimation(6);
        	ismoving=0;
          }
          else{
            x+=0.045*delta;
	        if(drew != getAnimation(7)){
		      drew = getAnimation(7);
		    }
	        if((moveX-x)/30<2.25&&(moveX-x)/30>2&&room.layouts[moveX/30][moveY/30].collision){
		      moveX-=30;
		    }
            ismoving=4;
          }
        }
	  }
	  if(moveY!=y){
		if(moveY<y&&(ismoving==0||ismoving==2)){
		  if(moveY >= y - 0.045*delta){
			y = moveY;
	        animationGoingOn = false;
	        drew = getAnimation(2);
	        ismoving=0;
	       
		  }
	      else{
	    	y-=0.045*delta;
	        if(drew != getAnimation(3)){
		      drew = getAnimation(3); 
		    }
	        if((moveY-y)/30>-2.25&&(moveY-y)/30<-2&&room.layouts[moveX/30][moveY/30].collision){
		      moveY+=30;
		    }
	    	ismoving=2;
		  } 
	    }
	    if(moveY>y&&(ismoving==0||ismoving==1)){
	      if(moveY <= y + 0.045*delta){
		    y = moveY;
		    animationGoingOn = false;
		    drew = getAnimation(0);
		    ismoving=0;
		  }
		  else{ 
	        y+=0.045*delta;
	        if(drew != getAnimation(1)){
	          drew = getAnimation(1);
	        }
	        if((moveY-y)/30<2.25&&(moveY-y)/30>2&&room.layouts[moveX/30][moveY/30].collision){
		      moveY-=30;
		    }
	        ismoving=1;
		  }
	    }
	    double b = Math.floor(y/20);
	    if(b!=drawingIndexY){
	      drawingIndexY = (int)b;
	    }
	  }
	}
	
	/**Adds behavior to Behaviors*/
	protected void addBehavior(Behavior behaviortoadd,int index){
	  behaviors[index]=behaviortoadd;
	}
	
	/**Moves entity to point (x,y)*/
	public void moveTo(float x,float y){
	  moveX = (int)x;
	  moveY = (int)y;
	  animationGoingOn = true;
	}
	
	/**Same code as moveTo(int x,int y) but takes floats*/
	public void moveTo(int x,int y){
	  moveTo(x*30f,y*20f);
	}
	/**Gives you drawingIndexY value*/
	public int getDrawingIndex(){
	  return drawingIndexY;
	}
	
	public void init(GameContainer gameC,Room room){
	  room.layouts[(int)x/30][drawingIndexY].collision=true;
	}
}
/* Henrik Valve
 * (wasn't written)
 * 27.12.2012
 * 07.02.2013
 * 11.02.2013
 * 19.02.2013
 * 24.02.2013
 * 15.03.2013
 * 17.03.2013
 * 19.03.2013
 * 22.03.2013
 * 24.05.2013
 * 31.05.2013
 * 10.06.2013
 * 22.06.2013
 * 25.06.2013
 */
