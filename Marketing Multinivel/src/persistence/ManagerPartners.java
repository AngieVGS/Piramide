package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;

public class ManagerPartners {

	RandomAccessFile file;
	private String fileName;

	public ManagerPartners(String fileName) {
		this.fileName = fileName;
	}

	public void open() throws FileNotFoundException{
		file = new RandomAccessFile(fileName, "rw");
	}

	public void openToRead() throws FileNotFoundException{
		RandomAccessFile file = new RandomAccessFile(fileName, "r");
	}

	public void close() throws IOException{
		if (file != null) {
			file.close();
		}
	}

	/**
	 * Metodo que permite la escritura de un socio en el archivo, en la posicion ACTUAL del cursor
	 * @param partnerInFile: el socio que se escribira en el archivo
	 * @throws IOException
	 * 
	 */
	public void write(PartnerInFile partnerInFile) throws IOException{
		if (file != null) {
			partnerInFile.write(file);
		}
	}

	/**
	 * Metodo que permite leer un socio en e archivo desde la posicion ACTUAL del cursor
	 * @return retorna el socio que ha sido leido
	 */
	public PartnerInFile readFromFile(){
		PartnerInFile partner = null;
		if (file != null) {
			try {
				partner = new PartnerInFile();
				partner.read(file);
			} catch (IOException | ParseException e) {
				partner = null;
			}
		}

		return partner;
	}

	/**
	 * 
	 * @param position la posicion a buscar para leer el socio en el archivo
	 * @return retorna el socio encontrado en la posicion especificada
	 * @throws IOException
	 */
	public PartnerInFile readAnyPosition(int position) throws IOException{
		if (file != null) {
			file.seek((position-1)*PartnerInFile.SIZE_REGISTER_PARTNER);
		}

		return readFromFile();
	}
}
