package file_handling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public CreateFile() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException {
		File f=new File("D:\\CapGemini\\test.bin");
		System.out.println(f.createNewFile());
		System.out.println(f.delete());	
	}
}
