package org.lma.app;

import java.awt.Font;
import java.io.IOException;

import javax.swing.*;

import org.lma.online.API;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JTextField userField;
	private JTextField passField;
	private JButton forgotPassword;
	public ImageIcon img = new ImageIcon("./icon app.png");

	public static void main(String[] args) throws IOException {
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

		userField = new JTextField();
		userField.setBounds(142, 95, 258, 26);
		contentPanel.add(userField);
		userField.setColumns(10);

		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(142, 149, 258, 26);
		contentPanel.add(passField);

		JButton signUpPlace = new JButton("Chưa có tài khoản? Đăng ký ở đây");
		signUpPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpPlace.setBounds(110, 246, 255, 23);
		contentPanel.add(signUpPlace);

		JButton login = new JButton("Đăng nhập");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				try {
					API.loginAPI(userField.getText(), passField.getText());
				} catch (Exception e) {
					e.printStackTrace();
				} 
				frame.dispose();
				new HomeWhenClosed();
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
