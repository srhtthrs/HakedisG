package uInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import HakEdisDomain.Degiskenler;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UyeOlUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblAdSoyad;
	private JLabel lblSifre;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JLabel lblSifreTekrar;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnGeri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeOlUI frame = new UyeOlUI();
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
	public UyeOlUI() {
		setTitle("Sifre Al");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 494);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 374, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(115, 71, 249, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 116, 249, 34);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 204, 249, 34);
		panel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Sicil");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 71, 71, 34);
		panel.add(lblNewLabel);
		
		lblAdSoyad = new JLabel("Ad Soyad");
		lblAdSoyad.setForeground(Color.WHITE);
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdSoyad.setBounds(10, 116, 71, 34);
		panel.add(lblAdSoyad);
		
		lblSifre = new JLabel("Sifre");
		lblSifre.setForeground(Color.WHITE);
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSifre.setBounds(10, 204, 71, 34);
		panel.add(lblSifre);
		
		
		comboBox = new JComboBox(Degiskenler.getMudurlukler());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setBounds(115, 161, 249, 32);
		panel.add(comboBox);
		
		lblNewLabel_1 = new JLabel("Mudurluk");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 161, 71, 34);
		panel.add(lblNewLabel_1);
		
		lblSifreTekrar = new JLabel("Sifre Tekrar");
		lblSifreTekrar.setForeground(Color.WHITE);
		lblSifreTekrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSifreTekrar.setBounds(10, 249, 71, 34);
		panel.add(lblSifreTekrar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 249, 249, 34);
		panel.add(textField_3);
		
		btnNewButton = new JButton("Gonder");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setBounds(250, 294, 114, 34);
		panel.add(btnNewButton);
		
		btnGeri = new JButton("Geri");
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeri.setForeground(Color.WHITE);
		btnGeri.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UyeOlUI.this.dispose();
				LogInUI mPane2sls=new LogInUI();
				mPane2sls.setVisible(true);
			}
		});
		btnGeri.setBackground(SystemColor.activeCaption);
		btnGeri.setBounds(115, 294, 114, 34);
		panel.add(btnGeri);
	}
}
