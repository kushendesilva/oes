package main;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.LoginPanel;

public class Panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel1() {
		setLayout(null);
		
		JButton btnNext = new JButton("LOGIN");
		btnNext.setFocusable(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new LoginPanel());
			}
		});
		btnNext.setForeground(new Color(253, 245, 230));
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNext.setBackground(new Color(0, 0, 0));
		btnNext.setBounds(892, 511, 89, 36);
		add(btnNext);
		
		JButton btnNewButton = new JButton("INFO");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Help());
			}
		});
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("ONLINE EXAMINATION");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("SansSerif", Font.BOLD, 41));
		lblOnlineExamination.setBounds(198, 150, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setForeground(new Color(0, 0, 0));
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setFont(new Font("SansSerif", Font.BOLD, 41));
		lblSystem.setBounds(198, 250, 603, 105);
		add(lblSystem);

		JLabel lblAuthor = new JLabel("DEVELOPED BY - KUSHEN DE SILVA");
		lblAuthor.setForeground(new Color(0, 0, 0));
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblAuthor.setBounds(198, 325, 603, 105);
		add(lblAuthor);
	}
}
