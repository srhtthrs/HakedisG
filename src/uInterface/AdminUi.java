package uInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import HakEdisDatabase.AylikHakedisSQL;
import HakEdisDatabase.UyelikDataBaseSQL;
import HakEdisDomain.UyelikDomain;


import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class AdminUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUi frame = new AdminUi();
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
	public AdminUi() {
		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 665);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 553, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 500, 252);
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Onayla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UyelikDomain uyeDomain =(UyelikDomain) list.getSelectedValue();
				if(uyeDomain!=null) {
					uyeDomain.setOnayDurumu("onaylandi");
					
					
					UyelikDataBaseSQL.uyeOnayla(uyeDomain);
					
					list.setListData(UyelikDataBaseSQL.uyeleriListele().toArray());
					
					
				}else
				{JOptionPane.showMessageDialog(null," Onaylanacak Personel Secilmedi.");
				
				
				}
				
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(25, 274, 229, 23);
		panel.add(btnNewButton);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setForeground(Color.BLACK);
		btnSil.setBounds(285, 274, 240, 23);
		panel.add(btnSil);
		
	
		list.setListData(UyelikDataBaseSQL.uyeleriListele().toArray());
		
		JButton btnNewButton_1 = new JButton("geri");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminUi.this.dispose();
				LogInUI mPane2sls=new LogInUI();
				mPane2sls.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 583, 89, 32);
		contentPane.add(btnNewButton_1);
		
		
	}
}
