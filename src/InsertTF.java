import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class InsertTF extends JFrame {

	private JPanel contentPane;
	private JTextField question;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertTF frame = new InsertTF();
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
	public InsertTF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertYourQuestion = new JLabel("Insert your Question");
		lblInsertYourQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertYourQuestion.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblInsertYourQuestion.setBounds(66, 11, 283, 14);
		contentPane.add(lblInsertYourQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 36, 283, 2);
		contentPane.add(separator);
		
		question = new JTextField();
		question.setBounds(24, 80, 376, 57);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Question ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 55, 86, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JComboBox answer = new JComboBox();
		answer.addItem("TRUE");
		answer.addItem("FALSE");
		answer.setSelectedItem(null);
		answer.setBounds(24, 181, 86, 20);
		contentPane.add(answer);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				question.setText(null);
				answer.setSelectedItem(null);
			}
		});
		btnReset.setBounds(21, 227, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ques = question.getText();
				String ans = (String) answer.getSelectedItem();
				if(ques.equals("")||(ans.equals(null)))
				{
					JOptionPane.showMessageDialog(null,"Please enter the question and answer.","Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						
					TFQuestion x = new TFQuestion();
					x.question  = question.getText();
					x.answer = (String) answer.getSelectedItem();
					RunApp.current.tfquiz.add(x);
					if(RunApp.subject.equals("phy"))
					{
						RunApp.writeTF("phyTF.txt");
					}
					else if(RunApp.subject.equals("chem"))
					{
						RunApp.writeTF("chemTF.txt");
					}
					else
					{
						RunApp.writeTF("mathTF.txt");
					}
					JOptionPane.showMessageDialog(null,"Question Successfully inserted.", "Information", JOptionPane.INFORMATION_MESSAGE);
					Changes cp = new Changes();
					cp.setVisible(true);
						
				}
			}
		});
		btnSubmit.setBounds(178, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAnswer.setBounds(24, 156, 73, 14);
		contentPane.add(lblAnswer);
	}

}
