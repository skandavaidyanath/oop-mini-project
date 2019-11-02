import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;


public class MenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage frame = new MenuPage();
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
	public MenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAutomaticQuizGenerator = new JLabel("Automatic Quiz Generator !");
		lblAutomaticQuizGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutomaticQuizGenerator.setFont(new Font("BankGothic Md BT", Font.BOLD, 22));
		lblAutomaticQuizGenerator.setBounds(20, 11, 381, 23);
		contentPane.add(lblAutomaticQuizGenerator);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 45, 327, 2);
		contentPane.add(separator);
		
		JButton btnPhysics = new JButton("PHYSICS");
		btnPhysics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RunApp.current = RunApp.physics;
				RunApp.subject = "phy";
				Commands cp = new Commands();
				cp.setVisible(true);
				
			}
		});
		btnPhysics.setBounds(151, 99, 89, 23);
		contentPane.add(btnPhysics);
		
		JButton btnChemistry = new JButton("CHEMISTRY");
		btnChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RunApp.current = RunApp.chemistry;
				RunApp.subject = "chem";
				Commands cp = new Commands();
				cp.setVisible(true);
			}
		});
		btnChemistry.setBounds(151, 156, 89, 23);
		contentPane.add(btnChemistry);
		
		JButton btnMaths = new JButton("MATH");
		btnMaths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RunApp.current = RunApp.math;
				RunApp.subject = "math";
				Commands cp = new Commands();
				cp.setVisible(true);
			}
		});
		btnMaths.setBounds(151, 211, 89, 23);
		contentPane.add(btnMaths);
		
		JLabel lblChooseASubject = new JLabel("Choose a Subject !");
		lblChooseASubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseASubject.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblChooseASubject.setBounds(107, 58, 200, 23);
		contentPane.add(lblChooseASubject);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginForm login = new LoginForm();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(335, 227, 89, 23);
		contentPane.add(btnLogout);
	}
}
