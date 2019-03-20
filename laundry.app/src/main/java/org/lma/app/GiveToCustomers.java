package org.lma.app;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import omg.lma.helpers.Links;
import omg.lma.helpers.PointLayout;

@SuppressWarnings("serial")
public class GiveToCustomers extends JDialog {

	private JPanel contentPanel;
	private int frameWidth = 500;
	private int frameHeight = 380;
	private int x;
	private int y;

	public static void main(String[] args) {
		JDialog modal = new JDialog();
		new GiveToCustomers(modal);
	}

	public void createFrame(final JDialog frame) {
		frame.setTitle("Phiếu trả hàng cho khách");
		frame.setIconImage(Links.img.getImage());
		this.contentPanel.setLayout(null);
		frame.setContentPane(this.contentPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.x = PointLayout.startXPoints(this.frameWidth, this.frameHeight);
		this.y = PointLayout.startYPoints(this.frameWidth, this.frameHeight);
		
		frame.setBounds(this.x, this.y, this.frameWidth, this.frameHeight);
		frame.setVisible(true);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				frame.dispose();
			}
		});
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		
	}
	
	public GiveToCustomers(JDialog modal) {
		createTextpaneAndTextfield();
		createFrame(modal);
	}

}
