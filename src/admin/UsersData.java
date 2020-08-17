package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import main.MainFrame;
import database.Connect;
import database.UserData;

public class UsersData extends JPanel {


	private static Connect c=new Connect("root","");
	private JComboBox<String> comboBox;
	private String Username;
	private String[] DATA;
	/**
	 * Create the panel.
	 */
	public UsersData() {
		databaseVerify();
		makeGUI();
	}
	private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select count(username) from userdetails";
			java.sql.ResultSet rs=st.executeQuery(query);
			rs.next();
			int i=rs.getInt(1);
			DATA=new String[i];
			i=0;
			query="select username from userdetails";
			rs=st.executeQuery(query);
			while(rs.next())
				DATA[i++]=rs.getString("username");
			for(String s:DATA)
				System.out.println(s);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}
	public void makeGUI() {
		//public Verification(){
			setLayout(null);
			
			JButton btnSearch = new JButton("SEARCH");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Show details of that username
					new UserData(Username,true,"UsersData");
				}
			});
			btnSearch.setForeground(new Color(255, 255, 255));
			btnSearch.setFont(new Font("SansSerif", Font.BOLD, 18));
			btnSearch.setBackground(SystemColor.BLACK);
			btnSearch.setBounds(739, 223, 125, 36);
			add(btnSearch);
			
			
			
			JLabel lblUsersForVerification = new JLabel("Available Users");
			lblUsersForVerification.setForeground(new Color(0, 0, 0));
			lblUsersForVerification.setFont(new Font("SansSerif", Font.BOLD, 13));
			lblUsersForVerification.setBounds(234, 223, 156, 28);
			add(lblUsersForVerification);
			
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(DATA));
			comboBox.setFont(new Font("SansSerif", Font.BOLD, 12));
			comboBox.setBounds(434, 223, 266, 30);
			add(comboBox);
			Username=DATA[0];
			comboBox.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Username=(String)comboBox.getSelectedItem();				
				}
			});
			
			JButton btnNewButton = new JButton("BACK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainFrame.AddPanel(new MainAdmin());
				}
			});
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(0, 0, 0));
			btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 16));
			btnNewButton.setBounds(10, 512, 125, 36);
			add(btnNewButton);
			
			JLabel lblOnlineExamination = new JLabel("STUDENTS");
			lblOnlineExamination.setForeground(new Color(0, 0, 0));
			lblOnlineExamination.setBackground(Color.GREEN);
			lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
			lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 36));
			lblOnlineExamination.setBounds(307, 28, 378, 82);
			add(lblOnlineExamination);
		}
}
