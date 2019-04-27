package org.lma.app;

import java.awt.*;
import javax.swing.*;

import org.json.JSONObject;
import org.lma.helpers.Links;
import org.lma.helpers.PointLayout;
import org.lma.helpers.Storage;
import org.lma.online.API;

import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PrintForm extends JDialog {

	private JPanel contentPanel;
	private JLabel code1;
	private JLabel timestamp1;
	private JLabel name1;
	private JLabel dvc1;
	private JLabel purchase1;
	private JLabel dvp1;
	private JLabel dvk1;
	private JLabel purchase2;
	private JLabel dvk2;
	private JLabel dvp2;
	private JLabel dvc2;
	private JLabel name2;
	private JLabel timestamp2;
	private JLabel code2;
	private JButton addToDB;
	
	private int frameWidth = 600;
	private int frameHeight = 700;
	private int x;
	private int y;
	private JLabel dvk2F;
	private JLabel purchase2F;
	
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
	
	public void createTextpaneAndTextfield(final JDialog frame) {
		contentPanel = new JPanel();
		
		final JPanel printPanel = new JPanel();
		printPanel.setBounds(10, 11, 564, 601);
		printPanel.setLayout(null);
		contentPanel.add(printPanel);
		
		code1 = new JLabel("Mã số hóa đơn");
		code1.setBounds(31, 11, 85, 31);
		printPanel.add(code1);
		
		timestamp1 = new JLabel("Thời gian lập hóa đơn");
		timestamp1.setBounds(31, 39, 132, 31);
		printPanel.add(timestamp1);
		
		name1 = new JLabel("Tên Khách Hàng");
		name1.setBounds(31, 70, 115, 31);
		printPanel.add(name1);
		
		dvc1 = new JLabel("Dịch vụ giặt chính");
		dvc1.setBounds(31, 112, 103, 31);
		printPanel.add(dvc1);
		
		purchase1 = new JLabel("Thanh toán");
		purchase1.setBounds(31, 238, 103, 31);
		printPanel.add(purchase1);
		
		dvp1 = new JLabel("Dịch vụ giặt phụ");
		dvp1.setBounds(31, 154, 103, 31);
		printPanel.add(dvp1);
		
		dvk1 = new JLabel("Dịch vụ giặt khác");
		dvk1.setBounds(31, 196, 103, 31);
		printPanel.add(dvk1);
		
		purchase2 = new JLabel("Thanh toán");
		purchase2.setBounds(31, 548, 103, 31);
		printPanel.add(purchase2);
		
		dvk2 = new JLabel("Dịch vụ giặt khác");
		dvk2.setBounds(31, 506, 103, 31);
		printPanel.add(dvk2);
		
		dvp2 = new JLabel("Dịch vụ giặt phụ");
		dvp2.setBounds(31, 460, 103, 31);
		printPanel.add(dvp2);
		
		dvc2 = new JLabel("Dịch vụ giặt chính");
		dvc2.setBounds(31, 418, 103, 31);
		printPanel.add(dvc2);
		
		name2 = new JLabel("Tên Khách Hàng");
		name2.setBounds(31, 380, 115, 31);
		printPanel.add(name2);
		
		timestamp2 = new JLabel("Thời gian lập hóa đơn");
		timestamp2.setBounds(31, 351, 132, 31);
		printPanel.add(timestamp2);
		
		code2 = new JLabel("Mã số hóa đơn");
		code2.setBounds(31, 321, 85, 31);
		printPanel.add(code2);
		
		JLabel code1F = new JLabel(Storage.newBill.getBillID());
		code1F.setBounds(233, 11, 277, 23);
		printPanel.add(code1F);
		
		JLabel timestamp1F = new JLabel(Storage.newBill.getTimeCreated());
		timestamp1F.setBounds(233, 39, 277, 23);
		printPanel.add(timestamp1F);
		
		JLabel name1F = new JLabel(Storage.newBill.getName());
		name1F.setBounds(233, 70, 277, 23);
		printPanel.add(name1F);
		
		JLabel dvc1F = new JLabel(Storage.newBill.getDry() + "kg sấy, " + Storage.newBill.getWet() + "kg ướt");
		dvc1F.setBounds(233, 120, 277, 23);
		printPanel.add(dvc1F);
		
		int jB = Storage.newBill.getJacketBig(), jM = Storage.newBill.getJacketMedium(), jS = Storage.newBill.getJacketSmall(),
				bB = Storage.newBill.getBlanketBig(), bM = Storage.newBill.getBlanketMedium(), bS = Storage.newBill.getBlanketSmall();
		
		
		JLabel dvp1F = new JLabel((jB == 0 ? "" : jB + "kg áo khoác to, ") + (jM == 0 ? "" : jM + "kg áo khoác vừa, ") + (jS == 0 ? "" : jS + "kg áo khoác nhỏ, ")
				+ (bB == 0 ? "" : bB + "kg chăn to, ") + (bM == 0 ? "" : bM + "kg chăn vừa, ") + (bS == 0 ? "" : bS + "kg chăn nhỏ, "));
		dvp1F.setBounds(233, 162, 277, 23);
		printPanel.add(dvp1F);
		
		JLabel dvk1F = new JLabel(Storage.newBill.getOthersName());
		dvk1F.setBounds(233, 204, 277, 23);
		printPanel.add(dvk1F);
		
		JLabel purchase1F = new JLabel(Storage.newBill.getMoney() + " đồng, " + (Storage.newBill.isPurchased() == true ? "trả trước" : "trả sau"));
		purchase1F.setBounds(233, 246, 277, 23);
		printPanel.add(purchase1F);
		
		JLabel code2F = new JLabel(Storage.newBill.getBillID());
		code2F.setBounds(233, 321, 277, 23);
		printPanel.add(code2F);
		
		JLabel timestamp2F = new JLabel(Storage.newBill.getTimeCreated());
		timestamp2F.setBounds(233, 351, 277, 23);
		printPanel.add(timestamp2F);
		
		JLabel name2F = new JLabel(Storage.newBill.getName());
		name2F.setBounds(233, 388, 277, 23);
		printPanel.add(name2F);
		
		JLabel dvc2F = new JLabel(Storage.newBill.getDry() + "kg sấy, " + Storage.newBill.getWet() + "kg ướt");
		dvc2F.setBounds(233, 426, 277, 23);
		printPanel.add(dvc2F);
		
		JLabel dvp2F = new JLabel((jB == 0 ? "" : jB + "kg áo khoác to, ") + (jM == 0 ? "" : jM + "kg áo khoác vừa, ") + (jS == 0 ? "" : jS + "kg áo khoác nhỏ, ")
				+ (bB == 0 ? "" : bB + "kg chăn to, ") + (bM == 0 ? "" : bM + "kg chăn vừa, ") + (bS == 0 ? "" : bS + "kg chăn nhỏ, "));
		dvp2F.setBounds(233, 468, 277, 23);
		printPanel.add(dvp2F);
		
		dvk2F = new JLabel(Storage.newBill.getOthersName());
		dvk2F.setBounds(233, 514, 277, 23);
		printPanel.add(dvk2F);
		
		purchase2F = new JLabel(Storage.newBill.getMoney() + " đồng, " + (Storage.newBill.isPurchased() == true ? "trả trước" : "trả sau"));
		purchase2F.setBounds(233, 556, 277, 23);
		printPanel.add(purchase2F);
		
		addToDB = new JButton("Thêm vào CSDL");
		addToDB.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(
			            null,
			            "Bạn có muốn in hoá đơn không?",
			            "",
			            JOptionPane.YES_NO_OPTION);

			        if(choice == 0){
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
			        } else {
			        	
			        }
			        
			        //Add to Database 
			        JSONObject response = null;
					Boolean success = null;
					
					try {
						response = API.insertBillAPI(Storage.newBill);
						success = (Boolean) response.get("success");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Không kết nối được tới máy chủ!");
					} 
					
					if (!success) {
						JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Đã thêm vào Cơ sở Dữ liệu!");
					}
								
				
				Storage.billCounter++;
				frame.dispose();
				
			}
		});
		addToDB.setFont(new Font("Tahoma", Font.BOLD, 16));
		addToDB.setBounds(336, 617, 238, 33);
		contentPanel.add(addToDB);
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
		createTextpaneAndTextfield(modal);
		createFrame(modal);
	}
}
