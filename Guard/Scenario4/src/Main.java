import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		
		PrintPolygon.getInput();
		PrintPolygon.getGuard();
		PrintPolygon.multiplyCoordinates();
		//PrintPolygon.updateInput();
		//Create a frame to plot graph
		JFrame frame = new JFrame("DLLM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrintPolygon p = new PrintPolygon();
		frame.add(p);
		frame.setSize(1200, 900);
		frame.setVisible(true);
	}
}
