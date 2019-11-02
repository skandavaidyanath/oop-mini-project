import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;


public class GenQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField answer;
	ArrayList<Question> totalTest = new ArrayList<Question>();
	ArrayList<Question> test = new ArrayList<Question>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenQuiz frame = new GenQuiz();
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
	public GenQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerateQuiz = new JLabel("Generate Quiz");
		lblGenerateQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateQuiz.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblGenerateQuiz.setBounds(82, 11, 235, 14);
		contentPane.add(lblGenerateQuiz);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 36, 298, 2);
		contentPane.add(separator);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of questions");
		lblEnterNumberOf.setBounds(40, 49, 149, 14);
		contentPane.add(lblEnterNumberOf);
		
		number = new JTextField();
		number.setBounds(199, 46, 46, 20);
		contentPane.add(number);
		number.setColumns(10);
		
		JList list = new JList();
		list.setBounds(40, 80, 340, 91);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					test.clear();
					totalTest.clear();
					int n = Integer.parseInt(number.getText());
					totalTest.addAll(RunApp.current.fbquiz);
					totalTest.addAll(RunApp.current.tfquiz);
					totalTest.addAll(RunApp.current.mcqquiz);
					Collections.shuffle(totalTest);
					DefaultListModel dlm = new DefaultListModel();
					if(n > totalTest.size())
					{
						JOptionPane.showMessageDialog(null,"There aren't enough questions.","Error",JOptionPane.ERROR_MESSAGE);
					}
					else if(n < 1)
					{
						JOptionPane.showMessageDialog(null,"Are you stupid ?.","Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{	
						for(int i = 0; i < n; i++)
						{
							test.add(totalTest.get(i));
							dlm.addElement(totalTest.get(i));
						}
					}
					list.setModel(dlm);
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(null,"Enter a valid number please","Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnNewButton.setBounds(288, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Commands cp = new Commands();
				cp.setVisible(true);
			}
		});
		btnCancel.setBounds(269, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAnswer.setBounds(40, 182, 62, 14);
		contentPane.add(lblAnswer);
		
		answer = new JTextField();
		answer.setBounds(112, 182, 116, 20);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton btnShowAnswer = new JButton("Show Answer");
		btnShowAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Question q = (Question) list.getSelectedValue();
				answer.setText(q.answer);
			}
		});
		btnShowAnswer.setBounds(269, 182, 108, 23);
		contentPane.add(btnShowAnswer);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int k = 1;
					PrintWriter pw = new PrintWriter("finalTest.txt", "UTF-8");
					pw.println("\t\t\tTHE FINAL TEST\n");
					for(Question i : test)
					{
						pw.println(k + ")" + " " + i.toString());
						k++;
					}
					pw.close();
				}
				catch(Exception exc)
				{
					System.out.println(exc);
				}
				JOptionPane.showMessageDialog(null,"Successfully exported into file finalTest !","Success", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		btnExport.setBounds(60, 227, 89, 23);
		contentPane.add(btnExport);
	}
}
