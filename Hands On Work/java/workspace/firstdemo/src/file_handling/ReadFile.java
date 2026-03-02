package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public ReadFile() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException {
		File f=new File("D:\\CapGemini\\test.txt");
			System.out.println(f.createNewFile());
			FileInputStream fis=new FileInputStream(f);
			int count;
			while((count=fis.read())!=-1) {
				System.out.println((char)count);
		}
	}
}