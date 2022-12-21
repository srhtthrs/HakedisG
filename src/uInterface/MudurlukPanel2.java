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

import HakEdisDatabase.AylikHakedisSQL;
import HakEdisDatabase.DataBaseConn;
import HakEdisDatabase.DataBaseSQL;
import HakEdisDomain.AylikHakEdisDomain;
import HakEdisDomain.Degiskenler;
import HakEdisDomain.TaseronPersonelDomain;
import HakEdisDomain.UyelikDomain;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ComboBoxModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.DebugGraphics;
import javax.swing.AbstractListModel;

public class MudurlukPanel2 extends JFrame {

	private JPanel contentPane;
	
	
	static String mudurlukAl;
	static String sicilAl;
	String[] gunler=Degiskenler.getCalismaGunleri();
	
	
	String secilenTarih;
	
	int yil,ay; 
	
	String secilenTarihAyAl, secilenTarihYilAl;
	
	int fazlaMesai1=0,fazlaMesai2=0,fazlaMesai3=0,fazlaMesai4=0,fazlaMesai5=0,fazlaMesai6=0,fazlaMesai7=0,fazlaMesai8=0,
	fazlaMesai9=0,fazlaMesai10=0,fazlaMesai11=0,fazlaMesai12=0,fazlaMesai13=0,fazlaMesai14=0,fazlaMesai15=0,fazlaMesai16=0,fazlaMesai17=0,
	fazlaMesai18=0,fazlaMesai19=0,fazlaMesai20=0,fazlaMesai21=0,fazlaMesai22=0,fazlaMesai23=0,fazlaMesai24=0,fazlaMesai25=0,fazlaMesai26=0,
	fazlaMesai27=0,fazlaMesai28=0,fazlaMesai29=0,fazlaMesai30=0,fazlaMesai31=0;
	
	int toplamMesai=0;
	
	
	float gO,hT,yI,r2GUR,r2GAR,cI,rT,oI,bI,eI,iI,dI,gE;  //tGC;
	float yG=0.0f;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudurlukPanel2 frame = new MudurlukPanel2();
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
	public MudurlukPanel2() {
		setResizable(false);
		
	
		
		setTitle(mudurlukAl+"   Kullanici Sicil: "+sicilAl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 839);
		contentPane = new JPanel();
		
		
		
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBorder(new LineBorder(Color.WHITE));
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(1156, 11, 268, 577);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(213, 11, 933, 244);
		contentPane.add(panel);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("1");
		label1.setBorder(new LineBorder(Color.WHITE));
		label1.setForeground(new Color(0, 0, 0));
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 50, 30, 26);
		panel.add(label1);
		
		JLabel labelGorevde = new JLabel("(X)   Fiili Calisilan Gun ");
		labelGorevde.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGorevde.setBorder(new LineBorder(Color.WHITE));
		labelGorevde.setForeground(new Color(255, 255, 255));
		labelGorevde.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGorevde.setBounds(10, 11, 211, 26);
		panel_3.add(labelGorevde);
		
		JLabel labelGorevdeSay = new JLabel("0");
		labelGorevdeSay.setBorder(new LineBorder(Color.WHITE));
		labelGorevdeSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGorevdeSay.setForeground(Color.WHITE);
		labelGorevdeSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelGorevdeSay.setBounds(222, 11, 36, 26);
		panel_3.add(labelGorevdeSay);
		
		JLabel labelHaftaTatiliSay = new JLabel("0");
		labelHaftaTatiliSay.setBorder(new LineBorder(Color.WHITE));
		labelHaftaTatiliSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelHaftaTatiliSay.setForeground(Color.WHITE);
		labelHaftaTatiliSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelHaftaTatiliSay.setBounds(222, 37, 36, 26);
		panel_3.add(labelHaftaTatiliSay);
		
		JLabel labelHaftaTatili = new JLabel("(HT)   Hafta Tatili ");
		labelHaftaTatili.setBorder(new LineBorder(Color.WHITE));
		labelHaftaTatili.setHorizontalAlignment(SwingConstants.RIGHT);
		labelHaftaTatili.setForeground(Color.WHITE);
		labelHaftaTatili.setFont(new Font("Dialog", Font.BOLD, 15));
		labelHaftaTatili.setBounds(10, 37, 211, 26);
		panel_3.add(labelHaftaTatili);
		
		JLabel labelYillikIzinSay = new JLabel("0");
		labelYillikIzinSay.setBorder(new LineBorder(Color.WHITE));
		labelYillikIzinSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYillikIzinSay.setForeground(Color.WHITE);
		labelYillikIzinSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYillikIzinSay.setBounds(222, 63, 36, 26);
		panel_3.add(labelYillikIzinSay);
		
		JLabel labelYillikIzin = new JLabel("(YI)   Yillik Izin ");
		labelYillikIzin.setBorder(new LineBorder(Color.WHITE));
		labelYillikIzin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYillikIzin.setForeground(Color.WHITE);
		labelYillikIzin.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYillikIzin.setBounds(10, 63, 211, 26);
		panel_3.add(labelYillikIzin);
		
		JLabel label2gunUstuRaporSay = new JLabel("0");
		label2gunUstuRaporSay.setBorder(new LineBorder(Color.WHITE));
		label2gunUstuRaporSay.setHorizontalAlignment(SwingConstants.CENTER);
		label2gunUstuRaporSay.setForeground(Color.WHITE);
		label2gunUstuRaporSay.setFont(new Font("Dialog", Font.BOLD, 15));
		label2gunUstuRaporSay.setBounds(222, 89, 36, 26);
		panel_3.add(label2gunUstuRaporSay);
		
		JLabel label2gunUstuRapor = new JLabel("(R2U)   2 Gun Ustu Rapor ");
		label2gunUstuRapor.setBorder(new LineBorder(Color.WHITE));
		label2gunUstuRapor.setHorizontalAlignment(SwingConstants.RIGHT);
		label2gunUstuRapor.setForeground(Color.WHITE);
		label2gunUstuRapor.setFont(new Font("Dialog", Font.BOLD, 15));
		label2gunUstuRapor.setBounds(10, 89, 211, 26);
		panel_3.add(label2gunUstuRapor);
		
		JLabel label2gunAltiRapor = new JLabel("(R2A)   2 Gun ve Alti Rapor ");
		label2gunAltiRapor.setBorder(new LineBorder(Color.WHITE));
		label2gunAltiRapor.setHorizontalAlignment(SwingConstants.RIGHT);
		label2gunAltiRapor.setForeground(Color.WHITE);
		label2gunAltiRapor.setFont(new Font("Dialog", Font.BOLD, 15));
		label2gunAltiRapor.setBounds(10, 115, 211, 26);
		panel_3.add(label2gunAltiRapor);
		
		JLabel label2gunAltiRaporSay = new JLabel("0");
		label2gunAltiRaporSay.setBorder(new LineBorder(Color.WHITE));
		label2gunAltiRaporSay.setHorizontalAlignment(SwingConstants.CENTER);
		label2gunAltiRaporSay.setForeground(Color.WHITE);
		label2gunAltiRaporSay.setFont(new Font("Dialog", Font.BOLD, 15));
		label2gunAltiRaporSay.setBounds(222, 115, 36, 26);
		panel_3.add(label2gunAltiRaporSay);
		
		JLabel labelCikis = new JLabel("(C)   Cikis ");
		labelCikis.setBorder(new LineBorder(Color.WHITE));
		labelCikis.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCikis.setForeground(Color.WHITE);
		labelCikis.setFont(new Font("Dialog", Font.BOLD, 15));
		labelCikis.setBounds(10, 140, 211, 26);
		panel_3.add(labelCikis);
		
		JLabel labelCikisSay = new JLabel("0");
		labelCikisSay.setBorder(new LineBorder(Color.WHITE));
		labelCikisSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelCikisSay.setForeground(Color.WHITE);
		labelCikisSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelCikisSay.setBounds(222, 140, 36, 26);
		panel_3.add(labelCikisSay);
		
		JLabel labelResmiTatil = new JLabel("(RT)   Resmi Tatil ");
		labelResmiTatil.setBorder(new LineBorder(Color.WHITE));
		labelResmiTatil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResmiTatil.setForeground(Color.WHITE);
		labelResmiTatil.setFont(new Font("Dialog", Font.BOLD, 15));
		labelResmiTatil.setBounds(10, 166, 211, 26);
		panel_3.add(labelResmiTatil);
		
		JLabel labelResmiTatilSay = new JLabel("0");
		labelResmiTatilSay.setBorder(new LineBorder(Color.WHITE));
		labelResmiTatilSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelResmiTatilSay.setForeground(Color.WHITE);
		labelResmiTatilSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelResmiTatilSay.setBounds(222, 166, 36, 26);
		panel_3.add(labelResmiTatilSay);
		
		JLabel labelOlumIzni = new JLabel("(OI)   Olum Izni ");
		labelOlumIzni.setBorder(new LineBorder(Color.WHITE));
		labelOlumIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOlumIzni.setForeground(Color.WHITE);
		labelOlumIzni.setFont(new Font("Dialog", Font.BOLD, 15));
		labelOlumIzni.setBounds(10, 193, 211, 26);
		panel_3.add(labelOlumIzni);
		
		JLabel labelOlumIzniSay = new JLabel("0");
		labelOlumIzniSay.setBorder(new LineBorder(Color.WHITE));
		labelOlumIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelOlumIzniSay.setForeground(Color.WHITE);
		labelOlumIzniSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelOlumIzniSay.setBounds(222, 193, 36, 26);
		panel_3.add(labelOlumIzniSay);
		
		JLabel labelBabalikIzni = new JLabel("(BI)   Babalik Izni ");
		labelBabalikIzni.setBorder(new LineBorder(Color.WHITE));
		labelBabalikIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBabalikIzni.setForeground(Color.WHITE);
		labelBabalikIzni.setFont(new Font("Dialog", Font.BOLD, 15));
		labelBabalikIzni.setBounds(10, 220, 211, 26);
		panel_3.add(labelBabalikIzni);
		
		JLabel labelBabalikIzniSay = new JLabel("0");
		labelBabalikIzniSay.setBorder(new LineBorder(Color.WHITE));
		labelBabalikIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelBabalikIzniSay.setForeground(Color.WHITE);
		labelBabalikIzniSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelBabalikIzniSay.setBounds(222, 220, 36, 26);
		panel_3.add(labelBabalikIzniSay);
		
		JLabel labelEvlilikIzni = new JLabel("(EI)   Evlilik Izni ");
		labelEvlilikIzni.setBorder(new LineBorder(Color.WHITE));
		labelEvlilikIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEvlilikIzni.setForeground(Color.WHITE);
		labelEvlilikIzni.setFont(new Font("Dialog", Font.BOLD, 15));
		labelEvlilikIzni.setBounds(10, 246, 211, 26);
		panel_3.add(labelEvlilikIzni);
		
		JLabel labelEvlilikIzniSay = new JLabel("0");
		labelEvlilikIzniSay.setBorder(new LineBorder(Color.WHITE));
		labelEvlilikIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelEvlilikIzniSay.setForeground(Color.WHITE);
		labelEvlilikIzniSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelEvlilikIzniSay.setBounds(222, 246, 36, 26);
		panel_3.add(labelEvlilikIzniSay);
		
		JLabel labelIdariIzin = new JLabel("(II)   Idari Izin ");
		labelIdariIzin.setBorder(new LineBorder(Color.WHITE));
		labelIdariIzin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIdariIzin.setForeground(Color.WHITE);
		labelIdariIzin.setFont(new Font("Dialog", Font.BOLD, 15));
		labelIdariIzin.setBounds(10, 271, 211, 26);
		panel_3.add(labelIdariIzin);
		
		JLabel labelIdariIzinSay = new JLabel("0");
		labelIdariIzinSay.setBorder(new LineBorder(Color.WHITE));
		labelIdariIzinSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelIdariIzinSay.setForeground(Color.WHITE);
		labelIdariIzinSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelIdariIzinSay.setBounds(222, 271, 36, 26);
		panel_3.add(labelIdariIzinSay);
		
		JLabel labelDogumIzni = new JLabel("(DI)   Dogum Izni ");
		labelDogumIzni.setBorder(new LineBorder(Color.WHITE));
		labelDogumIzni.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDogumIzni.setForeground(Color.WHITE);
		labelDogumIzni.setFont(new Font("Dialog", Font.BOLD, 15));
		labelDogumIzni.setBounds(10, 297, 211, 26);
		panel_3.add(labelDogumIzni);
		
		JLabel label30 = new JLabel("30");
		label30.setBorder(new LineBorder(Color.WHITE));
		label30.setForeground(new Color(0, 0, 0));
		label30.setHorizontalAlignment(SwingConstants.CENTER);
		label30.setFont(new Font("Tahoma", Font.BOLD, 14));
		label30.setBounds(143, 204, 30, 26);
		panel.add(label30);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setBorder(new LineBorder(Color.WHITE));
		panel_4.setBackground(new Color(95, 158, 160));
		panel_4.setBounds(10, 266, 357, 523);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel labelDogumIzniSay = new JLabel("0");
		labelDogumIzniSay.setBorder(new LineBorder(Color.WHITE));
		labelDogumIzniSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelDogumIzniSay.setForeground(Color.WHITE);
		labelDogumIzniSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelDogumIzniSay.setBounds(222, 297, 36, 26);
		panel_3.add(labelDogumIzniSay);
		
		JLabel labelYarimGun = new JLabel("(YG)   Yarim Gun ");
		labelYarimGun.setBorder(new LineBorder(Color.WHITE));
		labelYarimGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYarimGun.setForeground(Color.WHITE);
		labelYarimGun.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYarimGun.setBounds(10, 323, 211, 26);
		panel_3.add(labelYarimGun);
		
		JLabel labelYarimGunSay = new JLabel("0");
		labelYarimGunSay.setBorder(new LineBorder(Color.WHITE));
		labelYarimGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYarimGunSay.setForeground(Color.WHITE);
		labelYarimGunSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYarimGunSay.setBounds(222, 323, 36, 26);
		panel_3.add(labelYarimGunSay);
		
		JLabel labelGelmedi = new JLabel("(G)   Gelmedi ");
		labelGelmedi.setBorder(new LineBorder(Color.WHITE));
		labelGelmedi.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGelmedi.setForeground(Color.WHITE);
		labelGelmedi.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGelmedi.setBounds(10, 349, 211, 26);
		panel_3.add(labelGelmedi);
		
		JLabel labelGelmediSay = new JLabel("0");
		labelGelmediSay.setBorder(new LineBorder(Color.WHITE));
		labelGelmediSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelGelmediSay.setForeground(Color.WHITE);
		labelGelmediSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGelmediSay.setBounds(222, 349, 36, 26);
		panel_3.add(labelGelmediSay);
		
		JLabel labelSaatlikMesai = new JLabel("(SM)   Saatlik Mesai ");
		labelSaatlikMesai.setBorder(new LineBorder(Color.WHITE));
		labelSaatlikMesai.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaatlikMesai.setForeground(new Color(128, 0, 0));
		labelSaatlikMesai.setFont(new Font("Dialog", Font.BOLD, 15));
		labelSaatlikMesai.setBounds(10, 437, 211, 26);
		panel_3.add(labelSaatlikMesai);
		
		JLabel labelSaatlikMesaiSay = new JLabel("0");
		labelSaatlikMesaiSay.setBorder(new LineBorder(Color.WHITE));
		labelSaatlikMesaiSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelSaatlikMesaiSay.setForeground(new Color(128, 0, 0));
		labelSaatlikMesaiSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelSaatlikMesaiSay.setBounds(222, 437, 36, 26);
		panel_3.add(labelSaatlikMesaiSay);
		
		JLabel labelYemekUcretiVerGun = new JLabel("Yol/Yemek Verilecek Gun ");
		labelYemekUcretiVerGun.setBounds(10, 503, 211, 26);
		panel_3.add(labelYemekUcretiVerGun);
		labelYemekUcretiVerGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelYemekUcretiVerGun.setForeground(new Color(128, 0, 0));
		labelYemekUcretiVerGun.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYemekUcretiVerGun.setBorder(new LineBorder(Color.WHITE));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 337, 418);
		panel_4.add(scrollPane);
		
		
		JList list1 = new JList();
		scrollPane.setViewportView(list1);
		list1.setSelectionBackground(Color.WHITE);
		list1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list1.setBorder(new LineBorder(Color.WHITE));
		list1.setForeground(Color.WHITE);
		list1.setBackground(new Color(95, 158, 160));
		
		JLabel labelMaasHesaplacakGun = new JLabel("Ucret Verilecek Gun ");
		labelMaasHesaplacakGun.setBounds(10, 476, 211, 26);
		panel_3.add(labelMaasHesaplacakGun);
		labelMaasHesaplacakGun.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMaasHesaplacakGun.setForeground(new Color(128, 0, 0));
		labelMaasHesaplacakGun.setFont(new Font("Dialog", Font.BOLD, 15));
		labelMaasHesaplacakGun.setBorder(new LineBorder(Color.WHITE));
		
		JLabel labelMaasHesaplacakGunSay = new JLabel("0");
		labelMaasHesaplacakGunSay.setBounds(222, 476, 36, 26);
		panel_3.add(labelMaasHesaplacakGunSay);
		labelMaasHesaplacakGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaasHesaplacakGunSay.setForeground(new Color(128, 0, 0));
		labelMaasHesaplacakGunSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelMaasHesaplacakGunSay.setBorder(new LineBorder(Color.WHITE));
		
		JLabel labelYemekUcretiVerGunSay = new JLabel("0");
		labelYemekUcretiVerGunSay.setBounds(222, 503, 36, 26);
		panel_3.add(labelYemekUcretiVerGunSay);
		labelYemekUcretiVerGunSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelYemekUcretiVerGunSay.setForeground(new Color(128, 0, 0));
		labelYemekUcretiVerGunSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelYemekUcretiVerGunSay.setBorder(new LineBorder(Color.WHITE));
		
		
		
		JButton BtnGunAdetleriOnayla = new JButton("Onayla");
	
		
		
		
		
		BtnGunAdetleriOnayla.setBounds(160, 540, 98, 26);
		panel_3.add(BtnGunAdetleriOnayla);
		BtnGunAdetleriOnayla.setBackground(UIManager.getColor("Button.light"));
		BtnGunAdetleriOnayla.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_10_1_1 = new JLabel("4");
		lblNewLabel_10_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_10_1_1.setBounds(134, 540, 23, 26);
		panel_3.add(lblNewLabel_10_1_1);
		
		JLabel labelGunlukMesai = new JLabel("(GM)   Gunluk Mesai ");
		labelGunlukMesai.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGunlukMesai.setForeground(new Color(128, 0, 0));
		labelGunlukMesai.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGunlukMesai.setBorder(new LineBorder(Color.WHITE));
		labelGunlukMesai.setBounds(10, 412, 211, 26);
		panel_3.add(labelGunlukMesai);
		
		JLabel labelGunlukMesaiSay = new JLabel("0");
		labelGunlukMesaiSay.setHorizontalAlignment(SwingConstants.CENTER);
		labelGunlukMesaiSay.setForeground(new Color(128, 0, 0));
		labelGunlukMesaiSay.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGunlukMesaiSay.setBorder(new LineBorder(Color.WHITE));
		labelGunlukMesaiSay.setBounds(222, 412, 36, 26);
		panel_3.add(labelGunlukMesaiSay);
		
		JLabel labelGelmediSay_1 = new JLabel("0");
		labelGelmediSay_1.setBorder(new LineBorder(Color.WHITE));
		labelGelmediSay_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelGelmediSay_1.setForeground(Color.WHITE);
		labelGelmediSay_1.setFont(new Font("Dialog", Font.BOLD, 15));
		labelGelmediSay_1.setBounds(222, 375, 36, 26);
		panel_3.add(labelGelmediSay_1);
		
		JLabel lblUcretsizIzin = new JLabel("(UI)   Ucretsiz Izin ");
		lblUcretsizIzin.setBorder(new LineBorder(Color.WHITE));
		lblUcretsizIzin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUcretsizIzin.setForeground(Color.WHITE);
		lblUcretsizIzin.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUcretsizIzin.setBounds(10, 375, 211, 26);
		panel_3.add(lblUcretsizIzin);
	
		
		JComboBox comboBox2 = new JComboBox(gunler);
		
		
		
		comboBox2.setSelectedIndex(0);
		comboBox2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox2.setBorder(new LineBorder(Color.WHITE));
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setBounds(183, 50, 54, 29);
		panel.add(comboBox2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("02");
		lblNewLabel_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(143, 50, 30, 26);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox3 = new JComboBox(gunler);
		comboBox3.setSelectedIndex(0);
		comboBox3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox3.setBorder(new LineBorder(Color.WHITE));
		comboBox3.setBackground(Color.WHITE);
		comboBox3.setBounds(314, 51, 54, 29);
		panel.add(comboBox3);
		
		JLabel lblNewLabel_2 = new JLabel("03");
		lblNewLabel_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(274, 51, 30, 26);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox4 = new JComboBox(gunler);
		comboBox4.setSelectedIndex(0);
		comboBox4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox4.setBorder(new LineBorder(Color.WHITE));
		comboBox4.setBackground(Color.WHITE);
		comboBox4.setBounds(446, 50, 54, 29);
		panel.add(comboBox4);
		
		JLabel lblNewLabel_3 = new JLabel("04");
		lblNewLabel_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(406, 50, 30, 26);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox5 = new JComboBox(gunler);
		comboBox5.setSelectedIndex(0);
		comboBox5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox5.setBorder(new LineBorder(Color.WHITE));
		comboBox5.setBackground(Color.WHITE);
		comboBox5.setBounds(578, 50, 54, 29);
		panel.add(comboBox5);
		
		JLabel lblNewLabel_4 = new JLabel("05");
		lblNewLabel_4.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(538, 50, 30, 26);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox6 = new JComboBox(gunler);
		comboBox6.setSelectedIndex(0);
		comboBox6.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox6.setBorder(new LineBorder(Color.WHITE));
		comboBox6.setBackground(Color.WHITE);
		comboBox6.setBounds(711, 50, 54, 29);
		panel.add(comboBox6);
		
		JLabel lblNewLabel_5 = new JLabel("06");
		lblNewLabel_5.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(671, 50, 30, 26);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox7 = new JComboBox(gunler);
		comboBox7.setSelectedIndex(0);
		comboBox7.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox7.setBorder(new LineBorder(Color.WHITE));
		comboBox7.setBackground(Color.WHITE);
		comboBox7.setBounds(842, 50, 54, 29);
		panel.add(comboBox7);
		
		JLabel lblNewLabel_6 = new JLabel("07");
		lblNewLabel_6.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(802, 50, 30, 26);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("08");
		lblNewLabel_7.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 87, 30, 26);
		panel.add(lblNewLabel_7);
		
		JComboBox comboBox8 = new JComboBox(gunler);
		comboBox8.setSelectedIndex(0);
		comboBox8.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox8.setBorder(new LineBorder(Color.WHITE));
		comboBox8.setBackground(Color.WHITE);
		comboBox8.setBounds(50, 87, 54, 29);
		panel.add(comboBox8);
		
		JLabel lblNewLabel_1_1 = new JLabel("09");
		lblNewLabel_1_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(143, 87, 30, 26);
		panel.add(lblNewLabel_1_1);
		
		JComboBox comboBox9 = new JComboBox(gunler);
		comboBox9.setSelectedIndex(0);
		comboBox9.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox9.setBorder(new LineBorder(Color.WHITE));
		comboBox9.setBackground(Color.WHITE);
		comboBox9.setBounds(183, 87, 54, 29);
		panel.add(comboBox9);
		
		JLabel lblNewLabel_2_1 = new JLabel("10");
		lblNewLabel_2_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(274, 88, 30, 26);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox10 = new JComboBox(gunler);
		comboBox10.setSelectedIndex(0);
		comboBox10.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox10.setBorder(new LineBorder(Color.WHITE));
		comboBox10.setBackground(Color.WHITE);
		comboBox10.setBounds(314, 88, 54, 29);
		panel.add(comboBox10);
		
		JLabel lblNewLabel_3_1 = new JLabel("11");
		lblNewLabel_3_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(406, 87, 30, 26);
		panel.add(lblNewLabel_3_1);
		
		JComboBox comboBox11 = new JComboBox(gunler);
		comboBox11.setSelectedIndex(0);
		comboBox11.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox11.setBorder(new LineBorder(Color.WHITE));
		comboBox11.setBackground(Color.WHITE);
		comboBox11.setBounds(446, 87, 54, 29);
		panel.add(comboBox11);
		
		JLabel lblNewLabel_4_1 = new JLabel("12");
		lblNewLabel_4_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(538, 87, 30, 26);
		panel.add(lblNewLabel_4_1);
		
		JComboBox comboBox12 = new JComboBox(gunler);
		comboBox12.setSelectedIndex(0);
		comboBox12.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox12.setBorder(new LineBorder(Color.WHITE));
		comboBox12.setBackground(Color.WHITE);
		comboBox12.setBounds(578, 87, 54, 29);
		panel.add(comboBox12);
		
		JLabel lblNewLabel_5_1 = new JLabel("13");
		lblNewLabel_5_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(671, 87, 30, 26);
		panel.add(lblNewLabel_5_1);
		
		JComboBox comboBox13 = new JComboBox(gunler);
		comboBox13.setSelectedIndex(0);
		comboBox13.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox13.setBorder(new LineBorder(Color.WHITE));
		comboBox13.setBackground(Color.WHITE);
		comboBox13.setBounds(711, 87, 54, 29);
		panel.add(comboBox13);
		
		JLabel lblNewLabel_6_1 = new JLabel("14");
		lblNewLabel_6_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(802, 87, 30, 26);
		panel.add(lblNewLabel_6_1);
		
		JComboBox comboBox14 = new JComboBox(gunler);
		comboBox14.setSelectedIndex(0);
		comboBox14.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox14.setBorder(new LineBorder(Color.WHITE));
		comboBox14.setBackground(Color.WHITE);
		comboBox14.setBounds(842, 87, 54, 29);
		panel.add(comboBox14);
		
		JLabel lblNewLabel_8 = new JLabel("15");
		lblNewLabel_8.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 127, 30, 26);
		panel.add(lblNewLabel_8);
		
		JComboBox comboBox15 = new JComboBox(gunler);
		comboBox15.setSelectedIndex(0);
		comboBox15.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox15.setBorder(new LineBorder(Color.WHITE));
		comboBox15.setBackground(Color.WHITE);
		comboBox15.setBounds(50, 127, 54, 29);
		panel.add(comboBox15);
		
		JLabel lblNewLabel_1_2 = new JLabel("16");
		lblNewLabel_1_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(143, 127, 30, 26);
		panel.add(lblNewLabel_1_2);
		
		JComboBox comboBox16 = new JComboBox(gunler);
		comboBox16.setSelectedIndex(0);
		comboBox16.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox16.setBorder(new LineBorder(Color.WHITE));
		comboBox16.setBackground(Color.WHITE);
		comboBox16.setBounds(183, 127, 54, 29);
		panel.add(comboBox16);
		
		JLabel labelFM30 = new JLabel("");
		labelFM30.setVisible(false);
		labelFM30.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM30.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM30.setForeground(new Color(128, 0, 0));
		labelFM30.setBounds(234, 204, 30, 28);
		panel.add(labelFM30);
		
		JLabel lblNewLabel_2_2 = new JLabel("17");
		lblNewLabel_2_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(274, 128, 30, 26);
		panel.add(lblNewLabel_2_2);
		
		JComboBox comboBox17 = new JComboBox(gunler);
		comboBox17.setSelectedIndex(0);
		comboBox17.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox17.setBorder(new LineBorder(Color.WHITE));
		comboBox17.setBackground(Color.WHITE);
		comboBox17.setBounds(314, 128, 54, 29);
		panel.add(comboBox17);
		
		JLabel lblNewLabel_3_2 = new JLabel("18");
		lblNewLabel_3_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(406, 127, 30, 26);
		panel.add(lblNewLabel_3_2);
		
		JComboBox comboBox18 = new JComboBox(gunler);
		comboBox18.setSelectedIndex(0);
		comboBox18.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox18.setBorder(new LineBorder(Color.WHITE));
		comboBox18.setBackground(Color.WHITE);
		comboBox18.setBounds(446, 127, 54, 29);
		panel.add(comboBox18);
		
		JLabel lblNewLabel_4_2 = new JLabel("19");
		lblNewLabel_4_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(538, 127, 30, 26);
		panel.add(lblNewLabel_4_2);
		
		JLabel labelFM29 = new JLabel("");
		labelFM29.setVisible(false);
		labelFM29.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM29.setForeground(new Color(128, 0, 0));
		labelFM29.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM29.setBounds(103, 203, 30, 27);
		panel.add(labelFM29);
		
		JLabel labelFM28 = new JLabel("");
		labelFM28.setVisible(false);
		labelFM28.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM28.setForeground(new Color(128, 0, 0));
		labelFM28.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM28.setBounds(893, 167, 30, 27);
		panel.add(labelFM28);
		
		JLabel labelFM21 = new JLabel("");
		labelFM21.setBounds(893, 125, 30, 27);
		panel.add(labelFM21);
		labelFM21.setVisible(false);
		labelFM21.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM21.setForeground(new Color(128, 0, 0));
		labelFM21.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM27 = new JLabel("");
		labelFM27.setBounds(762, 167, 30, 27);
		panel.add(labelFM27);
		labelFM27.setVisible(false);
		labelFM27.setDoubleBuffered(true);
		labelFM27.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM27.setForeground(new Color(128, 0, 0));
		labelFM27.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM26 = new JLabel("");
		labelFM26.setBounds(631, 169, 30, 27);
		panel.add(labelFM26);
		labelFM26.setVisible(false);
		labelFM26.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM26.setForeground(new Color(128, 0, 0));
		labelFM26.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM26.setDoubleBuffered(true);
		
		JLabel labelFM25 = new JLabel("");
		labelFM25.setBounds(498, 169, 30, 27);
		panel.add(labelFM25);
		labelFM25.setVisible(false);
		labelFM25.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM25.setForeground(new Color(128, 0, 0));
		labelFM25.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM25.setDoubleBuffered(true);
		
		JLabel labelFM24 = new JLabel("");
		labelFM24.setBounds(366, 166, 30, 27);
		panel.add(labelFM24);
		labelFM24.setVisible(false);
		labelFM24.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM24.setForeground(new Color(128, 0, 0));
		labelFM24.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM20 = new JLabel("");
		labelFM20.setVisible(false);
		labelFM20.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM20.setForeground(new Color(128, 0, 0));
		labelFM20.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM20.setBounds(762, 127, 30, 27);
		panel.add(labelFM20);
		
		JLabel labelFM19 = new JLabel("");
		labelFM19.setVisible(false);
		labelFM19.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM19.setForeground(new Color(128, 0, 0));
		labelFM19.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM19.setBounds(631, 129, 30, 27);
		panel.add(labelFM19);
		
		JLabel labelFM18 = new JLabel("");
		labelFM18.setVisible(false);
		labelFM18.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM18.setForeground(new Color(128, 0, 0));
		labelFM18.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM18.setBounds(498, 129, 30, 27);
		panel.add(labelFM18);
		
		JLabel labelFM17 = new JLabel("");
		labelFM17.setVisible(false);
		labelFM17.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM17.setForeground(new Color(128, 0, 0));
		labelFM17.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM17.setBounds(366, 127, 30, 27);
		panel.add(labelFM17);
		
		JLabel labelFM16 = new JLabel("");
		labelFM16.setVisible(false);
		labelFM16.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM16.setForeground(new Color(128, 0, 0));
		labelFM16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM16.setBounds(234, 126, 30, 27);
		panel.add(labelFM16);
		
		JLabel labelFM15 = new JLabel("");
		labelFM15.setVisible(false);
		labelFM15.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM15.setForeground(new Color(128, 0, 0));
		labelFM15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM15.setBounds(103, 126, 30, 27);
		panel.add(labelFM15);
		
		JLabel labelFM14 = new JLabel("");
		labelFM14.setVisible(false);
		labelFM14.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM14.setForeground(new Color(128, 0, 0));
		labelFM14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM14.setBounds(893, 84, 30, 27);
		panel.add(labelFM14);
		
		JLabel labelFM13 = new JLabel("");
		labelFM13.setVisible(false);
		labelFM13.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM13.setForeground(new Color(128, 0, 0));
		labelFM13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM13.setBounds(762, 86, 30, 27);
		panel.add(labelFM13);
		
		JLabel labelFM12 = new JLabel("");
		labelFM12.setVisible(false);
		labelFM12.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM12.setForeground(new Color(128, 0, 0));
		labelFM12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM12.setBounds(631, 88, 30, 27);
		panel.add(labelFM12);
		
		JLabel labelFM11 = new JLabel("");
		labelFM11.setVisible(false);
		labelFM11.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM11.setForeground(new Color(128, 0, 0));
		labelFM11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM11.setBounds(498, 88, 30, 27);
		panel.add(labelFM11);
		
		JLabel labelFM10 = new JLabel("");
		labelFM10.setVisible(false);
		labelFM10.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM10.setForeground(new Color(128, 0, 0));
		labelFM10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM10.setBounds(366, 89, 30, 27);
		panel.add(labelFM10);
		
		JLabel labelFM9 = new JLabel("");
		labelFM9.setVisible(false);
		labelFM9.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM9.setForeground(new Color(128, 0, 0));
		labelFM9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM9.setBounds(234, 90, 30, 27);
		panel.add(labelFM9);
		
		JLabel labelFM8 = new JLabel("");
		labelFM8.setVisible(false);
		labelFM8.setDoubleBuffered(true);
		labelFM8.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM8.setForeground(new Color(128, 0, 0));
		labelFM8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM8.setBounds(103, 87, 30, 27);
		panel.add(labelFM8);
		
		JLabel labelFM7 = new JLabel("");
		labelFM7.setVisible(false);
		labelFM7.setDoubleBuffered(true);
		labelFM7.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM7.setForeground(new Color(128, 0, 0));
		labelFM7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM7.setBounds(893, 48, 30, 27);
		panel.add(labelFM7);
		
		JLabel labelFM6 = new JLabel("");
		labelFM6.setVisible(false);
		labelFM6.setDoubleBuffered(true);
		labelFM6.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM6.setForeground(new Color(128, 0, 0));
		labelFM6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM6.setBounds(762, 50, 30, 27);
		panel.add(labelFM6);
		
		JLabel labelFM1 = new JLabel("");
		labelFM1.setBounds(103, 49, 30, 27);
		panel.add(labelFM1);
		labelFM1.setVisible(false);
		labelFM1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM1.setForeground(new Color(128, 0, 0));
		labelFM1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM2 = new JLabel("");
		labelFM2.setBounds(234, 50, 30, 27);
		panel.add(labelFM2);
		labelFM2.setVisible(false);
		labelFM2.setDoubleBuffered(true);
		labelFM2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM2.setForeground(new Color(128, 0, 0));
		labelFM2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM3 = new JLabel("");
		labelFM3.setBounds(366, 50, 30, 27);
		panel.add(labelFM3);
		labelFM3.setVisible(false);
		labelFM3.setDoubleBuffered(true);
		labelFM3.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM3.setForeground(new Color(128, 0, 0));
		labelFM3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM4 = new JLabel("");
		labelFM4.setBounds(498, 52, 30, 27);
		panel.add(labelFM4);
		labelFM4.setVisible(false);
		labelFM4.setDoubleBuffered(true);
		labelFM4.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM4.setForeground(new Color(128, 0, 0));
		labelFM4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM5 = new JLabel("");
		labelFM5.setBounds(631, 52, 30, 27);
		panel.add(labelFM5);
		labelFM5.setVisible(false);
		labelFM5.setDoubleBuffered(true);
		labelFM5.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM5.setForeground(new Color(128, 0, 0));
		labelFM5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel labelFM23 = new JLabel("");
		labelFM23.setVisible(false);
		labelFM23.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM23.setForeground(new Color(128, 0, 0));
		labelFM23.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM23.setBounds(234, 167, 30, 27);
		panel.add(labelFM23);
		
		JLabel labelFM22 = new JLabel("");
		labelFM22.setVisible(false);
		labelFM22.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM22.setForeground(new Color(128, 0, 0));
		labelFM22.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM22.setBounds(103, 166, 30, 27);
		panel.add(labelFM22);
		
		
		
		JComboBox comboBox19 = new JComboBox(gunler);
		comboBox19.setSelectedIndex(0);
		comboBox19.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox19.setBorder(new LineBorder(Color.WHITE));
		comboBox19.setBackground(Color.WHITE);
		comboBox19.setBounds(578, 127, 54, 29);
		panel.add(comboBox19);
		
		JLabel labelFM31 = new JLabel("");
		labelFM31.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelFM31.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFM31.setForeground(new Color(128, 0, 0));
		labelFM31.setVisible(false);
		labelFM31.setBounds(366, 203, 30, 28);
		panel.add(labelFM31);
		
		JLabel lblNewLabel_5_2 = new JLabel("20");
		lblNewLabel_5_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_5_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(671, 127, 30, 26);
		panel.add(lblNewLabel_5_2);
		
		
		
		JComboBox comboBox20 = new JComboBox(gunler);
		comboBox20.setSelectedIndex(0);
		comboBox20.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox20.setBorder(new LineBorder(Color.WHITE));
		comboBox20.setBackground(Color.WHITE);
		comboBox20.setBounds(711, 127, 54, 29);
		panel.add(comboBox20);
		
		JLabel lblNewLabel_6_2 = new JLabel("21");
		lblNewLabel_6_2.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_6_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(802, 127, 30, 26);
		panel.add(lblNewLabel_6_2);
		
		JComboBox comboBox21 = new JComboBox(gunler);
		comboBox21.setSelectedIndex(0);
		comboBox21.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox21.setBorder(new LineBorder(Color.WHITE));
		comboBox21.setBackground(Color.WHITE);
		comboBox21.setBounds(842, 127, 54, 29);
		panel.add(comboBox21);
		
		JComboBox comboBox1 = new JComboBox(gunler);
		comboBox1.setBounds(50, 48, 54, 29);
		panel.add(comboBox1);
		
		comboBox1.setSelectedIndex(0);
		comboBox1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox1.setBorder(new LineBorder(Color.WHITE));
		comboBox1.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel_9 = new JLabel("22");
		lblNewLabel_9.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 167, 30, 26);
		panel.add(lblNewLabel_9);
		
		JComboBox comboBox22 = new JComboBox(gunler);
		comboBox22.setSelectedIndex(0);
		comboBox22.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox22.setBorder(new LineBorder(Color.WHITE));
		comboBox22.setBackground(Color.WHITE);
		comboBox22.setBounds(50, 167, 54, 29);
		panel.add(comboBox22);
		
		JLabel lblNewLabel_1_3 = new JLabel("23");
		lblNewLabel_1_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(143, 167, 30, 26);
		panel.add(lblNewLabel_1_3);
		
		JComboBox comboBox23 = new JComboBox(gunler);
		comboBox23.setSelectedIndex(0);
		comboBox23.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox23.setBorder(new LineBorder(Color.WHITE));
		comboBox23.setBackground(Color.WHITE);
		comboBox23.setBounds(183, 164, 54, 29);
		panel.add(comboBox23);
		
		JLabel lblNewLabel_2_3 = new JLabel("24");
		lblNewLabel_2_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(274, 168, 30, 26);
		panel.add(lblNewLabel_2_3);
		
		JComboBox comboBox24 = new JComboBox(gunler);
		comboBox24.setSelectedIndex(0);
		comboBox24.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox24.setBorder(new LineBorder(Color.WHITE));
		comboBox24.setBackground(Color.WHITE);
		comboBox24.setBounds(314, 168, 54, 29);
		panel.add(comboBox24);
		
		JLabel lblNewLabel_3_3 = new JLabel("25");
		lblNewLabel_3_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_3_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(406, 167, 30, 26);
		panel.add(lblNewLabel_3_3);
		
		JComboBox comboBox25 = new JComboBox(gunler);
		comboBox25.setSelectedIndex(0);
		comboBox25.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox25.setBorder(new LineBorder(Color.WHITE));
		comboBox25.setBackground(Color.WHITE);
		comboBox25.setBounds(446, 167, 54, 29);
		panel.add(comboBox25);
		
		JLabel lblNewLabel_4_3 = new JLabel("26");
		lblNewLabel_4_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_4_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(538, 167, 30, 26);
		panel.add(lblNewLabel_4_3);
		
		JComboBox comboBox26 = new JComboBox(gunler);
		comboBox26.setSelectedIndex(0);
		comboBox26.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox26.setBorder(new LineBorder(Color.WHITE));
		comboBox26.setBackground(Color.WHITE);
		comboBox26.setBounds(578, 167, 54, 29);
		panel.add(comboBox26);
		
		JLabel lblNewLabel_5_3 = new JLabel("27");
		lblNewLabel_5_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_5_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_3.setBounds(671, 167, 30, 26);
		panel.add(lblNewLabel_5_3);
		
		JComboBox comboBox27 = new JComboBox(gunler);
		comboBox27.setSelectedIndex(0);
		comboBox27.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox27.setBorder(new LineBorder(Color.WHITE));
		comboBox27.setBackground(Color.WHITE);
		comboBox27.setBounds(711, 167, 54, 29);
		panel.add(comboBox27);
		
		JLabel lblNewLabel_6_3 = new JLabel("28");
		lblNewLabel_6_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_6_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_3.setBounds(802, 167, 30, 26);
		panel.add(lblNewLabel_6_3);
		
		
		JComboBox comboBox28 = new JComboBox(gunler);
		comboBox28.setSelectedIndex(0);
		comboBox28.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox28.setBorder(new LineBorder(Color.WHITE));
		comboBox28.setBackground(Color.WHITE);
		comboBox28.setBounds(842, 167, 54, 29);
		panel.add(comboBox28);
		
		JLabel label29 = new JLabel("29");
		label29.setBorder(new LineBorder(Color.WHITE));
		label29.setForeground(new Color(0, 0, 0));
		label29.setHorizontalAlignment(SwingConstants.CENTER);
		label29.setFont(new Font("Tahoma", Font.BOLD, 14));
		label29.setBounds(10, 204, 30, 26);
		panel.add(label29);
		
		JComboBox comboBox29 = new JComboBox(gunler);
		comboBox29.setSelectedIndex(0);
		comboBox29.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox29.setBorder(new LineBorder(Color.WHITE));
		comboBox29.setBackground(Color.WHITE);
		comboBox29.setBounds(50, 204, 54, 29);
		panel.add(comboBox29);
		
		
		
		JComboBox comboBox30 = new JComboBox(gunler);
		comboBox30.setSelectedIndex(0);
		comboBox30.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox30.setBorder(new LineBorder(Color.WHITE));
		comboBox30.setBackground(Color.WHITE);
		comboBox30.setBounds(183, 204, 54, 29);
		panel.add(comboBox30);
		
		
		
		
		JLabel label31 = new JLabel("31");
		label31.setBorder(new LineBorder(Color.WHITE));
		label31.setForeground(new Color(0, 0, 0));
		label31.setHorizontalAlignment(SwingConstants.CENTER);
		label31.setFont(new Font("Tahoma", Font.BOLD, 14));
		label31.setBounds(274, 205, 30, 26);
		panel.add(label31);
		
		JComboBox comboBox31 = new JComboBox(gunler);
		
		
		comboBox31.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboBox31.getSelectedItem().toString().equals("SM")) {	
					
					try {
					
					fazlaMesai31 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai31));											
					
					
					if(fazlaMesai31>0)
						
					{
					labelFM31.setVisible(true);														
					labelFM31.setText(" "+fazlaMesai31+" saat");
					//comboBox31.setBounds(391, 205, 90, 29);										
					}	
				else 
					{
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				else {
					labelFM31.setVisible(false);
					fazlaMesai31=0;
					labelFM31.setText(""+fazlaMesai31);
					//comboBox31.setBounds(391, 205, 122, 29);
					}				
			}
		});
		
		comboBox30.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox30.getSelectedItem().toString().equals("SM")){	
					
					try {
						
					fazlaMesai30 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai30));											
					if(fazlaMesai30>0)
					{labelFM30.setVisible(true);														
					labelFM30.setText(" "+fazlaMesai30+" saat");
					//comboBox30.setBounds(219, 204, 90, 29);																
					}					
					else
					{
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}										
				}
			
			catch(Exception e1) {
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
			}
				}
				else {
					labelFM30.setVisible(false);
					fazlaMesai30=0;
					labelFM30.setText(""+fazlaMesai30);
					//comboBox30.setBounds(219, 204, 122, 29);
					}				
			}
		});
	
		comboBox29.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox29.getSelectedItem().toString().equals("SM")) {
					
					try {
					fazlaMesai29 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai29));											
					if(fazlaMesai29>0)
					{labelFM29.setVisible(true);														
					labelFM29.setText(" "+fazlaMesai29+" saat");
					//comboBox29.setBounds(50, 204, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
				}
				catch(Exception e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				}
				else {labelFM29.setVisible(false);
				      fazlaMesai29=0;
					  labelFM29.setText(""+fazlaMesai29);
					  //comboBox29.setBounds(50, 204, 119, 29);
					  }}});

		comboBox28.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox28.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai28 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai28));											
					if(fazlaMesai28>0)
					{labelFM28.setVisible(true);														
					labelFM28.setText(" "+fazlaMesai28+" saat");
					//comboBox28.setBounds(1079, 167, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					
				}
				catch(Exception e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				}
				else {labelFM28.setVisible(false);
				      fazlaMesai28=0;
					  labelFM28.setText(""+fazlaMesai28);
					  //comboBox28.setBounds(1079, 167, 122, 29);
					  }}});
		
		comboBox27.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox27.getSelectedItem().toString().equals("SM")) {	
					
					try {
					
					fazlaMesai27 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai27));											
					if(fazlaMesai27>0)
					{labelFM27.setVisible(true);														
					labelFM27.setText(" "+fazlaMesai27+" saat");
					//comboBox27.setBounds(907, 167, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					
					
					
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					}
				else {labelFM27.setVisible(false);
				      fazlaMesai27=0;
					  labelFM27.setText(""+fazlaMesai27);
					  //comboBox27.setBounds(907, 167, 122, 29);
					  }}});				
		//26  735, 167, 122, 29		
		comboBox26.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox26.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai26 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai26));											
					if(fazlaMesai26>0)
					{labelFM26.setVisible(true);														
					labelFM26.setText(" "+fazlaMesai26+" saat");
					//comboBox26.setBounds(735, 167, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					}
				else {labelFM26.setVisible(false);
				      fazlaMesai26=0;
					  labelFM26.setText(""+fazlaMesai26);
					  //comboBox26.setBounds(735, 167, 122, 29);
					  }}});
		//25  563, 167, 122, 29
		comboBox25.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox25.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai25 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai25));											
					if(fazlaMesai25>0)
					{labelFM25.setVisible(true);														
					labelFM25.setText(" "+fazlaMesai25+" saat");
					//comboBox25.setBounds(563, 167, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM25.setVisible(false);
				      fazlaMesai25=0;
					  labelFM25.setText(""+fazlaMesai25);
					  //comboBox25.setBounds(563, 167, 122, 29);
					  }}});		
		//24  391, 168, 122, 29		
		comboBox24.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox24.getSelectedItem().toString().equals("SM")) {		
					
					try {
					fazlaMesai24 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai24));											
					if(fazlaMesai24>0)
					{labelFM24.setVisible(true);														
					labelFM24.setText(" "+fazlaMesai24+" saat");
					//comboBox24.setBounds(391, 168, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					}
				else {labelFM24.setVisible(false);
				      fazlaMesai24=0;
					  labelFM24.setText(""+fazlaMesai24);
					 // comboBox24.setBounds(391, 168, 122, 29);
					  }}});
		//23  219, 164, 122, 29
		comboBox23.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox23.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai23 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai23));											
					if(fazlaMesai23>0)
					{labelFM23.setVisible(true);														
					labelFM23.setText(" "+fazlaMesai23+" saat");
					//comboBox23.setBounds(219, 164, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM23.setVisible(false);
				      fazlaMesai23=0;
					  labelFM23.setText(""+fazlaMesai23);
					  //comboBox23.setBounds(219, 164, 122, 29);
					  }}});
		//22  50, 167, 119, 29
		comboBox22.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox22.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai22 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai22));											
					if(fazlaMesai22>0)
					{labelFM22.setVisible(true);														
					labelFM22.setText(" "+fazlaMesai22+" saat");
					//comboBox22.setBounds(50, 167, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM22.setVisible(false);
				      fazlaMesai22=0;
					  labelFM22.setText(""+fazlaMesai22);
					  //comboBox22.setBounds(50, 167, 119, 29);
					  }}});
		
		//21  1079, 127, 122, 29
		comboBox21.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox21.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai21 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai21));											
					if(fazlaMesai21>0)
					{labelFM21.setVisible(true);														
					labelFM21.setText(" "+fazlaMesai21+" saat");
					//comboBox21.setBounds(1079, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM21.setVisible(false);
				      fazlaMesai21=0;
					  labelFM21.setText(""+fazlaMesai21);
					  //comboBox21.setBounds(1079, 127, 122, 29);
					  }}});
		//20  907, 127, 122, 29
		comboBox20.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox20.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai20 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai20));											
					if(fazlaMesai20>0)
					{labelFM20.setVisible(true);														
					labelFM20.setText(" "+fazlaMesai20+" saat");
					//comboBox20.setBounds(907, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM20.setVisible(false);
				      fazlaMesai20=0;
					  labelFM20.setText(""+fazlaMesai20);
					  //comboBox20.setBounds(907, 127, 122, 29);
					  }}});
		
		//19  735, 127, 122, 29
		comboBox19.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox19.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai19 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai19));											
					if(fazlaMesai19>0)
					{labelFM19.setVisible(true);														
					labelFM19.setText(" "+fazlaMesai19+" saat");
					//comboBox19.setBounds(735, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM19.setVisible(false);
				      fazlaMesai19=0;
					  labelFM19.setText(""+fazlaMesai19);
					  //comboBox19.setBounds(735, 127, 122, 29);
					  }}});
		//18  563, 127, 122, 29
		comboBox18.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox18.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai18 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai18));											
					if(fazlaMesai18>0)
					{labelFM18.setVisible(true);														
					labelFM18.setText(" "+fazlaMesai18+" saat");
					//comboBox18.setBounds(563, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM18.setVisible(false);
				      fazlaMesai18=0;
					  labelFM18.setText(""+fazlaMesai18);
					  //comboBox18.setBounds(563, 127, 122, 29);
					  }}});
		//17  391, 128, 122, 29
		comboBox17.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox17.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai17 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai17));											
					if(fazlaMesai17>0)
					{labelFM17.setVisible(true);														
					labelFM17.setText(" "+fazlaMesai17+" saat");
					//comboBox17.setBounds(391, 128,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM17.setVisible(false);
				      fazlaMesai17=0;
					  labelFM17.setText(""+fazlaMesai17);
					  //comboBox17.setBounds(391, 128, 122, 29);
					  }}});
		//16  219, 127, 122, 29
		comboBox16.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox16.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai16 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai16));											
					if(fazlaMesai16>0)
					{labelFM16.setVisible(true);														
					labelFM16.setText(" "+fazlaMesai16+" saat");
					//comboBox16.setBounds(219, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM16.setVisible(false);
				      fazlaMesai16=0;
					  labelFM16.setText(""+fazlaMesai16);
					  //comboBox16.setBounds(219, 127, 122, 29);
					  }}});
		//15  50, 127, 122, 29
		comboBox15.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox15.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai15 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai15));											
					if(fazlaMesai15>0)
					{labelFM15.setVisible(true);														
					labelFM15.setText(" "+fazlaMesai15+" saat");
					//comboBox15.setBounds(50, 127,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM15.setVisible(false);
				      fazlaMesai15=0;
					  labelFM15.setText(""+fazlaMesai15);
					  //comboBox15.setBounds(50, 127, 122, 29);
					  }}});
		//14 1079, 87, 122, 29
		comboBox14.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox14.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai14 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai14));											
					if(fazlaMesai14>0)
					{labelFM14.setVisible(true);														
					labelFM14.setText(" "+fazlaMesai14+" saat");
					//comboBox14.setBounds(1079, 87,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM14.setVisible(false);
				      fazlaMesai14=0;
					  labelFM14.setText(""+fazlaMesai14);
					  //comboBox14.setBounds(1079, 87, 122, 29);
					  }}});
		//13  907, 87, 122, 29
		comboBox13.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox13.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai13 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai13));											
					if(fazlaMesai13>0)
					{labelFM13.setVisible(true);														
					labelFM13.setText(" "+fazlaMesai13+" saat");
					//comboBox13.setBounds(907, 87,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM13.setVisible(false);
				      fazlaMesai13=0;
					  labelFM13.setText(""+fazlaMesai13);
					  //comboBox13.setBounds(907, 87, 122, 29);
					  }}});
		
		//12  735, 87, 122, 29
		comboBox12.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox12.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai12 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai12));											
					if(fazlaMesai12>0)
					{labelFM12.setVisible(true);														
					labelFM12.setText(" "+fazlaMesai12+" saat");
					//comboBox12.setBounds(735, 87,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM12.setVisible(false);
				      fazlaMesai12=0;
					  labelFM12.setText(""+fazlaMesai12);
					  //comboBox12.setBounds(735, 87, 122, 29);
					  }}});
		//11  563, 87, 122, 29
		comboBox11.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox11.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai11 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai11));											
					if(fazlaMesai11>0)
					{labelFM11.setVisible(true);														
					labelFM11.setText(" "+fazlaMesai11+" saat");
					//comboBox11.setBounds(563, 87,90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM11.setVisible(false);
				      fazlaMesai11=0;
					  labelFM11.setText(""+fazlaMesai11);
					  //comboBox11.setBounds(563, 87, 122, 29);
					  }}});
		//10  391, 88, 122, 29
		comboBox10.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox10.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai10 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai10));											
					if(fazlaMesai10>0)
					{labelFM10.setVisible(true);														
					labelFM10.setText(" "+fazlaMesai10+" saat");
					//comboBox10.setBounds(391, 88, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM10.setVisible(false);
				      fazlaMesai10=0;
					  labelFM10.setText(""+fazlaMesai10);
					  //comboBox10.setBounds(391, 88, 122, 29);
					  }}});
		//9  219, 87, 122, 29
		comboBox9.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox9.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai9 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai9));											
					if(fazlaMesai9>0)
					{labelFM9.setVisible(true);														
					labelFM9.setText(" "+fazlaMesai9+" saat");
					//comboBox9.setBounds(219, 87, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM9.setVisible(false);
				      fazlaMesai9=0;
					  labelFM9.setText(""+fazlaMesai9);
					  //comboBox9.setBounds(219, 87, 122, 29);
					  }}});
		//8  50, 87, 122, 29
		comboBox8.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox8.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai8 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai8));											
					if(fazlaMesai8>0)
					{labelFM8.setVisible(true);														
					labelFM8.setText(" "+fazlaMesai8+" saat");
					//comboBox8.setBounds(50, 87, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM8.setVisible(false);
				      fazlaMesai8=0;
					  labelFM8.setText(""+fazlaMesai8);
					  //comboBox8.setBounds(50, 87, 122, 29);
					  }}});
		//7  1079, 50, 122, 29
		comboBox7.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox7.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai7 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai7));											
					if(fazlaMesai7>0)
					{labelFM7.setVisible(true);														
					labelFM7.setText(" "+fazlaMesai7+" saat");
					//comboBox7.setBounds(1079, 50, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM7.setVisible(false);
				      fazlaMesai7=0;
					  labelFM7.setText(""+fazlaMesai7);
					 // comboBox7.setBounds(1079, 50, 122, 29);
					  }}});
		//6  907, 50, 122, 29
		comboBox6.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox6.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai6 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai6));											
					if(fazlaMesai6>0)
					{labelFM6.setVisible(true);														
					labelFM6.setText(" "+fazlaMesai6+" saat");
					//comboBox6.setBounds(907, 50, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM6.setVisible(false);
				      fazlaMesai6=0;
					  labelFM6.setText(""+fazlaMesai6);
					  //comboBox6.setBounds(907, 50, 122, 29);
					  }}});
		//5  735, 50, 122, 29
		comboBox5.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox5.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai5 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai5));											
					if(fazlaMesai5>0)
					{labelFM5.setVisible(true);														
					labelFM5.setText(" "+fazlaMesai5+" saat");
					//comboBox5.setBounds(735, 50, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM5.setVisible(false);
				      fazlaMesai5=0;
					  labelFM5.setText(""+fazlaMesai5);
					  //comboBox5.setBounds(735, 50, 122, 29);
					  }}});
		//4  563, 50, 122, 29
		comboBox4.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox4.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai4 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai4));											
					if(fazlaMesai4>0)
					{labelFM4.setVisible(true);														
					labelFM4.setText(" "+fazlaMesai4+" saat");
					//comboBox4.setBounds(563, 50, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM4.setVisible(false);
				      fazlaMesai4=0;
					  labelFM4.setText(""+fazlaMesai4);
					  //comboBox4.setBounds(563, 50, 122, 29);
					  }}});
		//3  391, 51, 122, 29
		comboBox3.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox3.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai3 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai3));											
					if(fazlaMesai3>0)
					{labelFM3.setVisible(true);														
					labelFM3.setText(" "+fazlaMesai3+" saat");
					//comboBox3.setBounds(391, 51, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM3.setVisible(false);
				      fazlaMesai3=0;
					  labelFM3.setText(""+fazlaMesai3);
					  //comboBox3.setBounds(391, 51, 122, 29);
					  }}});
		//2  219, 50, 122, 29
		comboBox2.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox2.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai2 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai2));											
					if(fazlaMesai2>0)
					{labelFM2.setVisible(true);														
					labelFM2.setText(" "+fazlaMesai2+" saat");
					//comboBox2.setBounds(219, 50, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM2.setVisible(false);
				      fazlaMesai2=0;
					  labelFM2.setText(""+fazlaMesai2);
					  //comboBox2.setBounds(219, 50, 122, 29);
					  }}});
		//1  50, 48, 122, 29
		comboBox1.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(comboBox1.getSelectedItem().toString().equals("SM")) {	
					try {
					fazlaMesai1 = Integer.parseInt(JOptionPane.showInputDialog("Mesai Saati Giriniz: ",+fazlaMesai1));											
					if(fazlaMesai1>0)
					{labelFM1.setVisible(true);														
					labelFM1.setText(" "+fazlaMesai1+" saat");
					//comboBox1.setBounds(50, 48, 90, 29);
					}					
					else{JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);}
					}
					catch(Exception e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Mesai Girilmedi", "UYARI" , JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else {labelFM1.setVisible(false);
				      fazlaMesai1=0;
					  labelFM1.setText(""+fazlaMesai1);
					 // comboBox1.setBounds(50, 48, 122, 29);
					  }}});
		
		
		
		
		comboBox31.setSelectedIndex(0);
		comboBox31.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox31.setBorder(new LineBorder(Color.WHITE));
		comboBox31.setBackground(Color.WHITE);
		comboBox31.setBounds(314, 205, 54, 29);
		panel.add(comboBox31);
		
		JLabel labelGun1 = new JLabel("");
		labelGun1.setBorder(new LineBorder(Color.WHITE));
		labelGun1.setForeground(Color.BLACK);
		labelGun1.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun1.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun1.setBounds(10, 13, 123, 26);
		panel.add(labelGun1);
		
		JLabel labelGun2 = new JLabel("");
		labelGun2.setBorder(new LineBorder(Color.WHITE));
		labelGun2.setForeground(Color.BLACK);
		labelGun2.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun2.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun2.setBounds(143, 13, 121, 26);
		panel.add(labelGun2);
		
		JLabel labelGun3 = new JLabel("");
		labelGun3.setBorder(new LineBorder(Color.WHITE));
		labelGun3.setForeground(Color.BLACK);
		labelGun3.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun3.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun3.setBounds(274, 13, 122, 26);
		panel.add(labelGun3);
		
		JLabel labelGun4 = new JLabel("");
		labelGun4.setBorder(new LineBorder(Color.WHITE));
		labelGun4.setForeground(Color.BLACK);
		labelGun4.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun4.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun4.setBounds(406, 13, 122, 26);
		panel.add(labelGun4);
		
		JLabel labelGun5 = new JLabel("");
		labelGun5.setBorder(new LineBorder(Color.WHITE));
		labelGun5.setForeground(Color.BLACK);
		labelGun5.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun5.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun5.setBounds(538, 13, 123, 26);
		panel.add(labelGun5);
		
		JLabel labelGun6 = new JLabel("");
		labelGun6.setBorder(new LineBorder(Color.WHITE));
		labelGun6.setForeground(Color.BLACK);
		labelGun6.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun6.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun6.setBounds(671, 13, 121, 26);
		panel.add(labelGun6);
		
		JLabel labelGun7 = new JLabel("");
		labelGun7.setBorder(new LineBorder(Color.WHITE));
		labelGun7.setForeground(Color.BLACK);
		labelGun7.setHorizontalAlignment(SwingConstants.CENTER);
		labelGun7.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelGun7.setBounds(802, 13, 121, 26);
		panel.add(labelGun7);
		
		
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHesapla.setBounds(812, 208, 84, 28);
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
				//tGC=0;
				
				
				
	
				
				
				
				
			
				
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
					else if(comboBox1.getSelectedIndex()==14){gO++;}
				
		
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
					else if(comboBox2.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox3.getSelectedIndex()==14){gO++;}
			
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
					else if(comboBox4.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox5.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox6.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox7.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox8.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox9.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox10.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox11.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox12.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox13.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox14.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox15.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox5.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox17.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox18.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox19.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox20.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox21.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox22.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox23.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox24.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox25.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox26.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox27.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox28.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox29.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox30.getSelectedIndex()==14){gO++;}
				 
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
					else if(comboBox31.getSelectedIndex()==14){gO++;}
				 
				 
				 
				 
				 
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
			
			
			labelSaatlikMesaiSay.setText(""+(fazlaMesai1+fazlaMesai2+fazlaMesai3+fazlaMesai4+fazlaMesai5+fazlaMesai6+fazlaMesai7+fazlaMesai8+
				fazlaMesai9+fazlaMesai10+fazlaMesai11+fazlaMesai12+fazlaMesai13+fazlaMesai14+fazlaMesai15+fazlaMesai16+fazlaMesai17+
				fazlaMesai18+fazlaMesai19+fazlaMesai20+fazlaMesai21+fazlaMesai22+fazlaMesai23+fazlaMesai24+fazlaMesai25+fazlaMesai26+
				fazlaMesai27+fazlaMesai28+fazlaMesai29+fazlaMesai30+fazlaMesai31));						
			labelMaasHesaplacakGunSay.setText(""+(gO+rT+hT+yG+oI+bI+eI+yI+iI));
			//labelYolUcretiVerilecekGunSay.setText(""+((2*yG)+gO));
			labelYemekUcretiVerGunSay.setText(""+((2*yG)+gO));
			
			
			}});
		
		btnHesapla.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHesapla.setBackground(UIManager.getColor("Button.light"));
		
		
		
		
		
			
		
		
		
		
//**************************************************************************************************************************************************************
			
			
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBorder(new LineBorder(Color.WHITE));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 89, 193, 166);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel labelIsimYaz = new JLabel("");
		labelIsimYaz.setForeground(new Color(255, 255, 255));
		labelIsimYaz.setHorizontalAlignment(SwingConstants.LEFT);
		labelIsimYaz.setBorder(null);
		labelIsimYaz.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelIsimYaz.setBounds(5, 92, 178, 24);
		panel_2.add(labelIsimYaz);
		
		JLabel labelUnvanYaz = new JLabel("");
		labelUnvanYaz.setForeground(new Color(255, 255, 255));
		labelUnvanYaz.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnvanYaz.setBorder(null);
		labelUnvanYaz.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelUnvanYaz.setBounds(5, 64, 178, 24);
		panel_2.add(labelUnvanYaz);
		
		JComboBox comboBoxSicil = new JComboBox(DataBaseSQL.sicilListele(mudurlukAl).toArray());
		comboBoxSicil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxSicil.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxSicil.setBackground(Color.WHITE);
		comboBoxSicil.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxSicil.setBounds(30, 33, 153, 26);
		panel_2.add(comboBoxSicil);
		
		JLabel lblNewLabel_10_1 = new JLabel("2");
		lblNewLabel_10_1.setBounds(0, 11, 20, 26);
		panel_2.add(lblNewLabel_10_1);
		lblNewLabel_10_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnNewButton_1_1 = new JButton("Personel Ekle");
		btnNewButton_1_1.setBounds(30, 11, 153, 17);
		panel_2.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MudurlukPanel2.this.dispose();
				PersonelUI mPane2sl=new PersonelUI();
				mPane2sl.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1_1.setBackground(UIManager.getColor("Button.light"));
		
		JLabel labelMudurlukYaz = new JLabel("");
		labelMudurlukYaz.setHorizontalAlignment(SwingConstants.LEFT);
		labelMudurlukYaz.setForeground(Color.WHITE);
		labelMudurlukYaz.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelMudurlukYaz.setBorder(null);
		labelMudurlukYaz.setBounds(5, 126, 178, 24);
		panel_2.add(labelMudurlukYaz);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 193, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateChooser.setBounds(22, 30, 114, 21);
		panel_1.add(dateChooser);
		
		JButton btnNewButton_1 = new JButton("Sec");
		btnNewButton_1.setBounds(137, 30, 53, 21);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBackground(UIManager.getColor("Button.light"));
		
		JLabel lblNewLabel = new JLabel("Hak Edis Ayinin Ilk Gununu Seciniz.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(12, 6, 171, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_10 = new JLabel("1");
		lblNewLabel_10.setBounds(0, 25, 20, 27);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(128, 0, 0));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel lblNewLabel_10_2 = new JLabel("3");
		lblNewLabel_10_2.setBounds(782, 204, 20, 34);
		panel.add(lblNewLabel_10_2);
		lblNewLabel_10_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		
		
		
		
		
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("5");
		lblNewLabel_10_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_10_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_10_1_1_1.setBounds(10, 468, 28, 44);
		panel_4.add(lblNewLabel_10_1_1_1);
		
		
		
		
		
		JButton btnTmnOnayla_1_1 = new JButton("Sil");
	
		btnTmnOnayla_1_1.setBounds(137, 461, 58, 26);
		panel_4.add(btnTmnOnayla_1_1);
		btnTmnOnayla_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmnOnayla_1_1.setBackground(UIManager.getColor("Button.light"));
		
		JButton btnTmnOnayla = new JButton("T\u00FCm\u00FCn\u00FC Onayla");
		btnTmnOnayla.setBounds(205, 461, 142, 26);
		panel_4.add(btnTmnOnayla);
		btnTmnOnayla.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmnOnayla.setBackground(UIManager.getColor("Button.light"));
		
		JLabel lblNewLabel_11 = new JLabel("Sicil");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(10, 11, 50, 20);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Unvan");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1.setBounds(70, 11, 84, 20);
		panel_4.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Mesai");
		lblNewLabel_11_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2.setForeground(Color.WHITE);
		lblNewLabel_11_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11_2.setBounds(164, 11, 40, 20);
		panel_4.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_3 = new JLabel("Ucret Gun");
		lblNewLabel_11_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_3.setForeground(Color.WHITE);
		lblNewLabel_11_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11_3.setBounds(214, 11, 58, 20);
		panel_4.add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("Yol/Yemek");
		lblNewLabel_11_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_3_1.setForeground(Color.WHITE);
		lblNewLabel_11_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11_3_1.setBounds(282, 11, 65, 20);
		panel_4.add(lblNewLabel_11_3_1);
		
		 
		 
		
		
	
		
		
		
		
		dateChooser.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			
	    	    
	    	   
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		setLocationRelativeTo(null);
		
		
		
		
//*************************************************************************************************************************************************************
		
//		hak ediþ tarih combobxlarýn listenerleri aþaðýda
		
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
				if(!comboBox1.getSelectedItem().toString().equals("X")) {
					comboBox1.setBackground(new Color(233, 150, 122));}
				else {comboBox1.setBackground(SystemColor.WHITE);}}});
		
		
			comboBox2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox2.getSelectedItem().toString().equals("X")) {
						comboBox2.setBackground(new Color(233, 150, 122));}
					else {comboBox2.setBackground(SystemColor.WHITE);}}});
			
			comboBox3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox3.getSelectedItem().toString().equals("X")) {
						comboBox3.setBackground(new Color(233, 150, 122));}
					else {comboBox3.setBackground(SystemColor.WHITE);}}});
			
			comboBox4.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox4.getSelectedItem().toString().equals("X")) {
						comboBox4.setBackground(new Color(233, 150, 122));}
					else {comboBox4.setBackground(SystemColor.WHITE);}}});
			
			comboBox5.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox5.getSelectedItem().toString().equals("X")) {
						comboBox5.setBackground(new Color(233, 150, 122));}
					else {comboBox5.setBackground(SystemColor.WHITE);}}});
			
			comboBox6.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox6.getSelectedItem().toString().equals("X")) {
						comboBox6.setBackground(new Color(233, 150, 122));}
					else {comboBox6.setBackground(SystemColor.WHITE);}}});
			
			comboBox7.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox7.getSelectedItem().toString().equals("X")) {
						comboBox7.setBackground(new Color(233, 150, 122));}
					else {comboBox7.setBackground(SystemColor.WHITE);}}});
			
			comboBox8.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox8.getSelectedItem().toString().equals("X")) {
						comboBox8.setBackground(new Color(233, 150, 122));}
					else {comboBox8.setBackground(SystemColor.WHITE);}}});
			
			comboBox9.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox9.getSelectedItem().toString().equals("X")) {
						comboBox9.setBackground(new Color(233, 150, 122));}
					else {comboBox9.setBackground(SystemColor.WHITE);}}});
			
			comboBox10.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox10.getSelectedItem().toString().equals("X")) {
						comboBox10.setBackground(new Color(233, 150, 122));}
					else {comboBox10.setBackground(SystemColor.WHITE);}}});
			
			comboBox11.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox11.getSelectedItem().toString().equals("X")) {
						comboBox11.setBackground(new Color(233, 150, 122));}
					else {comboBox11.setBackground(SystemColor.WHITE);}}});
			
			comboBox12.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox12.getSelectedItem().toString().equals("X")) {
						comboBox12.setBackground(new Color(233, 150, 122));}
					else {comboBox12.setBackground(SystemColor.WHITE);}}});
			
			comboBox13.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox13.getSelectedItem().toString().equals("X")) {
						comboBox13.setBackground(new Color(233, 150, 122));}
					else {comboBox13.setBackground(SystemColor.WHITE);}}});
			
			comboBox14.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox14.getSelectedItem().toString().equals("X")) {
						comboBox14.setBackground(new Color(233, 150, 122));}
					else {comboBox14.setBackground(SystemColor.WHITE);}}});
			
			comboBox15.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox15.getSelectedItem().toString().equals("X")) {
						comboBox15.setBackground(new Color(233, 150, 122));}
					else {comboBox15.setBackground(SystemColor.WHITE);}}});
			
			comboBox16.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox16.getSelectedItem().toString().equals("X")) {
						comboBox16.setBackground(new Color(233, 150, 122));}
					else {comboBox16.setBackground(SystemColor.WHITE);}}});
			
			comboBox17.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox17.getSelectedItem().toString().equals("X")) {
						comboBox17.setBackground(new Color(233, 150, 122));}
					else {comboBox17.setBackground(SystemColor.WHITE);}}});
			
			comboBox18.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox18.getSelectedItem().toString().equals("X")) {
						comboBox18.setBackground(new Color(233, 150, 122));}
					else {comboBox18.setBackground(SystemColor.WHITE);}}});
			
			comboBox19.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox19.getSelectedItem().toString().equals("X")) {
						comboBox19.setBackground(new Color(233, 150, 122));}
					else {comboBox19.setBackground(SystemColor.WHITE);}}});
			
			comboBox20.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox20.getSelectedItem().toString().equals("X")) {
						comboBox20.setBackground(new Color(233, 150, 122));}
					else {comboBox20.setBackground(SystemColor.WHITE);}}});
			
			comboBox21.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox21.getSelectedItem().toString().equals("X")) {
						comboBox21.setBackground(new Color(233, 150, 122));}
					else {comboBox21.setBackground(SystemColor.WHITE);}}});
			
			comboBox22.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox22.getSelectedItem().toString().equals("X")) {
						comboBox22.setBackground(new Color(233, 150, 122));}
					else {comboBox22.setBackground(SystemColor.WHITE);}}});
			
			comboBox23.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox23.getSelectedItem().toString().equals("X")) {
						comboBox23.setBackground(new Color(233, 150, 122));}
					else {comboBox23.setBackground(SystemColor.WHITE);}}});
			
			comboBox24.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox24.getSelectedItem().toString().equals("X")) {
						comboBox24.setBackground(new Color(233, 150, 122));}
					else {comboBox24.setBackground(SystemColor.WHITE);}}});
			
			comboBox25.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox25.getSelectedItem().toString().equals("X")) {
						comboBox25.setBackground(new Color(233, 150, 122));}
					else {comboBox25.setBackground(SystemColor.WHITE);}}});
			
			comboBox26.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox26.getSelectedItem().toString().equals("X")) {
						comboBox26.setBackground(new Color(233, 150, 122));}
					else {comboBox26.setBackground(SystemColor.WHITE);}}});
			
			comboBox27.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox27.getSelectedItem().toString().equals("X")) {
						comboBox27.setBackground(new Color(233, 150, 122));}
					else {comboBox27.setBackground(SystemColor.WHITE);}}});
			
			comboBox28.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox28.getSelectedItem().toString().equals("X")) {
						comboBox28.setBackground(new Color(233, 150, 122));}
					else {comboBox28.setBackground(SystemColor.WHITE);}}});
			
			comboBox29.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox29.getSelectedItem().toString().equals("X")) {
						comboBox29.setBackground(new Color(233, 150, 122));}
					else {comboBox29.setBackground(SystemColor.WHITE);}}});
			
			comboBox30.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(!comboBox30.getSelectedItem().toString().equals("X")) {
						comboBox30.setBackground(new Color(233, 150, 122));}
					else {comboBox30.setBackground(SystemColor.WHITE);}}});
			
			comboBox31.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
										
				
					
					if(!comboBox31.getSelectedItem().toString().equals("X")) {
						comboBox31.setBackground(new Color(233, 150, 122));}
					else {comboBox31.setBackground(SystemColor.WHITE);}}});
			
			
			
			

//*************************************************************************************************************************************************************
//*************************************************************************************************************************************************************		
//*************************************************************************************************************************************************************	
			
			
			BtnGunAdetleriOnayla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 
					
			if(labelIsimYaz.getText().equals("")||labelGorevdeSay.getText().toString().equals("0")) {
				
				JOptionPane.showMessageDialog(null,"Hak Edis Yapilacak Personelin Sicilini Secip, Hak Edis Yapilacak Gunleri Giriniz.");
			}
			else {
					
				      try {								    	  
				    	  AylikHakEdisDomain addHakedis=new AylikHakEdisDomain();	
				    	  			    	 
				    	  addHakedis.setSicil(comboBoxSicil.getSelectedItem().toString());
				    	  addHakedis.setMudurluk(mudurlukAl);
				    	  addHakedis.setUnvan(labelUnvanYaz.getText());
				    	  addHakedis.setYil(String.valueOf(yil));
				    	  addHakedis.setAy(String.valueOf(ay));
				    	  
				    	  
				    	  addHakedis.setBir(comboBox1.getSelectedItem().toString());
				    	  addHakedis.setBirM(labelFM1.getText());
				    	  
				    	  addHakedis.setIki(comboBox2.getSelectedItem().toString());
				    	  addHakedis.setIkiM(labelFM2.getText());
				    	  
				    	  addHakedis.setUc(comboBox3.getSelectedItem().toString());
				    	  addHakedis.setUcM(labelFM3.getText());
				    	  
				    	  addHakedis.setDort(comboBox4.getSelectedItem().toString());
				    	  addHakedis.setDortM(labelFM4.getText());
				    	  
				    	  
				    	  addHakedis.setBes(comboBox5.getSelectedItem().toString());
				    	  addHakedis.setBesM(labelFM5.getText());
				    	  
				    	  addHakedis.setAlti(comboBox6.getSelectedItem().toString());
				    	  addHakedis.setAltiM(labelFM6.getText());
				    	  
				    	  addHakedis.setYedi(comboBox7.getSelectedItem().toString());
				    	  addHakedis.setYediM(labelFM7.getText());
				    	  
				    	  addHakedis.setSekiz(comboBox8.getSelectedItem().toString());
				    	  addHakedis.setSekizM(labelFM8.getText());
				    	  
				    	  addHakedis.setDokuz(comboBox9.getSelectedItem().toString());
				    	  addHakedis.setDokuzM(labelFM9.getText());
				    	  
				    	  addHakedis.setOn(comboBox10.getSelectedItem().toString());
				    	  addHakedis.setOnM(labelFM10.getText());
				    	  
				    	  addHakedis.setOnBir(comboBox11.getSelectedItem().toString());
				    	  addHakedis.setOnBirM(labelFM11.getText());
				    	  
				    	  addHakedis.setOnIki(comboBox12.getSelectedItem().toString());
				    	  addHakedis.setOnIkiM(labelFM12.getText());
				    	  
				    	  addHakedis.setOnUc(comboBox13.getSelectedItem().toString());
				    	  addHakedis.setOnUcM(labelFM13.getText());
				    	  
				    	  addHakedis.setOnDort(comboBox14.getSelectedItem().toString());
				    	  addHakedis.setOnDortM(labelFM14.getText());
				    	  
				    	  addHakedis.setOnBes(comboBox15.getSelectedItem().toString());
				    	  addHakedis.setOnBesM(labelFM15.getText());
				    	  
				    	  addHakedis.setOnAlti(comboBox16.getSelectedItem().toString());
				    	  addHakedis.setOnAltiM(labelFM16.getText());
				    	  
				    	  addHakedis.setOnYedi(comboBox17.getSelectedItem().toString());
				    	  addHakedis.setOnYediM(labelFM17.getText());
				    	  
				    	  addHakedis.setOnSekiz(comboBox18.getSelectedItem().toString());
				    	  addHakedis.setOnSekizM(labelFM18.getText());
				    	  
				    	  addHakedis.setOnDokuz(comboBox19.getSelectedItem().toString());
				    	  addHakedis.setOnDokuzM(labelFM19.getText());
				    	  
				    	  addHakedis.setYirmi(comboBox20.getSelectedItem().toString());
				    	  addHakedis.setYirmiM(labelFM20.getText());
				    	  
				    	  addHakedis.setYirmiBir(comboBox21.getSelectedItem().toString());
				    	  addHakedis.setYirmiBirM(labelFM21.getText());
				    	  
				    	  addHakedis.setYirmiIki(comboBox22.getSelectedItem().toString());
				    	  addHakedis.setYirmiIkiM(labelFM22.getText());
				    	  
				    	  addHakedis.setYirmiUc(comboBox23.getSelectedItem().toString());
				    	  addHakedis.setYirmiUcM(labelFM23.getText());
				    	  
				    	  addHakedis.setYirmiDort(comboBox24.getSelectedItem().toString());
				    	  addHakedis.setYirmiDortM(labelFM24.getText());
				    	  
				    	  addHakedis.setYirmiBes(comboBox25.getSelectedItem().toString());
				    	  addHakedis.setYirmiBesM(labelFM25.getText());
				    	  
				    	  addHakedis.setYirmiAlti(comboBox26.getSelectedItem().toString());
				    	  addHakedis.setYirmiAltiM(labelFM26.getText());
				    	  
				    	  addHakedis.setYirmiYedi(comboBox27.getSelectedItem().toString());
				    	  addHakedis.setYirmiYediM(labelFM27.getText());
				    	  
				    	  addHakedis.setYirmiSekiz(comboBox28.getSelectedItem().toString());
				    	  addHakedis.setYirmiSekizM(labelFM28.getText());
				    	  
				    	  addHakedis.setYirmiDokuz(comboBox29.getSelectedItem().toString());
				    	  addHakedis.setYirmiDokuzM(labelFM29.getText());
				    	  
				    	  addHakedis.setOtuz(comboBox30.getSelectedItem().toString());
				    	  addHakedis.setOtuzM(labelFM30.getText());
				    	  
				    	  addHakedis.setOtuzBir(comboBox31.getSelectedItem().toString());
				    	  addHakedis.setOtuzBirM(labelFM31.getText());


				    	  if(Integer.parseInt(labelSaatlikMesaiSay.getText().toString())<10) 
				    	  {addHakedis.setTopMesai("0"+labelSaatlikMesaiSay.getText().toString());}				    	 
				    	  else{addHakedis.setTopMesai(labelSaatlikMesaiSay.getText().toString());}				    	  
				    	  				    	
				    	  addHakedis.setUcretVerGun(labelMaasHesaplacakGunSay.getText().toString());
				    	 // addHakedis.setYolUVerGun(labelYolUcretiVerilecekGunSay.getText().toString());
				    	  addHakedis.setYemekUVerGun(labelYemekUcretiVerGunSay.getText().toString());
				    	  
				    	  
				    	  
				    	  AylikHakedisSQL.hakEdisEkle(addHakedis);	
				    	  
				    	  JOptionPane.showMessageDialog(null,"Kayit Basarili");																									    																			
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}													
							
				
				}
							
							
				      list1.setListData((AylikHakedisSQL.hakEdisListeleSicil(mudurlukAl,String.valueOf(ay),String.valueOf(yil))).toArray());
							
					
				}
			});
			
			
			//günleri aldýðým bölüm, günleri labele atýyoruz..
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
					
					
					
					
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
		    	    
		    	    
		    	    
		    	    
		    	 //   labelTarihYaz.setText(labelIsim.getText().toString()+"-"+secilenTarihYilAl+"-"+secilenTarihAyAl+".ay");
		    	   
		    	    
		    	   
		    	    if(ay==4||ay==6||ay==9||ay==11) {		    	    	
		    	    	comboBox31.setVisible(false);
		    	    	label31.setVisible(false);
		    	    	
		    	    	comboBox31.setSelectedItem("Seciniz");
		    	    
		    	    }
		    	    else if(ay==2) {	    	    	
		    	    	if(yil%4==0) {		    	    		
		    	    		comboBox31.setVisible(false);
			    	    	label31.setVisible(false);			    	    	
			    	    	comboBox30.setVisible(false);
			    	    	label30.setVisible(false);	
			    	    	
			    	    	comboBox31.setSelectedItem("Seciniz");
			    	    	comboBox30.setSelectedItem("Seciniz");
			    	    	
		    	    	}
		    	    	else {
		    	    		comboBox31.setVisible(false);
			    	    	label31.setVisible(false);			    	    	
			    	    	comboBox30.setVisible(false);
			    	    	label30.setVisible(false);
			    	    	comboBox29.setVisible(false);
			    	    	label29.setVisible(false);
			    	    	
			    	    	comboBox31.setSelectedItem("Seciniz");
			    	    	comboBox30.setSelectedItem("Seciniz");
			    	    	comboBox29.setSelectedItem("Seciniz");
			    	    	
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
		    	    	;
		    	    }
		    	    
		    	  
		    	    
		    	    
		    	    
		    	    	    	    
		    	    if(secilenTarihGunSayi.toString().equals(label1.getText().toString())){
		    	    	panel_2.setVisible(true);
		    	    	panel_3.setVisible(true);
		    	    	panel_4.setVisible(true);
		    	    	panel.setVisible(true);
		    	    
		    	    	
		    	    	
		    	    	String gun = null;
		    	    			    	    			    	    	
		    	    	if(secilenTarih3.equals("Pzt")) {gun="Pazartesi";}
		    	    	else if(secilenTarih3.equals("Sal")) {gun="Sali";}else if(secilenTarih3.equals("Çar")) {gun="Carsamba";}
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
		    	    	if(secilenTarih3.equals("Çar")) {
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
		    	   
		    	    
					}catch(Exception e2){//e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Personelinizi Kontrol Edip Tarih Seciniz");
					}
				}
					
				
			
			});
			
			
			
			comboBoxSicil.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {	
					
					String sicil=comboBoxSicil.getSelectedItem().toString();					
								
					TaseronPersonelDomain bulunanPersonel=DataBaseSQL.personelBul(sicil);					
					String adiSoyadi= bulunanPersonel.getAdiSoyadi().toString();
					String unvan= bulunanPersonel.getUnvan().toString();
					String sicilB=bulunanPersonel.getSicil().toString();
					String mudurlukIsim=bulunanPersonel.getMudurluk().toString();
					
					labelUnvanYaz.setText(unvan);
					labelIsimYaz.setText(adiSoyadi);					
					labelMudurlukYaz.setText(mudurlukIsim);
															
				
					
					
				}
			});
			
			btnTmnOnayla_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					AylikHakEdisDomain silinecekHakEdisDomain =(AylikHakEdisDomain)list1.getSelectedValue();
					if(silinecekHakEdisDomain!=null) {
						int n=JOptionPane.showConfirmDialog(null,silinecekHakEdisDomain.getSicil()+ "Sicile Ait Secilen Veri Silinecek.","UYARI !!", JOptionPane.YES_NO_OPTION);
						if(n==0) {
							
							AylikHakedisSQL.hakEdisSil(silinecekHakEdisDomain);
							
					
							
							list1.setListData((AylikHakedisSQL.hakEdisListeleSicil(mudurlukAl,String.valueOf(ay),String.valueOf(yil))).toArray());
							
							JOptionPane.showMessageDialog(null,silinecekHakEdisDomain.getSicil()+" siciline ait kayit silindi");
										
						}
						else {						
							}					
					}	
					else {JOptionPane.showMessageDialog(null," Silinecek Kaydi Seciniz.");}
					
					
					
				}
			});
			
			PersonelUI.MudurlukveSicilGetir(sicilAl,mudurlukAl);
	}
	





	public static void MudurlukveSicilGetir(String sicil,String mudurluk) {
		
		sicilAl=sicil;
		mudurlukAl=mudurluk;
	}
}
