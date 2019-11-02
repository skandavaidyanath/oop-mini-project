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


public class InsertFB extends JFrame {

	private JPanel contentPane;
	private JTextField question;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertFB frame = new InsertFB();
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
	public InsertFB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Insert your Question");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label.setBounds(67, 11, 283, 14);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 36, 283, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Question ");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_1.setBounds(28, 49, 86, 14);
		contentPane.add(label_1);
		
		question = new JTextField();
		question.setColumns(10);
		question.setBounds(28, 74, 376, 57);
		contentPane.add(question);
		
		JLabel label_2 = new JLabel("Answer");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_2.setBounds(28, 151, 73, 14);
		contentPane.add(label_2);
		
		answer = new JTextField();
		answer.setBounds(28, 179, 376, 20);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				question.setText(null);
				answer.setText(null);
			}
		});
		button.setBounds(28, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ques = question.getText();
				String ans = (String) answer.getText();
				if(ques.equals("")||(ans.equals("")))
				{
					JOptionPane.showMessageDialog(null,"Please enter the question and answer.","Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					FBQuestion x = new FBQuestion();
					x.question  = question.getText();
					x.answer = (String) answer.getText();
					RunApp.current.fbquiz.add(x);
					if(RunApp.subject.equals("phy"))
					{
						RunApp.writeFB("phyFB.txt");
					}
					else if(RunApp.subject.equals("chem"))
					{
						RunApp.writeFB("chemFB.txt");
					}
					else
					{
						RunApp.writeFB("mathFB.txt");
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
		button_2.setBounds(315, 227, 89, 23);
		contentPane.add(button_2);
	}

}
