import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.*;

public class Rectangles {
	
	private JFrame mainMap;
    private Polygon poly;
    private Random rand;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Rectangles(40);
            }
        });
	}
	
	public Rectangles(int num) {
		initComponents(num);
	}
	
	private void initComponents(int num) {
		mainMap = new JFrame();
		rand = new Random();
		
		mainMap.setSize(800, 800);
		mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainMap.setResizable(true);
        mainMap.setVisible(true);
        
	    int x = rand.nextInt(100, 200), x2 = rand.nextInt(100, 300), x3 = rand.nextInt(300, 400),  y = rand.nextInt(100, 400), y2 = rand.nextInt(100, 400), y3 = rand.nextInt(500, 600);
	        
		int xPoly[] = {300, 250, 200, 150, 200, 250};
	    int yPoly[] = {300, 250, 250, 300, 350, 350};
	
	    poly = new Polygon(xPoly, yPoly, xPoly.length);
	
	    JPanel p = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	             g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
	             g.fillPolygon(poly);
	        }
	
	        @Override
	        public Dimension getPreferredSize() {
	             return new Dimension(800, 800);
	        }
	     };
	     mainMap.add(p);
	     mainMap.pack();
	     mainMap.setVisible(true);
        
	}
	
}
