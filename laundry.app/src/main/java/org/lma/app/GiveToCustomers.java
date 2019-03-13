package org.lma.app;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GiveToCustomers extends JDialog {

	private JPanel contentPanel;
	public ImageIcon img = new ImageIcon("./icon app.png");

	public static void main(String[] args) {
		JDialog modal = new JDialog();
		new GiveToCustomers(modal);
	}

	public void createFrame(final JDialog frame) {
		frame.setTitle("Phiếu trả hàng cho khách");
		frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		frame.setContentPane(this.contentPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setBounds(350, 200, 500, 380);
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
