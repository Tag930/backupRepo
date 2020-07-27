package part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import okhttp3.internal.http2.Settings;

public class oficepro {

	public static void main(String[] args) throws IOException {

		/*	File log= new File("C:\\Users\\STrange\\Desktop\\ISPPExample1.iss");
		String search = "define";
		String replace = "define https://google.com/";

		try{
		    FileReader fr = new FileReader(log);
		    String s;
		    String totalStr = "";
		    try (BufferedReader br = new BufferedReader(fr)) {

		        while ((s = br.readLine()) != null) {
		            totalStr += s;
		        }
		        totalStr = totalStr.replaceAll(search, replace);
		        FileWriter fw = new FileWriter(log);
		    fw.write(totalStr);
		    fw.close();
		    }
		}catch(Exception e){
		    e.printStackTrace();
		}
}*/
	


	Path path = Paths.get("C:\\Users\\STrange\\Desktop\\ISPPExample1.iss");
	Charset charset = StandardCharsets.UTF_8;

	String content = new String(Files.readAllBytes(path), charset);
	
	content = content.replace("define", "bar");
	Files.write(path, content.getBytes(charset));
	
	}
}
