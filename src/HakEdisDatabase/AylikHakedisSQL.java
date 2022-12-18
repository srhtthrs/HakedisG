package HakEdisDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import HakEdisDomain.AylikHakEdisDomain;




public class AylikHakedisSQL {
	
	static DefaultTableModel model;
	
	public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
			baglanti.prepareStatement("CREATE TABLE aylikhakedis (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), sicil VARCHAR(50), "
					+ "mudurluk VARCHAR(50), "
					+ "unvan VARCHAR(50), "
					+ "yil VARCHAR(50), "
					+ "ay VARCHAR(50), "
					+ "bir VARCHAR(50), "
					+ "birm VARCHAR(50), "
					+ "iki VARCHAR(50), "
					+ "ikim VARCHAR(50), "
					+ "uc VARCHAR(50), "
					+ "ucm VARCHAR(50), "
					+ "dort VARCHAR(50), "
					+ "dortm VARCHAR(50), "
					+ "bes VARCHAR(50), "
					+ "besm VARCHAR(50), "
					+ "alti VARCHAR(50), "
					+ "altim VARCHAR(50), "
					+ "yedi VARCHAR(50), "
					+ "yedim VARCHAR(50), "
					+ "sekiz VARCHAR(50), "
					+ "sekizm VARCHAR(50), "
					+ "dokuz VARCHAR(50), "
					+ "dokuzm VARCHAR(50), "
					+ "onn VARCHAR(50), "
					+ "onnm VARCHAR(50), "
					+ "onbir VARCHAR(50), "
					+ "onbirm VARCHAR(50), "
					+ "oniki VARCHAR(50), "
					+ "onikim VARCHAR(50), "
					+ "onuc VARCHAR(50), "
					+ "onucm VARCHAR(50), "
					+ "ondort VARCHAR(50), "
					+ "ondortm VARCHAR(50), "
					+ "onbes VARCHAR(50), "
					+ "onbesm VARCHAR(50), "
					+ "onalti VARCHAR(50), "
					+ "onaltim VARCHAR(50), "
					+ "onyedi VARCHAR(50), "
					+ "onyedim VARCHAR(50), "
					+ "onsekiz VARCHAR(50), "
					+ "onsekizm VARCHAR(50), "
					+ "ondokuz VARCHAR(50), "
					+ "ondokuzm VARCHAR(50), "
					+ "yirmi VARCHAR(50), "
					+ "yirmim VARCHAR(50), "
					+ "yirmibir VARCHAR(50), "
					+ "yirmibirm VARCHAR(50), "
					+ "yirmiiki VARCHAR(50), "
					+ "yirmiikim VARCHAR(50), "
					+ "yirmiuc VARCHAR(50), "
					+ "yirmiucm VARCHAR(50), "
					+ "yirmidort VARCHAR(50), "
					+ "yirmidortm VARCHAR(50), "
					+ "yirmibes VARCHAR(50), "
					+ "yirmibesm VARCHAR(50), "
					+ "yirmialti VARCHAR(50), "
					+ "yirmialtim VARCHAR(50), "
					+ "yirmiyedi VARCHAR(50), "
					+ "yirmiyedim VARCHAR(50), "
					+ "yirmisekiz VARCHAR(50), "
					+ "yirmisekizm VARCHAR(50), "
					+ "yirmidokuz VARCHAR(50), "
					+ "yirmidokuzm VARCHAR(50), "
					+ "otuz VARCHAR(50), "
					+ "otuzm VARCHAR(50), "
					+ "otuzbir VARCHAR(50), "
					+ "otuzbirm VARCHAR(50), "
					+ "toplammesai VARCHAR(50), "
					+ "ucretverilecekgun VARCHAR(50), "
					+ "yolverilecekgun VARCHAR(50), "
					+ "yemekverilecekgun VARCHAR(50))");		
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
	

	public static void hakEdisEkle(AylikHakEdisDomain hakedisEkle) {	
		Connection baglanti=DataBaseConn.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO aylikhakedis (sicil,mudurluk,unvan,yil,ay,bir,birm,iki,ikim,uc,ucm,dort,dortm,bes,besm,alti,altim,yedi,yedim,sekiz,sekizm,dokuz,dokuzm,onn,onnm,onbir,onbirm,oniki,onikim,onuc,onucm,ondort,ondortm,onbes,onbesm,onalti,onaltim,onyedi,onyedim,onsekiz,onsekizm,ondokuz,ondokuzm,yirmi,yirmim,yirmibir,yirmibirm,yirmiiki,yirmiikim,yirmiuc,yirmiucm,yirmidort,yirmidortm,yirmibes,yirmibesm,yirmialti,yirmialtim,yirmiyedi,yirmiyedim,yirmisekiz,yirmisekizm,yirmidokuz,yirmidokuzm,otuz,otuzm,otuzbir,otuzbirm,toplammesai,ucretverilecekgun,yolverilecekgun,yemekverilecekgun) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			
			
			sorguPreparedStatement.setString(1, hakedisEkle.getSicil().toUpperCase());
			sorguPreparedStatement.setString(2, hakedisEkle.getMudurluk().toUpperCase());
			sorguPreparedStatement.setString(3, hakedisEkle.getUnvan().toUpperCase());
			sorguPreparedStatement.setString(4, hakedisEkle.getYil());
			sorguPreparedStatement.setString(5, hakedisEkle.getAy());
			
			sorguPreparedStatement.setString(6, hakedisEkle.getBir().toUpperCase());
			sorguPreparedStatement.setString(7, hakedisEkle.getBirM().toUpperCase());
			sorguPreparedStatement.setString(8, hakedisEkle.getIki().toUpperCase());
			sorguPreparedStatement.setString(9, hakedisEkle.getIkiM().toUpperCase());
			sorguPreparedStatement.setString(10, hakedisEkle.getUc().toUpperCase());
			sorguPreparedStatement.setString(11, hakedisEkle.getUcM().toUpperCase());
			sorguPreparedStatement.setString(12, hakedisEkle.getDort().toUpperCase());
			sorguPreparedStatement.setString(13, hakedisEkle.getDortM().toUpperCase());
			sorguPreparedStatement.setString(14, hakedisEkle.getBes().toUpperCase());
			sorguPreparedStatement.setString(15, hakedisEkle.getBesM().toUpperCase());
			sorguPreparedStatement.setString(16, hakedisEkle.getAlti().toUpperCase());
			sorguPreparedStatement.setString(17, hakedisEkle.getAltiM().toUpperCase());
			sorguPreparedStatement.setString(18, hakedisEkle.getYedi().toUpperCase());
			sorguPreparedStatement.setString(19, hakedisEkle.getYediM().toUpperCase());
			sorguPreparedStatement.setString(20, hakedisEkle.getSekiz().toUpperCase());
			sorguPreparedStatement.setString(21, hakedisEkle.getSekizM().toUpperCase());
			sorguPreparedStatement.setString(22, hakedisEkle.getDokuz().toUpperCase());
			sorguPreparedStatement.setString(23, hakedisEkle.getDokuzM().toUpperCase());
			sorguPreparedStatement.setString(24, hakedisEkle.getOn().toUpperCase());
			sorguPreparedStatement.setString(25, hakedisEkle.getOnM().toUpperCase());
			sorguPreparedStatement.setString(26, hakedisEkle.getOnBir().toUpperCase());
			sorguPreparedStatement.setString(27, hakedisEkle.getOnBirM().toUpperCase());
			sorguPreparedStatement.setString(28, hakedisEkle.getOnIki().toUpperCase());
			sorguPreparedStatement.setString(29, hakedisEkle.getOnIkiM().toUpperCase());//on iki
			sorguPreparedStatement.setString(30, hakedisEkle.getOnUc().toUpperCase());
			sorguPreparedStatement.setString(31, hakedisEkle.getOnUcM().toUpperCase());
			sorguPreparedStatement.setString(32, hakedisEkle.getOnDort().toUpperCase());
			sorguPreparedStatement.setString(33, hakedisEkle.getOnDortM().toUpperCase());
			sorguPreparedStatement.setString(34, hakedisEkle.getOnBes().toUpperCase());
			sorguPreparedStatement.setString(35, hakedisEkle.getOnBesM().toUpperCase());
			sorguPreparedStatement.setString(36, hakedisEkle.getOnAlti().toUpperCase());
			sorguPreparedStatement.setString(37, hakedisEkle.getOnAltiM().toUpperCase());//on alti
			sorguPreparedStatement.setString(38, hakedisEkle.getOnYedi().toUpperCase());
			sorguPreparedStatement.setString(39, hakedisEkle.getOnYediM().toUpperCase());
			sorguPreparedStatement.setString(40, hakedisEkle.getOnSekiz().toUpperCase());
			sorguPreparedStatement.setString(41, hakedisEkle.getOnSekizM().toUpperCase());
			sorguPreparedStatement.setString(42, hakedisEkle.getOnDokuz().toUpperCase());
			sorguPreparedStatement.setString(43, hakedisEkle.getOnDokuzM().toUpperCase());
			sorguPreparedStatement.setString(44, hakedisEkle.getYirmi().toUpperCase());
			sorguPreparedStatement.setString(45, hakedisEkle.getYirmiM().toUpperCase());
			sorguPreparedStatement.setString(46, hakedisEkle.getYirmiBir().toUpperCase());
			sorguPreparedStatement.setString(47, hakedisEkle.getYirmiBirM().toUpperCase());
			sorguPreparedStatement.setString(48, hakedisEkle.getYirmiIki().toUpperCase());
			sorguPreparedStatement.setString(49, hakedisEkle.getYirmiIkiM().toUpperCase());
			sorguPreparedStatement.setString(50, hakedisEkle.getYirmiUc().toUpperCase());
			sorguPreparedStatement.setString(51, hakedisEkle.getYirmiUcM().toUpperCase());
			sorguPreparedStatement.setString(52, hakedisEkle.getYirmiDort().toUpperCase());
			sorguPreparedStatement.setString(53, hakedisEkle.getYirmiDortM().toUpperCase());
			sorguPreparedStatement.setString(54, hakedisEkle.getYirmiBes().toUpperCase());
			sorguPreparedStatement.setString(55, hakedisEkle.getYirmiBesM().toUpperCase());
			sorguPreparedStatement.setString(56, hakedisEkle.getYirmiAlti().toUpperCase());
			sorguPreparedStatement.setString(57, hakedisEkle.getYirmiAltiM().toUpperCase());
			sorguPreparedStatement.setString(58, hakedisEkle.getYirmiYedi().toUpperCase());
			sorguPreparedStatement.setString(59, hakedisEkle.getYirmiYediM().toUpperCase());
			sorguPreparedStatement.setString(60, hakedisEkle.getYirmiSekiz().toUpperCase());
			sorguPreparedStatement.setString(61, hakedisEkle.getYirmiSekizM().toUpperCase());
			sorguPreparedStatement.setString(62, hakedisEkle.getYirmiDokuz().toUpperCase());
			sorguPreparedStatement.setString(63, hakedisEkle.getYirmiDokuzM().toUpperCase());
			sorguPreparedStatement.setString(64, hakedisEkle.getOtuz().toUpperCase());
			sorguPreparedStatement.setString(65, hakedisEkle.getOtuzM().toUpperCase());
			sorguPreparedStatement.setString(66, hakedisEkle.getOtuzBir().toUpperCase());
			sorguPreparedStatement.setString(67, hakedisEkle.getOtuzBirM().toUpperCase());
			
			sorguPreparedStatement.setString(68, hakedisEkle.getTopMesai());
			sorguPreparedStatement.setString(69, hakedisEkle.getUcretVerGun());
			sorguPreparedStatement.setString(70, hakedisEkle.getYolUVerGun());
			sorguPreparedStatement.setString(71, hakedisEkle.getYemekUVerGun());
			
			
			
						
			sorguPreparedStatement.executeUpdate();	
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}


	public static ArrayList<AylikHakEdisDomain> hakEdisListeleSicil(String mudurluk, String ay, String yil){
		
		//public static ArrayList<AylikHakEdisDomain> hakEdisListeleSicil(String mudurluk){	
		ArrayList<AylikHakEdisDomain> hakedisSicil= new ArrayList<AylikHakEdisDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM aylikhakedis WHERE mudurluk=? AND ay=? AND yil=? ORDER BY unvan ASC");
			//PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM aylikhakedis WHERE mudurluk=?");
			sorgu2.setString(1, mudurluk);	
			sorgu2.setString(2, ay);	
			sorgu2.setString(3, yil);	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				AylikHakEdisDomain siradakiDomain2=new AylikHakEdisDomain();					
				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setSicil(rs2.getString("sicil"));					
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setMudurluk(rs2.getString("mudurluk"));
				siradakiDomain2.setTopMesai(rs2.getString("toplammesai"));
				siradakiDomain2.setUcretVerGun(rs2.getString("ucretverilecekgun"));
				siradakiDomain2.setYolUVerGun(rs2.getString("yolverilecekgun"));
				siradakiDomain2.setYemekUVerGun(rs2.getString("yemekverilecekgun"));
				
				
				hakedisSicil.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return hakedisSicil;	
	}
	
	
	public static void hakEdisSil(AylikHakEdisDomain silinecekHakEdisDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM aylikhakedis WHERE id=?");
			sorgu.setInt(1, silinecekHakEdisDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static DefaultTableModel hakEdisListele(String mudurluk, String ay, String yil) {
		 model=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"SICIL", "UNVAN","MESAI", "UCRET.GUN","YOL.YEMEK.GUN"};  
		 
		 Object[] satirlar=new Object[500];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {				
						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM aylikhakedis WHERE mudurluk=? AND ay=? AND yil=?");
			
			sorgu.setString(1, mudurluk);
			sorgu.setString(2, ay);
			sorgu.setString(3, yil);
			
			ResultSet rs=sorgu.executeQuery();	
			
			
			while(rs.next()) {									
				
				
				satirlar[0]=rs.getString("sicil");
				satirlar[1]=rs.getString("unvan");
				satirlar[2]=rs.getString("toplammesai");
				satirlar[3]=rs.getString("ucretverilecekgun");
				satirlar[4]=rs.getString("yolverilecekgun");
				//satirlar[5]=rs.getString("yemekverilecekgun");
				
				model.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}









	
	
	
	
	
	
	
	
}