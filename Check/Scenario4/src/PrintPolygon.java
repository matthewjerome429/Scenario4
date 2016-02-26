import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;
import java.lang.String;
import java.util.Scanner;

public class PrintPolygon extends JPanel {
	
	static double [] inputX = new double[512];
	static double [] inputY = new double[512];
	static double multiplier = 20;
	static int vertices = 175;
	static int guardNumber = 56;
	static double [] x = new double[512];
	static double [] y = new double[512];
	static double [] guardX = new double[512];
	static double [] guardY = new double[512];
	static double [] newGuardX = new double[512];
	static double [] newGuardY = new double[512];
	
	public static void getInput(){
		int n = 0;
		Scanner scan = new Scanner(System.in);
		
		while (n < vertices){
			inputX[n] = scan.nextDouble();
			inputY[n] = scan.nextDouble();
			n++;
		}
	}
	
	public static void getGuard(){
		int n = 0;
		Scanner scan = new Scanner(System.in);
		
		while (n < guardNumber){
			guardX[n] = scan.nextDouble();
			guardY[n] = scan.nextDouble();
			n++;
		}
		
	}
	
	//Multiply coordinates to make polygon visible
	public static void multiplyCoordinates(){
		for (int n = 1; n <= vertices; n++){
			x[n-1] = inputX[n-1] * multiplier;
			y[n-1] = inputY[n-1] * multiplier;
			System.out.println(n-1 + " (" + inputX[n-1] + ", " + inputY[n-1] + ")");
		}
		for (int n = 1; n <= guardNumber; n++){
			newGuardX[n-1] = guardX[n-1] * multiplier;
			newGuardY[n-1] = guardY[n-1] * multiplier;
			//System.out.println(n-1 + " (" + newGuardX[n-1] + ", " + newGuardY[n-1] + ")");
		}
	}
	
	
	//print polygon and point
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g.translate(500, 500);
		
		
		for (int n = 1; n < vertices; n++){
			g2.draw(new Line2D.Double(x[n-1], y[n-1], x[n], y[n]));
			Ellipse2D.Double l = new Ellipse2D.Double(x[n-1]-4, y[n-1]-4, 8, 8);
			g2.setColor(Color.black);
	        g2.fill(l);
		}
		
		//g2.draw(new Line2D.Double(x[0], y[0], x[vertices-1], y[vertices-1]));
		Ellipse2D.Double p = new Ellipse2D.Double(x[vertices-1]-4, y[vertices-1]-4, 10, 10);
        g2.setColor(Color.blue);
        g2.fill(p);
        
        for (int n = 1; n <= guardNumber; n++){
        	Ellipse2D.Double k = new Ellipse2D.Double(newGuardX[n-1]-6, newGuardY[n-1]-6, 12, 12);
            g2.setColor(Color.yellow);
            g2.fill(k);
        }
        
        
		
		/*g2.draw(new Line2D.Double(x[0], y[0], x[vertices-1], y[vertices-1]));
		g2.setColor(Color.BLACK);
		g2.draw(new Ellipse2D.Double(x[vertices-1]-10, y[vertices-1]-10, 20, 20));*/
		
		
		//g2.draw(new Ellipse2D.Double(x[0]-5, y[0]-5, 10, 10));
		
		//drawline
		//g2.draw(new Line2D.Double(32.888543819998315555, -1.3944271909999166555, 2.841640786499873555, -2.28885438155559998324));
		
		/*super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.translate(200, 200);
		
		g.setColor(Color.BLACK);
		g.drawPolygon(x, y, 3);*/
		
	}

}
