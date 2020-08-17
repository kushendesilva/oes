package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import admin.AdminPanel;
import user.UserLogin;
import main.MainFrame;
import main.Panel1;

public class LoginPanel extends JPanel {
	private JButton btnUser;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Panel1());
			}
		});
		
		JButton btnAdmin = new JButton("LECTURERS");
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
			}
		});
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setBackground(new Color(0, 0, 0));
		btnAdmin.setFont(new Font("SansSerif", Font.BOLD, 24));
		btnAdmin.setBounds(256, 322, 478, 99);
		add(btnAdmin);
		
		btnUser = new JButton("STUDENTS");
		btnUser.setFocusable(false);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
			}
		});
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setBackground(new Color(0, 0, 0));
		btnUser.setFont(new Font("SansSerif", Font.BOLD, 24));
		btnUser.setBounds(256, 212, 478, 99);
		add(btnUser);
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("LOGIN");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblOnlineExamination.setBounds(388, 46, 214, 105);
		add(lblOnlineExamination);


	}

}
