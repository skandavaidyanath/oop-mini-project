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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModifyTF extends JFrame {

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
					ModifyTF frame = new ModifyTF();
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
	public ModifyTF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifyAQuestion = new JLabel("Modify a question ");
		lblModifyAQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyAQuestion.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblModifyAQuestion.setBounds(49, 11, 327, 14);
		contentPane.add(lblModifyAQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 36, 327, 2);
		contentPane.add(separator);
		
		JLabel lblEnterAKeyword = new JLabel("Enter a keyword to search");
		lblEnterAKeyword.setBounds(25, 49, 134, 14);
		contentPane.add(lblEnterAKeyword);
		
		keyword = new JTextField();
		keyword.setBounds(169, 46, 110, 20);
		contentPane.add(keyword);
		keyword.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String key = keyword.getText();
				int flag = 0;
				TFQuestion tf = new TFQuestion();
				for(TFQuestion q : RunApp.current.tfquiz)
				{
					if(q.question.toLowerCase().contains(key.toLowerCase()))
					{
						flag = 1;
						tf = q;
						RunApp.current.tfquiz.remove(q);
						break;
					}
				}
				if(flag == 0)
				{
					JOptionPane.showMessageDialog(null,"No Such Question Found","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					question.setText(tf.question);
					answer.setText(tf.answer);
				}
				
			}
		});
		btnSearch.setBounds(317, 45, 89, 23);
		contentPane.add(btnSearch);
		
		question = new JTextField();
		question.setBounds(25, 111, 381, 64);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel label_1 = new JLabel("Answer");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_1.setBounds(25, 186, 73, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Question ");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_2.setBounds(25, 86, 86, 14);
		contentPane.add(label_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TFQuestion q = new TFQuestion();
				q.question = question.getText();
				q.answer = answer.getText();
				RunApp.current.tfquiz.add(q);
				JOptionPane.showMessageDialog(null,"Question Modified","Information", JOptionPane.INFORMATION_MESSAGE);
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
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		btnOk.setBounds(83, 227, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		btnCancel.setBounds(234, 227, 89, 23);
		contentPane.add(btnCancel);
		
		answer = new JTextField();
		answer.setBounds(108, 186, 86, 20);
		contentPane.add(answer);
		answer.setColumns(10);
	}
}
