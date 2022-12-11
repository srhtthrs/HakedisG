package HakEdisDomain;

public class SicilDomain {
	
	private int id;
	private String sicil;
	private String adiSoyadi;
	private String unvan;
	private String mudurluk;
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
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	public String getMudurluk() {
		return mudurluk;
	}
	public void setMudurluk(String mudurluk) {
		this.mudurluk = mudurluk;
	}
	@Override
	public String toString() {
		return  sicil;
	}
	
	
	

}
