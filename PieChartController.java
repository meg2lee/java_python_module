package com.example.demo.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.PieChartCreator;

@Controller
public class PieChartController {
	@RequestMapping("/chart/pie")
	public String showChart(@RequestParam("files") MultipartFile[] mfiles,
	           HttpServletRequest request, Model model) throws Exception {
	    ServletContext context = request.getServletContext();
	    String savePath = context.getRealPath("/chart");
	            
		String pymodule="C:\\test\\CreatePieChart.py";
		String imgPath="C:\\javaWeb\\demo\\src\\main\\webapp\\chart\\piechart.png";
		
		PieChartCreator pcc = new PieChartCreator();
		boolean isCreated = pcc.createPieChart(pymodule, imgPath, savePath, mfiles);
		
		model.addAttribute("chart", "piechart.png");
		return "piechart";
	}
	
	@RequestMapping("/chart/upload")
	public String uploadForm() {
		return "chartUpload";
	}
	
}
