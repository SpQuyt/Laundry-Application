package org.lma.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TakeFromCustomers extends JDialog {

	private JPanel contentPanel;
	private JPanel dvChinh;
	private JPanel dvPhu;
	private JPanel dvKhac;
	private JPanel thanhToan;
	public ImageIcon img = new ImageIcon("./icon app.png");
	private JTextField nameField;
	private JTextField weightField1;
	private JTextField weightField2;
	private JCheckBox khoAoKhoac;
	private JTextField to1Field;
	private JTextField vua1Field;
	private JTextField nho1Field;
	private JCheckBox chan;
	private JTextField to2Field;
	private JTextField vua2Field;
	private JTextField nho2Field;
	private JLabel to1;
	private JLabel vua1;
	private JLabel nho1;
	private JLabel to2;
	private JLabel vua2;
	private JLabel nho2;
	private JLabel tenDV;
	private JTextField textField;
	private JLabel soTien;
	private JTextField textField_1;
	private JRadioButton traTruoc;
	private JRadioButton traSau;
	private JLabel totalAmount;
	private JLabel numberTotal;
	private int numberTotalAmount = 0;
	private JButton printButton;

	public static void main(String[] args) {
//		JDialog modal = new JDialog();
//		new TakeFromCustomers(modal);
	}

	public void createFrame(final JDialog frame) {
		frame.setTitle("Phiếu nhận hàng từ khách");
		frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		frame.setContentPane(this.contentPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tenKH = new JLabel("Tên Khách Hàng");
		tenKH.setBounds(49, 48, 155, 42);
		contentPanel.add(tenKH);
		tenKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		nameField = new JTextField();
		nameField.setBounds(214, 54, 335, 37);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		frame.setBounds(300, 150, 675, 496);
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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(49, 139, 500, 267);
		contentPanel.add(tabbedPane);
		
		createDichVuChinh(tabbedPane);
		createDichVuPhu(tabbedPane);
		createDichVuKhac(tabbedPane);
		createThanhToan(tabbedPane);		
	}
	
	public void createDichVuChinh(JTabbedPane tabbedPane) {
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();

		dvChinh = new JPanel();
		dvChinh.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT CHÍNH", null, dvChinh, null);
		
		///////////////////////////////////////////////////////////////////////GROUP BUTTON 1
		final JCheckBox check1 = new JCheckBox(" Khối lượng giặt sấy");
		check1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		check1.setBounds(17, 51, 213, 35);
		dvChinh.add(check1);
		
		weightField1 = new JTextField();
		weightField1.setBounds(320, 37, 126, 20);
		dvChinh.add(weightField1);
		weightField1.setColumns(10);
		
		final JRadioButton weightAfter1 = new JRadioButton("Cân sau");
		weightAfter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weightField1.setEnabled(false);
			}
		});
		weightAfter1.setBounds(230, 77, 84, 23);
		dvChinh.add(weightAfter1);
		
		final JRadioButton weightFirst1 = new JRadioButton("Cân trước");
		weightFirst1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightField1.setEnabled(true);
			}
		});
		weightFirst1.setBounds(230, 37, 84, 23);
		dvChinh.add(weightFirst1);
		
		check1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (check1.isSelected()) {
					weightFirst1.setEnabled(true);
					weightAfter1.setEnabled(true);
					weightField1.setEnabled(true);
				}
				else {
					weightFirst1.setEnabled(false);
					weightAfter1.setEnabled(false);
					weightField1.setEnabled(false);
				}
			}
		});
		
		weightFirst1.setSelected(true);
		group1.add(weightFirst1);
		group1.add(weightAfter1);
		
		////////////////////////////////////////////////////////////////////////GROUP BUTTON 2
		final JCheckBox check2 = new JCheckBox(" Khối lượng giặt ướt");
		check2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		check2.setBounds(15, 155, 213, 35);
		dvChinh.add(check2);
		
		final JRadioButton weightFirst2 = new JRadioButton("Cân trước");
		weightFirst2.setBounds(230, 143, 84, 23);
		weightFirst2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightField2.setEnabled(true);
			}
		});
		dvChinh.add(weightFirst2);
		
		weightField2 = new JTextField();
		weightField2.setColumns(10);
		weightField2.setBounds(320, 143, 126, 20);
		dvChinh.add(weightField2);
		
		final JRadioButton weightAfter2 = new JRadioButton("Cân sau");
		weightAfter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightField2.setEnabled(true);
			}
		});
		weightAfter2.setBounds(230, 183, 84, 23);
		dvChinh.add(weightAfter2);
		
		weightFirst2.setSelected(true);
		group2.add(weightFirst2);
		group2.add(weightAfter2);
		
		check2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (check2.isSelected()) {
					weightFirst2.setEnabled(true);
					weightAfter2.setEnabled(true);
					weightField2.setEnabled(true);
				}
				else {
					weightFirst2.setEnabled(false);
					weightAfter2.setEnabled(false);
					weightField2.setEnabled(false);
				}
			}
		});
		
		if (check1.isSelected()) {
			weightFirst1.setEnabled(true);
			weightAfter1.setEnabled(true);
			weightField1.setEnabled(true);
		}
		else if (check2.isSelected()) {
			weightFirst2.setEnabled(true);
			weightAfter2.setEnabled(true);
			weightField2.setEnabled(true);
		}
		else if (check1.isSelected() && check2.isSelected()){
			weightFirst1.setEnabled(true);
			weightAfter1.setEnabled(true);
			weightField1.setEnabled(true);
			weightFirst2.setEnabled(true);
			weightAfter2.setEnabled(true);
			weightField2.setEnabled(true);
		}
		else {
			weightFirst1.setEnabled(false);
			weightAfter1.setEnabled(false);
			weightField1.setEnabled(false);
			weightFirst2.setEnabled(false);
			weightAfter2.setEnabled(false);
			weightField2.setEnabled(false);
		}
	}
	
	public void createDichVuPhu(JTabbedPane tabbedPane) {
		dvPhu = new JPanel();
		dvPhu.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT PHỤ", null, dvPhu, null);
		
		khoAoKhoac = new JCheckBox(" Giặt khô áo khoác");
		khoAoKhoac.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		khoAoKhoac.setBounds(24, 27, 193, 35);
		dvPhu.add(khoAoKhoac);
		
		to1Field = new JTextField();
		to1Field.setColumns(10);
		to1Field.setBounds(309, 11, 126, 20);
		dvPhu.add(to1Field);
		
		vua1Field = new JTextField();
		vua1Field.setColumns(10);
		vua1Field.setBounds(309, 37, 126, 20);
		dvPhu.add(vua1Field);
		
		nho1Field = new JTextField();
		nho1Field.setColumns(10);
		nho1Field.setBounds(309, 63, 126, 20);
		dvPhu.add(nho1Field);
		
		chan = new JCheckBox(" Giặt chăn");
		chan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		chan.setBounds(24, 144, 126, 35);
		dvPhu.add(chan);
		
		to2Field = new JTextField();
		to2Field.setColumns(10);
		to2Field.setBounds(309, 128, 126, 20);
		dvPhu.add(to2Field);
		
		vua2Field = new JTextField();
		vua2Field.setColumns(10);
		vua2Field.setBounds(309, 154, 126, 20);
		dvPhu.add(vua2Field);
		
		nho2Field = new JTextField();
		nho2Field.setColumns(10);
		nho2Field.setBounds(309, 180, 126, 20);
		dvPhu.add(nho2Field);
		
		to1 = new JLabel("To");
		to1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		to1.setBounds(239, 11, 30, 17);
		dvPhu.add(to1);
		
		vua1 = new JLabel("Vừa");
		vua1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		vua1.setBounds(239, 38, 30, 17);
		dvPhu.add(vua1);
		
		nho1 = new JLabel("Nhỏ");
		nho1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nho1.setBounds(239, 66, 30, 17);
		dvPhu.add(nho1);
		
		to2 = new JLabel("To");
		to2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		to2.setBounds(239, 128, 30, 17);
		dvPhu.add(to2);
		
		vua2 = new JLabel("Vừa");
		vua2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		vua2.setBounds(239, 155, 30, 17);
		dvPhu.add(vua2);
		
		nho2 = new JLabel("Nhỏ");
		nho2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nho2.setBounds(239, 180, 30, 17);
		dvPhu.add(nho2);
		
		khoAoKhoac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (khoAoKhoac.isSelected()) {
					to1.setEnabled(true); to1Field.setEnabled(true);
					nho1.setEnabled(true); nho1Field.setEnabled(true);
					vua1.setEnabled(true); vua1Field.setEnabled(true);
				}
				else {
					to1.setEnabled(false); to1Field.setEnabled(false);
					nho1.setEnabled(false); nho1Field.setEnabled(false);
					vua1.setEnabled(false); vua1Field.setEnabled(false);
				}
			}
		});
		
		chan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chan.isSelected()) {
					to2.setEnabled(true); to2Field.setEnabled(true);
					nho2.setEnabled(true); nho2Field.setEnabled(true);
					vua2.setEnabled(true); vua2Field.setEnabled(true);
				}
				else {
					to2.setEnabled(false); to2Field.setEnabled(false);
					nho2.setEnabled(false); nho2Field.setEnabled(false);
					vua2.setEnabled(false); vua2Field.setEnabled(false);
				}
			}
		});
		if (khoAoKhoac.isSelected()) {
			to1.setEnabled(true); to1Field.setEnabled(true);
			nho1.setEnabled(true); nho1Field.setEnabled(true);
			vua1.setEnabled(true); vua1Field.setEnabled(true);
		}
		else if (chan.isSelected()) {
			to2.setEnabled(true); to2Field.setEnabled(true);
			nho2.setEnabled(true); nho2Field.setEnabled(true);
			vua2.setEnabled(true); vua2Field.setEnabled(true);
		}
		else if (khoAoKhoac.isSelected() && chan.isSelected()){
			to1.setEnabled(true); to1Field.setEnabled(true);
			nho1.setEnabled(true); nho1Field.setEnabled(true);
			vua1.setEnabled(true); vua1Field.setEnabled(true);
			to2.setEnabled(true); to2Field.setEnabled(true);
			nho2.setEnabled(true); nho2Field.setEnabled(true);
			vua2.setEnabled(true); vua2Field.setEnabled(true);
		}
		else {
			to1.setEnabled(false); to1Field.setEnabled(false);
			nho1.setEnabled(false); nho1Field.setEnabled(false);
			vua1.setEnabled(false); vua1Field.setEnabled(false);
			to2.setEnabled(false); to2Field.setEnabled(false);
			nho2.setEnabled(false); nho2Field.setEnabled(false);
			vua2.setEnabled(false); vua2Field.setEnabled(false);
		}
	}
	
	public void createDichVuKhac(JTabbedPane tabbedPane) {
		dvKhac = new JPanel();
		dvKhac.setLayout(null);
		tabbedPane.addTab("DỊCH VỤ GIẶT KHÁC", null, dvKhac, null);
		
		tenDV = new JLabel("Tên Dịch Vụ Khác");
		tenDV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tenDV.setBounds(56, 37, 126, 20);
		dvKhac.add(tenDV);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(205, 24, 224, 54);
		dvKhac.add(textField);
		
		soTien = new JLabel("Số tiền");
		soTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		soTien.setBounds(56, 168, 126, 20);
		dvKhac.add(soTien);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 170, 126, 20);
		dvKhac.add(textField_1);
	}
	
	public void createThanhToan(JTabbedPane tabbedPane) {
		thanhToan = new JPanel();
		thanhToan.setLayout(null);
		tabbedPane.addTab("THANH TOÁN TIỀN", null, thanhToan, null);
		
		traTruoc = new JRadioButton("Trả trước");
		traTruoc.setSelected(true);
		traTruoc.setBounds(335, 35, 84, 23);
		thanhToan.add(traTruoc);
		
		traSau = new JRadioButton("Trả sau");
		traSau.setBounds(335, 99, 84, 23);
		thanhToan.add(traSau);
		
		totalAmount = new JLabel("TỔNG SỐ TIỀN THANH TOÁN");
		totalAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalAmount.setBounds(27, 23, 260, 43);
		thanhToan.add(totalAmount);
		
		numberTotal = new JLabel("");
		numberTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		numberTotal.setBounds(27, 87, 260, 43);
		numberTotal.setText(numberTotalAmount + " đồng");
		thanhToan.add(numberTotal);
		
		JButton confirmButton = new JButton("Hoàn thành");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmButton.setBounds(310, 168, 159, 43);
		thanhToan.add(confirmButton);
		
		printButton = new JButton("Xem hóa đơn");
		printButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		printButton.setBounds(128, 168, 159, 43);
		thanhToan.add(printButton);
	}
	
	public TakeFromCustomers(JDialog modal) {
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		createTextpaneAndTextfield();
		createFrame(modal);
	}
}
