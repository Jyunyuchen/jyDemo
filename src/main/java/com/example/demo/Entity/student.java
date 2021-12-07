package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sno")
	private int sno;
	
	@Column(name="sname")
    private String sname;
	
	@Column(name="sage")
    private String sage;
	
	@Column(name="saddress")
    private String saddress;
	
	@Column(name="spwd")
    private String spwd;

	

	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getSage() {
		return sage;
	}



	public void setSage(String sage) {
		this.sage = sage;
	}



	public String getSaddress() {
		return saddress;
	}



	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}



	public String getSpwd() {
		return spwd;
	}



	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}



	@Override
	public String toString() {
		return "student [sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + ", spwd="
				+ spwd + "]";
	}
	
	
}
