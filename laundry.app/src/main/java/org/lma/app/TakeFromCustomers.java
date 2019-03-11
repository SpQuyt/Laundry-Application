package org.lma.app;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class TakeFromCustomers extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	public ImageIcon img = new ImageIcon("./icon app.png");
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		new TakeFromCustomers();
	}

	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Phiếu nhận hàng từ khách");
		this.frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.frame.setBounds(350, 200, 675, 496);
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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(49, 139, 534, 267);
		contentPanel.add(tabbedPane);
		
		JPanel dvChinh = new JPanel();
		dvChinh.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT CHÍNH", null, dvChinh, null);
		
		JLabel tenKH = new JLabel("Tên Khách Hàng");
		tenKH.setBounds(32, 11, 166, 65);
		dvChinh.add(tenKH);
		tenKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel khoiLuongGiat = new JLabel("Khối lượng giặt");
		khoiLuongGiat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		khoiLuongGiat.setBounds(32, 112, 166, 65);
		dvChinh.add(khoiLuongGiat);
		
		textField = new JTextField();
		textField.setBounds(247, 25, 216, 51);
		dvChinh.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 176, 216, 20);
		dvChinh.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxCnSau = new JCheckBox("Cân sau");
		chckbxCnSau.setBounds(247, 136, 97, 23);
		dvChinh.add(chckbxCnSau);
		
		JPanel dvPhu = new JPanel();
		dvPhu.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT PHỤ", null, dvPhu, null);
		
		JPanel dvKhac = new JPanel();
		dvKhac.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT KHÁC", null, dvKhac, null);
		
		JPanel thanhToan = new JPanel();
		thanhToan.setLayout(null);
		tabbedPane.addTab("THANH TOÁN TIỀN", null, thanhToan, null);
		
	}
	
	public TakeFromCustomers() {
		createTextpaneAndTextfield();
		createFrame();
	}
}
