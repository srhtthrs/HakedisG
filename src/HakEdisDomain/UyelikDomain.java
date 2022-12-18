package HakEdisDomain;

public class UyelikDomain {
	
	private int id;
	private String sicil;
	private String adiSoyadi;
	private String mudurluk;
	private String sifre;
	private String onayDurumu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSicil() {
		return sicil;
	}
	public void setSicil(String sicil) {
		this.sicil = sicil;
	}
	
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getMudurluk() {
		return mudurluk;
	}
	public void setMudurluk(String mudurluk) {
		this.mudurluk = mudurluk;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
		
		
		
		
	}
	public String getOnayDurumu() {
		return onayDurumu;
	}
	public void setOnayDurumu(String onayDurumu) {
		this.onayDurumu = onayDurumu;
	}
	@Override
	public String toString() {
		return mudurluk+"  "+sicil+"   "+adiSoyadi+"  Onay Durumu: "+onayDurumu;
	}
	
	

}
