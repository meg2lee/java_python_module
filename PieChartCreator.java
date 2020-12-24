package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.springframework.web.multipart.MultipartFile;

public class PieChartCreator {
	  
//	   public boolean createPieChart(String pymodule, String imgPath) {
//	      boolean isCreated = false;
//		   try {
//			  ProcessBuilder pb = new ProcessBuilder("python", pymodule," ",imgPath).inheritIO();
//		      Process p = pb.start();
//		      p.waitFor();
//		      BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		      String line="";
//		      while ((line = bfr.readLine()) != null) {
//		         System.out.println(line);
//		      }
//	      
//			File file = new File(imgPath);
//			if(!file.exists()){
//				isCreated = false;
//			} else {
//				isCreated = true;
//			}
//	      } catch(Exception e) {
//	    	e.printStackTrace();  
//	      }
//	      return isCreated;
//	   }
	
	public boolean createPieChart(String pymodule, String imgPath, String savePath, MultipartFile[] mfiles) {
		boolean isCreated = false;
		try {
			for(int i = 0 ; i < mfiles.length ; i++) {
	            mfiles[i].transferTo(new File(savePath+"/"+mfiles[i].getOriginalFilename()));
	        }
			
			ProcessBuilder pb=new ProcessBuilder("python",pymodule,savePath+mfiles[0].getOriginalFilename(),imgPath).inheritIO();
	        Process p=pb.start();
	        p.waitFor();
	        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line="";
	        while((line=bfr.readLine())!=null) {
	           System.out.println(line);
	        }
        } catch(Exception e) {
	    	e.printStackTrace();  
        }
        return isCreated;
   }
	
}
