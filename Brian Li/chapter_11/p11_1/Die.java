package p11_1;

import java.util.Random;

/**
   This class models a die that, when cast, lands on a random
   face.
*/
public class Die implements shared.Measurable
{
   /**
      Constructs a die with a given number of sides.
      @param s the number of sides, e.g. 6 for a normal die
   */
   public Die(int s)
   {
      sides = s;
      generator = new Random();
      this.cast();
   }

   /**
      Simulates a throw of the die
      @return the face of the die 
   */
   public void cast()
   {
      this.roll = 1 + generator.nextInt(sides);
   }
   
   public double getMeasure()
   {
	   return this.roll;
   }
   private Random generator;
   private int sides;
   private double roll;
}
