package org.lma.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import org.json.JSONObject;
import org.lma.helpers.Links;
import org.lma.helpers.MyIntFilter;
import org.lma.helpers.PointLayout;
import org.lma.helpers.Storage;
import org.lma.model.*;
import org.lma.online.API;

import org.lma.helpers.*;

@SuppressWarnings("serial")
public class TakeFromCustomers extends JDialog {

	private JPanel contentPanel, dvChinh, dvPhu, dvKhac, thanhToan;
	private JRadioButton weightFirst1, weightFirst2, weightAfter1, weightAfter2;
	private JCheckBox check1, check2;
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
	private JTextField tenDVField;
	private JLabel soTien;
	private JTextField soTienField;
	private JLabel numberTotal;
	
	private int frameWidth = 675;
	private int frameHeight = 496;
	private int x;
	private int y;
	
	public void createFrame(final JDialog frame) {
		frame.setTitle("Quick Laundry Management");
		frame.setIconImage(Links.img.getImage());
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
		frame.setResizable(false);
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
		check1 = new JCheckBox(" Khối lượng giặt sấy");
		check1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		check1.setBounds(17, 51, 213, 35);
		dvChinh.add(check1);
		
		weightField1 = new JTextField();
		weightField1.setBounds(320, 37, 126, 20);
		dvChinh.add(weightField1);
		weightField1.setColumns(10);
		((PlainDocument) weightField1.getDocument()).setDocumentFilter(new MyIntFilter());
		
		weightAfter1 = new JRadioButton("Cân sau");
		weightAfter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weightField1.setEnabled(false);
			}
		});
		weightAfter1.setBounds(230, 77, 84, 23);
		dvChinh.add(weightAfter1);
		
		weightFirst1 = new JRadioButton("Cân trước");
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
		check2 = new JCheckBox(" Khối lượng giặt ướt");
		check2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		check2.setBounds(15, 155, 213, 35);
		dvChinh.add(check2);
		
		weightFirst2 = new JRadioButton("Cân trước");
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
		((PlainDocument) weightField2.getDocument()).setDocumentFilter(new MyIntFilter());
		
		weightAfter2 = new JRadioButton("Cân sau");
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
		((PlainDocument) to1Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
		vua1Field = new JTextField();
		vua1Field.setColumns(10);
		vua1Field.setBounds(309, 37, 126, 20);
		dvPhu.add(vua1Field);
		((PlainDocument) vua1Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
		nho1Field = new JTextField();
		nho1Field.setColumns(10);
		nho1Field.setBounds(309, 63, 126, 20);
		dvPhu.add(nho1Field);
		((PlainDocument) nho1Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
		chan = new JCheckBox(" Giặt chăn");
		chan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		chan.setBounds(24, 144, 126, 35);
		dvPhu.add(chan);
		
		to2Field = new JTextField();
		to2Field.setColumns(10);
		to2Field.setBounds(309, 128, 126, 20);
		dvPhu.add(to2Field);
		((PlainDocument) to2Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
		vua2Field = new JTextField();
		vua2Field.setColumns(10);
		vua2Field.setBounds(309, 154, 126, 20);
		dvPhu.add(vua2Field);
		((PlainDocument) vua2Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
		nho2Field = new JTextField();
		nho2Field.setColumns(10);
		nho2Field.setBounds(309, 180, 126, 20);
		dvPhu.add(nho2Field);
		((PlainDocument) nho2Field.getDocument()).setDocumentFilter(new MyIntFilter());
		
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
		
		tenDVField = new JTextField();
		tenDVField.setColumns(10);
		tenDVField.setBounds(205, 24, 224, 54);
		dvKhac.add(tenDVField);
		
		soTien = new JLabel("Số tiền");
		soTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		soTien.setBounds(56, 168, 126, 20);
		dvKhac.add(soTien);
		
		soTienField = new JTextField();
		soTienField.setColumns(10);
		soTienField.setBounds(205, 170, 126, 20);
		dvKhac.add(soTienField);
		((PlainDocument) soTienField.getDocument()).setDocumentFilter(new MyIntFilter());
	}
	
	public void createThanhToan(JTabbedPane tabbedPane) {
		thanhToan = new JPanel();
		thanhToan.setLayout(null);
		tabbedPane.addTab("THANH TOÁN TIỀN", null, thanhToan, null);
		
		numberTotal = new JLabel("");
		numberTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		numberTotal.setBounds(27, 87, 260, 43);
		numberTotal.setText(0 + " đồng");
		thanhToan.add(numberTotal);
		
		JButton totalAmount = new JButton("TỔNG SỐ TIỀN THANH TOÁN");
		totalAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberTotal.setText(calculateTotal() + " đồng");
			}
		});
		totalAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalAmount.setBounds(24, 29, 260, 43);
		thanhToan.add(totalAmount);
		
		JButton confirmButton = new JButton("Xem hoá đơn");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillModel newBill = new BillModel(nameField, weightField1, weightField2, 
						to1Field, vua1Field, nho1Field, to2Field, vua2Field, nho2Field,
						tenDVField, soTienField, calculateTotal(), check1, check2, 
						weightAfter1, weightAfter2);

				Storage.newBill = newBill;
				JSONObject response = null;
				Boolean success = null;
				
				
				try {
					response = API.updateBillAPI(newBill);
					success = (Boolean) response.get("success");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Không kết nối được tới máy chủ!");
				} 
				
				if (!success) {
					JOptionPane.showMessageDialog(null, "Không tìm được tài khoản và mật khẩu người dùng!");
				}
				else {
					
				}
				
				JDialog modalPrint = new JDialog(new JFrame(), true);
				new PrintForm(modalPrint);
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmButton.setBounds(310, 168, 159, 43);
		thanhToan.add(confirmButton);
	}
	
	public long calculateTotal() {
		int dry, wet, jBig, jMedium,jSmall, bBig, bMedium, bSmall, oTotal;
		
		/////////////////////////////////////////////////////////////////////////////Wet and Dry
		if (weightField1.getText() == null || weightField1.getText().compareTo("") == 0) {
			dry = 0;
		}
		else {
			dry = Integer.parseInt(weightField1.getText()) * Storage.newUserLogin.getGiatSayTien();
		}
		
		if (weightField2.getText() == null || weightField2.getText().compareTo("") == 0) {
			wet = 0;
		}
		else {
			wet = Integer.parseInt(weightField2.getText()) * Storage.newUserLogin.getGiatUotTien();
		}
		
		///////////////////////////////////////////////////////////////////////////jacket
		if (to1Field.getText() == null || to1Field.getText().compareTo("") == 0) {
			jBig = 0;
		}
		else {
			jBig = Integer.parseInt(to1Field.getText()) * Storage.newUserLogin.getAoKhoacToTien();
		}
		
		if (vua1Field.getText() == null || vua1Field.getText().compareTo("") == 0) {
			jMedium = 0;
		}
		else {
			jMedium = Integer.parseInt(vua1Field.getText()) * Storage.newUserLogin.getAoKhoacVuaTien();
		}
		
		if (nho1Field.getText() == null || nho1Field.getText().compareTo("") == 0) {
			jSmall = 0;
		}
		else {
			jSmall = Integer.parseInt(nho1Field.getText()) * Storage.newUserLogin.getAoKhoacNhoTien();
		}
		
		//////////////////////////////////////////////////////////////////////////blanket
		if (to2Field.getText() == null || to2Field.getText().compareTo("") == 0) {
			bBig = 0;
		}
		else {
			bBig = Integer.parseInt(to2Field.getText()) * Storage.newUserLogin.getChanToTien();
		}
		
		if (vua2Field.getText() == null || vua2Field.getText().compareTo("") == 0) {
			bMedium = 0;
		}
		else {
			bMedium = Integer.parseInt(vua2Field.getText()) * Storage.newUserLogin.getChanVuaTien();
		}
		
		if (nho2Field.getText() == null || nho2Field.getText().compareTo("") == 0) {
			bSmall = 0;
		}
		else {
			bSmall = Integer.parseInt(nho2Field.getText()) * Storage.newUserLogin.getChanNhoTien();
		}
		
		////////////////////////////////////////////////////////////////others
		
		if (soTienField.getText() == null || soTienField.getText().compareTo("") == 0) {
			oTotal = 0;
		}
		else {
			oTotal = Integer.parseInt(soTienField.getText());
		}
		
		return wet + dry + jBig + jMedium + jSmall + bBig + bMedium + bSmall + oTotal;
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
