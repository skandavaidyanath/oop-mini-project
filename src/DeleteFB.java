import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class DeleteFB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFB frame = new DeleteFB();
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
	public DeleteFB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteAQuestion = new JLabel("Delete a question ");
		lblDeleteAQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAQuestion.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblDeleteAQuestion.setBounds(42, 11, 327, 14);
		contentPane.add(lblDeleteAQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 27, 327, 2);
		contentPane.add(separator);
		
		
		JList list = new JList(RunApp.current.fbquiz.toArray());
		list.setBounds(52, 40, 317, 169);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Changes cp = new Changes();
				cp.setVisible(true);
			}
		});
		btnCancel.setBounds(229, 220, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list.getSelectedIndex()==-1)
				{
					JOptionPane.showMessageDialog(null,"Please select a question","Error Message",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					FBQuestion q = (FBQuestion) list.getSelectedValue();
					RunApp.current.fbquiz.remove(q);
					JOptionPane.showMessageDialog(null,"Question Deleted","Information",JOptionPane.INFORMATION_MESSAGE);
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
					Changes cp = new Changes();
					cp.setVisible(true);
				}
			}
		});
		btnDelete.setBounds(88, 220, 89, 23);
		contentPane.add(btnDelete);
		
	}
}
