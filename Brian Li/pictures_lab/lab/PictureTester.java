package lab;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
//  public static void keepOnlyBlue()
//  {
//	  { 
//		  Pixel[][] pixels = this.getPixels2D(); 
//		  for (Pixel[] rowArray : pixels) 
//		  { 
//			  for (Pixel pixelObj : rowArray) 
//			  { 
//				  	pixelObj.setGreen(0); 
//				  	pixelObj.setRed(0);
//			  } 
//		  }
//  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEncode()
  {
	  Picture mrhorn = new Picture("brandon-horn.jpg");
	  mrhorn.encode("Hi this is Mr. Horn");
	  mrhorn.explore();
	  System.out.println(mrhorn.decode());
  }
  
  public static void testChromakey()
  {
	  Picture mark = new Picture("blue-mark.jpg");
	  mark.explore();
	  mark.chromakey(new Picture("moon-surface.jpg"), mark.getPixel(100, 100).getColor());
	  mark.explore();
  }
  
  public static void testMosaic()
  {
	  Picture mrhorn = new Picture("brandon-horn.jpg");
	  mrhorn.mosaic(10);
	  mrhorn.explore();
  }
  

  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	  testEncode();
//    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
//    testEdgeDetection();
    //testEdgeDetection2();
//    testChromakey();
//    testMosaic();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}