package file_handling;

import java.io.File;
import java.io.IOException;

public class ExistFile {
	public ExistFile() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException {
		File f=new File("D:\\CapGemini\\test.dll");
		if(f.exists())
			System.out.println(f.delete());	
		else
			System.out.println(f.createNewFile());
	}
}