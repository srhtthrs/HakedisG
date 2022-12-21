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

import HakEdisDatabase.UyelikDataBaseSQL;
import HakEdisDomain.Degiskenler;
import HakEdisDomain.UyelikDomain;

import javax.swing.border.EtchedBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSicil;
	private JTextField textFieldSifre;

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
		
		textFieldSicil = new JTextField();
		textFieldSicil.setBackground(Color.WHITE);
		textFieldSicil.setBorder(null);
		textFieldSicil.setBounds(282, 106, 259, 35);
		contentPane.add(textFieldSicil);
		textFieldSicil.setColumns(10);
		
		textFieldSifre = new JTextField();
		textFieldSifre.setColumns(10);
		textFieldSifre.setBorder(null);
		textFieldSifre.setBackground(Color.WHITE);
		textFieldSifre.setBounds(282, 152, 259, 35);
		contentPane.add(textFieldSifre);
		
		JButton btnNewButton = new JButton("Giris");
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(420, 198, 121, 28);
		contentPane.add(btnNewButton);
		
		
		JComboBox comboBoxMudurluk = new JComboBox(Degiskenler.getMudurlukler());
		comboBoxMudurluk.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxMudurluk.setBorder(null);
		comboBoxMudurluk.setBackground(Color.WHITE);
		comboBoxMudurluk.setBounds(282, 60, 259, 35);
		contentPane.add(comboBoxMudurluk);
		
		JLabel lblNewLabel = new JLabel("Mudurluk");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(200, 60, 72, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblSicil = new JLabel("Sicil");
		lblSicil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSicil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSicil.setForeground(Color.WHITE);
		lblSicil.setBounds(200, 106, 72, 35);
		contentPane.add(lblSicil);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParola.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParola.setForeground(Color.WHITE);
		lblParola.setBounds(200, 152, 72, 35);
		contentPane.add(lblParola);
		
		Icon iconKus2=new ImageIcon("Icons/pttkus.png");
		JLabel lblNewLabel_1 = new JLabel(iconKus2);
		lblNewLabel_1.setBounds(10, 59, 180, 128);
		contentPane.add(lblNewLabel_1);
		
		JButton btnUyeOl = new JButton("Uye Ol");
		btnUyeOl.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUyeOl.setForeground(Color.BLACK);
		btnUyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LogInUI.this.dispose();
				UyeOlUI mPane2sls=new UyeOlUI();
				mPane2sls.setVisible(true);
				
			}
		});
		btnUyeOl.setBorder(new LineBorder(Color.WHITE));
		btnUyeOl.setBackground(SystemColor.activeCaption);
		btnUyeOl.setBounds(282, 198, 121, 28);
		contentPane.add(btnUyeOl);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogInUI.this.dispose();
				AdminUi mPane2sl=new AdminUi();
				mPane2sl.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 285, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String sicilAl=textFieldSicil.getText().toString();
			String mudurlukAl=comboBoxMudurluk.getSelectedItem().toString();
			String sifreAl=textFieldSifre.getText().toString();
			
			
			
			
			
				
				if(UyelikDataBaseSQL.kullaniciGirisKontrol(sicilAl,mudurlukAl,sifreAl,"onaylandi")) {
				
				MudurlukPanel2.MudurlukveSicilGetir(sicilAl,mudurlukAl);
						
				LogInUI.this.dispose();
				MudurlukPanel2 mPane2sls=new MudurlukPanel2();
				mPane2sls.setVisible(true);
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Hatali Giris");
				}
				
				
			}
		});
	}
}
