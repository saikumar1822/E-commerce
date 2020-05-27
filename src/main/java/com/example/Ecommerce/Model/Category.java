package com.example.Ecommerce.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;

	private String categoryName;
	/*
	 * @JsonIgnoreProperties("category")
	 * 
	 * @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private Set<Product> productSet;
	 */
	


	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/*
	 * public Set<Product> getProductSet() { return productSet; }
	 * 
	 * public void setProductSet(Set<Product> productSet) { this.productSet =
	 * productSet; }
	 */
}
