package RPG;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Light{
  /**Middle point of the light*/
  private float x,y;
  /**Max radiuses of different rings end spots*/
  private int[] radiuses;
  /**Light's flip per update*/
  private int flipPer;
    public Light(float _x,float _y){
      x = _x;
      y = _y;
    }
    public Light(float _x,float _y,int flipPerUpdate){
      x = _x;
      y = _y;
      flipPer = flipPerUpdate;
    }
    
    public float getX(){
      return x;
    }
    
    public float getY(){
      return y;
    }
    /**Draws AplhaMap for lighting to take place*/
    public void drawAlpha(Graphics g){
      
    }
    /**gives the area this lights alpha*/
    public Shape getAlphaArea(){
      Circle alpha=new Circle(x,y,radiuses[0]);
      for(int a=1;a<radiuses.length;a++){
      }
      return alpha;
    }
    
    /**Updates light so that there is movement*/
    public void update(int delta){
      
    }
}
/* Henrik Valve
 * (not marked)
 * 10.7.2013
 */
