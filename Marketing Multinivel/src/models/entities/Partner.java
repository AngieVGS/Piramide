package models.entities;

import java.util.Date;

import controller.Controller;
import view.PanelActionsTable;

/**
 * 
 * @author Yuliana Boyaca, Viviana Galindo, Dayan Ramirez, sebastian Rodriguez, Daniela Torres
 *
 */
public class Partner {

	private static int idConsecutive = 1;
	private int id;
	private Date registerDate;
	private long idLegal;
	private String name;
	private String surname;
	private Genre genre;
	private Date birthday;
	private int stratum;
	private int parent;

	public Partner(Date registerDate, long idLegal, String name, String surname, Genre genre, Date birthday,
			int stratum, int parent) {
		this.id = idConsecutive++;
		this.registerDate = registerDate;
		this.idLegal = idLegal;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.birthday = birthday;
		this.stratum = stratum;
		this.parent = parent;
	}

	public Partner() {

	}

	public void editParnet(Partner partner) {
		this.registerDate = partner.registerDate;
		this.idLegal = partner.idLegal;
		this.name = partner.name;
		this.surname = partner.surname;
		this.genre = partner.genre;
		this.birthday = partner.birthday;
		this.stratum = partner.stratum;
		this.parent = partner.parent;

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

	public long getIdLegal() {
		return idLegal;
	}

	public void setIdLegal(long idLegal) {
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
	
	public static int getIdConsecutive() {
		return idConsecutive;
	}
	
	public static void setIdConsecutive(int idConsecutive) {
		Partner.idConsecutive = idConsecutive;
	}

	public Object[] getPartner() {
		return new Object[] { id, registerDate, idLegal, name, surname, genre, birthday, stratum, parent, new PanelActionsTable()};
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
}