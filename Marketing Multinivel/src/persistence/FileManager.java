package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import exceptions.RegisteredPartner;
import models.comparator.ComparatorPartner;
import models.dao.Company;
import models.entities.Genre;
import models.entities.Partner;

public class FileManager {

	public String fileName;
	public File file;
	public FileReader fr;
	public FileWriter fw;
	public BufferedReader br;
	public BufferedWriter bw;
	public PrintWriter pw;
	public boolean append = true;

	public FileManager(String st) throws IOException {
		this.fileName = st;
	}

	public void createFile(String nameFile) {
		this.fileName = nameFile;
	}

	public void openToWrite() throws IOException {
		file = new File(fileName);
		fw = new FileWriter(file, append);
		fr = new FileReader(file);
		bw = new BufferedWriter(fw);
		fw = new FileWriter(file);
	}

	public void openToRead() throws FileNotFoundException {
		file = new File(fileName);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	public void writeFile(String chain) throws IOException {
		fw.write(chain + (char) 13 + (char) 10);
		fw.flush();
	}

	public Company readToTree() throws IOException {
		Company auxList = new Company(new ComparatorPartner());
		Partner partnerAux;
		String line = "";
		openToRead();
		do {
			try {
				line = br.readLine();
				if (line != null) {
					if (line.charAt(0) != 'I') {
						partnerAux = new Partner(null, Long.parseLong(line.split(",")[2]), line.split(",")[3],
								line.split(",")[4], Genre.FEMALE, null, Integer.parseInt(line.split(",")[7]),
								Integer.parseInt(line.split(",")[8]));
//						System.out.println(partnerAux.toString());
						partnerAux.setId(Integer.parseInt(line.split(",")[0]));
						auxList.registerPartner(partnerAux);
					}
				}
			} catch (IOException e) {
				throw new IOException("error al leer los datos del archivo " + super.toString());
			} catch (RegisteredPartner e) {
				e.printStackTrace();
			}
		} while (line != null);
		br.close();
		fr.close();
		return auxList;
	}

	public void close() throws IOException {
		fw.close();
	}

	public void notAppend() {

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}
}