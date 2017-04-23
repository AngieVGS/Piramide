package persistence;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTwo {
	public static final String FILEPATH = ".\\src\\file.prs";

//	public static void main(String[] args) {
//		try {
//			System.out.println(new String(readFromFile(FILEPATH, 150, 23)));
//
//			writeToFile(FILEPATH, "write ended! :) ", 765);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public  byte[] readFromFile(String filePath, int position, int size)throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(position);
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		return bytes;
	}

	public  void writeToFile(String filePath, String data, int position)throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "rwd");
		file.seek(position);
		file.write(data.getBytes());
		file.close();
	}
}