package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class student {

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

	@Override
	public String toString() {
		return "student [sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + ", spwd="
				+ spwd + "]";
	}
	
	
}
