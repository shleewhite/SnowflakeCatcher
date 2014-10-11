SnowFlake [] snowing;
void setup()
{
 size (400, 400);
 background(0);
 snowing = new SnowFlake[50];
 for (int i = 0; i < snowing.length; i++){
  snowing[i] = new SnowFlake();
 }
}
void draw()
{

  for (int i = 0; i < snowing.length; i++){
    snowing[i].erase();
    snowing[i].move();
    snowing[i].lookDown();
    snowing[i].wrap();
    snowing[i].show();
  }
}
void mouseDragged()
{
  if (mouseButton == RIGHT)
  {
    fill (0);
  }
  else 
  {
  noStroke();
  fill(255, 0, 0);
  }
  
  ellipse(mouseX, mouseY, 10, 10);
}

class SnowFlake
{
 int myX, myY;
 boolean isMoving;
  SnowFlake()
  {
    myX = (int)(Math.random()*401);
    myY = (int)(Math.random()*401);
    isMoving = true;
  }
  void show()
  {
    stroke(0);
    fill(255);
    ellipse(myX, myY, 5, 5);
  }
  void lookDown()
  {
    if (myY > 0 && myY < 393 && get(myX, myY + 7) != color(0, 0, 0))
    {
      isMoving = false;
    }
    else 
    {
      isMoving = true;
    }
  }
  void erase()
  {
    fill(0);
    ellipse(myX, myY, 10, 10);
  
  }
  void move()
  {
    if (isMoving == true){
      myY = myY + 1;
    }
  }
  void wrap()
  {
    if (myY > 400){
      myY = 0;
      myX = (int)(Math.random()*401);
    }
  }
}


