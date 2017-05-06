package com.nit.pingsite.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

	public static void main(String[] args) {
		try{
		File file=new File("E:/Jars/test.txt");
		
		FileWriter fw=new FileWriter(file);
		
		List<String> list=Arrays.asList("abbac","adkfk","adkj");
		for(String str:list){
			fw.write(str+"\n");	
		}
		fw.flush();
		fw.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
