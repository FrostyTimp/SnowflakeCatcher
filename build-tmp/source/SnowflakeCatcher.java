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
int sizeX=550;
int sizeY=500;
double timer=0;
public void setup()
{
  size(sizeX,sizeY);
  background(0);
  powder=new Snowflake[250];
  for(int i=0;i<powder.length;i++)
  {
    powder[i]=new Snowflake();
  }
  frameRate(60);
}
public void mouseDragged()
{
  int r=(int)(Math.random()*256);
  int g=(int)(Math.random()*256);
  int b=(int)(Math.random()*256);
  strokeWeight(3);
  stroke(r,g,b);
  fill(r,g,b);
  line(mouseX,mouseY,pmouseX,pmouseY);
}
public void draw()
{
  for(int i=0;i<powder.length;i++)
  {
    powder[i].erase();
    powder[i].lookDown();
    powder[i].move();
    powder[i].wrap();
    powder[i].show();
  }
  if(timer<10000)
    timer++;
  stroke(0);
  fill(0);
  rect(510,0,50,50);
  textAlign(CENTER);
  textSize(20);
  text((float)timer,sizeX-20,20);
} 
class Snowflake
{
  int x,y;
  boolean isMoving;
  Snowflake()
  {
    x=(int)(Math.random()*(sizeX-50));
    y=(int)(Math.random()*sizeY*2)-sizeY*2;
    isMoving=true;
  }
  public void show()
  {
    strokeWeight(1);
    fill(255);
    ellipse(x,y,5,5);
  }
  public void lookDown()
  {
    if(y>0&&y<sizeY)
    {
      if(get(x,y+7)!=color(0))
      {
        isMoving=false;
      }
      else 
      {
        isMoving=true;
      }
    }
  }
  public void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y,7,7);
  }
  public void move()
  {
    if(isMoving)
      y=y+(int)(Math.random()*2)+1;
  }
  public void wrap()
  {
    if(y>sizeY-10)
    {
      y=1;
      x=(int)(Math.random()*(sizeX-50));
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
