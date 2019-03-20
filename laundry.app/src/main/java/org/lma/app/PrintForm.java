package org.lma.app;

import java.awt.*;
import javax.swing.*;

import omg.lma.helpers.Links;
import omg.lma.helpers.PointLayout;

import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PrintForm extends JDialog {

	private JPanel contentPanel;
	private JLabel lblMSHa;
	private JLabel lblThiGianLp;
	private JLabel lblTnKhchHng;
	private JLabel lblDchVGit;
	private JLabel lblThanhTon;
	private JLabel lblDchVGit_1;
	private JLabel lblDchVGit_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JButton btnInHan;
	
	private int frameWidth = 600;
	private int frameHeight = 700;
	private int x;
	private int y;
	
	public void createFrame(final JDialog frame) {
		frame.setTitle("Quick Laundry Management");
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
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		
		final JPanel printPanel = new JPanel();
		printPanel.setBounds(10, 11, 564, 601);
		printPanel.setLayout(null);
		contentPanel.add(printPanel);
		
		lblMSHa = new JLabel("Mã số hóa đơn");
		lblMSHa.setBounds(31, 11, 85, 31);
		printPanel.add(lblMSHa);
		
		lblThiGianLp = new JLabel("Thời gian lập hóa đơn");
		lblThiGianLp.setBounds(31, 39, 132, 31);
		printPanel.add(lblThiGianLp);
		
		lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setBounds(31, 70, 115, 31);
		printPanel.add(lblTnKhchHng);
		
		lblDchVGit = new JLabel("Dịch vụ giặt chính");
		lblDchVGit.setBounds(31, 112, 103, 31);
		printPanel.add(lblDchVGit);
		
		lblThanhTon = new JLabel("Thanh toán");
		lblThanhTon.setBounds(31, 238, 103, 31);
		printPanel.add(lblThanhTon);
		
		lblDchVGit_1 = new JLabel("Dịch vụ giặt phụ");
		lblDchVGit_1.setBounds(31, 154, 103, 31);
		printPanel.add(lblDchVGit_1);
		
		lblDchVGit_2 = new JLabel("Dịch vụ giặt khác");
		lblDchVGit_2.setBounds(31, 196, 103, 31);
		printPanel.add(lblDchVGit_2);
		
		label = new JLabel("Thanh toán");
		label.setBounds(31, 548, 103, 31);
		printPanel.add(label);
		
		label_1 = new JLabel("Dịch vụ giặt khác");
		label_1.setBounds(31, 506, 103, 31);
		printPanel.add(label_1);
		
		label_2 = new JLabel("Dịch vụ giặt phụ");
		label_2.setBounds(31, 460, 103, 31);
		printPanel.add(label_2);
		
		label_3 = new JLabel("Dịch vụ giặt chính");
		label_3.setBounds(31, 418, 103, 31);
		printPanel.add(label_3);
		
		label_4 = new JLabel("Tên Khách Hàng");
		label_4.setBounds(31, 380, 115, 31);
		printPanel.add(label_4);
		
		label_5 = new JLabel("Thời gian lập hóa đơn");
		label_5.setBounds(31, 351, 132, 31);
		printPanel.add(label_5);
		
		label_6 = new JLabel("Mã số hóa đơn");
		label_6.setBounds(31, 321, 85, 31);
		printPanel.add(label_6);
		
		btnInHan = new JButton("In hóa đơn");
		btnInHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("IN_HOA_DON");
				job.setPrintable(new Printable() {

					public int print(Graphics pg, PageFormat pf, int pageNum) throws PrinterException {
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}
						// get the bounds of the component
					    Dimension dim = printPanel.getSize();
					    double cHeight = dim.getHeight();
					    double cWidth = dim.getWidth();

					    // get the bounds of the printable area
					    double pHeight = pf.getImageableHeight();
					    double pWidth = pf.getImageableWidth();

					    double pXStart = pf.getImageableX();
					    double pYStart = pf.getImageableY();

					    double xRatio = pWidth / cWidth;
					    double yRatio = pHeight / cHeight;
						
						Graphics2D g2 = (Graphics2D)pg;
						g2.translate(pXStart, pYStart);
					    g2.scale(xRatio, yRatio);
						printPanel.paint(g2);
						
						return Printable.PAGE_EXISTS;
					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {
						job.print();
					}
					catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnInHan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInHan.setBounds(435, 617, 139, 33);
		contentPanel.add(btnInHan);
	}
	
	public PrintForm(JDialog modal) {
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
