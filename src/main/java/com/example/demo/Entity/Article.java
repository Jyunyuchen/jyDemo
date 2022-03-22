package com.example.demo.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * 多對多
 * 此方為Article(文章)對方為Type(文章類型)
 * @author jy
 *
 */
@Entity
@Table(name = "t_article")
@Getter
@Setter
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private Integer aId;
	
	@Column(name = "autohr")
	private String autohr;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "title")
	private String title;
	
	@ManyToMany(
			mappedBy = "articles", 
			cascade = CascadeType.PERSIST
			//fetch = FetchType.EAGER
	)
	private Set<Type> types = new HashSet<>();

	@Override
	public String toString() {
		return "Article [aId=" + aId + ", autohr=" + autohr + ", createTime=" + createTime + ", title=" + title + "]";
	}
	
	
	
}









