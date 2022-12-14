package uInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

import HakEdisDatabase.DataBaseConn;
import HakEdisDatabase.DataBaseSQL;

import HakEdisDomain.TaseronPersonelDomain;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ComboBoxModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

public class MudurlukPanel extends JFrame {

	private JPanel contentPane;
	
	
	
	String secilenTarih;
	
	int yil,ay; 
	
	String secilenTarihAyAl, secilenTarihYilAl;
	
	float gO,hT,yI,r2GUR,r2GAR,cI,rT,oI,bI,eI,iI,dI,gE,tGC;
	float yG=0.0f;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudurlukPanel frame = new MudurlukPanel();
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
	public MudurlukPanel() {
		
		setTitle("...... Mudurlugu");
		setResizable(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1548, 838);
		contentPane = new JPanel();
		
		
		
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		String [] gunler = {"Gorevde", 
							"Hafta Tatili",
							"Yillik Izin",
							"2 Gun Ustu Rapor",
							"2 Gun Alti Rapor",	
							"Cikis (15 Gun ve Alti)",
							"Resmi Tatil",
							"Olum izni",
							"Babalik Izni",
							"Evlilik Izni",
							"Idari Izin",							 
							"Dogum Izni",							
							"Yarim Gun", 						 
							"Gelmedi.Gorevde.Yok",																				
							"Tatil Gunu Calisma"									
							};
		
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(10, 290, 193, 498);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(311, 11, 1211, 268);
		contentPane.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("1");
		label1.setBorder(new LineBorder(new Color(0, 0, 0)));
		label1.setForeground(new Color(0, 0, 0));
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 50, 30, 26);
		panel.add(label1);
		
		JLabel labelGorevde = new JLabel("Gorevde");
		labelGorevde.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGorevde.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelGorevde.setForeground(new Color(255, 255, 255));
		labelGorevde.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGorevde.setBounds(10, 11, 132, 14);
		panel_3.add(labelGorevde);
		
		JLabel labelGorevdeSay = new JLabel("0");
		labelGorevdeSay.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelGorevdeSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGorevdeSay.setForeground(Color.WHITE);
		labelGorevdeSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelGorevdeSay.setBounds(152, 11, 36, 14);
		panel_3.add(labelGorevdeSay);
		
		JLabel labelHaftaTatiliSay = new JLabel("0");
		labelHaftaTatiliSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelHaftaTatiliSay.setForeground(Color.WHITE);
		labelHaftaTatiliSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelHaftaTatiliSay.setBounds(152, 36, 36, 14);
		panel_3.add(labelHaftaTatiliSay);
		
		JLabel labelHaftaTatili = new JLabel("Hafta Tatili");
		labelHaftaTatili.setHorizontalAlignment(SwingConstants.RIGHT);
		labelHaftaTatili.setForeground(Color.WHITE);
		labelHaftaTatili.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelHaftaTatili.setBounds(10, 36, 132, 14);
		panel_3.add(labelHaftaTatili);
		
		JLabel labelYillikIzinSay = new JLabel("0");
		labelYillikIzinSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYillikIzinSay.setForeground(Color.WHITE);
		labelYillikIzinSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYillikIzinSay.setBounds(152, 61, 36, 14);
		panel_3.add(labelYillikIzinSay);
		
		JLabel labelYillikIzin = new JLabel("Yillik Izin");
		labelYillikIzin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYillikIzin.setForeground(Color.WHITE);
		labelYillikIzin.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYillikIzin.setBounds(10, 61, 132, 14);
		panel_3.add(labelYillikIzin);
		
		JLabel label2gunUstuRaporSay = new JLabel("0");
		label2gunUstuRaporSay.setHorizontalAlignment(SwingConstants.CENTER);
		label2gunUstuRaporSay.setForeground(Color.WHITE);
		label2gunUstuRaporSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2gunUstuRaporSay.setBounds(152, 86, 36, 14);
		panel_3.add(label2gunUstuRaporSay);
		
		JLabel label2gunUstuRapor = new JLabel("2 Gun Ustu Rapor");
		label2gunUstuRapor.setHorizontalAlignment(SwingConstants.RIGHT);
		label2gunUstuRapor.setForeground(Color.WHITE);
		label2gunUstuRapor.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2gunUstuRapor.setBounds(10, 86, 132, 14);
		panel_3.add(label2gunUstuRapor);
		
		JLabel label2gunAltiRapor = new JLabel("2 Gun Alti Rapor");
		label2gunAltiRapor.setHorizontalAlignment(SwingConstants.RIGHT);
		label2gunAltiRapor.setForeground(Color.WHITE);
		label2gunAltiRapor.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2gunAltiRapor.setBounds(10, 111, 132, 14);
		panel_3.add(label2gunAltiRapor);
		
		JLabel label2gunAltiRaporSay = new JLabel("0");
		label2gunAltiRaporSay.setHorizontalAlignment(SwingConstants.CENTER);
		label2gunAltiRaporSay.setForeground(Color.WHITE);
		label2gunAltiRaporSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2gunAltiRaporSay.setBounds(152, 111, 36, 14);
		panel_3.add(label2gunAltiRaporSay);
		
		JLabel labelCikis = new JLabel("Cikis (15 Gun ve Alti)");
		labelCikis.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCikis.setForeground(Color.WHITE);
		labelCikis.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCikis.setBounds(10, 136, 132, 14);
		panel_3.add(labelCikis);
		
		JLabel labelCikisSay = new JLabel("0");
		labelCikisSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelCikisSay.setForeground(Color.WHITE);
		labelCikisSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCikisSay.setBounds(152, 136, 36, 14);
		panel_3.add(labelCikisSay);
		
		JLabel labelResmiTatil = new JLabel("Resmi Tatil");
		labelResmiTatil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResmiTatil.setForeground(Color.WHITE);
		labelResmiTatil.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResmiTatil.setBounds(10, 161, 132, 14);
		panel_3.add(labelResmiTatil);
		
		JLabel labelResmiTatilSay = new JLabel("0");
		labelResmiTatilSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelResmiTatilSay.setForeground(Color.WHITE);
		labelResmiTatilSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelResmiTatilSay.setBounds(152, 161, 36, 14);
		panel_3.add(labelResmiTatilSay);
		
		JLabel labelOlumIzni = new JLabel("Olum Izni");
		labelOlumIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOlumIzni.setForeground(Color.WHITE);
		labelOlumIzni.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelOlumIzni.setBounds(10, 186, 132, 14);
		panel_3.add(labelOlumIzni);
		
		JLabel labelOlumIzniSay = new JLabel("0");
		labelOlumIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelOlumIzniSay.setForeground(Color.WHITE);
		labelOlumIzniSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelOlumIzniSay.setBounds(152, 186, 36, 14);
		panel_3.add(labelOlumIzniSay);
		
		JLabel labelBabalikIzni = new JLabel("Babalik Izni");
		labelBabalikIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBabalikIzni.setForeground(Color.WHITE);
		labelBabalikIzni.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelBabalikIzni.setBounds(10, 211, 132, 14);
		panel_3.add(labelBabalikIzni);
		
		JLabel labelBabalikIzniSay = new JLabel("0");
		labelBabalikIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelBabalikIzniSay.setForeground(Color.WHITE);
		labelBabalikIzniSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelBabalikIzniSay.setBounds(152, 211, 36, 14);
		panel_3.add(labelBabalikIzniSay);
		
		JLabel labelEvlilikIzni = new JLabel("Evlilik Izni");
		labelEvlilikIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEvlilikIzni.setForeground(Color.WHITE);
		labelEvlilikIzni.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelEvlilikIzni.setBounds(10, 236, 132, 14);
		panel_3.add(labelEvlilikIzni);
		
		JLabel labelEvlilikIzniSay = new JLabel("0");
		labelEvlilikIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelEvlilikIzniSay.setForeground(Color.WHITE);
		labelEvlilikIzniSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelEvlilikIzniSay.setBounds(152, 236, 36, 14);
		panel_3.add(labelEvlilikIzniSay);
		
		JLabel labelIdariIzin = new JLabel("Idari Izin");
		labelIdariIzin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIdariIzin.setForeground(Color.WHITE);
		labelIdariIzin.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelIdariIzin.setBounds(10, 261, 132, 14);
		panel_3.add(labelIdariIzin);
		
		JLabel labelIdariIzinSay = new JLabel("0");
		labelIdariIzinSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelIdariIzinSay.setForeground(Color.WHITE);
		labelIdariIzinSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelIdariIzinSay.setBounds(152, 261, 36, 14);
		panel_3.add(labelIdariIzinSay);
		
		JLabel labelDogumIzni = new JLabel("Dogum Izni");
		labelDogumIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDogumIzni.setForeground(Color.WHITE);
		labelDogumIzni.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDogumIzni.setBounds(10, 286, 132, 14);
		panel_3.add(labelDogumIzni);
		
		JLabel labelDogumIzniSay = new JLabel("0");
		labelDogumIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelDogumIzniSay.setForeground(Color.WHITE);
		labelDogumIzniSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDogumIzniSay.setBounds(152, 286, 36, 14);
		panel_3.add(labelDogumIzniSay);
		
		JLabel labelYarimGun = new JLabel("Yarim Gun");
		labelYarimGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYarimGun.setForeground(Color.WHITE);
		labelYarimGun.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYarimGun.setBounds(10, 311, 132, 14);
		panel_3.add(labelYarimGun);
		
		JLabel labelYarimGunSay = new JLabel("0");
		labelYarimGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYarimGunSay.setForeground(Color.WHITE);
		labelYarimGunSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYarimGunSay.setBounds(152, 311, 36, 14);
		panel_3.add(labelYarimGunSay);
		
		JLabel labelGelmedi = new JLabel("Gelmedi, Gorevde Yok");
		labelGelmedi.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGelmedi.setForeground(Color.WHITE);
		labelGelmedi.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGelmedi.setBounds(10, 336, 132, 14);
		panel_3.add(labelGelmedi);
		
		JLabel labelGelmediSay = new JLabel("0");
		labelGelmediSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelGelmediSay.setForeground(Color.WHITE);
		labelGelmediSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGelmediSay.setBounds(152, 336, 36, 14);
		panel_3.add(labelGelmediSay);
		
		JLabel labelTatilGunuCalisma = new JLabel("Tatil Gunu Calisma");
		labelTatilGunuCalisma.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTatilGunuCalisma.setForeground(Color.WHITE);
		labelTatilGunuCalisma.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTatilGunuCalisma.setBounds(10, 361, 132, 14);
		panel_3.add(labelTatilGunuCalisma);
		
		JLabel labelTatilGunuCalismaSay = new JLabel("0");
		labelTatilGunuCalismaSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelTatilGunuCalismaSay.setForeground(Color.WHITE);
		labelTatilGunuCalismaSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTatilGunuCalismaSay.setBounds(152, 361, 36, 14);
		panel_3.add(labelTatilGunuCalismaSay);
		
		JLabel labelYemekUcretiVerGun = new JLabel("Yemek Ucreti Vrlck Gun");
		labelYemekUcretiVerGun.setBounds(10, 436, 132, 14);
		panel_3.add(labelYemekUcretiVerGun);
		labelYemekUcretiVerGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYemekUcretiVerGun.setForeground(new Color(128, 0, 0));
		labelYemekUcretiVerGun.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYemekUcretiVerGun.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel labelYolUcretiVerilecekGun = new JLabel("Yol Ucreti Verlck Gun");
		labelYolUcretiVerilecekGun.setBounds(10, 411, 132, 14);
		panel_3.add(labelYolUcretiVerilecekGun);
		labelYolUcretiVerilecekGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYolUcretiVerilecekGun.setForeground(new Color(128, 0, 0));
		labelYolUcretiVerilecekGun.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYolUcretiVerilecekGun.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel labelMaasHesaplacakGun = new JLabel("Ucret Verilecek Gun");
		labelMaasHesaplacakGun.setBounds(10, 386, 132, 14);
		panel_3.add(labelMaasHesaplacakGun);
		labelMaasHesaplacakGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMaasHesaplacakGun.setForeground(new Color(128, 0, 0));
		labelMaasHesaplacakGun.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMaasHesaplacakGun.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel labelMaasHesaplacakGunSay = new JLabel("0");
		labelMaasHesaplacakGunSay.setBounds(152, 386, 36, 14);
		panel_3.add(labelMaasHesaplacakGunSay);
		labelMaasHesaplacakGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaasHesaplacakGunSay.setForeground(new Color(128, 0, 0));
		labelMaasHesaplacakGunSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMaasHesaplacakGunSay.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel labelYolUcretiVerilecekGunSay = new JLabel("0");
		labelYolUcretiVerilecekGunSay.setBounds(152, 411, 36, 14);
		panel_3.add(labelYolUcretiVerilecekGunSay);
		labelYolUcretiVerilecekGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYolUcretiVerilecekGunSay.setForeground(new Color(128, 0, 0));
		labelYolUcretiVerilecekGunSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYolUcretiVerilecekGunSay.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel labelYemekUcretiVerGunSay = new JLabel("0");
		labelYemekUcretiVerGunSay.setBounds(152, 436, 36, 14);
		panel_3.add(labelYemekUcretiVerGunSay);
		labelYemekUcretiVerGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYemekUcretiVerGunSay.setForeground(new Color(128, 0, 0));
		labelYemekUcretiVerGunSay.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelYemekUcretiVerGunSay.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		
		
		JButton BtnGunAdetleriOnayla = new JButton("Onayla");
		BtnGunAdetleriOnayla.setBounds(85, 461, 98, 26);
		panel_3.add(BtnGunAdetleriOnayla);
		BtnGunAdetleriOnayla.setBackground(UIManager.getColor("Button.light"));
		BtnGunAdetleriOnayla.setFont(new Font("Tahoma", Font.BOLD, 12));
	
		
		JComboBox comboBox2 = new JComboBox(gunler);
		
		
		
		comboBox2.setSelectedIndex(0);
		comboBox2.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox2.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setBounds(219, 50, 122, 29);
		panel.add(comboBox2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("02");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(179, 50, 30, 26);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox3 = new JComboBox(gunler);
		comboBox3.setSelectedIndex(0);
		comboBox3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox3.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox3.setBackground(Color.WHITE);
		comboBox3.setBounds(391, 51, 122, 29);
		panel.add(comboBox3);
		
		JLabel lblNewLabel_2 = new JLabel("03");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(351, 51, 30, 26);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox4 = new JComboBox(gunler);
		comboBox4.setSelectedIndex(0);
		comboBox4.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox4.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox4.setBackground(Color.WHITE);
		comboBox4.setBounds(563, 50, 122, 29);
		panel.add(comboBox4);
		
		JLabel lblNewLabel_3 = new JLabel("04");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(523, 50, 30, 26);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox5 = new JComboBox(gunler);
		comboBox5.setSelectedIndex(0);
		comboBox5.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox5.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox5.setBackground(Color.WHITE);
		comboBox5.setBounds(735, 50, 122, 29);
		panel.add(comboBox5);
		
		JLabel lblNewLabel_4 = new JLabel("05");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(695, 50, 30, 26);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox6 = new JComboBox(gunler);
		comboBox6.setSelectedIndex(0);
		comboBox6.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox6.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox6.setBackground(Color.WHITE);
		comboBox6.setBounds(907, 50, 122, 29);
		panel.add(comboBox6);
		
		JLabel lblNewLabel_5 = new JLabel("06");
		lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(867, 50, 30, 26);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox7 = new JComboBox(gunler);
		comboBox7.setSelectedIndex(0);
		comboBox7.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox7.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox7.setBackground(Color.WHITE);
		comboBox7.setBounds(1079, 50, 122, 29);
		panel.add(comboBox7);
		
		JLabel lblNewLabel_6 = new JLabel("07");
		lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(1039, 50, 30, 26);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("08");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 87, 30, 26);
		panel.add(lblNewLabel_7);
		
		JComboBox comboBox8 = new JComboBox(gunler);
		comboBox8.setSelectedIndex(0);
		comboBox8.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox8.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox8.setBackground(Color.WHITE);
		comboBox8.setBounds(50, 87, 122, 29);
		panel.add(comboBox8);
		
		JLabel lblNewLabel_1_1 = new JLabel("09");
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(179, 87, 30, 26);
		panel.add(lblNewLabel_1_1);
		
		JComboBox comboBox9 = new JComboBox(gunler);
		comboBox9.setSelectedIndex(0);
		comboBox9.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox9.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox9.setBackground(Color.WHITE);
		comboBox9.setBounds(219, 87, 122, 29);
		panel.add(comboBox9);
		
		JLabel lblNewLabel_2_1 = new JLabel("10");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(351, 88, 30, 26);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox10 = new JComboBox(gunler);
		comboBox10.setSelectedIndex(0);
		comboBox10.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox10.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox10.setBackground(Color.WHITE);
		comboBox10.setBounds(391, 88, 122, 29);
		panel.add(comboBox10);
		
		JLabel lblNewLabel_3_1 = new JLabel("11");
		lblNewLabel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(523, 87, 30, 26);
		panel.add(lblNewLabel_3_1);
		
		JComboBox comboBox11 = new JComboBox(gunler);
		comboBox11.setSelectedIndex(0);
		comboBox11.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox11.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox11.setBackground(Color.WHITE);
		comboBox11.setBounds(563, 87, 122, 29);
		panel.add(comboBox11);
		
		JLabel lblNewLabel_4_1 = new JLabel("12");
		lblNewLabel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(695, 87, 30, 26);
		panel.add(lblNewLabel_4_1);
		
		JComboBox comboBox12 = new JComboBox(gunler);
		comboBox12.setSelectedIndex(0);
		comboBox12.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox12.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox12.setBackground(Color.WHITE);
		comboBox12.setBounds(735, 87, 122, 29);
		panel.add(comboBox12);
		
		JLabel lblNewLabel_5_1 = new JLabel("13");
		lblNewLabel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(867, 87, 30, 26);
		panel.add(lblNewLabel_5_1);
		
		JComboBox comboBox13 = new JComboBox(gunler);
		comboBox13.setSelectedIndex(0);
		comboBox13.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox13.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox13.setBackground(Color.WHITE);
		comboBox13.setBounds(907, 87, 122, 29);
		panel.add(comboBox13);
		
		JLabel lblNewLabel_6_1 = new JLabel("14");
		lblNewLabel_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(1039, 87, 30, 26);
		panel.add(lblNewLabel_6_1);
		
		JComboBox comboBox14 = new JComboBox(gunler);
		comboBox14.setSelectedIndex(0);
		comboBox14.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox14.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox14.setBackground(Color.WHITE);
		comboBox14.setBounds(1079, 87, 122, 29);
		panel.add(comboBox14);
		
		JLabel lblNewLabel_8 = new JLabel("15");
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 127, 30, 26);
		panel.add(lblNewLabel_8);
		
		JComboBox comboBox15 = new JComboBox(gunler);
		comboBox15.setSelectedIndex(0);
		comboBox15.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox15.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox15.setBackground(Color.WHITE);
		comboBox15.setBounds(50, 127, 122, 29);
		panel.add(comboBox15);
		
		JLabel lblNewLabel_1_2 = new JLabel("16");
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(179, 127, 30, 26);
		panel.add(lblNewLabel_1_2);
		
		JComboBox comboBox16 = new JComboBox(gunler);
		comboBox16.setSelectedIndex(0);
		comboBox16.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox16.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox16.setBackground(Color.WHITE);
		comboBox16.setBounds(219, 127, 122, 29);
		panel.add(comboBox16);
		
		JLabel lblNewLabel_2_2 = new JLabel("17");
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(351, 128, 30, 26);
		panel.add(lblNewLabel_2_2);
		
		JComboBox comboBox17 = new JComboBox(gunler);
		comboBox17.setSelectedIndex(0);
		comboBox17.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox17.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox17.setBackground(Color.WHITE);
		comboBox17.setBounds(391, 128, 122, 29);
		panel.add(comboBox17);
		
		JLabel lblNewLabel_3_2 = new JLabel("18");
		lblNewLabel_3_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(523, 127, 30, 26);
		panel.add(lblNewLabel_3_2);
		
		JComboBox comboBox18 = new JComboBox(gunler);
		comboBox18.setSelectedIndex(0);
		comboBox18.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox18.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox18.setBackground(Color.WHITE);
		comboBox18.setBounds(563, 127, 122, 29);
		panel.add(comboBox18);
		
		JLabel lblNewLabel_4_2 = new JLabel("19");
		lblNewLabel_4_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(695, 127, 30, 26);
		panel.add(lblNewLabel_4_2);
		
		
		
		JComboBox comboBox19 = new JComboBox(gunler);
		comboBox19.setSelectedIndex(0);
		comboBox19.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox19.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox19.setBackground(Color.WHITE);
		comboBox19.setBounds(735, 127, 122, 29);
		panel.add(comboBox19);
		
		JLabel lblNewLabel_5_2 = new JLabel("20");
		lblNewLabel_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(867, 127, 30, 26);
		panel.add(lblNewLabel_5_2);
		
		JComboBox comboBox20 = new JComboBox(gunler);
		comboBox20.setSelectedIndex(0);
		comboBox20.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox20.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox20.setBackground(Color.WHITE);
		comboBox20.setBounds(907, 127, 122, 29);
		panel.add(comboBox20);
		
		JLabel lblNewLabel_6_2 = new JLabel("21");
		lblNewLabel_6_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(1039, 127, 30, 26);
		panel.add(lblNewLabel_6_2);
		
		JComboBox comboBox21 = new JComboBox(gunler);
		comboBox21.setSelectedIndex(0);
		comboBox21.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox21.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox21.setBackground(Color.WHITE);
		comboBox21.setBounds(1079, 127, 122, 29);
		panel.add(comboBox21);
		
		JComboBox comboBox1 = new JComboBox(gunler);
		comboBox1.setBounds(50, 48, 122, 29);
		panel.add(comboBox1);
		
		comboBox1.setSelectedIndex(0);
		comboBox1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox1.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox1.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel_9 = new JLabel("22");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 167, 30, 26);
		panel.add(lblNewLabel_9);
		
		JComboBox comboBox22 = new JComboBox(gunler);
		comboBox22.setSelectedIndex(0);
		comboBox22.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox22.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox22.setBackground(Color.WHITE);
		comboBox22.setBounds(50, 167, 122, 29);
		panel.add(comboBox22);
		
		JLabel lblNewLabel_1_3 = new JLabel("23");
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(179, 167, 30, 26);
		panel.add(lblNewLabel_1_3);
		
		JComboBox comboBox23 = new JComboBox(gunler);
		comboBox23.setSelectedIndex(0);
		comboBox23.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox23.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox23.setBackground(Color.WHITE);
		comboBox23.setBounds(219, 167, 122, 29);
		panel.add(comboBox23);
		
		JLabel lblNewLabel_2_3 = new JLabel("24");
		lblNewLabel_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(351, 168, 30, 26);
		panel.add(lblNewLabel_2_3);
		
		JComboBox comboBox24 = new JComboBox(gunler);
		comboBox24.setSelectedIndex(0);
		comboBox24.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox24.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox24.setBackground(Color.WHITE);
		comboBox24.setBounds(391, 168, 122, 29);
		panel.add(comboBox24);
		
		JLabel lblNewLabel_3_3 = new JLabel("25");
		lblNewLabel_3_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(523, 167, 30, 26);
		panel.add(lblNewLabel_3_3);
		
		JComboBox comboBox25 = new JComboBox(gunler);
		comboBox25.setSelectedIndex(0);
		comboBox25.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox25.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox25.setBackground(Color.WHITE);
		comboBox25.setBounds(563, 167, 122, 29);
		panel.add(comboBox25);
		
		JLabel lblNewLabel_4_3 = new JLabel("26");
		lblNewLabel_4_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(695, 167, 30, 26);
		panel.add(lblNewLabel_4_3);
		
		JComboBox comboBox26 = new JComboBox(gunler);
		comboBox26.setSelectedIndex(0);
		comboBox26.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox26.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox26.setBackground(Color.WHITE);
		comboBox26.setBounds(735, 167, 122, 29);
		panel.add(comboBox26);
		
		JLabel lblNewLabel_5_3 = new JLabel("27");
		lblNewLabel_5_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_3.setBounds(867, 167, 30, 26);
		panel.add(lblNewLabel_5_3);
		
		JComboBox comboBox27 = new JComboBox(gunler);
		comboBox27.setSelectedIndex(0);
		comboBox27.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox27.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox27.setBackground(Color.WHITE);
		comboBox27.setBounds(907, 167, 122, 29);
		panel.add(comboBox27);
		
		JLabel lblNewLabel_6_3 = new JLabel("28");
		lblNewLabel_6_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_3.setBounds(1039, 167, 30, 26);
		panel.add(lblNewLabel_6_3);
		
		
		JComboBox comboBox28 = new JComboBox(gunler);
		comboBox28.setSelectedIndex(0);
		comboBox28.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox28.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox28.setBackground(Color.WHITE);
		comboBox28.setBounds(1079, 167, 122, 29);
		panel.add(comboBox28);
		
		JLabel label29 = new JLabel("29");
		label29.setBorder(new LineBorder(new Color(0, 0, 0)));
		label29.setForeground(new Color(0, 0, 0));
		label29.setHorizontalAlignment(SwingConstants.CENTER);
		label29.setFont(new Font("Tahoma", Font.BOLD, 14));
		label29.setBounds(10, 204, 30, 26);
		panel.add(label29);
		
		JComboBox comboBox29 = new JComboBox(gunler);
		comboBox29.setSelectedIndex(0);
		comboBox29.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox29.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox29.setBackground(Color.WHITE);
		comboBox29.setBounds(50, 204, 122, 29);
		panel.add(comboBox29);
		
		JLabel label30 = new JLabel("30");
		label30.setBorder(new LineBorder(new Color(0, 0, 0)));
		label30.setForeground(new Color(0, 0, 0));
		label30.setHorizontalAlignment(SwingConstants.CENTER);
		label30.setFont(new Font("Tahoma", Font.BOLD, 14));
		label30.setBounds(179, 204, 30, 26);
		panel.add(label30);
		
		JComboBox comboBox30 = new JComboBox(gunler);
		comboBox30.setSelectedIndex(0);
		comboBox30.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox30.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox30.setBackground(Color.WHITE);
		comboBox30.setBounds(219, 204, 122, 29);
		panel.add(comboBox30);
		
		
		
		
		JLabel label31 = new JLabel("31");
		label31.setBorder(new LineBorder(new Color(0, 0, 0)));
		label31.setForeground(new Color(0, 0, 0));
		label31.setHorizontalAlignment(SwingConstants.CENTER);
		label31.setFont(new Font("Tahoma", Font.BOLD, 14));
		label31.setBounds(351, 205, 30, 26);
		panel.add(label31);
		
		JComboBox comboBox31 = new JComboBox(gunler);
		comboBox31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox31.setSelectedIndex(0);
		comboBox31.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox31.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox31.setBackground(Color.WHITE);
		comboBox31.setBounds(391, 205, 122, 29);
		panel.add(comboBox31);
		
		JLabel labelGun1 = new JLabel("");
		labelGun1.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun1.setForeground(Color.BLACK);
		labelGun1.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun1.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun1.setBounds(10, 13, 162, 26);
		panel.add(labelGun1);
		
		JLabel labelGun2 = new JLabel("");
		labelGun2.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun2.setForeground(Color.BLACK);
		labelGun2.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun2.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun2.setBounds(179, 13, 162, 26);
		panel.add(labelGun2);
		
		JLabel labelGun3 = new JLabel("");
		labelGun3.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun3.setForeground(Color.BLACK);
		labelGun3.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun3.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun3.setBounds(351, 13, 162, 26);
		panel.add(labelGun3);
		
		JLabel labelGun4 = new JLabel("");
		labelGun4.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun4.setForeground(Color.BLACK);
		labelGun4.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun4.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun4.setBounds(523, 13, 162, 26);
		panel.add(labelGun4);
		
		JLabel labelGun5 = new JLabel("");
		labelGun5.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun5.setForeground(Color.BLACK);
		labelGun5.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun5.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun5.setBounds(695, 13, 162, 26);
		panel.add(labelGun5);
		
		JLabel labelGun6 = new JLabel("");
		labelGun6.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun6.setForeground(Color.BLACK);
		labelGun6.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun6.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun6.setBounds(867, 13, 162, 26);
		panel.add(labelGun6);
		
		JLabel labelGun7 = new JLabel("");
		labelGun7.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGun7.setForeground(Color.BLACK);
		labelGun7.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun7.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun7.setBounds(1039, 13, 162, 26);
		panel.add(labelGun7);
		
		
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHesapla.setBounds(1103, 231, 98, 26);
		panel.add(btnHesapla);
		
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				gO=0;
				hT=0;
				yI=0;
				r2GUR=0;
				r2GAR=0;
				cI=0;
				rT=0;
				oI=0;
				bI=0;
				eI=0;
				iI=0;
				dI=0;
				yG=0.0f;
				gE=0;
				tGC=0;
				
	
				
				
				
				
			
				
						 if(comboBox1.getSelectedIndex()==0){gO++;;}
					else if(comboBox1.getSelectedIndex()==1){hT++;}
					else if(comboBox1.getSelectedIndex()==2){yI++;}
					else if(comboBox1.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox1.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox1.getSelectedIndex()==5){cI++;}
					else if(comboBox1.getSelectedIndex()==6){rT++;}
					else if(comboBox1.getSelectedIndex()==7){oI++;}
					else if(comboBox1.getSelectedIndex()==8){bI++;}
					else if(comboBox1.getSelectedIndex()==9){eI++;}
					else if(comboBox1.getSelectedIndex()==10){iI++;}
					else if(comboBox1.getSelectedIndex()==11){dI++;}
					else if(comboBox1.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox1.getSelectedIndex()==13){gE++;}
					else if(comboBox1.getSelectedIndex()==14){tGC++;}
				
		
				 if(comboBox2.getSelectedIndex()==0){gO++;;}
					else if(comboBox2.getSelectedIndex()==1){hT++;}
					else if(comboBox2.getSelectedIndex()==2){yI++;}
					else if(comboBox2.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox2.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox2.getSelectedIndex()==5){cI++;}
					else if(comboBox2.getSelectedIndex()==6){rT++;}
					else if(comboBox2.getSelectedIndex()==7){oI++;}
					else if(comboBox2.getSelectedIndex()==8){bI++;}
					else if(comboBox2.getSelectedIndex()==9){eI++;}
					else if(comboBox2.getSelectedIndex()==10){iI++;}
					else if(comboBox2.getSelectedIndex()==11){dI++;}
					else if(comboBox2.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox2.getSelectedIndex()==13){gE++;}
					else if(comboBox2.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox3.getSelectedIndex()==0){gO++;;}
					else if(comboBox3.getSelectedIndex()==1){hT++;}
					else if(comboBox3.getSelectedIndex()==2){yI++;}
					else if(comboBox3.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox3.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox3.getSelectedIndex()==5){cI++;}
					else if(comboBox3.getSelectedIndex()==6){rT++;}
					else if(comboBox3.getSelectedIndex()==7){oI++;}
					else if(comboBox3.getSelectedIndex()==8){bI++;}
					else if(comboBox3.getSelectedIndex()==9){eI++;}
					else if(comboBox3.getSelectedIndex()==10){iI++;}
					else if(comboBox3.getSelectedIndex()==11){dI++;}
					else if(comboBox3.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox3.getSelectedIndex()==13){gE++;}
					else if(comboBox3.getSelectedIndex()==14){tGC++;}
			
				 if(comboBox4.getSelectedIndex()==0){gO++;;}
					else if(comboBox4.getSelectedIndex()==1){hT++;}
					else if(comboBox4.getSelectedIndex()==2){yI++;}
					else if(comboBox4.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox4.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox4.getSelectedIndex()==5){cI++;}
					else if(comboBox4.getSelectedIndex()==6){rT++;}
					else if(comboBox4.getSelectedIndex()==7){oI++;}
					else if(comboBox4.getSelectedIndex()==8){bI++;}
					else if(comboBox4.getSelectedIndex()==9){eI++;}
					else if(comboBox4.getSelectedIndex()==10){iI++;}
					else if(comboBox4.getSelectedIndex()==11){dI++;}
					else if(comboBox4.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox4.getSelectedIndex()==13){gE++;}
					else if(comboBox4.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox5.getSelectedIndex()==0){gO++;;}
					else if(comboBox5.getSelectedIndex()==1){hT++;}
					else if(comboBox5.getSelectedIndex()==2){yI++;}
					else if(comboBox5.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox5.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox5.getSelectedIndex()==5){cI++;}
					else if(comboBox5.getSelectedIndex()==6){rT++;}
					else if(comboBox5.getSelectedIndex()==7){oI++;}
					else if(comboBox5.getSelectedIndex()==8){bI++;}
					else if(comboBox5.getSelectedIndex()==9){eI++;}
					else if(comboBox5.getSelectedIndex()==10){iI++;}
					else if(comboBox5.getSelectedIndex()==11){dI++;}
					else if(comboBox5.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox5.getSelectedIndex()==13){gE++;}
					else if(comboBox5.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox6.getSelectedIndex()==0){gO++;;}
					else if(comboBox6.getSelectedIndex()==1){hT++;}
					else if(comboBox6.getSelectedIndex()==2){yI++;}
					else if(comboBox6.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox6.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox6.getSelectedIndex()==5){cI++;}
					else if(comboBox6.getSelectedIndex()==6){rT++;}
					else if(comboBox6.getSelectedIndex()==7){oI++;}
					else if(comboBox6.getSelectedIndex()==8){bI++;}
					else if(comboBox6.getSelectedIndex()==9){eI++;}
					else if(comboBox6.getSelectedIndex()==10){iI++;}
					else if(comboBox6.getSelectedIndex()==11){dI++;}
					else if(comboBox6.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox6.getSelectedIndex()==13){gE++;}
					else if(comboBox6.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox7.getSelectedIndex()==0){gO++;;}
					else if(comboBox7.getSelectedIndex()==1){hT++;}
					else if(comboBox7.getSelectedIndex()==2){yI++;}
					else if(comboBox7.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox7.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox7.getSelectedIndex()==5){cI++;}
					else if(comboBox7.getSelectedIndex()==6){rT++;}
					else if(comboBox7.getSelectedIndex()==7){oI++;}
					else if(comboBox7.getSelectedIndex()==8){bI++;}
					else if(comboBox7.getSelectedIndex()==9){eI++;}
					else if(comboBox7.getSelectedIndex()==10){iI++;}
					else if(comboBox7.getSelectedIndex()==11){dI++;}
					else if(comboBox7.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox7.getSelectedIndex()==13){gE++;}
					else if(comboBox7.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox8.getSelectedIndex()==0){gO++;;}
					else if(comboBox8.getSelectedIndex()==1){hT++;}
					else if(comboBox8.getSelectedIndex()==2){yI++;}
					else if(comboBox8.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox8.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox8.getSelectedIndex()==5){cI++;}
					else if(comboBox8.getSelectedIndex()==6){rT++;}
					else if(comboBox8.getSelectedIndex()==7){oI++;}
					else if(comboBox8.getSelectedIndex()==8){bI++;}
					else if(comboBox8.getSelectedIndex()==9){eI++;}
					else if(comboBox8.getSelectedIndex()==10){iI++;}
					else if(comboBox8.getSelectedIndex()==11){dI++;}
					else if(comboBox8.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox8.getSelectedIndex()==13){gE++;}
					else if(comboBox8.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox9.getSelectedIndex()==0){gO++;;}
					else if(comboBox9.getSelectedIndex()==1){hT++;}
					else if(comboBox9.getSelectedIndex()==2){yI++;}
					else if(comboBox9.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox9.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox9.getSelectedIndex()==5){cI++;}
					else if(comboBox9.getSelectedIndex()==6){rT++;}
					else if(comboBox9.getSelectedIndex()==7){oI++;}
					else if(comboBox9.getSelectedIndex()==8){bI++;}
					else if(comboBox9.getSelectedIndex()==9){eI++;}
					else if(comboBox9.getSelectedIndex()==10){iI++;}
					else if(comboBox9.getSelectedIndex()==11){dI++;}
					else if(comboBox9.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox9.getSelectedIndex()==13){gE++;}
					else if(comboBox9.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox10.getSelectedIndex()==0){gO++;;}
					else if(comboBox10.getSelectedIndex()==1){hT++;}
					else if(comboBox10.getSelectedIndex()==2){yI++;}
					else if(comboBox10.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox10.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox10.getSelectedIndex()==5){cI++;}
					else if(comboBox10.getSelectedIndex()==6){rT++;}
					else if(comboBox10.getSelectedIndex()==7){oI++;}
					else if(comboBox10.getSelectedIndex()==8){bI++;}
					else if(comboBox10.getSelectedIndex()==9){eI++;}
					else if(comboBox10.getSelectedIndex()==10){iI++;}
					else if(comboBox10.getSelectedIndex()==11){dI++;}
					else if(comboBox10.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox10.getSelectedIndex()==13){gE++;}
					else if(comboBox10.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox11.getSelectedIndex()==0){gO++;;}
					else if(comboBox11.getSelectedIndex()==1){hT++;}
					else if(comboBox11.getSelectedIndex()==2){yI++;}
					else if(comboBox11.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox11.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox11.getSelectedIndex()==5){cI++;}
					else if(comboBox11.getSelectedIndex()==6){rT++;}
					else if(comboBox11.getSelectedIndex()==7){oI++;}
					else if(comboBox11.getSelectedIndex()==8){bI++;}
					else if(comboBox11.getSelectedIndex()==9){eI++;}
					else if(comboBox11.getSelectedIndex()==10){iI++;}
					else if(comboBox11.getSelectedIndex()==11){dI++;}
					else if(comboBox11.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox11.getSelectedIndex()==13){gE++;}
					else if(comboBox11.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox12.getSelectedIndex()==0){gO++;;}
					else if(comboBox12.getSelectedIndex()==1){hT++;}
					else if(comboBox12.getSelectedIndex()==2){yI++;}
					else if(comboBox12.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox12.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox12.getSelectedIndex()==5){cI++;}
					else if(comboBox12.getSelectedIndex()==6){rT++;}
					else if(comboBox12.getSelectedIndex()==7){oI++;}
					else if(comboBox12.getSelectedIndex()==8){bI++;}
					else if(comboBox12.getSelectedIndex()==9){eI++;}
					else if(comboBox12.getSelectedIndex()==10){iI++;}
					else if(comboBox12.getSelectedIndex()==11){dI++;}
					else if(comboBox12.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox12.getSelectedIndex()==13){gE++;}
					else if(comboBox12.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox13.getSelectedIndex()==0){gO++;;}
					else if(comboBox13.getSelectedIndex()==1){hT++;}
					else if(comboBox13.getSelectedIndex()==2){yI++;}
					else if(comboBox13.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox13.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox13.getSelectedIndex()==5){cI++;}
					else if(comboBox13.getSelectedIndex()==6){rT++;}
					else if(comboBox13.getSelectedIndex()==7){oI++;}
					else if(comboBox13.getSelectedIndex()==8){bI++;}
					else if(comboBox13.getSelectedIndex()==9){eI++;}
					else if(comboBox13.getSelectedIndex()==10){iI++;}
					else if(comboBox13.getSelectedIndex()==11){dI++;}
					else if(comboBox13.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox13.getSelectedIndex()==13){gE++;}
					else if(comboBox13.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox14.getSelectedIndex()==0){gO++;;}
					else if(comboBox14.getSelectedIndex()==1){hT++;}
					else if(comboBox14.getSelectedIndex()==2){yI++;}
					else if(comboBox14.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox14.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox14.getSelectedIndex()==5){cI++;}
					else if(comboBox14.getSelectedIndex()==6){rT++;}
					else if(comboBox14.getSelectedIndex()==7){oI++;}
					else if(comboBox14.getSelectedIndex()==8){bI++;}
					else if(comboBox14.getSelectedIndex()==9){eI++;}
					else if(comboBox14.getSelectedIndex()==10){iI++;}
					else if(comboBox14.getSelectedIndex()==11){dI++;}
					else if(comboBox14.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox14.getSelectedIndex()==13){gE++;}
					else if(comboBox14.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox15.getSelectedIndex()==0){gO++;;}
					else if(comboBox15.getSelectedIndex()==1){hT++;}
					else if(comboBox15.getSelectedIndex()==2){yI++;}
					else if(comboBox15.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox15.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox15.getSelectedIndex()==5){cI++;}
					else if(comboBox15.getSelectedIndex()==6){rT++;}
					else if(comboBox15.getSelectedIndex()==7){oI++;}
					else if(comboBox15.getSelectedIndex()==8){bI++;}
					else if(comboBox15.getSelectedIndex()==9){eI++;}
					else if(comboBox15.getSelectedIndex()==10){iI++;}
					else if(comboBox15.getSelectedIndex()==11){dI++;}
					else if(comboBox15.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox15.getSelectedIndex()==13){gE++;}
					else if(comboBox15.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox16.getSelectedIndex()==0){gO++;;}
					else if(comboBox5.getSelectedIndex()==1){hT++;}
					else if(comboBox5.getSelectedIndex()==2){yI++;}
					else if(comboBox5.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox5.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox5.getSelectedIndex()==5){cI++;}
					else if(comboBox5.getSelectedIndex()==6){rT++;}
					else if(comboBox5.getSelectedIndex()==7){oI++;}
					else if(comboBox5.getSelectedIndex()==8){bI++;}
					else if(comboBox5.getSelectedIndex()==9){eI++;}
					else if(comboBox5.getSelectedIndex()==10){iI++;}
					else if(comboBox5.getSelectedIndex()==11){dI++;}
					else if(comboBox5.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox5.getSelectedIndex()==13){gE++;}
					else if(comboBox5.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox17.getSelectedIndex()==0){gO++;;}
					else if(comboBox17.getSelectedIndex()==1){hT++;}
					else if(comboBox17.getSelectedIndex()==2){yI++;}
					else if(comboBox17.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox17.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox17.getSelectedIndex()==5){cI++;}
					else if(comboBox17.getSelectedIndex()==6){rT++;}
					else if(comboBox17.getSelectedIndex()==7){oI++;}
					else if(comboBox17.getSelectedIndex()==8){bI++;}
					else if(comboBox17.getSelectedIndex()==9){eI++;}
					else if(comboBox17.getSelectedIndex()==10){iI++;}
					else if(comboBox17.getSelectedIndex()==11){dI++;}
					else if(comboBox17.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox17.getSelectedIndex()==13){gE++;}
					else if(comboBox17.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox18.getSelectedIndex()==0){gO++;;}
					else if(comboBox18.getSelectedIndex()==1){hT++;}
					else if(comboBox18.getSelectedIndex()==2){yI++;}
					else if(comboBox18.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox18.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox18.getSelectedIndex()==5){cI++;}
					else if(comboBox18.getSelectedIndex()==6){rT++;}
					else if(comboBox18.getSelectedIndex()==7){oI++;}
					else if(comboBox18.getSelectedIndex()==8){bI++;}
					else if(comboBox18.getSelectedIndex()==9){eI++;}
					else if(comboBox18.getSelectedIndex()==10){iI++;}
					else if(comboBox18.getSelectedIndex()==11){dI++;}
					else if(comboBox18.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox18.getSelectedIndex()==13){gE++;}
					else if(comboBox18.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox19.getSelectedIndex()==0){gO++;;}
					else if(comboBox19.getSelectedIndex()==1){hT++;}
					else if(comboBox19.getSelectedIndex()==2){yI++;}
					else if(comboBox19.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox19.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox19.getSelectedIndex()==5){cI++;}
					else if(comboBox19.getSelectedIndex()==6){rT++;}
					else if(comboBox19.getSelectedIndex()==7){oI++;}
					else if(comboBox19.getSelectedIndex()==8){bI++;}
					else if(comboBox19.getSelectedIndex()==9){eI++;}
					else if(comboBox19.getSelectedIndex()==10){iI++;}
					else if(comboBox19.getSelectedIndex()==11){dI++;}
					else if(comboBox19.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox19.getSelectedIndex()==13){gE++;}
					else if(comboBox19.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox20.getSelectedIndex()==0){gO++;;}
					else if(comboBox20.getSelectedIndex()==1){hT++;}
					else if(comboBox20.getSelectedIndex()==2){yI++;}
					else if(comboBox20.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox20.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox20.getSelectedIndex()==5){cI++;}
					else if(comboBox20.getSelectedIndex()==6){rT++;}
					else if(comboBox20.getSelectedIndex()==7){oI++;}
					else if(comboBox20.getSelectedIndex()==8){bI++;}
					else if(comboBox20.getSelectedIndex()==9){eI++;}
					else if(comboBox20.getSelectedIndex()==10){iI++;}
					else if(comboBox20.getSelectedIndex()==11){dI++;}
					else if(comboBox20.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox20.getSelectedIndex()==13){gE++;}
					else if(comboBox20.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox21.getSelectedIndex()==0){gO++;;}
					else if(comboBox21.getSelectedIndex()==1){hT++;}
					else if(comboBox21.getSelectedIndex()==2){yI++;}
					else if(comboBox21.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox21.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox21.getSelectedIndex()==5){cI++;}
					else if(comboBox21.getSelectedIndex()==6){rT++;}
					else if(comboBox21.getSelectedIndex()==7){oI++;}
					else if(comboBox21.getSelectedIndex()==8){bI++;}
					else if(comboBox21.getSelectedIndex()==9){eI++;}
					else if(comboBox21.getSelectedIndex()==10){iI++;}
					else if(comboBox21.getSelectedIndex()==11){dI++;}
					else if(comboBox21.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox21.getSelectedIndex()==13){gE++;}
					else if(comboBox21.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox22.getSelectedIndex()==0){gO++;;}
					else if(comboBox22.getSelectedIndex()==1){hT++;}
					else if(comboBox22.getSelectedIndex()==2){yI++;}
					else if(comboBox22.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox22.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox22.getSelectedIndex()==5){cI++;}
					else if(comboBox22.getSelectedIndex()==6){rT++;}
					else if(comboBox22.getSelectedIndex()==7){oI++;}
					else if(comboBox22.getSelectedIndex()==8){bI++;}
					else if(comboBox22.getSelectedIndex()==9){eI++;}
					else if(comboBox22.getSelectedIndex()==10){iI++;}
					else if(comboBox22.getSelectedIndex()==11){dI++;}
					else if(comboBox22.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox22.getSelectedIndex()==13){gE++;}
					else if(comboBox22.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox23.getSelectedIndex()==0){gO++;;}
					else if(comboBox23.getSelectedIndex()==1){hT++;}
					else if(comboBox23.getSelectedIndex()==2){yI++;}
					else if(comboBox23.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox23.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox23.getSelectedIndex()==5){cI++;}
					else if(comboBox23.getSelectedIndex()==6){rT++;}
					else if(comboBox23.getSelectedIndex()==7){oI++;}
					else if(comboBox23.getSelectedIndex()==8){bI++;}
					else if(comboBox23.getSelectedIndex()==9){eI++;}
					else if(comboBox23.getSelectedIndex()==10){iI++;}
					else if(comboBox23.getSelectedIndex()==11){dI++;}
					else if(comboBox23.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox23.getSelectedIndex()==13){gE++;}
					else if(comboBox23.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox24.getSelectedIndex()==0){gO++;;}
					else if(comboBox24.getSelectedIndex()==1){hT++;}
					else if(comboBox24.getSelectedIndex()==2){yI++;}
					else if(comboBox24.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox24.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox24.getSelectedIndex()==5){cI++;}
					else if(comboBox24.getSelectedIndex()==6){rT++;}
					else if(comboBox24.getSelectedIndex()==7){oI++;}
					else if(comboBox24.getSelectedIndex()==8){bI++;}
					else if(comboBox24.getSelectedIndex()==9){eI++;}
					else if(comboBox24.getSelectedIndex()==10){iI++;}
					else if(comboBox24.getSelectedIndex()==11){dI++;}
					else if(comboBox24.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox24.getSelectedIndex()==13){gE++;}
					else if(comboBox24.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox25.getSelectedIndex()==0){gO++;;}
					else if(comboBox25.getSelectedIndex()==1){hT++;}
					else if(comboBox25.getSelectedIndex()==2){yI++;}
					else if(comboBox25.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox25.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox25.getSelectedIndex()==5){cI++;}
					else if(comboBox25.getSelectedIndex()==6){rT++;}
					else if(comboBox25.getSelectedIndex()==7){oI++;}
					else if(comboBox25.getSelectedIndex()==8){bI++;}
					else if(comboBox25.getSelectedIndex()==9){eI++;}
					else if(comboBox25.getSelectedIndex()==10){iI++;}
					else if(comboBox25.getSelectedIndex()==11){dI++;}
					else if(comboBox25.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox25.getSelectedIndex()==13){gE++;}
					else if(comboBox25.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox26.getSelectedIndex()==0){gO++;;}
					else if(comboBox26.getSelectedIndex()==1){hT++;}
					else if(comboBox26.getSelectedIndex()==2){yI++;}
					else if(comboBox26.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox26.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox26.getSelectedIndex()==5){cI++;}
					else if(comboBox26.getSelectedIndex()==6){rT++;}
					else if(comboBox26.getSelectedIndex()==7){oI++;}
					else if(comboBox26.getSelectedIndex()==8){bI++;}
					else if(comboBox26.getSelectedIndex()==9){eI++;}
					else if(comboBox26.getSelectedIndex()==10){iI++;}
					else if(comboBox26.getSelectedIndex()==11){dI++;}
					else if(comboBox26.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox26.getSelectedIndex()==13){gE++;}
					else if(comboBox26.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox27.getSelectedIndex()==0){gO++;;}
					else if(comboBox27.getSelectedIndex()==1){hT++;}
					else if(comboBox27.getSelectedIndex()==2){yI++;}
					else if(comboBox27.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox27.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox27.getSelectedIndex()==5){cI++;}
					else if(comboBox27.getSelectedIndex()==6){rT++;}
					else if(comboBox27.getSelectedIndex()==7){oI++;}
					else if(comboBox27.getSelectedIndex()==8){bI++;}
					else if(comboBox27.getSelectedIndex()==9){eI++;}
					else if(comboBox27.getSelectedIndex()==10){iI++;}
					else if(comboBox27.getSelectedIndex()==11){dI++;}
					else if(comboBox27.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox27.getSelectedIndex()==13){gE++;}
					else if(comboBox27.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox28.getSelectedIndex()==0){gO++;;}
					else if(comboBox28.getSelectedIndex()==1){hT++;}
					else if(comboBox28.getSelectedIndex()==2){yI++;}
					else if(comboBox28.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox28.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox28.getSelectedIndex()==5){cI++;}
					else if(comboBox28.getSelectedIndex()==6){rT++;}
					else if(comboBox28.getSelectedIndex()==7){oI++;}
					else if(comboBox28.getSelectedIndex()==8){bI++;}
					else if(comboBox28.getSelectedIndex()==9){eI++;}
					else if(comboBox28.getSelectedIndex()==10){iI++;}
					else if(comboBox28.getSelectedIndex()==11){dI++;}
					else if(comboBox28.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox28.getSelectedIndex()==13){gE++;}
					else if(comboBox28.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox29.getSelectedIndex()==0){gO++;;}
					else if(comboBox29.getSelectedIndex()==1){hT++;}
					else if(comboBox29.getSelectedIndex()==2){yI++;}
					else if(comboBox29.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox29.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox29.getSelectedIndex()==5){cI++;}
					else if(comboBox29.getSelectedIndex()==6){rT++;}
					else if(comboBox29.getSelectedIndex()==7){oI++;}
					else if(comboBox29.getSelectedIndex()==8){bI++;}
					else if(comboBox29.getSelectedIndex()==9){eI++;}
					else if(comboBox29.getSelectedIndex()==10){iI++;}
					else if(comboBox29.getSelectedIndex()==11){dI++;}
					else if(comboBox29.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox29.getSelectedIndex()==13){gE++;}
					else if(comboBox29.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox30.getSelectedIndex()==0){gO++;;}
					else if(comboBox30.getSelectedIndex()==1){hT++;}
					else if(comboBox30.getSelectedIndex()==2){yI++;}
					else if(comboBox30.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox30.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox30.getSelectedIndex()==5){cI++;}
					else if(comboBox30.getSelectedIndex()==6){rT++;}
					else if(comboBox30.getSelectedIndex()==7){oI++;}
					else if(comboBox30.getSelectedIndex()==8){bI++;}
					else if(comboBox30.getSelectedIndex()==9){eI++;}
					else if(comboBox30.getSelectedIndex()==10){iI++;}
					else if(comboBox30.getSelectedIndex()==11){dI++;}
					else if(comboBox30.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox30.getSelectedIndex()==13){gE++;}
					else if(comboBox30.getSelectedIndex()==14){tGC++;}
				 
				 if(comboBox31.getSelectedIndex()==0){gO++;;}
					else if(comboBox31.getSelectedIndex()==1){hT++;}
					else if(comboBox31.getSelectedIndex()==2){yI++;}
					else if(comboBox31.getSelectedIndex()==3){r2GUR++;}
					else if(comboBox31.getSelectedIndex()==4){r2GAR++;}
					else if(comboBox31.getSelectedIndex()==5){cI++;}
					else if(comboBox31.getSelectedIndex()==6){rT++;}
					else if(comboBox31.getSelectedIndex()==7){oI++;}
					else if(comboBox31.getSelectedIndex()==8){bI++;}
					else if(comboBox31.getSelectedIndex()==9){eI++;}
					else if(comboBox31.getSelectedIndex()==10){iI++;}
					else if(comboBox31.getSelectedIndex()==11){dI++;}
					else if(comboBox31.getSelectedIndex()==12){yG=yG+0.5f;}
					else if(comboBox31.getSelectedIndex()==13){gE++;}
					else if(comboBox31.getSelectedIndex()==14){tGC++;}
				 
				 
				 
				 
				 
			labelGorevdeSay.setText(""+gO);
			labelHaftaTatiliSay.setText(""+hT);
			labelYillikIzinSay.setText(""+yI);
			label2gunUstuRaporSay.setText(""+r2GUR);
			label2gunAltiRaporSay.setText(""+r2GAR);
			labelCikisSay.setText(""+cI);
			labelResmiTatilSay.setText(""+rT);
			labelOlumIzniSay.setText(""+oI);
			labelBabalikIzniSay.setText(""+bI);
			labelEvlilikIzniSay.setText(""+eI);
			labelIdariIzinSay.setText(""+iI);
			labelDogumIzniSay.setText(""+dI);
			labelYarimGunSay.setText(""+yG);
			labelGelmediSay.setText(""+gE);
			labelTatilGunuCalismaSay.setText(""+tGC);
			
			
			
			labelMaasHesaplacakGunSay.setText(""+(gO+rT+hT+yG+oI+bI+eI+yI+iI));
			labelYolUcretiVerilecekGunSay.setText(""+((2*yG)+gO));
			labelYemekUcretiVerGunSay.setText(""+((2*yG)+gO));
			
			
			}});
		
		btnHesapla.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHesapla.setBackground(UIManager.getColor("Button.light"));
		
		
		
		
		
			
		
		
		
		
//**************************************************************************************************************************************************************
			
			
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 156, 291, 123);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel labelIsim = new JLabel("");
		labelIsim.setForeground(new Color(255, 255, 255));
		labelIsim.setHorizontalAlignment(SwingConstants.LEFT);
		labelIsim.setBorder(null);
		labelIsim.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelIsim.setBounds(10, 85, 271, 26);
		panel_2.add(labelIsim);
		
		JLabel labelUnvan = new JLabel("");
		labelUnvan.setForeground(new Color(255, 255, 255));
		labelUnvan.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnvan.setBorder(null);
		labelUnvan.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelUnvan.setBounds(10, 48, 271, 26);
		panel_2.add(labelUnvan);
		
		JComboBox comboBoxSicil = new JComboBox(DataBaseSQL.sicilListele().toArray());
		comboBoxSicil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxSicil.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxSicil.setBackground(Color.WHITE);
		comboBoxSicil.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxSicil.setBounds(10, 11, 125, 26);
		panel_2.add(comboBoxSicil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 291, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateChooser.setBounds(10, 93, 157, 26);
		panel_1.add(dateChooser);
		
		JButton btnNewButton_1 = new JButton("Sec");
		btnNewButton_1.setBounds(180, 93, 98, 26);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(UIManager.getColor("Button.light"));
		
		JLabel lblNewLabel = new JLabel("Hak Edis Yapilacak Ayin Ilk Gununu Seciniz.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 48, 268, 34);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Personel Bilgileri Kontrol");
		btnNewButton_1_1.setBounds(7, 11, 268, 26);
		panel_1.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MudurlukPanel.this.dispose();
				PersonelUI mPane2sl=new PersonelUI();
				mPane2sl.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBackground(UIManager.getColor("Button.light"));
		
		JLabel labelTarihYaz = new JLabel("");
		labelTarihYaz.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTarihYaz.setForeground(Color.WHITE);
		labelTarihYaz.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTarihYaz.setBounds(832, 231, 261, 26);
		panel.add(labelTarihYaz);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(213, 290, 328, 498);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 308, 439);
		panel_4.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(Color.WHITE));
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(95, 158, 160));
		
		JButton btnTmnOnayla = new JButton("T\u00FCm\u00FCn\u00FC Onayla");
		btnTmnOnayla.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmnOnayla.setBackground(UIManager.getColor("Button.light"));
		btnTmnOnayla.setBounds(183, 461, 135, 26);
		panel_4.add(btnTmnOnayla);
		
		JButton btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGncelle.setBackground(UIManager.getColor("Button.light"));
		btnGncelle.setBounds(80, 461, 93, 26);
		panel_4.add(btnGncelle);
		
		JButton btnTmnOnayla_1_1 = new JButton("Sil");
		btnTmnOnayla_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmnOnayla_1_1.setBackground(UIManager.getColor("Button.light"));
		btnTmnOnayla_1_1.setBounds(10, 461, 60, 26);
		panel_4.add(btnTmnOnayla_1_1);
		
	
		
		
		
		
		dateChooser.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			
	    	    
	    	   
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		setLocationRelativeTo(null);
		
		
		
		
//*************************************************************************************************************************************************************
		
//		hak edi� tarih combobxlar�n listenerleri a�a��da
		
//*************************************************************************************************************************************************************

		
		/*	Calendar takvim = new GregorianCalendar(1984, 01, 01);
			Date tarih = takvim.getTime();
			//System.out.println(tarih.toString());
			
			
			//Date simdikiZaman = new Date();
	        // System.out.println(simdikiZaman.toString());
	        DateFormat df = new SimpleDateFormat("E");
	        System.out.println(df.format(tarih));  */
			
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!comboBox1.getSelectedItem().toString().equals("Gorevde")) {
					comboBox1.setBackground(new Color(233, 150, 122));}
				else {comboBox1.setBackground(SystemColor.WHITE);}}});
		
		
			comboBox2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox2.getSelectedItem().toString().equals("Gorevde")) {
						comboBox2.setBackground(new Color(233, 150, 122));}
					else {comboBox2.setBackground(SystemColor.WHITE);}}});
			
			comboBox3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox3.getSelectedItem().toString().equals("Gorevde")) {
						comboBox3.setBackground(new Color(233, 150, 122));}
					else {comboBox3.setBackground(SystemColor.WHITE);}}});
			
			comboBox4.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox4.getSelectedItem().toString().equals("Gorevde")) {
						comboBox4.setBackground(new Color(233, 150, 122));}
					else {comboBox4.setBackground(SystemColor.WHITE);}}});
			
			comboBox5.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox5.getSelectedItem().toString().equals("Gorevde")) {
						comboBox5.setBackground(new Color(233, 150, 122));}
					else {comboBox5.setBackground(SystemColor.WHITE);}}});
			
			comboBox6.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox6.getSelectedItem().toString().equals("Gorevde")) {
						comboBox6.setBackground(new Color(233, 150, 122));}
					else {comboBox6.setBackground(SystemColor.WHITE);}}});
			
			comboBox7.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox7.getSelectedItem().toString().equals("Gorevde")) {
						comboBox7.setBackground(new Color(233, 150, 122));}
					else {comboBox7.setBackground(SystemColor.WHITE);}}});
			
			comboBox8.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox8.getSelectedItem().toString().equals("Gorevde")) {
						comboBox8.setBackground(new Color(233, 150, 122));}
					else {comboBox8.setBackground(SystemColor.WHITE);}}});
			
			comboBox9.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox9.getSelectedItem().toString().equals("Gorevde")) {
						comboBox9.setBackground(new Color(233, 150, 122));}
					else {comboBox9.setBackground(SystemColor.WHITE);}}});
			
			comboBox10.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox10.getSelectedItem().toString().equals("Gorevde")) {
						comboBox10.setBackground(new Color(233, 150, 122));}
					else {comboBox10.setBackground(SystemColor.WHITE);}}});
			
			comboBox11.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox11.getSelectedItem().toString().equals("Gorevde")) {
						comboBox11.setBackground(new Color(233, 150, 122));}
					else {comboBox11.setBackground(SystemColor.WHITE);}}});
			
			comboBox12.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox12.getSelectedItem().toString().equals("Gorevde")) {
						comboBox12.setBackground(new Color(233, 150, 122));}
					else {comboBox12.setBackground(SystemColor.WHITE);}}});
			
			comboBox13.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox13.getSelectedItem().toString().equals("Gorevde")) {
						comboBox13.setBackground(new Color(233, 150, 122));}
					else {comboBox13.setBackground(SystemColor.WHITE);}}});
			
			comboBox14.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox14.getSelectedItem().toString().equals("Gorevde")) {
						comboBox14.setBackground(new Color(233, 150, 122));}
					else {comboBox14.setBackground(SystemColor.WHITE);}}});
			
			comboBox15.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox15.getSelectedItem().toString().equals("Gorevde")) {
						comboBox15.setBackground(new Color(233, 150, 122));}
					else {comboBox15.setBackground(SystemColor.WHITE);}}});
			
			comboBox16.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox16.getSelectedItem().toString().equals("Gorevde")) {
						comboBox16.setBackground(new Color(233, 150, 122));}
					else {comboBox16.setBackground(SystemColor.WHITE);}}});
			
			comboBox17.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox17.getSelectedItem().toString().equals("Gorevde")) {
						comboBox17.setBackground(new Color(233, 150, 122));}
					else {comboBox17.setBackground(SystemColor.WHITE);}}});
			
			comboBox18.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox18.getSelectedItem().toString().equals("Gorevde")) {
						comboBox18.setBackground(new Color(233, 150, 122));}
					else {comboBox18.setBackground(SystemColor.WHITE);}}});
			
			comboBox19.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox19.getSelectedItem().toString().equals("Gorevde")) {
						comboBox19.setBackground(new Color(233, 150, 122));}
					else {comboBox19.setBackground(SystemColor.WHITE);}}});
			
			comboBox20.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox20.getSelectedItem().toString().equals("Gorevde")) {
						comboBox20.setBackground(new Color(233, 150, 122));}
					else {comboBox20.setBackground(SystemColor.WHITE);}}});
			
			comboBox21.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox21.getSelectedItem().toString().equals("Gorevde")) {
						comboBox21.setBackground(new Color(233, 150, 122));}
					else {comboBox21.setBackground(SystemColor.WHITE);}}});
			
			comboBox22.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox22.getSelectedItem().toString().equals("Gorevde")) {
						comboBox22.setBackground(new Color(233, 150, 122));}
					else {comboBox22.setBackground(SystemColor.WHITE);}}});
			
			comboBox23.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox23.getSelectedItem().toString().equals("Gorevde")) {
						comboBox23.setBackground(new Color(233, 150, 122));}
					else {comboBox23.setBackground(SystemColor.WHITE);}}});
			
			comboBox24.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox24.getSelectedItem().toString().equals("Gorevde")) {
						comboBox24.setBackground(new Color(233, 150, 122));}
					else {comboBox24.setBackground(SystemColor.WHITE);}}});
			
			comboBox25.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox25.getSelectedItem().toString().equals("Gorevde")) {
						comboBox25.setBackground(new Color(233, 150, 122));}
					else {comboBox25.setBackground(SystemColor.WHITE);}}});
			
			comboBox26.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox26.getSelectedItem().toString().equals("Gorevde")) {
						comboBox26.setBackground(new Color(233, 150, 122));}
					else {comboBox26.setBackground(SystemColor.WHITE);}}});
			
			comboBox27.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox27.getSelectedItem().toString().equals("Gorevde")) {
						comboBox27.setBackground(new Color(233, 150, 122));}
					else {comboBox27.setBackground(SystemColor.WHITE);}}});
			
			comboBox28.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox28.getSelectedItem().toString().equals("Gorevde")) {
						comboBox28.setBackground(new Color(233, 150, 122));}
					else {comboBox28.setBackground(SystemColor.WHITE);}}});
			
			comboBox29.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox29.getSelectedItem().toString().equals("Gorevde")) {
						comboBox29.setBackground(new Color(233, 150, 122));}
					else {comboBox29.setBackground(SystemColor.WHITE);}}});
			
			comboBox30.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox30.getSelectedItem().toString().equals("Gorevde")) {
						comboBox30.setBackground(new Color(233, 150, 122));}
					else {comboBox30.setBackground(SystemColor.WHITE);}}});
			
			comboBox31.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox31.getSelectedItem().toString().equals("Gorevde")) {
						comboBox31.setBackground(new Color(233, 150, 122));}
					else {comboBox31.setBackground(SystemColor.WHITE);}}});
			
			
			
			

//*************************************************************************************************************************************************************
//*************************************************************************************************************************************************************		
//*************************************************************************************************************************************************************	
			
			
			
			//g�nleri ald���m b�l�m, g�nleri labele at�yoruz..
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					
					
					//DateFormat dateformatYYYYMMDD = new SimpleDateFormat("yyyy.MM.dd E");
					DateFormat gunSayiAl = new SimpleDateFormat("d");
					DateFormat gunAdiAl = new SimpleDateFormat("E");
					DateFormat ayAl = new SimpleDateFormat("M");
					DateFormat yiliAl = new SimpleDateFormat("y");
					
		    	    //String secilenTarih = new String( dateformatYYYYMMDD.format(dateChooser.getDate()));
		    	    String secilenTarihGunSayi = new String( gunSayiAl.format(dateChooser.getDate()));
		    	    String secilenTarih3 = new String( gunAdiAl.format(dateChooser.getDate()));	
		    	    secilenTarihAyAl = new String( ayAl.format(dateChooser.getDate()));	
		    	    secilenTarihYilAl = new String( yiliAl.format(dateChooser.getDate()));			    	    
		    	   // System.out.println(secilenTarihGunSayi+" "+secilenTarih3);		    	    
		    	   // System.out.println(secilenTarihAyAl+" "+secilenTarihYilAl);		    	    
		    	    yil= Integer.parseInt(secilenTarihYilAl);
		    	    ay= Integer.parseInt(secilenTarihAyAl);
		    	   // System.out.println(yil);
		    	 // System.out.println(ay);
		    	    
		    	    
		    	    
		    	    
		    	    labelTarihYaz.setText(labelIsim.getText().toString()+"-"+secilenTarihYilAl+"-"+secilenTarihAyAl+".ay");
		    	    
		    	   
		    	    if(ay==4||ay==6||ay==9||ay==11) {		    	    	
		    	    	comboBox31.setVisible(false);
		    	    	label31.setVisible(false);
		    	    	
		    	    	comboBox31.setSelectedItem("Gelmedi.Gorevde.Yok");
		    	    }
		    	    else if(ay==2) {	    	    	
		    	    	if(yil%4==0) {		    	    		
		    	    		comboBox31.setVisible(false);
			    	    	label31.setVisible(false);			    	    	
			    	    	comboBox30.setVisible(false);
			    	    	label30.setVisible(false);	
			    	    	
			    	    	comboBox31.setSelectedItem("Gelmedi.Gorevde.Yok");
			    	    	comboBox30.setSelectedItem("Gelmedi.Gorevde.Yok");
			    	    	
		    	    	}
		    	    	else {
		    	    		comboBox31.setVisible(false);
			    	    	label31.setVisible(false);			    	    	
			    	    	comboBox30.setVisible(false);
			    	    	label30.setVisible(false);
			    	    	comboBox29.setVisible(false);
			    	    	label29.setVisible(false);
			    	    	
			    	    	comboBox31.setSelectedItem("Gelmedi.Gorevde.Yok");
			    	    	comboBox30.setSelectedItem("Gelmedi.Gorevde.Yok");
			    	    	comboBox29.setSelectedItem("Gelmedi.Gorevde.Yok");
		    	    	}		    	    	
		    	    }		    	    
		    	    else if (ay==1||ay==3||ay==5||ay==7||ay==8||ay==10||ay==12){
		    	    	
		    	    	comboBox31.setVisible(true);
		    	    	label31.setVisible(true);			    	    	
		    	    	comboBox30.setVisible(true);
		    	    	label30.setVisible(true);
		    	    	comboBox29.setVisible(true);
		    	    	label29.setVisible(true);
		    	    	
		    	    	comboBox29.setSelectedItem("Gorevde");
		    	    	comboBox30.setSelectedItem("Gorevde");
		    	    	comboBox31.setSelectedItem("Gorevde");
		    	    }
		    	    
		    	  
		    	    
		    	    
		    	    
		    	    	    	    
		    	    if(secilenTarihGunSayi.toString().equals(label1.getText().toString())){
		    	    	panel_2.setVisible(true);
		    	    	panel_3.setVisible(true);
		    	    	panel_4.setVisible(true);
		    	    	panel.setVisible(true);
		    	    	
		    	    	
		    	    	String gun = null;
		    	    			    	    			    	    	
		    	    	if(secilenTarih3.equals("Pzt")) {gun="Pazartesi";}
		    	    	else if(secilenTarih3.equals("Sal")) {gun="Sali";}else if(secilenTarih3.equals("�ar")) {gun="Carsamba";}
		    	    	else if(secilenTarih3.equals("Per")) {gun="Persembe";}else if(secilenTarih3.equals("Cum")) {gun="Cuma";}
		    	    	else if(secilenTarih3.equals("Cmt")) {gun="Cumartesi";}else if(secilenTarih3.equals("Paz")) {gun="Pazar";}
		    	    			    	    	
		    	    	labelGun1.setText(gun);
		    	    	
		    	    	if(secilenTarih3.equals("Pzt")) {
		    	    		labelGun2.setText("Sali");labelGun3.setText("Carsamba");labelGun4.setText("Persembe");
		    	    		labelGun5.setText("Cuma");labelGun6.setText("Cumartesi");labelGun7.setText("Pazar");	
		    	    		
		    	    	}
		    	    	if(secilenTarih3.equals("Sal")) {
		    	    		labelGun7.setText("Pazartesi");labelGun2.setText("Carsamba");labelGun3.setText("Persembe");
		    	    		labelGun4.setText("Cuma");labelGun5.setText("Cumartesi");labelGun6.setText("Pazar");
		    	    	}
		    	    	if(secilenTarih3.equals("�ar")) {
		    	    		labelGun6.setText("Pazartesi");labelGun7.setText("Sali");labelGun2.setText("Persembe");
		    	    		labelGun3.setText("Cuma");labelGun4.setText("Cumartesi");labelGun5.setText("Pazar");
		    	    	}
		    	    	if(secilenTarih3.equals("Per")) {
		    	    		labelGun5.setText("Pazartesi");labelGun6.setText("Sali");labelGun7.setText("Carsamba");
		    	    		labelGun2.setText("Cuma");labelGun3.setText("Cumartesi");labelGun4.setText("Pazar");
		    	    	}
		    	    	if(secilenTarih3.equals("Cum")) {
		    	    		labelGun4.setText("Pazartesi");labelGun5.setText("Sali");labelGun6.setText("Carsamba");
		    	    		labelGun7.setText("Persembe");labelGun2.setText("Cumartesi");labelGun3.setText("Pazar");
		    	    	}
		    	    	if(secilenTarih3.equals("Cmt")) {
		    	    		labelGun3.setText("Pazartesi");labelGun4.setText("Sali");labelGun5.setText("Carsamba");
		    	    		labelGun6.setText("Persembe");labelGun7.setText("Cuma");labelGun2.setText("Pazar");
		    	    	}
		    	    	if(secilenTarih3.equals("Paz")) {
		    	    		
		    	    		labelGun2.setText("Pazartesi");labelGun3.setText("Sali");labelGun4.setText("Carsamba");
		    	    		labelGun5.setText("Persembe");labelGun6.setText("Cuma");labelGun7.setText("Cumartesi");
		    	    	}		    	    	
		    	    }
		    	    
		    	    else {JOptionPane.showMessageDialog(null,"Lutfen Ayin Ilk Gununu Seciniz.");}
		    	    		    	    
		    	    if(labelGun1.getText().toString().equals("Pazar")) {labelGun1.setForeground(new Color(128, 0, 0));}else{labelGun1.setForeground(Color.BLACK);}
		    	    if(labelGun2.getText().toString().equals("Pazar")) {labelGun2.setForeground(new Color(128, 0, 0));}else{labelGun2.setForeground(Color.BLACK);}
		    	    if(labelGun3.getText().toString().equals("Pazar")) {labelGun3.setForeground(new Color(128, 0, 0));}else{labelGun3.setForeground(Color.BLACK);}
		    	    if(labelGun4.getText().toString().equals("Pazar")) {labelGun4.setForeground(new Color(128, 0, 0));}else{labelGun4.setForeground(Color.BLACK);}
		    	    if(labelGun5.getText().toString().equals("Pazar")) {labelGun5.setForeground(new Color(128, 0, 0));}else{labelGun5.setForeground(Color.BLACK);}
		    	    if(labelGun6.getText().toString().equals("Pazar")) {labelGun6.setForeground(new Color(128, 0, 0));}else{labelGun6.setForeground(Color.BLACK);}
		    	    if(labelGun7.getText().toString().equals("Pazar")) {labelGun7.setForeground(new Color(128, 0, 0));}else{labelGun7.setForeground(Color.BLACK);}
		    	    
				}
			});
			
			
			
			comboBoxSicil.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {	
					
					String sicil=comboBoxSicil.getSelectedItem().toString();					
								
					TaseronPersonelDomain bulunanPersonel=DataBaseSQL.personelBul(sicil);					
					String adiSoyadi= bulunanPersonel.getAdiSoyadi().toString();
					String unvan= bulunanPersonel.getUnvan().toString();
					
					labelUnvan.setText(unvan);
					labelIsim.setText(adiSoyadi);
															
					labelTarihYaz.setText(labelIsim.getText().toString()+"-"+secilenTarihYilAl+"-"+secilenTarihAyAl+".ay");
				}
			});
			
		
	}
}
