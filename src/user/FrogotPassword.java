package user;

import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class FrogotPassword extends JPanel implements FocusListener{
	private JTextField txtUsername;
	JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public FrogotPassword() {

		setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
			}
		});
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(355, 400, 557, 62);
		add(lblNewLabel_1);
		
		JButton btnGetYourPassword = new JButton("CHECK");
		btnGetYourPassword.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnGetYourPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsername.getForeground()!=SystemColor.controlShadow)
				{
					String Pass=UserLogin.exixtsUsername(txtUsername.getText());
					if(Pass!=null)
					{
						lblNewLabel_1.setText("Please Contact your lecturer.");
						System.out.println("Password : "+Pass);
					}
					else
					{
						lblNewLabel_1.setText("You are not a registered user.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Enter username");
				}
			}
		});
		btnGetYourPassword.setBounds(413, 270, 164, 36);
		btnGetYourPassword.setForeground(Color.WHITE);
		btnGetYourPassword.setBackground(new Color(0, 0, 0));
		add(btnGetYourPassword);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(SystemColor.controlShadow);
		txtUsername.setText("USERNAME");
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsername.setBounds(347, 206, 297, 36);
		add(txtUsername);
		txtUsername.addFocusListener(this);
			
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("FORGOT PASSWORD");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 41));
		lblOnlineExamination.setBounds(194, 22, 603, 105);
		add(lblOnlineExamination);
	}
	public void focusGained(FocusEvent arg0) {
		if(arg0.getSource()==txtUsername && txtUsername.getForeground()==SystemColor.controlShadow)
		{
			txtUsername.setText("");
			txtUsername.setForeground(Color.black);
			txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		}
		
	}
	public void focusLost(FocusEvent arg0) {
		if(txtUsername.getText().equals(""))
		{
			txtUsername.setForeground(SystemColor.controlShadow);
			txtUsername.setText("USERNAME");
			txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
	}
}