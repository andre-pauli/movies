package br.com.simples.api_movies.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

//aqui estamos declarando que a nossa classe será uma entidade nosso banco de dados
//e que essa entidade será um tabela.

@Entity
@Table(name = "TB_FILME")
public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "title")
	@JsonProperty(value = "Title")
	private String title;

	@Column(name = "year")
	@JsonProperty(value = "Year")
	private String year;

	@Column(name = "imdbID")
	@JsonProperty(value = "imdbID")
	private String imdbID;

	@Column(name = "poster")
	@JsonProperty(value = "Poster")
	private String poster;

	public long getId() {
		return Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public void setId(long id) {
		Id = id;
	}
}
