import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Commands extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commands frame = new Commands();
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
	public Commands() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to do ?");
		lblWhatWouldYou.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblWhatWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatWouldYou.setBounds(26, 11, 387, 14);
		contentPane.add(lblWhatWouldYou);
		
		JButton genTest = new JButton("Generate Test");
		genTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GenQuiz gp = new GenQuiz();
				gp.setVisible(true);
			}
		});
		genTest.setBounds(151, 96, 119, 23);
		contentPane.add(genTest);
		
		JButton makeChanges = new JButton("Make Changes");
		makeChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		makeChanges.setBounds(151, 157, 119, 23);
		contentPane.add(makeChanges);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPage menu = new MenuPage();
				menu.setVisible(true);
			}
		});
		back.setBounds(335, 227, 89, 23);
		contentPane.add(back);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 36, 306, 2);
		contentPane.add(separator);
	}

}
