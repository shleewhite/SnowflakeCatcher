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

SnowFlake [] snowing;
public void setup()
{
 size (400, 400);
 background(0);
 snowing = new SnowFlake[300];
 for (int i = 0; i < snowing.length; i++){
  snowing[i] = new SnowFlake();
 }
}
public void draw()
{

  for (int i = 0; i < snowing.length; i++){
    snowing[i].erase();
    snowing[i].move();
    snowing[i].lookDown();
    snowing[i].wrap();
    snowing[i].show();
  }
}
public void mouseDragged()
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
  public void show()
  {
    stroke(0);
    fill(255);
    ellipse(myX, myY, 5, 5);
  }
  public void lookDown()
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
  public void erase()
  {
    fill(0);
    ellipse(myX, myY, 10, 10);
  
  }
  public void move()
  {
    if (isMoving == true){
      myY = myY + 1;
    }
  }
  public void wrap()
  {
    if (myY > 400){
      myY = 0;
      myX = (int)(Math.random()*401);
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
