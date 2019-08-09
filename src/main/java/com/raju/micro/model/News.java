package com.raju.micro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Country;
	private String Category;
	private String Filterkeyword;
	private String NewsTitle;
	private String Description;
	private String SourceNewsURL;

	public News() {

	}

	public News(String country, String category, String filterkeyword) {
		this.Country = country;
		this.Category = category;
		this.Filterkeyword = filterkeyword;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getFilterkeyword() {
		return Filterkeyword;
	}

	public void setFilterkeyword(String filterkeyword) {
		Filterkeyword = filterkeyword;
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSourceNewsURL() {
		return SourceNewsURL;
	}

	public void setSourceNewsURL(String sourceNewsURL) {
		SourceNewsURL = sourceNewsURL;
	}

	@Override
	public String toString() {
		return "News [Country=" + Country + ", Category=" + Category + ", Filterkeyword=" + Filterkeyword
				+ ", NewsTitle=" + NewsTitle + ", Description=" + Description + ", SourceNewsURL=" + SourceNewsURL
				+ "]";
	}

}
