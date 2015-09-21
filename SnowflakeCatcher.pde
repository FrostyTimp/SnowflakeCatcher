Snowflake [] powder;
int sizeX=500;
int sizeY=500;
void setup()
{
  size(sizeX,sizeY);
  powder=new Snowflake[10];
  for(int i=0;i<powder.length;i++);
  {
    powder[i]=new Snowflake((int)(Math.random()*sizeX),(int)(Math.random()*sizeY));
  }
  frameRate(200);
}
void draw()
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
void mouseDragged()
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
  void show()
  {
    stroke(255);
    fill(255);
    ellipse(x,y,5,5);
  }
  void lookDown()
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
  void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y,0,0);
  }
  void move()
  {
    if(isMoving)
      y++;
  }
  void wrap()
  {
    if(y==sizeY)
    {
      y=0;
      x=(int)(Math.random()*sizeX);
    }
  }
}


