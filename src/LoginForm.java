import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSystem.setFont(new Font("BankGothic Lt BT", Font.BOLD, 20));
		lblLoginSystem.setBounds(128, 11, 172, 14);
		contentPane.add(lblLoginSystem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 44, 368, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 89, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(73, 135, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(202, 88, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(202, 132, 86, 20);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = username.getText();
				String pass = password.getText();
				int flag = 0;
				for(Credentials i : RunApp.creds)
				{
					if((i.username.equals(uname))&&(i.password.equals(pass)))
					{
						JOptionPane.showMessageDialog(null,"You have successfully logged in.", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
						flag = 1;
						break;
					}
				}
				if(flag == 0)
				{
					JOptionPane.showMessageDialog(null,"Invalid Credentials.", "Error Message", JOptionPane.ERROR_MESSAGE);
					username.setText(null);
					password.setText(null);
				}
				else
				{
					MenuPage menu = new MenuPage();
					menu.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(32, 189, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText(null);
				password.setText(null);
			}
		});
		btnReset.setBounds(179, 189, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationForm reg = new RegistrationForm();
				reg.setVisible(true);
			}
		});
		btnRegister.setBounds(311, 189, 89, 23);
		contentPane.add(btnRegister);
	}
}
