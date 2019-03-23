package org.lma.model;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import org.json.*;
import org.lma.online.*;
import org.quinto.swing.table.model.*;
import org.quinto.swing.table.view.*;

import omg.lma.helpers.Storage;

public class DiaryTable {
	public static JBroTable table;
	@SuppressWarnings("rawtypes")
	public static ArrayList dataTable = new ArrayList();;
	
	public static void main(String[] args) {
		DiaryTable.getDataTable();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList getDataTable() {
		
		
		
//		dataTable[0] = {{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"}};
//		
//		dataTable = {
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//				{"1", "1234", "KH1","4","","4","","","","","1","","","220000","Đã thanh toán"},
//		};
		
		JSONObject response = null;
		Boolean success = null;
		
		try {
			response = API.getBillAPI(Storage.objID);
			success = (Boolean) response.get("success");
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Không có kết nối Internet!");
		}
		
		if (!success) {
			JOptionPane.showMessageDialog(null, "Không có nhật ký hoá đơn!");
		}
		else {
			JSONArray jsonArray = (JSONArray) response.get("result");
			
			for (int i = 0; i < response.length(); i++) {
				ArrayList<String> list = new ArrayList<String>();
				JSONObject obj = (JSONObject) jsonArray.get(i);
				System.out.println((JSONObject) jsonArray.get(i));
				list.add("" + (i+1));
				list.add(((JSONObject) jsonArray.get(i)).get("billID").toString());
				list.add(((JSONObject) jsonArray.get(i)).get("name").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").get("dry").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").get("wet").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("jacket").get("big").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("jacket").get("medium").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("jacket").get("small").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("blanket").get("big").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("blanket").get("medium").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("blanket").get("small").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("others").get("name").toString());
				list.add(((JSONObject) jsonArray.get(i)).getJSONObject("services").getJSONObject("others").get("total").toString());
				list.add(((JSONObject) jsonArray.get(i)).get("money").toString());
				if (((JSONObject) jsonArray.get(i)).get("purchased").toString().compareTo("true") == 0) {
					list.add("Đã thanh toán");
				}
				else {
					list.add("");
				}
				
				dataTable.add(list);
				
			}
			
		}
		
		return dataTable;
	}
	
	public static void configTable(JBroTable table) {
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
	
	@SuppressWarnings("unchecked")
	public static void createTableModel() {
		
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
		ModelRow rows[] = new ModelRow[dataTable.size()];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new ModelRow(fields.length);
			for (int j = 0; j < fields.length; j++)
				rows[i].setValue(j, ((ArrayList<String>) dataTable.get(i)).get(j));
		}

		// Table.
		ModelData data = new ModelData(groups);
		data.setRows(rows);
		table = new JBroTable(data);		
		
	}
	
	public static JBroTable initTable() {
		getDataTable();
		createTableModel();
		configTable(table);
		return table;
	}
}
