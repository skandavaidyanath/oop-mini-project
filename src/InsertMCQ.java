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
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class InsertMCQ extends JFrame {

	private JPanel contentPane;
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
					InsertMCQ frame = new InsertMCQ();
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
	public InsertMCQ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Insert your Question");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label.setBounds(69, 11, 283, 14);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 36, 294, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Question ");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_1.setBounds(24, 49, 86, 14);
		contentPane.add(label_1);
		
		question = new JTextField();
		question.setBounds(24, 74, 358, 39);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblOptions.setBounds(24, 124, 86, 21);
		contentPane.add(lblOptions);
		
		option1 = new JTextField();
		option1.setBounds(24, 149, 86, 20);
		contentPane.add(option1);
		option1.setColumns(10);
		
		option2 = new JTextField();
		option2.setColumns(10);
		option2.setBounds(120, 149, 86, 20);
		contentPane.add(option2);
		
		option3 = new JTextField();
		option3.setColumns(10);
		option3.setBounds(216, 149, 86, 20);
		contentPane.add(option3);
		
		option4 = new JTextField();
		option4.setColumns(10);
		option4.setBounds(312, 149, 86, 20);
		contentPane.add(option4);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAnswer.setBounds(24, 178, 86, 21);
		contentPane.add(lblAnswer);
		
		answer = new JTextField();
		answer.setBounds(152, 180, 86, 20);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				question.setText(null);
				answer.setText(null);
				option1.setText(null);
				option2.setText(null);
				option3.setText(null);
				option4.setText(null);
				
			}
		});
		button.setBounds(24, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ques = question.getText();
				String ans = answer.getText();
				String opt1 = option1.getText();
				String opt2 = option2.getText();
				String opt3 = option3.getText();
				String opt4 = option4.getText();
				if((ques.equals(""))||(ans.equals(""))||(opt1.equals(""))||(opt2.equals(""))||(opt3.equals(""))||(opt4.equals("")))
				{
					JOptionPane.showMessageDialog(null,"Please enter all the fields.","Error Message", JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
						MCQQuestion x = new MCQQuestion();
						x.question  = ques;
						x.answer = ans;
						x.options[0] = opt1;
						x.options[1] = opt2;
						x.options[2] = opt3;
						x.options[3] = opt4;
						RunApp.current.mcqquiz.add(x);
						if(RunApp.subject.equals("phy"))
						{
							RunApp.writeMCQ("phyMCQ.txt");
						}
						else if(RunApp.subject.equals("chem"))
						{
							RunApp.writeMCQ("chemMCQ.txt");
						}
						else
						{
							RunApp.writeMCQ("mathMCQ.txt");
						}
						JOptionPane.showMessageDialog(null,"Question Successfully inserted.", "Information", JOptionPane.INFORMATION_MESSAGE);
						Changes cp = new Changes();
						cp.setVisible(true);
						
					}
				}
				
		});
		button_1.setBounds(167, 227, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		button_2.setBounds(312, 227, 89, 23);
		contentPane.add(button_2);
	}

}
