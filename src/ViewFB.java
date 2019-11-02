import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;


public class ViewFB extends JFrame {

	private JPanel contentPane;
	private JTextField keyword;
	private JTextField question;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFB frame = new ViewFB();
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
	public ViewFB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewAQuestion = new JLabel("View a question ");
		lblViewAQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewAQuestion.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblViewAQuestion.setBounds(53, 11, 327, 14);
		contentPane.add(lblViewAQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 36, 327, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Enter a keyword to search");
		label_1.setBounds(27, 49, 134, 14);
		contentPane.add(label_1);
		
		keyword = new JTextField();
		keyword.setColumns(10);
		keyword.setBounds(168, 46, 110, 20);
		contentPane.add(keyword);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String key = keyword.getText();
				int flag = 0;
				FBQuestion fb = new FBQuestion();
				for(FBQuestion q : RunApp.current.fbquiz)
				{
					if(q.question.toLowerCase().contains(key.toLowerCase()))
					{
						flag = 1;
						fb = q;
						break;
					}
				}
				if(flag == 0)
				{
					JOptionPane.showMessageDialog(null,"No Such Question Found","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					question.setText(fb.question);
					answer.setText(fb.answer);
				}
			}
		});
		button.setBounds(288, 45, 89, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("Question ");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_2.setBounds(27, 88, 86, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Answer");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_3.setBounds(27, 182, 86, 21);
		contentPane.add(label_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		btnBack.setBounds(291, 227, 89, 23);
		contentPane.add(btnBack);
		
		question = new JTextField();
		question.setBounds(27, 107, 358, 71);
		contentPane.add(question);
		question.setColumns(10);
		
		answer = new JTextField();
		answer.setBounds(123, 184, 95, 20);
		contentPane.add(answer);
		answer.setColumns(10);
	}
}
