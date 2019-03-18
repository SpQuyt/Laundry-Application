package org.lma.app;

import java.awt.Font;
import java.io.IOException;

import javax.swing.*;

import org.json.*;
import org.lma.model.*;
import org.lma.online.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JTextField userField;
	private JButton forgotPassword;
	public ImageIcon img = new ImageIcon("./icon app.png");
	private JPasswordField passField = new JPasswordField(20);

	public static void main(String[] args) throws IOException, JSONException {
		new Login();
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
		passField.setBounds(142, 152, 258, 20);
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
				String message = null;
				
				try {
					response = API.loginAPI(userField.getText(), Cryptograph.changeToMD5(String.valueOf(passField.getPassword())));
					message = response.get("message").toString();
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				if (message.compareTo("notOK") == 0) {
					JOptionPane.showMessageDialog(null, "Không thể đăng nhập được!");
				}
				else {
					UserLoginModel newUser = new UserLoginModel();
					newUser.setInfo(response);
					
					frame.dispose();
					new HomeWhenClosed();
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

	public void createFrame() {
		this.frame = new JFrame();
		this.frame.setTitle("Quick Laundry Management");
		this.frame.setIconImage(img.getImage());
		this.contentPanel.setLayout(null);
		this.frame.setContentPane(this.contentPanel);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.frame.setBounds(350, 200, 500, 380);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		createTextpaneAndTextfield();
		createFrame();
	}
}
