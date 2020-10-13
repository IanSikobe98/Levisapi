package test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {

	
	@Id
	int id;
	String gna;
	String pna;
	String fna;
	String lna;
	int agid;
	String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGna() {
		return gna;
	}
	public void setGna(String gna) {
		this.gna = gna;
	}
	public String getPna() {
		return pna;
	}
	public void setPna(String pna) {
		this.pna = pna;
	}
	public String getFna() {
		return fna;
	}
	public void setFna(String fna) {
		this.fna = fna;
	}
	public String getLna() {
		return lna;
	}
	public void setLna(String lna) {
		this.lna = lna;
	}
	public int getAgid() {
		return agid;
	}
	public void setAgid(int agid) {
		this.agid = agid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
