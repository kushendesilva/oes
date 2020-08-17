package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.UIManager;
import course.CoursePanel;
import database.Connect;

public class MainAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private boolean executeQuery(String query)
	{
		Connect c=new Connect("root","");
		try{
			Statement st=c.con.createStatement();
			if(st.executeQuery(query).next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	public MainAdmin() {
		setLayout(null);
		
		JButton btnUsers = new JButton("STUDENTS");
		btnUsers.setFocusable(false);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails"))
					MainFrame.AddPanel(new UsersData());
				else
					JOptionPane.showMessageDialog(null, "No users found.");
			}
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFocusable(false);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.password=JOptionPane.showInputDialog(null, "New password");
			}
		});
		btnChangePassword.setForeground(new Color(0, 0, 0));
		btnChangePassword.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnChangePassword.setBackground(new Color(255, 255, 255));
		btnChangePassword.setBounds(343, 100, 300, 30);
		add(btnChangePassword);
		btnUsers.setForeground(new Color(255, 255, 255));
		btnUsers.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUsers.setBackground(new Color(0, 0, 0));
		btnUsers.setBounds(330, 429, 332, 79);
		add(btnUsers);
		
		JButton btnResults = new JButton("RESULTS");
		btnResults.setFocusable(false);
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from result"))
					MainFrame.AddPanel(new CoursesResult());
				else
					JOptionPane.showMessageDialog(null, "No result found.");
			}
		});
		btnResults.setForeground(new Color(255, 255, 255));
		btnResults.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnResults.setBackground(new Color(0, 0, 0));
		btnResults.setBounds(330, 159, 332, 79);
		add(btnResults);
		
		JButton btnVerification = new JButton("VERIFICATIONS");
		btnVerification.setFocusable(false);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails where verify=0"))
					new Verification();
				else
					JOptionPane.showMessageDialog(null, "No users for verification.");
			}
		});
		btnVerification.setForeground(new Color(255, 255, 255));
		btnVerification.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnVerification.setBackground(new Color(0, 0, 0));
		btnVerification.setBounds(330, 249, 332, 79);
		add(btnVerification);
		
		JButton btnManageCourses = new JButton("COURSES");
		btnManageCourses.setFocusable(false);
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new CoursePanel());
			}
		});
		btnManageCourses.setForeground(new Color(255, 255, 255));
		btnManageCourses.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnManageCourses.setBackground(new Color(0, 0, 0));
		btnManageCourses.setBounds(330, 339, 332, 79);
		add(btnManageCourses);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
				JOptionPane.showMessageDialog(null, "Successfully Logout.");	
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 11, 125, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("LECTURER PANEL");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblOnlineExamination.setBounds(194, 20, 603, 105);
		add(lblOnlineExamination);
	}
}
