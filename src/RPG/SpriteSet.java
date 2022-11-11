package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public abstract class SpriteSet {
  /**First old man set. Don't create new objects because loading system*/
  public static SpriteSet ManOld1 = new SpriteSetManOld1();
  /**Tetman sprite' set. "Tet" comes form "test" and "man" is just the fact that he is a man. Don't create new objects because loading system*/
  public static SpriteSet Tetman  = new SpriteSetTetman();
  /**First Layout set created. Ancient place floors.*/
  public static SpriteSet GroundZeroFloor = new SpriteSetGroundZeroFloor();
  /**Ancient place's walls*/
  public static SpriteSet GroundZeroWall = new SpriteSetGroundZeroWall();
  /**SpriteSet that has black spaces that are out*/
  public static SpriteSet Black=new SpriteSetBlack();
  /**SpriteSet for Fusgo main character*/
  public static SpriteSet Fusgo = new SpriteSetFusgo();
  
  boolean loaded=false;
  protected Image[] sprites;
  protected Animation[] anims;
    
    SpriteSet(int index){
      sprites=new Image[index];
      anims=new Animation[0];
    }
    
    SpriteSet(int imageindex,int animationindex){
      sprites=new Image[imageindex];
      anims=new Animation[animationindex];
    }
    
    public Image getSprite(int index){
      try{
    	return sprites[index];
      }
      catch(ArrayIndexOutOfBoundsException e){
    	return null;
      }
    }
    /**gives you animation of given index*/
    public Animation getAnimation(int index){
      try{
        return anims[index];
      }
      catch(ArrayIndexOutOfBoundsException e){
        return null;
      }
    }    
    
   public abstract void load();
}
/* Henrik Valve
 * 10.12.2012
 * 27.12.2012
 * 28.12.2012
 * 01.02.2013
 * 19.02.2013
 * 20.02.2013
 * 17.03.2013
 * 18.03.2013
 * 29.03.2013
 * 21.04.2013
 * 27.04.2013
 */
