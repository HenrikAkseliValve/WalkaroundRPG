package RPG;

import java.util.ArrayList;
import java.util.TreeMap;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Room extends BasicGameState{

	/**Games command line*/
	final static CommandLine Com=new CommandLine();
	/**Rooms entities*/
	public ArrayList<Entity> entities=new ArrayList<Entity>();
	/**Rooms layout in double array. (x,y)*/
	public Layout[][] layouts = new Layout[50][50];
	/**Players on room*/
	public static Player players[] = new Player[2];
	/**Section that is drawn. (x,y,z)*/
	@SuppressWarnings("unchecked")
	private TreeMap<Integer,EntityObject>[][] drawing=new TreeMap[50][2];
	/**Constant numbers of point were drawing[a][1] has last layout*/
	private int[] layoutSize=new int[50];
	/**Command lines printed messages*/
	private String[] ComPrint;
	/**Special rendering list*/
	public ArrayList<SpecialRendering> SR = new ArrayList<SpecialRendering>();
	/**Rooms final ID*/
	private final int ID;
	/**Layout coordinates which player will spawn when coming new room*/
	private int spawnX=3,spawnY=9;
	/**boolean to indicate does black spaces be drawn*/
	private boolean isBlack=false;
	/**is two player mode on*/
	private static boolean twoplayer = true;
	/**Player one's clip*/
	final Rectangle clipP1 = new Rectangle(0,0,630,500);
	/**Player two's clip*/
	final Rectangle clipP2 = new Rectangle(635,0,1265,500);
	/**Counts 32 rounds and then goes back to zero*/
	private int counter = 0;

	public Room(int id){
		ID=id;
	}

	@Override
	public void init(GameContainer gameC, StateBasedGame game) throws SlickException{
		
		Com.setValues(gameC,game,this);
		if(!Com.isAlive()){
			Com.setPriority(5);
			Com.start();
		}
		
		RoomInit(gameC,game);
		EntityObject loop;

		for(int x=0;x<layouts.length;x++){
			for(int y=0;y<layouts[x].length;y++){
				loop = layouts[x][y];
				if(loop!=null){
					if(loop.isdrawn()){
						imageLoad(loop.getSet());
					}
					loop.init(gameC,this);
				}
			}
		}
		for(int e=0;e<entities.size();e++){
			loop = (Entity)entities.get(e);
			if(loop.isdrawn()){
				imageLoad(loop.getSet());
			}
			loop.init(gameC,this);
		}
		
		players[0] = new Player(spawnX,spawnY);
		imageLoad(SpriteSet.Fusgo);
		players[0].init(gameC,this);
		
		int[] option = {Input.KEY_W,Input.KEY_S,Input.KEY_A,Input.KEY_D,Input.KEY_G,Input.KEY_H};
		players[1] = new Player(spawnX+1,spawnY,option);
//		imageLoad(SpriteSet.Fusgo);
		players[1].init(gameC,this);
		
		Layout loopl;
		for(int y=0;y<drawing.length;y++){
			drawing[y][0]=new TreeMap<Integer,EntityObject>();
			drawing[y][1]=new TreeMap<Integer,EntityObject>();
			layoutSize[y]=0;
			for(int c=0;c<50;c++){
				if(layouts[c][y]!=null){
					loopl = layouts[c][y];
					if(loopl.isdrawn()){
						if(loopl.isAlwaysDown()){
							drawing[y][0].put(c,loopl);
						}
						else{
							drawing[y][1].put(c,loopl);
							layoutSize[y]++;
						}
					}
				}
			}
		}
		Entity loope;
		int loopindex;
		for(int e=0;e<entities.size();e++){
			loope = entities.get(e);
			loopindex = loope.getDrawingIndex();
			drawing[loopindex][1].put(layoutSize[loopindex]+e,loope);
		}
		drawing[spawnY][1].put(-1, players[0]);
		drawing[spawnY][1].put(-2, players[1]);
	}
	@Override
	public void render(GameContainer gamec,StateBasedGame game,Graphics g) throws SlickException{
//		RoomPainter(gamec,game,g);
		g.setWorldClip(clipP1);
		g.translate(300-players[0].getScreenX(),240-players[0].getScreenY());
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_SRC_ALPHA);

		g.setDrawMode(Graphics.MODE_NORMAL);
		if(isBlack){
			g.setBackground(new Color(25,25,25));
			isBlack=false;
		}

		TreeMap<Integer,EntityObject> looph;
		EntityObject loope;
		Object[] keys;
		for(int z=0;z<2;z++){
			for(int y=0;y<drawing.length;y++){
			if(drawing[y][z]!=null){
				looph = drawing[y][z];
				keys = looph.keySet().toArray();
				for(int d=0;d<keys.length;d++){
					loope = looph.get(keys[d]);
					if(loope!=null){
						loope.draw(g);
					}
				}
			}
			}
		}

		if(SR != null|SR.size()!=0){
			SpecialRendering renderingObject;
			Color defaultCopy = g.getColor();
			for(int index=0;index<SR.size();index++){
				renderingObject = (SpecialRendering)SR.get(index);
				if(renderingObject.doIDraw()){
					renderingObject.drawSpecial(gamec,g);
			 	}
				else{
					SR.remove(index);
					index--;
				}
			}
			g.setColor(defaultCopy);
		}
		g.setDrawMode(Graphics.MODE_ALPHA_MAP);
		g.setColor(new Color(0f,0f,0f,0.9f));
		g.fill(clipP1);
		//clear just example
		g.setColor(new Color(0f,0f,0f,.85f));
		g.fill(new Circle(110,170,35+reshape));
		g.setColor(new Color(0f,0f,0f,.80f));
		g.fill(new Circle(110,170,35+reshape));
		g.setColor(new Color(0f,0f,0f,.75f));
		g.fill(new Circle(110,170,33+reshape));
		g.setColor(new Color(0f,0f,0f,.70f));
		g.fill(new Circle(110,170,31+reshape));
		g.setColor(new Color(0f,0f,0f,.65f));
		g.fill(new Circle(110,170,29+reshape));
		g.setColor(new Color(0f,0f,0f,.60f));
		g.fill(new Circle(110,170,27+reshape));
		g.setColor(new Color(0f,0f,0f,.55f));
		g.fill(new Circle(110,170,25+reshape));
		g.setColor(new Color(0f,0f,0f,.50f));
		g.fill(new Circle(110,170,23+reshape));
		g.setColor(new Color(0f,0f,0f,.45f));
		g.fill(new Circle(110,170,21+reshape));
		g.setColor(new Color(0f,0f,0f,.40f));
		g.fill(new Circle(110,170,19+reshape));
		g.setColor(new Color(0f,0f,0f,.35f));
		g.fill(new Circle(110,170,17+reshape));
		g.setColor(new Color(0f,0f,0f,.30f));
		g.fill(new Circle(110,170,15+reshape));
		g.setColor(new Color(0f,0f,0f,.25f));
		g.fill(new Circle(110,170,13+reshape));
		g.setColor(new Color(0f,0f,0f,.2f));
		g.fill(new Circle(110,170,11+reshape));
		g.setColor(new Color(0f,0f,0f,.15f));
		g.fill(new Circle(110,170,9+reshape));
		g.setColor(new Color(0f,0f,0f,.1f));
		g.fill(new Circle(110,170,7+reshape));

		g.setDrawMode(Graphics.MODE_ALPHA_BLEND);
		g.setColor(new Color(0f,0f,0f,.8f));
		g.fill(clipP1);

		g.setDrawMode(Graphics.MODE_NORMAL);

		if(Com.isOpen()){
			ComPrint=Com.getPrinted();
			g.drawRect(0,254,clipP1.getWidth(),245);
			g.drawLine(1, 480, clipP1.getWidth()-1,480);
			if(ComPrint[0]!=null){
				g.drawString(ComPrint[0],2,483);
			}
			for(int i=1;i<=ComPrint.length-1;i++){
				g.drawString(ComPrint[i],2,465-(i-1)*14);
			}
		}
		g.clearWorldClip();
		g.clearAlphaMap();
		g.translate(-300+players[0].getScreenX(),-240+players[0].getScreenY());

		if(twoplayer){
			g.setDrawMode(Graphics.MODE_NORMAL);

			g.setWorldClip(new Rectangle(631,0,4,500));
			g.setColor(new Color(170,170,170));
			g.drawRect(631,0,4,500);
			g.setColor(new Color(255,255,255));
			g.fillRect(632,1,3,499);
			g.clearWorldClip();

			g.setWorldClip(clipP2);
			g.translate(935-players[1].getScreenX(),240-players[1].getScreenY());

//		g.setDrawMode(Graphics.MODE_ALPHA_MAP);

//		g.setDrawMode(Graphics.MODE_ALPHA_BLEND);

				for(int z=0;z<2;z++){
					for(int y=0;y<drawing.length;y++){
						if(drawing[y][z]!=null){
							looph = drawing[y][z];
							keys = looph.keySet().toArray();
							for(int d=0;d<keys.length;d++){
								loope = looph.get(keys[d]);
								if(loope!=null){
									loope.draw(g);
								}
							}
						}
					}
				}

			if(SR != null|SR.size()!=0){
				SpecialRendering renderingObject;
				Color defaultCopy = g.getColor();
				for(int index=0;index<SR.size();index++){
					renderingObject = (SpecialRendering)SR.get(index);
					if(renderingObject.doIDraw()){
						renderingObject.drawSpecial(gamec,g);
					}
					else{
						SR.remove(index);
						index--;
					}
				}
				g.setColor(defaultCopy);
			}

			g.clearWorldClip();
			g.clearAlphaMap();
			g.translate(-935+players[1].getScreenX(),-240+players[1].getScreenY());
		}
	}
	/**remove*/
	float reshape=1;
	/**remove*/
	float sinX=0;

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta){
		counter=(counter+1)&31;
		if(counter==15 || counter==31){sinX+=.5;reshape=(float) (2f*Math.sin(sinX));}

		EntityObject loop;
		int index1;
		int index2;
		for(int k=0;k<entities.size();k++){
			loop=entities.get(k);
			index1 = ((Entity)loop).getDrawingIndex();
			((Entity)loop).behavior(game,delta);
			index2 = ((Entity)loop).getDrawingIndex();

			if(index1!=index2){
				drawing[index1][1].remove(layoutSize[index1]+k);
				drawing[index2][1].put(layoutSize[index2]+k,loop);
			}
		}
		for(int x=0;x<layouts.length;x++){
			for(int y=0;y<layouts[x].length;y++){
				loop = (EntityObject)layouts[x][y];
			}
		}
		index1=players[0].getYLevel();
		players[0].update(container, game, delta);
		index2=players[0].getYLevel();
		if(index1!=index2){
			drawing[index1][1].remove(-1);
			drawing[index2][1].put(-1,players[0]);
		}
		index1=players[1].getYLevel();
		players[1].update(container, game, delta);
		index2=players[1].getYLevel();
		if(index1!=index2){
			drawing[index1][1].remove(-2);
			drawing[index2][1].put(-2,players[1]);
		}
	}
	/**Rooms personal initialization*/
	abstract void RoomInit(GameContainer GameC, StateBasedGame game);
	/**Rooms personal painting..... Not real use right now*/
	abstract void RoomPainter(GameContainer Gamec,StateBasedGame game,Graphics g);

	@Override
	public int getID(){
		return ID;
	}
	/**Loads set if not already loaded*/
	private void imageLoad(SpriteSet set){
		if(!set.loaded){
			set.load();
			set.loaded=true;
		}
	}
	/**Adds layout to the layouts*/
	protected void addLayout(Layout layout){
		layouts[(int)layout.x/30][(int)layout.y/20]=layout;
	}
	/**Adds layout that doesn't have images*/
	protected void addLayoutNotDrawn(int layoutX, int layoutY){
		layouts[layoutX][layoutY]=new LayoutNotDrawn(layoutX,layoutY);
	}
	/**When this runs background is set to black (color 25,25,25)*/
	protected void useBlackBackGround(){
		isBlack = true;
	}
	/**Game is on two player mode*/
	public void twoPlayerMode(){
		twoplayer = true;
	}
	/**Game is on one player mode*/
	public void onePlayerMode(){
		twoplayer = false;
	}
}
/* Henrik Valve
 * 2.11.2012
 * 4.11.2012(Copied from Officebot)
 * 06.12.2012
 * 08.12.2012
 * 27.12.2012
 * 29.12.2012
 * 01.02.2013
 * 04.02.2013
 * 06.02.2013
 * 07.02.2013
 * 18.02.2013
 * 19.02.2013
 * 02.03.2013
 * 04.03.2013
 * 09.03.2013
 * 10.03.2013
 * 14.03.2013
 * 15.03.2013
 * 16.03.2013
 * 17.03.2013
 * 18.03.2013
 * 19.03.2013
 * 21.03.2013
 * 22.03.2013
 * 23.03.2013
 * 25.03.2013
 * 27.03.2013
 * 29.03.2013
 * 11.04.2013
 * 16.04.2013
 * 17.04.2013
 * 19.04.2013
 * 06.05.2013
 * 07.05.2013
 * 15.05.2013
 * 16.05.2013
 * 18.05.2013
 * 19.05.2013
 * 22.05.2013
 * 23.05.2013
 * 24.05.2013
 * 04.06.2013
 * 10.06.2013
 * 29.06.2013
 * 30.06.2013
 * 10.07.2013
 * 11.07.2013
 * 16.07.2013
 * 17.07.2013
 */
