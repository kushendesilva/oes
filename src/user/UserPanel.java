package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.MainFrame;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;

import database.Connect;

import javax.swing.JTextArea;

import results.UserResult;
import startTest.BeginTest;

public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Connect c=new Connect("root","");
	private String[] Courses;
	private String Name;
	private String Username;
	private JComboBox<String> comboBox;
	private String Selected_course="";
	private String totalQuestions;
	private String eachMark;
	private String time;

	private void dataBaseWork()
	{
		String course_query="select *from course_details where hide=0";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(course_name) from course_details where hide=0");
			rs.next();
			int i=rs.getInt(1);
			rs=stmt.executeQuery(course_query);
			Courses=new String[i];
			i=0;
			while(rs.next())
				Courses[i++]=rs.getString("course_name");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	// this function helps the start button to add beginTest panel or not.
	private int courseDetail(String Course)
	{
		try {
			Statement stmt = c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from course_details where course_name='"+Course+"'");
			rs.next();
			int i=(int)rs.getInt("total_question");
			time=rs.getString("time");
			totalQuestions=rs.getString("total_question");
			eachMark=rs.getString("question_mark");
			System.out.println("Questions are available : "+i);
			return i;
		} catch (SQLException e) {
			System.out.println("UserPanel->availableQuestions : "+e);
		}
		System.out.println("No questions are available ");
		return -1;
	}

	private void dataBaseWork(String username)
	{
		String query="select * from userdetails where username='"+username+"'";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			Name=rs.getString("FirstName")+" "+rs.getString("MiddleName")+" "+rs.getString("LastName");
			System.out.println(Name);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	JTextArea instructions;
	
	
	public UserPanel(String username) {
		setLayout(null);
		Username=username;
		dataBaseWork();
		dataBaseWork(Username);
		
		JButton btnStartTest = new JButton("START TEST");
		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Selected_course.equals(""))
				{
					//Start test of selected course if no of questions available are greater than 1.
					if(courseDetail(Selected_course)>0)	
					{
						MainFrame.AddPanel(new BeginTest(Username,Selected_course,eachMark));
					}
					else
						JOptionPane.showMessageDialog(null, "Questions are not available.\nPlease contact to admin.");
				}
				else
					JOptionPane.showMessageDialog(null, "Select course first.");;	
			}
		});
		
		JButton btnResult = new JButton("RESULTS");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Show Result of current user
				new UserResult(Username,"user");			}
		});
		btnResult.setForeground(new Color(255, 255, 255));
		btnResult.setBackground(new Color(0, 0, 0, 255));
		btnResult.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnResult.setBounds(815, 64, 166, 42);
		add(btnResult);
		btnStartTest.setBackground(new Color(0, 255, 85, 255));
		btnStartTest.setForeground(new Color(0, 0, 0));
		btnStartTest.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnStartTest.setBounds(565, 175, 166, 42);
		add(btnStartTest);
		
		instructions = new JTextArea();
		instructions.setToolTipText("INSTRUCTIONS");
		instructions.setEditable(false);
		instructions.setDisabledTextColor(new Color(255, 255, 255));
		instructions.setBackground(new Color(0, 0, 0));
		instructions.setFont(new Font("SansSerif", Font.PLAIN, 16));
		instructions.setForeground(new Color(255, 255, 255));
		instructions.setBounds(10, 299, 971, 248);
		instructions.setVisible(false);
		add(instructions);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(Courses));
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setBounds(355, 180, 171, 36);
		comboBox.setSelectedIndex(-1);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Selected_course=(String)comboBox.getSelectedItem();
				courseDetail(Selected_course);
				
				instructions.setText("\n INSTRUCTIONS\r\n\r\n 1. There are total of "+totalQuestions+" questions in this quiz. Each will give you "+eachMark+" marks.\r\n 2. Maximum time is "+time+" .\r\n 3. When the time is up you will be automatically logged out.\r\n 4. You can see the time left on the upper right corner.");
				instructions.setVisible(true);
				revalidate();
			}
		});
				
		JLabel lblSelectCourse = new JLabel("SELECT EXAM");
		lblSelectCourse.setForeground(UIManager.getColor("CheckBoxMenuItem.foreground"));
		lblSelectCourse.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSelectCourse.setBounds(170, 184, 180, 28);
		add(lblSelectCourse);
		
		
		
		JButton btnEditDetails = new JButton("EDIT DETAILS");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Edit Details of User with the username
				new EditDetails(Username);
			}
		});
		btnEditDetails.setForeground(new Color(255, 255, 255));
		btnEditDetails.setBackground(new Color(0, 0, 0));
		btnEditDetails.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnEditDetails.setBounds(815, 11, 166, 42);
		add(btnEditDetails);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Save Data if any.
				MainFrame.AddPanel(new UserLogin());
				JOptionPane.showMessageDialog(null, "Logout Successfully");
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.setBounds(10, 11, 152, 36);
		add(btnLogout);
		
		JLabel WlecomeLabel = new JLabel("WELCOME! "+Name.toUpperCase()+",");
		WlecomeLabel.setForeground(new Color(0, 0, 0));
		WlecomeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		WlecomeLabel.setBounds(10, 107, 445, 28);
		add(WlecomeLabel);
	}
}
