package CSCI1933P1;
import java.awt.*;
import java.util.concurrent.*;
 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Canvas extends JPanel {

	
	private int height;
	private int width;
	private CopyOnWriteArrayList<Circle> circles;
	private CopyOnWriteArrayList<Triangle> triangles;
	private CopyOnWriteArrayList<Rectangle> rectangles;
	
	public Canvas() {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = 800;
		width = 800;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new CopyOnWriteArrayList<Circle>();
		rectangles = new CopyOnWriteArrayList<Rectangle>();
		triangles = new CopyOnWriteArrayList<Triangle>();
		f.setVisible(true);
	}
	
	public Canvas(int h, int w) {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = h;
		width = w;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new CopyOnWriteArrayList<Circle>();
		rectangles = new CopyOnWriteArrayList<Rectangle>();
		triangles = new CopyOnWriteArrayList<Triangle>();
		f.setVisible(true);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image buffer = createImage(width,height);
		drawToBuffer(buffer.getGraphics());
		g.drawImage(buffer,0,0,null);
	}

	public void drawToBuffer(Graphics g){	
		ListIterator<Circle> circItr = circles.listIterator();
		ListIterator<Rectangle> recItr = rectangles.listIterator();
		ListIterator<Triangle> triItr = triangles.listIterator();

		while (circItr.hasNext()) {
			Circle curCircle = circItr.next();
			g.setColor(curCircle.getColor());
			int curRadius = (int)curCircle.getRadius();
			g.fillOval((int)curCircle.getXPos() - curRadius, (int)curCircle.getYPos()
					- curRadius, 2 * curRadius, 2 * curRadius);

		}

		while (recItr.hasNext()) {
			Rectangle curRectangle = recItr.next();
			g.setColor(curRectangle.getColor());
			g.fillRect((int)curRectangle.getXPos(), (int)curRectangle.getYPos(),
					(int)curRectangle.getWidth(), (int)curRectangle.getHeight());
		}

		while (triItr.hasNext()) {
			Triangle curTriangle = triItr.next();
			g.setColor(curTriangle.getColor());
			Polygon po = new Polygon();
			po.addPoint((int)curTriangle.getXPos(), (int)curTriangle.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth()), (int)curTriangle
					.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth() / 2), (int)(curTriangle.getYPos() - curTriangle.getHeight()));
			g.fillPolygon(po);
		}
	}
	
	
	public void drawShape(Circle circ){
		circles.add(circ);
	}
	
	public void drawShape(Rectangle rec){
		rectangles.add(rec);
	}
	
	public void drawShape(Triangle tri){
		triangles.add(tri);
	}
	
	public void clear(){
		circles.clear();
		rectangles.clear();
		triangles.clear();
	}
	

}