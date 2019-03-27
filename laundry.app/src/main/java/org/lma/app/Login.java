package org.lma.app;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import org.json.*;
import org.lma.model.*;
import org.lma.online.*;

import omg.lma.helpers.Cryptograph;
import omg.lma.helpers.Links;
import omg.lma.helpers.PointLayout;
import omg.lma.helpers.Storage;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JTextField userField;
	private JButton forgotPassword;
	private static String md5Password;
	private JPasswordField passField = new JPasswordField(20);
	private int frameWidth = 500;
	private int frameHeight = 380;
	private int x;
	private int y;

	public static void main(String[] args) throws IOException, JSONException {
		new Login();
	}
	
	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Quick Laundry Management");
		this.frame.setIconImage(Links.img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.x = PointLayout.startXPoints(this.frameWidth, this.frameHeight);
		this.y = PointLayout.startYPoints(this.frameWidth, this.frameHeight);
		
		this.frame.setBounds(this.x, this.y, this.frameWidth, this.frameHeight);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();

		JLabel user = new JLabel("Tài khoản");
		user.setBounds(54, 92, 55, 32);
		contentPanel.add(user);

		JLabel pass = new JLabel("Mật khẩu");
		pass.setBounds(54, 146, 55, 32);
		contentPanel.add(pass);

		passField = new JPasswordField();
		passField.setBounds(142, 152, 258, 26);
		contentPanel.add(passField);

		
		userField = new JTextField();
		userField.setBounds(142, 95, 258, 26);
		contentPanel.add(userField);
		userField.setColumns(10);

		JButton signUpPlace = new JButton("Chưa có tài khoản? Đăng ký ở đây");
		signUpPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpPlace.setBounds(110, 246, 255, 23);
		contentPanel.add(signUpPlace);

		JButton login = new JButton("Đăng nhập");
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JSONObject response = null;	
				Boolean success = null;
				Login.md5Password = Cryptograph.changeToMD5(String.valueOf(passField.getPassword()));
				
				try {
					response = API.loginAPI(userField.getText(), Login.md5Password);
					success = (Boolean) response.get("success");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Không kết nối được tới máy chủ!");
				} 
				
				if (!success) {
					JOptionPane.showMessageDialog(null, "Không tìm được tài khoản và mật khẩu người dùng!");
				}
				else {
					UserLoginModel newUserLogin = new UserLoginModel(response);
					
					Storage.newUserLogin = newUserLogin;
					Storage.objID = newUserLogin.getObjID();
					
					try {
						Cookies.createCookieFile(userField.getText(), String.valueOf(passField.getPassword()));
					} catch (Exception e1) {
						
					}
					frame.dispose();
					new Home();
				}
			}
		});
		login.setBounds(281, 201, 101, 23);
		contentPanel.add(login);

		forgotPassword = new JButton("Quên mật khẩu?");
		forgotPassword.setBounds(92, 201, 127, 23);
		contentPanel.add(forgotPassword);

		JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ GIẶT LÀ");
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setBounds(65, 11, 362, 61);
		contentPanel.add(title);
	}

	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		String userFromCookie = "";
		String passFromCookie = "";
		
		if (Cookies.checkCookies()) {
			try {
				userFromCookie = Cookies.readCookieFileUsername();
				passFromCookie = Cookies.readCookieFilePassword();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		createTextpaneAndTextfield();
		createFrame();	
		this.userField.setText(userFromCookie);
		this.passField.setText(passFromCookie);
	}
}
