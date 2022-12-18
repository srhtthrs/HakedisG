package HakEdisDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import HakEdisDomain.UyelikDomain;








public class UyelikDataBaseSQL {
	
	public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE uyeler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),"
							+ "sicil VARCHAR(50),"
							+ "adisoyadi VARCHAR (50),"
							+ "mudurluk VARCHAR(50),"
							+"sifre VARCHAR(50),"
							+ "onaydurumu VARCHAR(50))");	
												
	sorguStatement.executeUpdate();		
		} catch (SQLException e) {			
			if(e.getSQLState().equals("X0Y32")) {				
				System.out.println("tablo mevcut");
			}else 
			{			
			e.printStackTrace();		
			}
}
}

	
	public static void uyeSil(UyelikDomain silinecekUyeDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM uyeler WHERE id=?");
			sorgu.setInt(1, silinecekUyeDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static ArrayList<UyelikDomain> uyeleriListele(){	
		ArrayList<UyelikDomain> uyeler= new ArrayList<UyelikDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM uyeler WHERE onaydurumu='onaylanmadi'");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				UyelikDomain siradakiDomain2=new UyelikDomain();				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setSicil(rs2.getString("sicil"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setMudurluk(rs2.getString("mudurluk"));
				siradakiDomain2.setSifre(rs2.getString("sifre"));
				siradakiDomain2.setOnayDurumu(rs2.getString("onaydurumu"));
							
				uyeler.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return uyeler;	
	}

	
	public static void uyeEkle(UyelikDomain eklenecekUyeDomain1) {	
		Connection baglanti=DataBaseConn.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO uyeler (sicil,adisoyadi,mudurluk,sifre,onaydurumu) VALUES (?,?,?,?,?)");
			
			sorguPreparedStatement.setString(1, eklenecekUyeDomain1.getSicil());			
			sorguPreparedStatement.setString(2, eklenecekUyeDomain1.getAdiSoyadi());
			sorguPreparedStatement.setString(3, eklenecekUyeDomain1.getMudurluk());
			sorguPreparedStatement.setString(4, eklenecekUyeDomain1.getSifre());
			sorguPreparedStatement.setString(5, eklenecekUyeDomain1.getOnayDurumu());
			
			
			
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
	
	
	public static boolean kullaniciAdiKontrol(String sicil) {
		boolean sonuc=false;	
		Connection baglanti= DataBaseConn.baglantiAl();
		 try {		 
			 PreparedStatement sorgu= baglanti.prepareStatement("SELECT * FROM uyeler WHERE sicil=?");
			 sorgu.setString(1,sicil);		 
			 ResultSet rs=sorgu.executeQuery();		 
			 while(rs.next()) {
				 sonuc=true;
				 }		
		 } 
		 catch (Exception e) 
		 {	
			JOptionPane.showMessageDialog(null, "Hata Var");		
		 }
		return sonuc;	
	}
	
	
	public static boolean kullaniciGirisKontrol(String sicil, String mudurluk, String sifre, String onayDurumu) {
		boolean sonuc=false;	
		Connection baglanti= DataBaseConn.baglantiAl();
		 try {		 
			 PreparedStatement sorgu= baglanti.prepareStatement("SELECT * FROM uyeler WHERE sicil=? AND mudurluk=? AND sifre=? AND onaydurumu=?");
			 sorgu.setString(1,sicil);
			 sorgu.setString(2,mudurluk);
			 sorgu.setString(3,sifre);
			 sorgu.setString(4,onayDurumu);
			 
			 ResultSet rs=sorgu.executeQuery();		 
			 while(rs.next()) {
				 sonuc=true;
				 }		
		 } 
		 catch (Exception e) 
		 {	
			JOptionPane.showMessageDialog(null, "Hata Var");		
		 }
		return sonuc;	
	}

	public static void uyeOnayla(UyelikDomain uyeOnayDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE uyeler SET onaydurumu=? WHERE id=?");
		sorgu.setString(1, uyeOnayDomain.getOnayDurumu());	
		sorgu.setInt(2, uyeOnayDomain.getId());		
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
