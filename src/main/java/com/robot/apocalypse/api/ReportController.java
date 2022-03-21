package com.robot.apocalypse.api;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robot.apocalypse.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/report")
public class ReportController {
  
	@Autowired
	ReportService reportService;
	
	@GetMapping("robot/pdf")
	public ResponseEntity<byte[]> generateRobotReport() throws FileNotFoundException, JRException {
		byte[] report =reportService.generatePDFReport();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=apocalypse-report.pdf");
		
		return ResponseEntity.ok().headers(headers).body(report);
	}
}
