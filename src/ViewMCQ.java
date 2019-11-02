import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewMCQ extends JFrame {

	private JPanel contentPane;
	private JTextField keyword;
	private JTextField question;
	private JTextField option1;
	private JTextField option2;
	private JTextField option3;
	private JTextField option4;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMCQ frame = new ViewMCQ();
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
	public ViewMCQ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("View a question ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label.setBounds(53, 11, 327, 14);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 36, 327, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Enter a keyword to search");
		label_1.setBounds(30, 49, 134, 14);
		contentPane.add(label_1);
		
		keyword = new JTextField();
		keyword.setColumns(10);
		keyword.setBounds(172, 46, 110, 20);
		contentPane.add(keyword);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String key = keyword.getText();
				int flag = 0;
				MCQQuestion mc = new MCQQuestion();
				for(MCQQuestion q : RunApp.current.mcqquiz)
				{
					if(q.question.toLowerCase().contains(key.toLowerCase()))
					{
						flag = 1;
						mc = q;
						break;
					}
				}
				if(flag == 0)
				{
					JOptionPane.showMessageDialog(null,"No Such Question Found","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					question.setText(mc.question);
					answer.setText(mc.answer);
					option1.setText(mc.options[0]);
					option2.setText(mc.options[1]);
					option3.setText(mc.options[2]);
					option4.setText(mc.options[3]);
					
				}
			}
		});
		button.setBounds(292, 45, 89, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("Question ");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_2.setBounds(30, 74, 86, 14);
		contentPane.add(label_2);
		
		question = new JTextField();
		question.setColumns(10);
		question.setBounds(30, 99, 358, 45);
		contentPane.add(question);
		
		JLabel label_3 = new JLabel("Options");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_3.setBounds(30, 155, 86, 21);
		contentPane.add(label_3);
		
		option1 = new JTextField();
		option1.setColumns(10);
		option1.setBounds(30, 178, 86, 20);
		contentPane.add(option1);
		
		option2 = new JTextField();
		option2.setColumns(10);
		option2.setBounds(126, 178, 86, 20);
		contentPane.add(option2);
		
		option3 = new JTextField();
		option3.setColumns(10);
		option3.setBounds(227, 178, 86, 20);
		contentPane.add(option3);
		
		option4 = new JTextField();
		option4.setColumns(10);
		option4.setBounds(323, 178, 86, 20);
		contentPane.add(option4);
		
		JLabel label_4 = new JLabel("Answer");
		label_4.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_4.setBounds(30, 209, 86, 21);
		contentPane.add(label_4);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(136, 211, 86, 20);
		contentPane.add(answer);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		button_1.setBounds(320, 227, 89, 23);
		contentPane.add(button_1);
	}
}
