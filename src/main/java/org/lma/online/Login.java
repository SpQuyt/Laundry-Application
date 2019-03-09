package org.lma.online;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPanel;
	private JFrame frame;
	private JTextPane title;
	private JTextField userField;
	private JTextField passField;
	private JButton forgotPassword;

	public static void main(String[] args) throws IOException {
		new Login();
	}

//	public static void main1(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login hasagi = new Login();
//					hasagi.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void createTextpaneAndTextfield() {
		contentPanel = new JPanel();
		
		title = new JTextPane();
		title.setText("ĐĂNG NHẬP");
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setBounds(164, 11, 149, 40);
		contentPanel.add(title);
		
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
		
		JButton signUpPlace = new JButton("Chưa có tài khoản? Đăng ký tại đây");
		signUpPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpPlace.setBounds(110, 246, 255, 23);
		contentPanel.add(signUpPlace);
		
		JButton login = new JButton("Đăng nhập");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		login.setBounds(293, 201, 89, 23);
		contentPanel.add(login);
		
		forgotPassword = new JButton("Quên mật khẩu?");
		forgotPassword.setBounds(92, 201, 111, 23);
		contentPanel.add(forgotPassword);
	}

	public void createFrame() {
		this.frame = new JFrame();
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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		createTextpaneAndTextfield();
		createFrame();
	}
}
