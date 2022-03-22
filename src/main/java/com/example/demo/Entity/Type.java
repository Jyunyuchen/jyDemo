package com.example.demo.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 多對多
 * 此方為Type(文章類型)對方為Article(文章)
 * @author jy
 *
 */
@Entity
@Table(name = "t_type")
@Getter
@Setter
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid")
	private Integer tId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			//name <-- 中間表名稱
			name = "t_article_type",
			//中間表的外鍵對應當前表的主鍵名稱
			joinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "tid")},
			//中間表的外鍵對應對方表(Article)的主鍵名稱
			inverseJoinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "aid")}
	)
	private Set<Article> articles = new HashSet<>();

	@Override
	public String toString() {
		return "Type [tId=" + tId + ", name=" + name + "]";
	}
	
	

}









