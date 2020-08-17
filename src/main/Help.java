package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JPanel {

	/**
	 * Create the panel.
	 */
	public Help() {
		setFocusable(false);
		setEnabled(false);
		setLayout(null);
		
		JTextArea txtrAboutHelpLine = new JTextArea();
		txtrAboutHelpLine.setEditable(false);
		txtrAboutHelpLine.setForeground(Color.WHITE);
		txtrAboutHelpLine.setBackground(new Color(0, 0, 0));
		txtrAboutHelpLine.setLineWrap(true);
		txtrAboutHelpLine.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtrAboutHelpLine.setRows(30);
		txtrAboutHelpLine.setText("\n Welcome!\r\n\r\n This is an Online Examination System(OES) which I developed for my 2nd\n graded unit of my HND in Computer Science.\r\n This project consists of many swing components like JPanel, Jframe, etc.\r\n\n\n\n\n\r\n Project Made by : Kushen De Silva (18s07034)\r\n\r\r\n");
		txtrAboutHelpLine.setBounds(177, 91, 637, 342);
		add(txtrAboutHelpLine);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(250, 78, 491, 2);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("OES");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(415, 24, 160, 47);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Panel1());
			}
		});
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
}
