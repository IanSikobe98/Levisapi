package test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

	@Id
	int agid;
	String fna;
	String lna;
	int nid;
	String gen;
	int pno;
	String region;
	String user;
	public int getAgid() {
		return agid;
	}
	public void setAgid(int agid) {
		this.agid = agid;
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
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	
}
