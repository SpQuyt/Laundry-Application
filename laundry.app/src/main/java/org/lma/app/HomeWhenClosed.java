package org.lma.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.quinto.swing.table.model.IModelFieldGroup;
import org.quinto.swing.table.model.ModelData;
import org.quinto.swing.table.model.ModelField;
import org.quinto.swing.table.model.ModelFieldGroup;
import org.quinto.swing.table.model.ModelRow;
import org.quinto.swing.table.view.CustomTableHeaderRenderer;
import org.quinto.swing.table.view.JBroTable;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HomeWhenClosed extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JBroTable table;
	private JTabbedPane areaTab;
	public ImageIcon img = new ImageIcon("./icon app.png");

	public static void main(String[] args) throws IOException {
		new HomeWhenClosed();
	}

	public void getData() {
	}

	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ GIẶT LÀ");
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setBounds(504, 11, 362, 61);
		contentPanel.add(title);
	}
	
	public void createTable() {
		String[][] dataTable = {
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
		};
		
		IModelFieldGroup groups[] = new IModelFieldGroup[] { 
				new ModelField("STT", "STT").withDefaultWidth(50),
				new ModelField("MAHD", "Mã HĐ"), 
				new ModelField("TENKH", "Tên KH").withDefaultWidth(150),
				new ModelFieldGroup("DV_GIAT", "Dịch vụ giặt")
						.withChild(new ModelField("SAY", "Sấy").withDefaultWidth(20))
						.withChild(new ModelField("UOT", "Ướt").withDefaultWidth(20))
						.withChild(new ModelFieldGroup("KHO_AO_KHOAC", "Giặt khô áo khoác")
								.withChild(new ModelField("TO1", "To").withDefaultWidth(20))
								.withChild(new ModelField("VUA1", "Vừa").withDefaultWidth(20))
								.withChild(new ModelField("NHO1", "Nhỏ").withDefaultWidth(20)))
						.withChild(new ModelFieldGroup("CHAN", "Giặt chăn")
								.withChild(new ModelField("TO2", "To").withDefaultWidth(20))
								.withChild(new ModelField("VUA2", "Vừa").withDefaultWidth(20))
								.withChild(new ModelField("NHO2", "Nhỏ").withDefaultWidth(20)))
						.withChild(new ModelFieldGroup("DV_KHAC", "Dịch vụ khác")
								.withChild(new ModelField("DV_KHAC_TEN", "Tên dịch vụ"))
								.withChild(new ModelField("DV_KHAC_SOTIEN", "Số tiền"))),
				new ModelField("THANH_TIEN", "Thành tiền"), 
				new ModelField("TRANG_THAI", "Trạng thái"), 
		};
	
		ModelField fields[] = ModelFieldGroup.getBottomFields(groups);
		
		// Sample data.
		ModelRow rows[] = new ModelRow[dataTable.length];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new ModelRow(fields.length);
			for (int j = 0; j < fields.length; j++)
				rows[i].setValue(j, dataTable[i][j]);
		}

		// Table.
		ModelData data = new ModelData(groups);
		data.setRows(rows);
		table = new JBroTable(data);		
		
		table.getTableHeader().getUI().setCustomRenderer(new CustomTableHeaderRenderer() {
			public Component getTableCellRendererComponent( Component originalComponent, JBroTable table, Object value, boolean isSelected, boolean hasFocus, boolean isDragged, int row, int viewColumn, int modelColumn, IModelFieldGroup dataField ) {
				  if ( dataField == null || !( originalComponent instanceof JLabel ) )
				    return originalComponent;
				  JLabel ret = ( JLabel )originalComponent;
				  String fieldName = dataField.getIdentifier();
				  
				  ret.setFont( ret.getFont().deriveFont( "*".equals( fieldName ) ? Font.PLAIN : Font.BOLD ) );
				  ret.setHorizontalAlignment( "*".equals( fieldName ) ? SwingConstants.RIGHT : SwingConstants.CENTER );
				  ret.setBorder("STT".equals( fieldName ) ? BorderFactory.createMatteBorder(1,1,1,0,Color.black) : 
					  			"MAHD".equals(fieldName) ? BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black) : 
					  			"TENKH".equals(fieldName) ? BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black): 
					  			"DV_GIAT".equals(fieldName) ? BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black) :
					  			"SAY".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"UOT".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"KHO_AO_KHOAC".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"TO1".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"VUA1".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"NHO1".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"CHAN".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"TO2".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"VUA2".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"NHO2".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"DV_KHAC".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"DV_KHAC_TEN".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) : 
					  			"DV_KHAC_SOTIEN".equals(fieldName) ? BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black) :
					  			"THANH_TIEN".equals(fieldName) ? BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black) : 
					  			"TRANG_THAI".equals(fieldName) ? BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black) : null );
				  ret.setBackground("*".equals(fieldName) ? null : Color.decode("#c1cedb"));
				  return ret;
			}
		});
	}
	
	public void createAreaTab() {
		areaTab = new JTabbedPane(JTabbedPane.TOP);
		areaTab.setBounds(41, 81, 1200, 544);
		contentPanel.add(areaTab);
	}

	public void createOpenTab() {

		JPanel openPanel = new JPanel();
		openPanel.setLayout(null);
		areaTab.addTab("CỬA HÀNG", null, openPanel, null);

		JButton openButton = new JButton("MỞ");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new HomeWhenOpened();
			}
		});
		openButton.setFont(new Font("Times New Roman", Font.BOLD, 75));
		openButton.setBounds(448, 183, 322, 102);
		openPanel.add(openButton);
	}
	
	public void createDiaryTab() {
		JPanel diaryPanel = new JPanel();
		diaryPanel.setLayout(null);
		areaTab.addTab("NHẬT KÝ HOÁ ĐƠN", null, diaryPanel, null);

		createTable();

		JScrollPane jps = new JScrollPane(table);
		jps.setBounds(48, 50, 1099, 458);
		diaryPanel.add(jps);
	}

	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Quick Laundry Management");
		this.frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		this.frame.setBounds(10, 10, 1300, 700);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Bạn có muốn đóng phần mềm này?", "Form With Excel",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public HomeWhenClosed() {
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
		createAreaTab();
		createOpenTab();
		createDiaryTab();
		createFrame();
	}
}
