package persistence;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import models.entities.Genre;
import models.entities.Partner;

public class PartnerInFile extends Partner{
	
	public final static int SIZE_REGISTER_PARTNER = 330;

	public PartnerInFile(Date registerDate, int idLegal, String name, String surname, Genre genre,
			Date birthday, int stratum, int parent) {
		super(registerDate, idLegal, name, surname, genre, birthday, stratum, parent);
	}
	
	public PartnerInFile() {

	}
	

	public void read(RandomAccessFile file) throws IOException, ParseException{
		DateFormat dateFormat;
		
		setId(file.readInt());
		
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		setRegisterDate((dateFormat.parse(readString(file, 32))));
		
		setIdLegal(file.readInt());
		setName(readString(file, 16));
		setSurname(readString(file, 16));
//		setGenre((Genre.valueOf(readString(file, 8))));
		
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		setBirthday(dateFormat.parse(readString(file, 32)));
		
		setStratum(file.readInt());
		setParent(file.readInt());
	}
	
	private String readString(RandomAccessFile file, int size) throws IOException{
		char field[] = new char[size];
		
		for (int i = 0; i < size; i++) {
			field[i] = file.readChar();
		}
		
		return new String(field).replace('\0', ' ');
	}
	
	public void write(RandomAccessFile file) throws IOException{
		DateFormat dateFormat ;
		file.writeInt(getId());
		
		dateFormat  = DateFormat.getDateInstance(DateFormat.LONG);
		writeString(file, dateFormat.format(getRegisterDate()), 32);
		
		file.writeLong(getIdLegal());
		writeString(file, getName(), 16);
		writeString(file, getSurname(), 16);
//		writeString(file, getGenre().getNameGenre(), 8);
	
		dateFormat  = DateFormat.getDateInstance(DateFormat.LONG);
		writeString(file, dateFormat.format(getBirthday()), 32);
		
		file.writeInt(getStratum());
		file.writeInt(getParent());
		
	}
	
	private void writeString(RandomAccessFile file, String chain, int size) throws IOException{
		StringBuffer buffer = new StringBuffer();
		if (chain != null) 
			buffer.append(chain);
		buffer.setLength(size);
		file.writeChars(buffer.toString());
	}
	
}
