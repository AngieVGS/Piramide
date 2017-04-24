package models.entities;

import java.util.Date;

public class Partner {

	private int id;
	private Date registerDate;
	private int idLegal;
	private String name;
	private String surname;
	private Genre genre;
	private Date birthday;
	private int stratum;
	private int parent;

	public Partner(int id, Date registerDate, int idLegal, String name, String surname, Genre genre, Date birthday,
			int stratum, int parent) {
		this.id = id;
		this.registerDate = registerDate;
		this.idLegal = idLegal;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.birthday = birthday;
		this.stratum = stratum;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getIdLegal() {
		return idLegal;
	}

	public void setIdLegal(int idLegal) {
		this.idLegal = idLegal;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getStratum() {
		return stratum;
	}

	public void setStratum(int stratum) {
		this.stratum = stratum;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
}