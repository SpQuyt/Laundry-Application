package org.lma.app;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GiveToCustomers extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	public ImageIcon img = new ImageIcon("./icon app.png");

	public static void main(String[] args) {
		new GiveToCustomers();
	}

	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Phiếu trả hàng cho khách");
		this.frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.frame.setBounds(350, 200, 500, 380);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				frame.dispose();
			}
		});
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		
	}
	
	public GiveToCustomers() {
		createTextpaneAndTextfield();
		createFrame();
	}

}
