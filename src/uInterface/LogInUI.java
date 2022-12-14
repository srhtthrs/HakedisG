package uInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import HakEdisDomain.Degiskenler;

import javax.swing.border.EtchedBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInUI frame = new LogInUI();
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
	public LogInUI() {
		setResizable(false);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 358);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBorder(null);
		textField.setBounds(103, 120, 259, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(103, 166, 259, 35);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Giris");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(241, 212, 121, 28);
		contentPane.add(btnNewButton);
		
		
		JComboBox comboBox = new JComboBox(Degiskenler.getMudurlukler());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(103, 74, 259, 35);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Mudurluk");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(21, 74, 72, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblSicil = new JLabel("Sicil");
		lblSicil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSicil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSicil.setForeground(Color.WHITE);
		lblSicil.setBounds(21, 120, 72, 35);
		contentPane.add(lblSicil);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParola.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParola.setForeground(Color.WHITE);
		lblParola.setBounds(21, 166, 72, 35);
		contentPane.add(lblParola);
		
		Icon iconKus2=new ImageIcon("Icons/pttkus.png");
		JLabel lblNewLabel_1 = new JLabel(iconKus2);
		lblNewLabel_1.setBounds(380, 74, 180, 128);
		contentPane.add(lblNewLabel_1);
		
		JButton btnUyeOl = new JButton("Uye Ol");
		btnUyeOl.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUyeOl.setForeground(Color.WHITE);
		btnUyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LogInUI.this.dispose();
				UyeOlUI mPane2sls=new UyeOlUI();
				mPane2sls.setVisible(true);
				
			}
		});
		btnUyeOl.setBorder(new LineBorder(Color.WHITE));
		btnUyeOl.setBackground(SystemColor.activeCaption);
		btnUyeOl.setBounds(103, 212, 121, 28);
		contentPane.add(btnUyeOl);
	}
}
