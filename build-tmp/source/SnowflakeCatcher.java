import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

Snowflake [] powder;
int sizeX=500;
int sizeY=500;
public void setup()
{
  size(sizeX,sizeY);
  powder=new Snowflake[10];
  for(int i=0;i<powder.length;i++);
  {
    powder[i]=new Snowflake((int)(Math.random()*sizeX),(int)(Math.random()*sizeY));
  }
  frameRate(200);
}
public void draw()
{
  for(int i=0;i<powder.length;i++);
  {
    powder[i].erase();
    powder[i].lookDown();
    powder[i].move();
    powder[i].wrap();
    powder[i].show();
  }
} 
public void mouseDragged()
{
  //your code here
}

class Snowflake
{
  int myX,myY;
  boolean isMoving;
  Snowflake(int x,int y)
  {
    myX=x;
    myY=y;
    isMoving=true;
  }
  public void show()
  {
    stroke(255);
    fill(255);
    ellipse(x,y,5,5);
  }
  public void lookDown()
  {
    if(y>0&&get(x,y+3)!=color(255))
    {
      isMoving=false;
    }
    else 
    {
      isMoving=true;
    }
  }
  public void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y,0,0);
  }
  public void move()
  {
    if(isMoving)
      y++;
  }
  public void wrap()
  {
    if(y==sizeY)
    {
      y=0;
      x=(int)(Math.random()*sizeX);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
