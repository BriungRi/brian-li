package general;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;

public class Fractal

{

	public void draw(Graphics g, int iteration, Point p1, Point p2, Point p3, Point p4) {
		if (iteration == 1) {
			// base case: simple triangle
			Polygon p = new Polygon();
			p.addPoint(p1.x, p1.y);
			p.addPoint(p2.x, p2.y);
			p.addPoint(p3.x, p3.y);
			p.addPoint(p4.x, p4.y);
			g.drawPolygon(p);
		} else {
			Point p5 = midpoint(p1, p2);
			Point p6 = midpoint(p2, p3);
			Point p7 = midpoint(p3, p4);
			Point p8 = midpoint(p4, p1);
			Point middle = midpoint(p1, p3);
			
			Point p9 = midpoint(p1, p8);
			Point p10 = midpoint(p8, middle);
			Point p11 = midpoint(middle, p5);
			Point p12 = midpoint(p5, p1);
			Point p13 = midpoint(p5, p2);
			Point p14 = midpoint(p2, p6);
			Point p15 = midpoint(p6, middle);
			Point p16 = midpoint(p6, p3);
			Point p17 = midpoint(p3, p7);
			Point p18 = midpoint(p7, middle);
			Point p19 = midpoint(p7, p4);
			Point p20 = midpoint(p4, p8);

			draw(g, iteration - 1, p1, p5, middle, p8);
			draw(g, iteration - 1, p5, p2, p6, middle);
			draw(g, iteration - 1, p6, p3, p7, middle);
			draw(g, iteration - 1, middle, p7, p4, p8);
			draw(g, iteration - 1, p9, p10, p11, p12);
			draw(g, iteration - 1, p11, p13, p14, p15);
			draw(g, iteration - 1, p15, p16, p17, p18);
			draw(g, iteration - 1, p10, p18, p19, p20);
		}
	}

	public static Point midpoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

}