package omg.lma.helpers;

import java.awt.*;

public class PointLayout {
	
	public static int startXPoints(int frameWidth, int frameHeight) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int tempX = (int) (screen.getWidth()/2);
		
		return (tempX - (int) (frameWidth/2));
	}
	
	public static int startYPoints(int frameWidth, int frameHeight) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int tempY = (int) (screen.getHeight()/2);
		
		int taskbarheight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() 
			    - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
		
		return (tempY - (int) ((frameHeight + taskbarheight)/2));
	}

}
