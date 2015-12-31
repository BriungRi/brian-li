package general;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.Polygon;

public class FractalComponent extends JComponent

{
	public static final int SIZE = 512;
	
	private int numIterations;

	private int length;

	public FractalComponent(int iters, int aLength)

	{

		numIterations = iters;

		length = aLength;

	}

	public void paintComponent(Graphics g)

	{

		Graphics2D g2 = (Graphics2D) g;

		Fractal fractal = new Fractal();

		int rectangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, rectangleHeight);
        Point p3 = new Point(SIZE, rectangleHeight);
        Point p4 = new Point(SIZE, 0);
        fractal.draw(g, numIterations, p1, p2, p3, p4);

	}

	public static void main(String[] args)

	{

		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 550;

		final int FRAME_HEIGHT = 500;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setTitle("My First Fractal");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String input = JOptionPane
				.showInputDialog(null, "hao mny frctl unitz u wantz");

		if (input == null)

			System.exit(0);

		int iterations = Integer.parseInt(input);

		FractalComponent component = new FractalComponent(iterations, 300);

		frame.add(component);

		frame.setVisible(true);

	}

}