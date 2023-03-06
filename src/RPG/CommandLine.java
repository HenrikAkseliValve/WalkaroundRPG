package RPG;

import static org.newdawn.slick.Input.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class CommandLine extends Thread{
	/**Class has information about user inputs*/
	private Input input;
	/**GameContainer has information about screen*/
	private GameContainer GameC;
	/**StateBasedGame has information example about state */
	private StateBasedGame Game;
	/**This information could have been gotten through StateBasedGame but this faster to get information that is add to engine*/
	private Room currentRoom;
	/**Boolean that is returned at isOpen() method*/
	private boolean open=false;
	/**This string is what is inputed by user with out spaces*/
	private String TextInput[]={"","","","",""};
	/**History*/
	private String[] TextPrint=new String[40];
	/**how much "up" you have gotten while going through history*/
	private int up=0;
	/**Tells is certain word at TextInput pure number after first word*/
	private boolean[] purenumber = {false,false,false,false};
	/**how many spaces is there*/
	private int spaces=0;

	/**Toggles between does system draw shape to layout to tell is it collide false or true*/
	private boolean showcollideToggle=false;

	/**New tread. Runs input checking and commands*/
	@Override
	public void run(){
		while(true){
			if(input.isKeyPressed(KEY_F12)){
				if(open==false){
					open=true;
					GameC.pause();
				}
				try{
					if(open==true){
						boolean emptier=true;
						do{
							if(input.isKeyPressed(KEY_ENTER)){
								up=0;
								moveUp(1);
								for(int j=0;j<TextInput.length;j++){
									TextPrint[1]+=TextInput[j];
									TextPrint[1]+=" ";
								}
								switch(TextInput[0]){
									case "full":
										for(int s=1;s<17;s++){
											returnPrint("Line here!");
										}
										break;
										case "getfps":
											returnPrint(GameC.getFPS());
											break;
										case "getmouse":
											returnPrint(Mouse.getX()+" "+ Mouse.getY());
											break;
											case "showentity":
												if(purenumber[0]){
													if(Integer.parseInt(TextInput[1])<currentRoom.entities.size()){
														Entity e = (Entity) currentRoom.entities.get(Integer.parseInt(TextInput[1]));
														SpecialRendering box= new RenderingBox(e);
														currentRoom.SR.add(box);
														break;
													}
													returnPrint("Error! Too big number to be ID!");
												}
												returnPrint("Error! Missing id for entity!");
												break;
											case "help":
												returnPrint("Commands listed below");
												returnPrint("entitymove <entityID> <\"coordinates\"> <x y>/<layoutID>");
												returnPrint("full");
												returnPrint("getfps");
												returnPrint("getmouse");
												returnPrint("showcollision");
												returnPrint("showentity <entityID>");
												break;
											case "":
												open=false;
												GameC.resume();
												break;
											case "showcollision":
												if(!showcollideToggle){
													showcollideToggle=true;
													for(int x=0;x<21;x++){
														for(int y=0;y<25;y++){
															currentRoom.SR.add(new RenderingCollision(x,y));
														}
													}
												}
												else{
													showcollideToggle=false;
												}
												break;
											default:
												returnPrint("Error! No command named \""+TextInput[0]+"\" exist!");
												break;
								}
								for(int h=0;h<TextInput.length;h++){
									TextInput[h] = "";
								}
								for(int f=0;f<purenumber.length;f++){
									purenumber[f] = false;
								}
								spaces = 0;
								print("");
								sleep(100);
							}
							if(input.isKeyPressed(KEY_BACK)&&TextInput[0].length()!=0){
								if(!emptier){
									if(TextInput[spaces].length()<1&&spaces>0){
										spaces--;
									}
									else{
										String test = TextInput[spaces].substring(0,TextInput[spaces].length()-1);
										char[] ac = test.toCharArray();
										if(spaces>0){
											for(int c=0;c<ac.length;c++){
												if(!(ac[c]=='1'|ac[c]=='2'|ac[c]=='3'|ac[c]=='4'|ac[c]=='5'|ac[c]=='6'|ac[c]=='7'|ac[c]=='8'|ac[c]=='9'|ac[c]=='0')){
													purenumber[spaces-1]=false;
													break;
												}
												else{
													purenumber[spaces]=true;
												}
											}
										}
										TextInput[spaces]=test;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_F12)){
								open=false;
								GameC.resume();
							}
							if(input.isKeyPressed(KEY_A)){
								if(!emptier){
									TextInput[spaces]+="a";
									if(spaces<0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_B)){
								if(!emptier){
									TextInput[spaces]+="b";
									if(spaces<0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_C)){
								if(!emptier){
									TextInput[spaces]+="c";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_D)){
								if(!emptier){
									TextInput[spaces]+="d";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_E)){
								if(!emptier){
									TextInput[spaces]+="e";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_F)){
								if(!emptier){  
									TextInput[spaces]+="f";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_G)){
								if(!emptier){
									TextInput[spaces]+="g";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_H)){
								if(!emptier){
									TextInput[spaces]+="h";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_I)){
								if(!emptier){
									TextInput[spaces]+="i";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_J)){
								if(!emptier){
									TextInput[spaces]+="j";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_K)){
								if(!emptier){
									TextInput[spaces]+="k";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_L)){
								if(!emptier){
									TextInput[spaces]+="l";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_M)){
								if(!emptier){
									TextInput[spaces]+="m";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_N)){
								if(!emptier){
									TextInput[spaces]+="n";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_O)){
								if(!emptier){
									TextInput[spaces]+="o";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_P)){
								if(!emptier){
									TextInput[spaces]+="p";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_Q)){
								if(!emptier){
									TextInput[spaces]+="q";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_R)){
								if(!emptier){
									TextInput[spaces]+="r";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_S)){
								if(!emptier){
									TextInput[spaces]+="s";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_T)){
								if(!emptier){
									TextInput[spaces]+="t";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_U)){
								if(!emptier){
									TextInput[spaces]+="u";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_V)){
								if(!emptier){
									TextInput[spaces]+="v";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_W)){
								if(!emptier){
									TextInput[spaces]+="w";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_X)){
								if(!emptier){
									TextInput[spaces]+="x";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_Y)){
								if(!emptier){
									TextInput[spaces]+="y";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_Z)){
								if(!emptier){
									TextInput[spaces]+="z";
									if(spaces>0){
										purenumber[spaces-1]=false;
									}
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_SPACE)){
								if(!emptier&&spaces<4){
									spaces++;
								}
							}
							if(input.isKeyPressed(KEY_0)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="0";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_1)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="1"; 
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_2)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="2";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_3)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="3";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_4)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="4";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_5)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="5";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_6)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="6";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_7)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="7";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_8)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="8";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_9)){
								if(!emptier){
									if(spaces>0&&TextInput[spaces].isEmpty()){
										purenumber[spaces-1]=true;
									}
									TextInput[spaces]+="9";
									printForSpace(TextInput);
								}
							}
							if(input.isKeyPressed(KEY_NUMPAD8)){
								if(!emptier&&up!=TextPrint.length-17) up++;
							}
							if(input.isKeyPressed(KEY_NUMPAD2)){
								if(!emptier&&up!=0) up--;
							}
							emptier=false;
							sleep(100);
						}while(open==true);
					}
				}
				catch(InterruptedException error){
					error.printStackTrace();
				}
				catch(IllegalStateException error){
					System.exit(0);
				}
			}
			try{
				sleep(100);
			}
			catch(Exception error){
				error.printStackTrace();
			}
		}
	}

	/**Returns true if command line is open*/
	public boolean isOpen(){
		return open;
	}

	/**returns String array that has 16 lines of history. Up to 39 lines is stored. You can move history while command
	 * line is open by pressing numpad's 8 and 2. Whit same array is also returned input line (always index 0 so 
	 * history is indexes 1 to 16)*/
	public String[] getPrinted(){
		String[] returnS=new String[17];
		returnS[0]=TextPrint[0];
		for(int k=1;k<17;k++){
			if(TextPrint[up+k]!=null){
				returnS[k]=TextPrint[up+k];
			}
			else{
				returnS[k]="";
			}
		}
		return returnS;
	}

	/**set's Game Container and StateBasedGame values (used to get command line functions to work)*/
	public void setValues(GameContainer Gamec,StateBasedGame game,Room room){
		GameC=Gamec;
		Game=game;
		input=GameC.getInput();
		currentRoom=room;
	}
	
	/**Change input line*/
	private void print(String in){
		TextPrint[0]=in;
	}

	/**Prints string "in" to the history*/
	private void returnPrint(String in){
		moveUp(1);
		TextPrint[1]=in;
	}

	/**Same than returnPrint(String in) but only for string*/
	private void returnPrint(int in){
		returnPrint(String.valueOf(in));
	}

	private void printForSpace(String[] in){
		String out="";
		for(int u=0;u<in.length;u++){
			out+=in[u]+" ";
		}
		print(out);
	}

	/**Notice that moveUp doesn't move zero anywhere. Zero is used as a input!*/
	private void moveUp(int times){
		for(int k=1;k<=times;k++){
			for(int i=TextPrint.length-2;i>0;i--){
				TextPrint[i+1]=TextPrint[i];
			}
			TextPrint[1]="";
		}
	}

	/**Rendering the box around given entity*/
	private class RenderingBox extends SpecialRendering{
		private Entity entity;
		
		RenderingBox(Entity _entity){
			entity = _entity;
			setTimeAmount(10000);
		}
		
		@Override
		public void tellSpecial(Graphics g){
			g.setColor(Color.red);
			g.drawRect(entity.x, entity.y+10, entity.drew.getWidth(), -entity.drew.getHeight());
		}
	}

	private class RenderingCollision extends SpecialRendering{
		/**Layout*/
		private Layout layout;
		/**Coordinates*/
		private int x,y;

		RenderingCollision(int layoutX,int layoutY){
			layout=currentRoom.layouts[layoutX][layoutY];
			x = layoutX*30;
			y = layoutY*20;
			setTimeAmount(1000);
		}

		@Override
		public void tellSpecial(Graphics g){
			addTime(1000);
			if(layout==null){
				g.setColor(Color.yellow);
			}
			else{
				if(layout.collision){
					g.setColor(Color.red);
				}
				else{
					g.setColor(Color.green);
				}
			}
			g.drawRect(x+2, y+2, 28, 18);
			g.drawRect(x+1, y+1, 29, 19);
		}
		
		@Override
		public boolean doIDraw(){
			return showcollideToggle;
		}
	}
}
/*Henrik Valve
 * 04.11.2012(copied from Officebot)
 * 01.02.2013
 * 04.02.2013
 * 06.02.2013
 * 07.02.2013
 * 18.02.2013
 * 20.02.2013
 * 21.02.2013
 * 22.02.2013
 * 23.02.2013
 * 24.02.2013
 * 02.03.2013
 * 03.03.2013
 * 09.03.2013
 * 14.03.2013
 * 19.03.2013
 * 04.06.2013
 * 10.06.2013
 * 20.06.2013
 */
