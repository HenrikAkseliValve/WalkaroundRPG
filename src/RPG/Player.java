package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends EntityObject{
	/**Is controls locked*/
	private boolean controlLock;
	/**Player is in conversation*/
	private boolean inConversation;
	/**Players Animation*/
	private Animation anime;
	/**z level*/
	private int zLevel;
	/**y level*/
	private int yLevel;
	/**integer of key/button that makes player to move up*/
	private int moveUp = Input.KEY_UP;
	/**integer of key/button that makes player to move down*/
	private int moveDown = Input.KEY_DOWN;
	/**integer of key/button that makes player to move left*/
	private int moveLeft = Input.KEY_LEFT;
	/**integer of key/button that makes player to move right*/
	private int moveRight = Input.KEY_RIGHT;
	/**Integer of first action key/button*/
	private int ActionButton1 = Input.KEY_M;
	/**Integer of second action key/button*/
	private int ActionButton2 = Input.KEY_N;
	/**Long integer for counting how long key was down*/
	private long keyDownCount;
	/**Is there key counting*/
	private boolean isKeyCounting=false;
	/**x,y coordinates change*/
	private float screenX,screenY;
	/**Counts are x,y of the player so that stopping should happen*/
	private float xPlus=0,yPlus=0;

	/**Takes layout coordinates and changes them */
	Player(int layoutX,int layoutY,int options[]){
		this(layoutX,layoutY);
		moveUp=options[0];
		moveDown=options[1];
		moveLeft=options[2];
		moveRight=options[3];
		ActionButton1 = options[4];
		ActionButton2 = options[5];
	}

	/**Takes layout's coordinates and changes them drawing coordinates*/
		Player(int layoutX,int layoutY){
			this(layoutX*30f,layoutY*20f);
			yLevel=layoutY;
		}

	Player(float _x,float _y){
		super(_x, _y,true);
	}

	/**Players update*/
	public void update(GameContainer container, StateBasedGame game,int delta){
		Input input = container.getInput();
		Room room = (Room)game.getCurrentState();
		boolean isMoved=false;
		if(!inConversation){ 
			if(!isMoved&&xPlus==0&&yPlus>=0){
				if(input.isKeyDown(moveDown)){
					if(!isKeyCounting){
						keyDownCount = 115000000+System.nanoTime();
						isKeyCounting = true;
						anime = getAnimation(0);
					}
					else if(keyDownCount <= System.nanoTime()){
						if(anime != getAnimation(1)){
							anime = getAnimation(1);
						}
						if(doIMove1(room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)+1],yPlus)){
							room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)+1].collision=true;
							if(yPlus+0.045*delta>=20&&doesCollide(room,Math.round(x/30),(Math.round((y-yPlus)/20))+2)){
								y+=20-yPlus;
								yPlus=0;
							}
							else{
								y+=0.045*delta;
								yPlus+=0.045*delta;
								if(yPlus>20){
									yPlus-=20;
								}
								if(yPlus>=10&&room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision){
									room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision=false;
								}
							}
							if(y>240) screenY = y;
							else screenY = 240;
						}
					}
					isMoved = true;
				}
				else{
					if(yPlus>0){
						if(yPlus+0.045*delta>=20){
							y+=20-yPlus;
							yPlus=0;
							anime = getAnimation(0);
						}
						else{
							y+=0.045*delta;
							yPlus+=0.045*delta;
							if(yPlus<-20){
								yPlus+=20;
							}
							if(yPlus>=10&&room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision){
								room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision=false;
							}
						}
						if(y>240){
							screenY = y;
						}
						else{
							screenY = 240;
						}
						isMoved = true;
					}
					else if(anime==getAnimation(1)){
						anime=getAnimation(0);
					}
				}
			}

			if(!isMoved&&xPlus==0){
				if(input.isKeyDown(moveUp)){
					if(!isKeyCounting){
						keyDownCount = 115000000+System.nanoTime();
						isKeyCounting = true;
						anime = getAnimation(2);
					}
					else if(keyDownCount <= System.nanoTime()){
						if(anime != getAnimation(3)){
							anime = getAnimation(3);
						}
						if(doIMove1(room.layouts[Math.round(x/30)][(Math.round((y-yPlus)/20))-1],yPlus)){
							room.layouts[Math.round(x/30)][(Math.round((y-yPlus)/20))-1].collision=true;
							if(doesCollide(room,Math.round(x/30),(Math.round((y-yPlus)/20))-2)&&yPlus-0.045*delta<=-20){
								y+=-20-yPlus;
								yPlus=0;
							}
							else{
								y-=0.045*delta;
								yPlus-=0.045*delta;
								if(yPlus<-20){
									yPlus+=20;
								}
								if(yPlus<=-10&&room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision){
									room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision=false;
								}
							}
							if(y>240) screenY = y;
							else{
								screenY = 240;
							}
						}
					}
					isMoved = true;
				}
				else{
					if(yPlus<0){
						if(yPlus-0.045*delta<=-20){
							y+=-20-yPlus;
							yPlus=0;
							anime = getAnimation(2);
						}
						else{
							y-=0.045*delta;
							yPlus-=0.045*delta;
							if(yPlus<=-10&&room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision){
								room.layouts[Math.round(x/30)][Math.round((y-yPlus)/20)].collision=false;
							}
						}
						if(y>240) screenY = y;
						else screenY = 240;
						isMoved = true;
					}
					else if(anime==getAnimation(3)){
						anime=getAnimation(2);
					}
				}
			}

			double b = Math.floor(y/20);
			if(b!=yLevel) yLevel = (int)b;

			if(!isMoved&&yPlus==0&&xPlus<=0){
				if(input.isKeyDown(moveLeft)){
					if(!isKeyCounting){
						keyDownCount = 115000000+System.nanoTime();
						isKeyCounting = true;
						anime = getAnimation(4);
					}
					else if(keyDownCount <= System.nanoTime()){
						if(anime != getAnimation(5)){
							anime = getAnimation(5);
						}
						if(doIMove1(room.layouts[((int)Math.round((x-xPlus)/30))-1][(int)Math.round(y/20)],xPlus)){
							room.layouts[((int)Math.round((x-xPlus)/30))-1][(int)Math.round(y/20)].collision=true;
							if(doesCollide(room,((int)Math.round((x-xPlus)/30))-2,(int)Math.round(y/20))&&xPlus-0.045*delta<=-30){
								x+=-30-xPlus;
								xPlus=0;
							}
							else{
								x-=0.045*delta;
								xPlus-=0.045*delta;
								if(xPlus<-30){
									xPlus+=30;
								}
								if(xPlus<=-15&&room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision){
									room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision=false;
								}
							}
							if(x>300){
								screenX = x;
							}
							else{
								screenX = 300;
							}
						}
					}
					isMoved = true;
				}
				else{ 
					if(xPlus<0){
						if(xPlus-0.045*delta<=-30){
							x+=-30-xPlus;
							xPlus=0;
							anime = getAnimation(4);
						}
						else{
							x-=0.045*delta;
							xPlus-=0.045*delta;
							if(xPlus<=-15&&room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision){
								room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision=false;
							}
						}
						if(x>300) screenX = x;
						else screenX = 300;
						isMoved = true;
					}
					else if(anime==getAnimation(5)){
						anime=getAnimation(4);
					}
				}
			}

			if(!isMoved&&yPlus==0){
				if(input.isKeyDown(moveRight)){
					if(!isKeyCounting){
						keyDownCount = 115000000+System.nanoTime();
						isKeyCounting = true;
						anime = getAnimation(6);
					}
					else if(keyDownCount <= System.nanoTime()){
						if(anime != getAnimation(7)){
							anime = getAnimation(7);
						}
						if(doIMove1(room.layouts[((int)Math.round((x-xPlus)/30))+1][(int)Math.round(y/20)],xPlus)){
							room.layouts[((int)Math.round((x-xPlus)/30))+1][(int)Math.round(y/20)].collision=true;
							if(doesCollide(room,((int)Math.round((x-xPlus)/30)+2),(int)Math.round(y/20))&&xPlus+0.045*delta>=30){
								x+=30-xPlus;
								xPlus=0;
							}
							else{
								x+=0.045*delta;
								xPlus+=0.045*delta;
								if(xPlus>30) xPlus-=30;
								if(xPlus>=15&&room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision){
									room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision=false;
								}
							}
							if(x>300) screenX = x;
							else{
								screenX = 300;
							}
						}
					}
					isMoved = true;
				} 
				else{
					if(xPlus>0){
						if(xPlus+0.045*delta>=30){
							x+=30-xPlus;
							xPlus=0;
							anime = getAnimation(6);
						}
						else{
							x+=0.045*delta;
							xPlus+=0.045*delta;
							if(xPlus>=15&&room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision){
								room.layouts[(int)Math.round((x-xPlus)/30)][(int)Math.round(y/20)].collision=false;
							}
						}
						if(x>300){
							screenX = x;
						}
						isMoved = true;
					}
					else if(anime==getAnimation(7)){
						anime=getAnimation(6);
					}
				}
			}
		}
		if(!isMoved) isKeyCounting=false;
		//System.out.println("Coord: "+x+" ; "+y+" Plusses:"+xPlus+" ; "+yPlus+" Layout coord:"+y/20+" ; "+x/30);
	}

	@Override
	public void draw(Graphics g){
//		anime.draw(x,y);
		g.drawAnimation(anime, (int)x, (int)y-39);
	}

	@Override
	public void init(GameContainer gameC,Room room){
		if(room.layouts[(int)Math.round(x/30)][yLevel]!=null){
			room.layouts[(int)Math.round(x/30)][yLevel].collision=true;
		}
		anime = getAnimation(0);
		if(x>300) screenX = x;
		else screenX = 300;
		if(y>240) screenY = y;
		else screenY = 240;
	}
	
	@Override
	public SpriteSet getSet(){
		return SpriteSet.Fusgo;
	}
	
	/**gives z level of the player to drawing*/
	public int getZLevel(){
		return zLevel;
	}
	
	/**gives y level of the player to drawing*/
	public int getYLevel(){
		return yLevel;
	}
	
	/**Get screenX (middle point of the screen)*/
	public int getScreenX(){
		return (int)screenX;
	}
	
	/**Get screenY (middle point of the screen)*/
	public int getScreenY(){
		return (int)screenY;
	}
	
	/**Ask is given layout's collision true and is given movePlus not zero*/
	private boolean doIMove1(Layout layout,float movePlus){
		if(movePlus!=0) return true;
		if(layout!=null){
			if(!layout.collision){
				return true;
			}
		}
		return false;
	}
	/**Return boolean for this guestion. Checks that Layout isn't null and return if it is true*/
	private boolean doesCollide(Room room,int LayoutX,int LayoutY){
		if(room.layouts[LayoutX][LayoutY]==null) return true;
		return room.layouts[LayoutX][LayoutY].collision;
	}
	
}
/* Henrik Valve
 * 09.03.2013
 * 26.03.2013
 * 27.03.2013
 * 17.04.2013
 * 19.04.2013
 * 20.04.2013
 * 27.04.2013
 * 28.04.2013
 * 30.04.2013
 * 02.05.2013
 * 03.05.2013
 * 06.05.2013
 * 07.05.2013
 * 08.05.2013
 * 16.05.2013
 * 19.05.2013
 * 21.05.2013
 * 24.05.2013
 * 31.05.2013
 * 10.06.2013
 * 20.06.2013
 * 21.06.2013
 */
