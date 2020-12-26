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
		
		/*java단에서 python을 함께 실행하도록 하는 ProcessBuilder 생성
		* 순서대로 python.exe, 실행할.py파일, .py에서 참고할 csv파일 위치(first argument), .py 실행후 이미지 저장할 위치(second argument)*/
		ProcessBuilder pb=new ProcessBuilder("python",pymodule,savePath+mfiles[0].getOriginalFilename(),imgPath).inheritIO();
	        Process p=pb.start(); // process 실행
	        p.waitFor(); // 실행완료될때까지 대기
		/*bianry파일->tex파일->한 행씩 읽어옴*/
	        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line=""; // 빈 문자열 준비
	        while((line=bfr.readLine())!=null) { //null 나올때까지 읽어온 한 행씩 저장
	           System.out.println(line); // .py 전체코드출력(최종적으로 piechart 생성 후, 저장)
	        }
        } catch(Exception e) {
	    	e.printStackTrace();  
        }
        return isCreated; // boolean값 return
   }
	
}
