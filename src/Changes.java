import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Changes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changes frame = new Changes();
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
	public Changes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseAnOption = new JLabel("Choose an Option");
		lblChooseAnOption.setBounds(129, 11, 130, 14);
		contentPane.add(lblChooseAnOption);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 36, 281, 2);
		contentPane.add(separator);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Fill in the Blanks");
		comboBox.addItem("True or False");
		comboBox.addItem("Multiple Choice");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(129, 49, 116, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Insert Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null,"Please select a type of Question", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String s = (String) comboBox.getSelectedItem();
					if(s.equals("True or False"))
					{
						InsertTF ipt = new InsertTF();
						ipt.setVisible(true);
					}
					else if(s.equals("Fill in the Blanks"))
					{
						InsertFB ipf = new InsertFB();
						ipf.setVisible(true);
					}
					else if(s.equals("Multiple Choice"))
					{
						InsertMCQ ipm = new InsertMCQ();
						ipm.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBounds(129, 93, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify Question");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null,"Please select a type of Question", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String s = (String) comboBox.getSelectedItem();
					if(s.equals("True or False"))
					{
						ModifyTF mpt = new ModifyTF();
						mpt.setVisible(true);
					}
					else if(s.equals("Fill in the Blanks"))
					{
						ModifyFB mpf = new ModifyFB();
						mpf.setVisible(true);
					}
					else if(s.equals("Multiple Choice"))
					{
						ModifyMCQ mpf = new ModifyMCQ();
						mpf.setVisible(true);
					}
				}
			}
		});
		btnNewButton_1.setBounds(129, 127, 116, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Question");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null,"Please select a type of Question", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String s = (String) comboBox.getSelectedItem();
					if(s.equals("True or False"))
					{
						ViewTF vpt = new ViewTF();
						vpt.setVisible(true);
					}
					else if(s.equals("Fill in the Blanks"))
					{
						ViewFB vpf = new ViewFB();
						vpf.setVisible(true);
					}
					else if(s.equals("Multiple Choice"))
					{
						ViewMCQ vpf = new ViewMCQ();
						vpf.setVisible(true);
					}
				}
			}
		});
		btnNewButton_2.setBounds(129, 195, 116, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Question");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null,"Please select a type of Question", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String s = (String) comboBox.getSelectedItem();
					if(s.equals("True or False"))
					{
						DeleteTF dpt = new DeleteTF();
						dpt.setVisible(true);
					}
					else if(s.equals("Fill in the Blanks"))
					{
						DeleteFB dpf = new DeleteFB();
						dpf.setVisible(true);
					}
					else if(s.equals("Multiple Choice"))
					{
						DeleteMCQ dpm = new DeleteMCQ();
						dpm.setVisible(true);
					}
				}
			}
		});
		btnNewButton_3.setBounds(129, 161, 116, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Commands cmdphy = new Commands();
				cmdphy.setVisible(true);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
