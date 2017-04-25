package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import models.entities.Genre;
import models.entities.Partner;
import structureData.SimpleList;

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
//		file = new File(fileName);
//		//		fw = new FileWriter(file, true);
//		fr = new FileReader(file);
////		bw = new BufferedWriter(fw);
		//br =  new BufferedReader(fr);
//		pw = new PrintWriter(bw);
		
	}
	
	public void createFile(String nameFile){
		this.fileName = nameFile;
	}
	
	
	public void openToWrite() throws IOException{
		
		file = new File(fileName);
		fw = new FileWriter(file, append);
		fr = new FileReader(file);
		bw = new BufferedWriter(fw);
		
		fw = new FileWriter(file);
	}
	
	public void openToRead() throws FileNotFoundException{
		file = new File( fileName);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	public void writeFile(String chain) throws IOException{
//				pw.write(chain);
//		fw = new FileWriter(file, true);
		fw.write(chain + (char)13 +(char)10 );
		fw.flush();
	}
	
	public SimpleList<Partner> read() throws IOException{
		SimpleList<Partner> auxList= new SimpleList<>();
		Partner partnerAux;
		String line ="";
		openToRead();
		do {
			try {
				line = br.readLine();
				if (line !=null) {
					if (line.charAt(0)!= 'I') {
						
					partnerAux = new Partner(null, Long.parseLong(line.split(",")[2]), line.split(",")[3],line.split(",")[4], Genre.FEMALE, null, Integer.parseInt(line.split(",")[7]), Integer.parseInt(line.split(",")[8]));
					System.out.println(partnerAux.toString());
					partnerAux.setId(Integer.parseInt(line.split(",")[0]));
					auxList.add(partnerAux);
					}
				}
				auxList.remove(0);
			} catch (IOException e) {
				throw new IOException("error al leer los datos del archivo "+ super.toString());
			}
		} while(line != null);
		br.close();
		fr.close();
		return  auxList;
		
	}

//	public  ArrayList<VideoGame>  readFile() throws IOException{
//		ArrayList<String> arrayList = new ArrayList<String>();
//		ArrayList<VideoGame> listVideoGame = new ArrayList<>();
//		VideoGame gameAux = new VideoGame();
//		String line ="";
//		openToRead();
//		do {
//			try {
//				line = br.readLine();
//				if (line !=null) {
////					arrayList.add(line);
////					line.split(",");
//					gameAux = new VideoGame(Integer.parseInt(line.split(",")[0]), line.split(",")[1], file.getName(), line.split(",")[2], 
//							line.split(",")[3], null,0, 0, 0, 0, Double.parseDouble(line.split(",")[4]));
//					listVideoGame.add(gameAux);
//				}
//			} catch (IOException e) {
//				throw new IOException("error al leer los datos del archivo "+ super.toString());
//			}
//		} while(line != null);
//		br.close();
//		fr.close();
//		return  listVideoGame;
//	}
	
	
	
	
	public void close() throws IOException{
		fw.close();
	}

	
	public void notAppend(){

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