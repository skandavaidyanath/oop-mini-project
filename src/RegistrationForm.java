import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;


public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField repassword;
	private JSeparator separator;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationForm.setBounds(57, 11, 271, 14);
		contentPane.add(lblRegistrationForm);
		
		JLabel usernamelabel = new JLabel("Username");
		usernamelabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		usernamelabel.setBounds(57, 58, 113, 19);
		contentPane.add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		passwordlabel.setBounds(57, 97, 113, 19);
		contentPane.add(passwordlabel);
		
		JLabel repasswordlabel = new JLabel("Retype Password");
		repasswordlabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		repasswordlabel.setBounds(57, 141, 143, 19);
		contentPane.add(repasswordlabel);
		
		username = new JTextField();
		username.setBounds(242, 57, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(242, 96, 86, 20);
		contentPane.add(password);
		
		repassword = new JPasswordField();
		repassword.setBounds(242, 140, 86, 20);
		contentPane.add(repassword);
		
		separator = new JSeparator();
		separator.setBounds(43, 36, 341, 2);
		contentPane.add(separator);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = username.getText();
				String pass = password.getText();
				String repass = repassword.getText();
				int flag = 1;
				for(Credentials i : RunApp.creds)
				{
					if((i.username).equals(uname))
					{
						JOptionPane.showMessageDialog(null, "This username is already registered. Try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
						username.setText(null);
						password.setText(null);
						repassword.setText(null);
						flag = 0;
						if(flag == 0) break;
					}
				}
				if(flag == 1)
				{
					if(pass.equals(repass)) 
					{
						//we also have to check if previous usernames have been taken
						Credentials c = new Credentials();
						c.username = uname;
						c.password = pass;
						RunApp.creds.add(c);
						RunApp.writeCredentials();
						JOptionPane.showMessageDialog(null, "Successfully Registered.", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
						LoginForm login = new LoginForm();
						login.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The passwords don't match. Try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
						password.setText(null);
						repassword.setText(null);
					}
				}
					
			}
		});
		btnRegister.setBounds(158, 190, 89, 23);
		contentPane.add(btnRegister);
	}

}
