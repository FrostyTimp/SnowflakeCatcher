Snowflake [] powder;
int sizeX=500;
int sizeY=500;
void setup()
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
void mouseDragged()
{
  int r=(int)(Math.random()*256);
  int g=(int)(Math.random()*256);
  int b=(int)(Math.random()*256);
  strokeWeight(3);
  stroke(r,g,b);
  fill(r,g,b);
  line(mouseX,mouseY,pmouseX,pmouseY);
}
void draw()
{
  for(int i=0;i<powder.length;i++)
  {
    powder[i].erase();
    powder[i].lookDown();
    powder[i].move();
    powder[i].wrap();
    powder[i].show();
  }
} 
class Snowflake
{
  int x,y;
  boolean isMoving;
  Snowflake()
  {
    x=(int)(Math.random()*sizeX);
    y=(int)(Math.random()*sizeY*2)-sizeY*2;
    isMoving=true;
  }
  void show()
  {
    strokeWeight(1);
    fill(255);
    ellipse(x,y,5,5);
  }
  void lookDown()
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
  void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y,7,7);
  }
  void move()
  {
    if(isMoving)
      y=y+(int)(Math.random()*2)+1;
  }
  void wrap()
  {
    if(y>sizeY-10)
    {
      y=1;
      x=(int)(Math.random()*sizeX);
    }
  }
}