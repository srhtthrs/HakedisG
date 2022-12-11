package HakEdisDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import HakEdisDomain.SicilDomain;
import HakEdisDomain.TaseronPersonelDomain;











public class DataBaseSQL {
	
	static DefaultTableModel model;
	
	
	public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
			baglanti.prepareStatement("CREATE TABLE taseronpersonel (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), sicil VARCHAR(50), adisoyadi VARCHAR(50), unvan VARCHAR(50), mudurluk VARCHAR(50))");		
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

	public static void perstasEkle(TaseronPersonelDomain ekltasperdom) {	
		Connection baglanti=DataBaseConn.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO taseronpersonel (sicil,adisoyadi,unvan,mudurluk) VALUES (?,?,?,?)");
			sorguPreparedStatement.setString(1, ekltasperdom.getSicil().toUpperCase());
			sorguPreparedStatement.setString(2, ekltasperdom.getAdiSoyadi().toUpperCase());
			sorguPreparedStatement.setString(3, ekltasperdom.getUnvan().toUpperCase());
			sorguPreparedStatement.setString(4, ekltasperdom.getMudurluk().toUpperCase());
			
			
						
			sorguPreparedStatement.executeUpdate();	
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}

	public static ArrayList<TaseronPersonelDomain> taseronPersListele(){	
		ArrayList<TaseronPersonelDomain> isyeri= new ArrayList<TaseronPersonelDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM taseronpersonel WHERE sicil IS NOT NULL ORDER BY sicil ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				TaseronPersonelDomain siradakiDomain2=new TaseronPersonelDomain();					
				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setSicil(rs2.getString("sicil"));	
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setMudurluk(rs2.getString("mudurluk"));
				
				isyeri.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return isyeri;	
	}

	public static void kisiGuncelle(TaseronPersonelDomain taseronPersGuncelle) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE taseronpersonel SET sicil=?, adisoyadi=?, unvan=?, mudurluk=? WHERE id=?");
		
			sorgu.setString(1, taseronPersGuncelle.getSicil().toUpperCase());			
			sorgu.setString(2, taseronPersGuncelle.getAdiSoyadi().toUpperCase());			
			sorgu.setString(3, taseronPersGuncelle.getUnvan().toUpperCase());			
			sorgu.setString(4, taseronPersGuncelle.getMudurluk().toUpperCase());					
			sorgu.setInt(5, taseronPersGuncelle.getId());
			
			sorgu.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void kisiSil(TaseronPersonelDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM taseronpersonel WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<SicilDomain> sicilListele(){	
		ArrayList<SicilDomain> sicil= new ArrayList<SicilDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM taseronpersonel WHERE sicil IS NOT NULL ORDER BY sicil ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				SicilDomain siradakiDomain2=new SicilDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setSicil(rs2.getString("sicil"));											
				sicil.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return sicil;	
	}
	


	
}
