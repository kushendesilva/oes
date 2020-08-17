package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import login.LoginPanel;
import main.MainFrame;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class AdminPanel extends JPanel implements FocusListener{
	private JTextField txtUsername;

	/**
	 * Create the panel.
	 */
	static String password="admin";
	public AdminPanel() {
		setLayout(null);

		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(new Color(92, 92, 92));
		pwdPassword.setEchoChar('*');
		pwdPassword.setFont(new Font("SansSerif", Font.PLAIN, 12));
		pwdPassword.setText("");
		pwdPassword.setBounds(445, 191, 215, 36);
		add(pwdPassword);
		pwdPassword.addFocusListener(this);

		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(92, 92, 92));
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtUsername.setText("");
		txtUsername.setBounds(445, 137, 215, 36);
		add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.addFocusListener(this);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsername.getText().equals("admin") && pwdPassword.getText().equals(password))
				{
					//goto Main Admin Panel
					MainFrame.AddPanel(new MainAdmin());
				}
				else
				{
					//Show error popup message
					JOptionPane.showMessageDialog(null, "Password or Username is wrong.");
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(415, 246, 160, 56);
		add(btnLogin);


		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new LoginPanel());
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);

		JLabel lblOnlineExamination = new JLabel("Lecturer LOGIN");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblOnlineExamination.setBounds(327, 57, 338, 44);
		add(lblOnlineExamination);

		JLabel lblusername = new JLabel("USERNAME:");
		lblusername.setForeground(new Color(0, 0, 0));
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblusername.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblusername.setBounds(220, 134, 338, 44);
		add(lblusername);

		JLabel lblpassword = new JLabel("PASSWORD:");
		lblpassword.setForeground(new Color(0, 0, 0));
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblpassword.setBounds(220, 188, 338, 44);
		add(lblpassword);
	}

	private JPasswordField pwdPassword;

	public void focusGained(FocusEvent arg0) {
		if(arg0.getSource()==pwdPassword && pwdPassword.getForeground()==Color.LIGHT_GRAY)
		{
			pwdPassword.setText("");
			pwdPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
			pwdPassword.setForeground(new Color(0, 0, 0));
		}
		if(arg0.getSource()==txtUsername && txtUsername.getForeground()==Color.LIGHT_GRAY)
		{
			txtUsername.setText("");
			txtUsername.setFont(new Font("SansSerif", Font.BOLD, 18));
			txtUsername.setForeground(new Color(0, 0, 0));
		}

	}

	@SuppressWarnings("deprecation")
	public void focusLost(FocusEvent arg0) {
		if(pwdPassword.getText().equals(""))
		{
			pwdPassword.setFont(new Font("SansSerif", Font.PLAIN, 12));
			pwdPassword.setText("");
			pwdPassword.setForeground(new Color(90, 90, 90));
		}
		if(txtUsername.getText().equals(""))
		{
			txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 12));
			txtUsername.setText("");
			txtUsername.setForeground(new Color(90, 90, 90));
		}
	}
}
