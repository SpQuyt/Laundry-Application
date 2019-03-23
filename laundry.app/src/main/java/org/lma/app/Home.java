package org.lma.app;

import java.awt.*;

import org.lma.model.*;
import org.quinto.swing.table.view.JBroTable;

import omg.lma.helpers.Links;
import omg.lma.helpers.PointLayout;
import omg.lma.helpers.Storage;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JBroTable table;
	private JTabbedPane areaTab;
	static boolean closed = true;
	private int frameWidth = 1300;
	private int frameHeight = 700;
	private int x;
	private int y;
	
	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Quick Laundry Management");
		this.frame.setIconImage(Links.img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		JLabel fullName = new JLabel();
		fullName.setHorizontalAlignment(SwingConstants.RIGHT);
		fullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fullName.setText(Storage.newUserLogin.getFullname());
		fullName.setBounds(967, 26, 274, 35);
		contentPanel.add(fullName);
		
		this.x = PointLayout.startXPoints(this.frameWidth, this.frameHeight);
		this.y = PointLayout.startYPoints(this.frameWidth, this.frameHeight);
		
		this.frame.setBounds(this.x, this.y, this.frameWidth, this.frameHeight);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Bạn có muốn đóng phần mềm này?", "Quick Laundry Management",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ GIẶT LÀ");
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setBounds(504, 11, 362, 61);
		contentPanel.add(title);
	}
	
	public void createAreaTab() {
		areaTab = new JTabbedPane(JTabbedPane.TOP);
		areaTab.setBounds(41, 81, 1200, 544);
		contentPanel.add(areaTab);
	}

	public void createOpenTab() {
		final JPanel openPanel = new JPanel();
		openPanel.setLayout(null);
		areaTab.addTab("CỬA HÀNG", null, openPanel, null);
		
		if (Home.closed) {
			JButton openButton = new JButton("MỞ");
			openButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					Home.closed = !Home.closed;
					areaTab.removeAll();
					createOpenTab();
					createDiaryTab();
				}
			});
			openButton.setFont(new Font("Times New Roman", Font.BOLD, 75));
			openButton.setBounds(448, 183, 322, 102);
			openPanel.add(openButton);
		}
		else {
			JButton takeFromCustomer = new JButton("Nhận hàng");
			takeFromCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			takeFromCustomer.setBounds(860, 60, 268, 76);
			takeFromCustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JDialog modalTake = new JDialog(new JFrame(), true);
					new TakeFromCustomers(modalTake);
				}
			});
			openPanel.add(takeFromCustomer);
			
			JButton sendBackToCustomer = new JButton("Trả hàng");
			sendBackToCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			sendBackToCustomer.setBounds(860, 196, 268, 76);
			sendBackToCustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JDialog modalGive = new JDialog(new JFrame(), true);
					new GiveToCustomers(modalGive);
				}
			});
			openPanel.add(sendBackToCustomer);
			
			JButton closeButton = new JButton("ĐÓNG CỬA HÀNG");
			closeButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
			closeButton.setBounds(860, 360, 268, 115);
			closeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Home.closed = !Home.closed;
					areaTab.removeAll();
					createOpenTab();
					createDiaryTab();
				}
			});
			openPanel.add(closeButton);
			
			JLabel moneyLabel = new JLabel("SỐ TIỀN HIỆN TẠI CỦA VÍ");
			moneyLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
			moneyLabel.setBounds(54, 163, 229, 76);
			openPanel.add(moneyLabel);
			
			JLabel money = new JLabel("");
			money.setFont(new Font("Times New Roman", Font.BOLD, 17));
			money.setBounds(309, 163, 229, 76);
			openPanel.add(money);	
		}
		
	}
	
	public void createDiaryTab() {
		JPanel diaryPanel = new JPanel();
		diaryPanel.setLayout(null);
		areaTab.addTab("NHẬT KÝ HOÁ ĐƠN", null, diaryPanel, null);

		this.table = DiaryTable.initTable();
//		DiaryTable newTable = new DiaryTable(this.table);

		JScrollPane jps = new JScrollPane(this.table);
		jps.setBounds(48, 50, 1099, 458);
		diaryPanel.add(jps);
	}

	public Home() {
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
		createAreaTab();
		createOpenTab();
		createDiaryTab();
		createFrame();
	}
}
