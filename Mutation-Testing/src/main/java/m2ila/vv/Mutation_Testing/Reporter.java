package m2ila.vv.Mutation_Testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporter {
	private PrintWriter pw;
	private StringBuilder sb;
	
	public void init() throws FileNotFoundException{
		String fileName = generateFileName();
        pw = new PrintWriter(new File(fileName));
        sb = new StringBuilder();
	}
	
	public void insert(String str){
		this.sb.append(str);
		this.sb.append('\n');
	}
	
	public void insertLine(){
		this.sb.append("<hr>");
		this.sb.append('\n');
	}
	
	public void save(){
        pw.write(sb.toString());
        pw.close();
        System.out.println("Report Done !");
	}
	
	public String generateFileName(){
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String fileName = "Report"+time+".html";
		return fileName;
	}
}
