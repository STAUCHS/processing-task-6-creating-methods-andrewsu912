import processing.core.PApplet;

public class Sketch extends PApplet {

  // Declare Variables
  int intAmtFlowers;
  int intAmtStickMen;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255, 255, 255);
  }

  public void draw() {

    intAmtStickMen = drawStickManRow(3, 3);
    blnCheckStickMen(intAmtStickMen);

    intAmtFlowers = drawFlowerRow(4, 2);
    blnCheckFlowers(intAmtFlowers);
  }

  /**
   * This determines how many stick men to draw as well as where to draw them.
   * 
   * @param intRowStickMan    The amount of stick men within the row
   * @param intColumnStickMan the amount of stick men within the column
   * @return The total amount of stick men
   */
  public int drawStickManRow(int intRowStickMan, int intColumnStickMan) {
    for (float fltX = (width / intRowStickMan) / 2; fltX <= width; fltX += width / intRowStickMan) {
      for (float fltY = (height / intColumnStickMan) / 2; fltY <= height; fltY += height / intColumnStickMan) {

        drawStickMan(fltX, fltY);

      }
    }
    return intRowStickMan * intColumnStickMan;
  }

  /**
   * This checks if the amount of stickmen are an even or odd number.
   * 
   * @param intAmtStickMen The amount of stickmen
   */
  private boolean blnCheckStickMen(int intAmtStickMen) {
    if (intAmtStickMen % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This draws each individual stick man.
   * 
   * @param fltX The x coordinate of the stick man
   * @param fltY The y coordinate of the stick man
   * @author Andrew Su
   */
  public void drawStickMan(float fltX, float fltY) {

    boolean blnCheckStickMen = blnCheckStickMen(intAmtStickMen);
    if (blnCheckStickMen) {
      stroke(3, 209, 255);
    } else {
      stroke(237, 81, 193);
    }

    // Draw head

    ellipse(fltX, fltY - 35, 30, 30);

    // Draw body
    line(fltX, fltY - 20, fltX, fltY + 30);

    // Draw arms
    line(fltX, fltY - 10, fltX - 25, fltY + 10);
    line(fltX, fltY - 10, fltX + 25, fltY + 10);

    // Draw legs
    line(fltX, fltY + 30, fltX - 25, fltY + 70);
    line(fltX, fltY + 30, fltX + 25, fltY + 70);
  }

  /**
   * This determines how many flowers to draw as well as where to draw them.
   * 
   * @param intRowFlower    The amount of flowers within the row
   * @param intColumnFlower The amount of flowers within the column
   * @return The total amount of flowers
   * @author Andrew Su
   */
  public int drawFlowerRow(int intRowFlower, int intColumnFlower) {
    for (int fltX = (width / intRowFlower) / 2; fltX <= width; fltX += width / intRowFlower) {
      for (int fltY = (height / intColumnFlower) / 2; fltY <= height; fltY += height / intColumnFlower) {

        drawFlower(fltX, fltY, 255, 209, 3);

      }
    }
    return intRowFlower * intColumnFlower;
  }

  /**
   * This checks if the amount of flowers are an even or odd number.
   * 
   * @param intAmtFlower The amount of Flowers
   * @author Andrew Su
   */
  private boolean blnCheckFlowers(int intAmtFlowers) {
    if (intAmtFlowers % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This draws each individual flower.
   * 
   * @param fltX       The x coordinate of the flower
   * @param fltY       The y coordinate of the flower
   * @param intCenterR The Red amount in RBG for the center of the flower
   * @param intCenterG The Green amount in RBG for the center of the flower
   * @param intCenterB The Blue amount in RBG for the center of the flower
   * @author Andrew Su
   */
  public void drawFlower(float fltX, float fltY, int intCenterR, int intCenterG, int intCenterB) {
    // Calling Variables

    int intPetals = 8;

    // Flower Petals
    translate(fltX, fltY);
    boolean blnCheckFlowers = blnCheckFlowers(intAmtFlowers);
    if (blnCheckFlowers) {
      fill(3, 209, 255);
    } else {
      fill(237, 81, 193);
    }

    for (int intDegree = 0; intDegree < 360; intDegree += 360 / intPetals) {
      pushMatrix();

      rotate((float) Math.toRadians(intDegree));
      ellipse(0, 15, 15, 20);
      popMatrix();
    }

    // Center of Flower
    noStroke();
    fill(intCenterR, intCenterG, intCenterB);
    ellipse(0, 0, 38, 38);
    resetMatrix();
  }
}