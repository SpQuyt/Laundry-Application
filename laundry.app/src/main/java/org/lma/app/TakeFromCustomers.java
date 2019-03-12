package org.lma.app;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TakeFromCustomers extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JPanel dvChinh;
	private JPanel dvPhu;
	private JPanel dvKhac;
	private JPanel thanhToan;
	public ImageIcon img = new ImageIcon("./icon app.png");
	private JTextField nameField;
	private JTextField weightField;

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
		tabbedPane.setBounds(49, 139, 500, 267);
		contentPanel.add(tabbedPane);
		
		createDichVuChinh(tabbedPane);
		createDichVuPhu(tabbedPane);
		createDichVuKhac(tabbedPane);
		createThanhToan(tabbedPane);		
	}
	
	public void createDichVuChinh(JTabbedPane tabbedPane) {
		ButtonGroup group = new ButtonGroup();
		
		dvChinh = new JPanel();
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
		
		nameField = new JTextField();
		nameField.setBounds(196, 21, 216, 51);
		dvChinh.add(nameField);
		nameField.setColumns(10);
		
		weightField = new JTextField();
		weightField.setBounds(286, 137, 126, 20);
		dvChinh.add(weightField);
		weightField.setColumns(10);
		
		JRadioButton weightAfter = new JRadioButton("Cân sau");
		weightAfter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weightField.setEnabled(false);
			}
		});
		weightAfter.setBounds(196, 177, 84, 23);
		dvChinh.add(weightAfter);
		
		JRadioButton weightFirst = new JRadioButton("Cân trước");
		weightFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightField.setEnabled(true);
			}
		});
		weightFirst.setBounds(196, 137, 84, 23);
		dvChinh.add(weightFirst);
	}
	
	public void createDichVuPhu(JTabbedPane tabbedPane) {
		dvPhu = new JPanel();
		dvPhu.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT PHỤ", null, dvPhu, null);
	}
	
	public void createDichVuKhac(JTabbedPane tabbedPane) {
		dvKhac = new JPanel();
		dvKhac.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT KHÁC", null, dvKhac, null);
	}
	
	public void createThanhToan(JTabbedPane tabbedPane) {
		thanhToan = new JPanel();
		thanhToan.setLayout(null);
		tabbedPane.addTab("THANH TOÁN TIỀN", null, thanhToan, null);
	}
	
	public TakeFromCustomers() {
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createTextpaneAndTextfield();
		createFrame();
	}
}
