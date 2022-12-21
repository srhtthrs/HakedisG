package uInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import HakEdisDatabase.DataBaseSQL;
import HakEdisDomain.TaseronPersonelDomain;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PersonelUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSicil;
	private JTextField textFieldAdiSoyadi;
	static String sicilAl;
	static String mudurlukAl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelUI frame = new PersonelUI();
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
	public PersonelUI() {
		setTitle("Personel Islemleri" +"Kullanici Sicil: "+sicilAl +"  Mudurluk: "+mudurlukAl);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 680);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 377, 622);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelSicil = new JLabel("Sicil:");
		labelSicil.setForeground(Color.WHITE);
		labelSicil.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelSicil.setBounds(10, 144, 357, 21);
		panel.add(labelSicil);
		
		textFieldSicil = new JTextField();
		textFieldSicil.setForeground(new Color(128, 0, 0));
		textFieldSicil.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldSicil.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldSicil.setBounds(10, 176, 357, 32);
		panel.add(textFieldSicil);
		textFieldSicil.setColumns(10);
		
		JComboBox comboBoxUnvan = new JComboBox();
		comboBoxUnvan.setModel(new DefaultComboBoxModel(new String[] {"Unvan Seciniz", "YAYA DAGITICI", "MOT. DAGITICI", "POSTA AYRIM  ", "ENGELLI (DAG)", "ENGELLI (AYR)"}));
		comboBoxUnvan.setForeground(new Color(128, 0, 0));
		comboBoxUnvan.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxUnvan.setBounds(10, 326, 357, 32);
		panel.add(comboBoxUnvan);
		
		textFieldAdiSoyadi = new JTextField();
		textFieldAdiSoyadi.setForeground(new Color(128, 0, 0));
		textFieldAdiSoyadi.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldAdiSoyadi.setColumns(10);
		textFieldAdiSoyadi.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldAdiSoyadi.setBounds(10, 251, 357, 32);
		panel.add(textFieldAdiSoyadi);
		
		JLabel labelAdiSoyadi = new JLabel("Ad Soyad:");
		labelAdiSoyadi.setForeground(Color.WHITE);
		labelAdiSoyadi.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAdiSoyadi.setBounds(10, 219, 357, 21);
		panel.add(labelAdiSoyadi);
		
		JLabel labelUnvan = new JLabel("Unvan:");
		labelUnvan.setForeground(Color.WHITE);
		labelUnvan.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelUnvan.setBounds(10, 294, 357, 21);
		panel.add(labelUnvan);
		
		JLabel labelMudurluk = new JLabel(mudurlukAl);
		labelMudurluk.setHorizontalAlignment(SwingConstants.LEFT);
		labelMudurluk.setForeground(new Color(128, 0, 0));
		labelMudurluk.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMudurluk.setBorder(new LineBorder(Color.WHITE));
		labelMudurluk.setBounds(10, 401, 357, 32);
		panel.add(labelMudurluk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(397, 11, 625, 622);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGorevYeri = new JLabel("Gorev Yeri:");
		lblGorevYeri.setForeground(Color.WHITE);
		lblGorevYeri.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGorevYeri.setBounds(10, 369, 357, 21);
		panel.add(lblGorevYeri);
		
		Icon iconKus=new ImageIcon("Icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(iconKus);
		lblNewLabel.setBounds(10, 11, 357, 102);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 2));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 444, 357, 61);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 605, 600);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		list.setBorder(new LineBorder(Color.WHITE, 2));
		list.setBackground(new Color(95, 158, 160));
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(list);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonelUI.this.dispose();
				MudurlukPanel2 mPane2sl=new MudurlukPanel2();
				mPane2sl.setVisible(true);
			}
		});
		btnGeri.setBounds(279, 11, 67, 36);
		panel_2.add(btnGeri);
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGeri.setBackground(UIManager.getColor("Button.light"));
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TaseronPersonelDomain silinecekPersDomain =(TaseronPersonelDomain)list.getSelectedValue();
				if(silinecekPersDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Personel Silinecek.","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						
						DataBaseSQL.kisiSil(silinecekPersDomain);
						
						list.setListData(DataBaseSQL.taseronPersListele(mudurlukAl).toArray());	
						
						JOptionPane.showMessageDialog(null,"Kayit Silindi");
					
						textFieldSicil.setText("");
						textFieldAdiSoyadi.setText("");
						comboBoxUnvan.setSelectedItem("Unvan Seciniz");				
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Personel Secilmedi");}
				
			}
		});
		btnSil.setBounds(210, 11, 59, 36);
		panel_2.add(btnSil);
		btnSil.setBackground(UIManager.getColor("Button.light"));
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldSicil.getText().equals("") || textFieldAdiSoyadi.getText().equals("")|| comboBoxUnvan.getSelectedItem().toString().equals("Unvan Seciniz"))										
				{
					JOptionPane.showMessageDialog(null," Listeden Personelin Bulundugu Satiri Seciniz.");
				}		
				else {			   			    	  
				    	  TaseronPersonelDomain guncelleUser=(TaseronPersonelDomain) list.getSelectedValue();
				    	  
				    	  if(guncelleUser!=null) {				    		  
				    		  guncelleUser.setSicil(textFieldSicil.getText().toUpperCase());
				    		  guncelleUser.setAdiSoyadi(textFieldAdiSoyadi.getText().toUpperCase());				    	  
				    		  guncelleUser.setUnvan(comboBoxUnvan.getSelectedItem().toString().toUpperCase());
				    		  guncelleUser.setMudurluk(labelMudurluk.getText());					    	 
				    		  DataBaseSQL.kisiGuncelle(guncelleUser);					    	  
				    		  JOptionPane.showMessageDialog(null,"Guncelleme Basarili");															
				    		  list.setListData(DataBaseSQL.taseronPersListele(mudurlukAl).toArray());							
				    		  textFieldSicil.setText("");
				    		  textFieldAdiSoyadi.setText("");
				    		  comboBoxUnvan.setSelectedItem("Unvan Seciniz");
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(null," Listeden ilgilinin Bulundugu Satiri Seciniz...");			    		  
				    	  }																					
				}					
			}	
		});
		
		btnGuncelle.setBounds(110, 11, 89, 36);
		panel_2.add(btnGuncelle);
		btnGuncelle.setBackground(UIManager.getColor("Button.light"));
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldSicil.getText().equals("")||textFieldAdiSoyadi.getText().equals("")||comboBoxUnvan.getSelectedItem().toString().equals("Unvan Seciniz")) { 
					JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz.");
			}					
			else {
			      try {								    	  
			    	  TaseronPersonelDomain addBaslayis=new TaseronPersonelDomain();	
			    	  			    	 
			    	  addBaslayis.setSicil(textFieldSicil.getText().toUpperCase());
			    	  addBaslayis.setAdiSoyadi(textFieldAdiSoyadi.getText().toUpperCase());
			    	  addBaslayis.setUnvan(comboBoxUnvan.getSelectedItem().toString().toUpperCase());			    	
			    	  addBaslayis.setMudurluk(labelMudurluk.getText());
			    	  
			    	  DataBaseSQL.perstasEkle(addBaslayis);	
			    	  
			    	  JOptionPane.showMessageDialog(null,"Kayit Basarili");	
						
						textFieldSicil.setText("");
						textFieldAdiSoyadi.setText("");
						comboBoxUnvan.setSelectedItem("Unvan Seciniz");
													    																			
			      }						
				 catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
				}													
			}
						
				list.setListData(DataBaseSQL.taseronPersListele(mudurlukAl).toArray());
		
		}
	});
				
				
				
			
		btnKaydet.setBounds(10, 11, 90, 36);
		panel_2.add(btnKaydet);
		btnKaydet.setBackground(UIManager.getColor("Button.light"));
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		
		
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
												
				TaseronPersonelDomain seciliKisiDomain=(TaseronPersonelDomain)list.getSelectedValue();
				if(seciliKisiDomain!=null) {
					
					textFieldSicil.setText(seciliKisiDomain.getSicil());
					textFieldAdiSoyadi.setText(seciliKisiDomain.getAdiSoyadi());
					comboBoxUnvan.setSelectedItem(seciliKisiDomain.getUnvan().toString());
					
				}
			}});
		
		
		
		
		
		list.setListData(DataBaseSQL.taseronPersListele(mudurlukAl).toArray());
		setLocationRelativeTo(null);
	}
	
public static void MudurlukveSicilGetir(String sicil,String mudurluk) {
		
		sicilAl=sicil;
		mudurlukAl=mudurluk;
	}
}
