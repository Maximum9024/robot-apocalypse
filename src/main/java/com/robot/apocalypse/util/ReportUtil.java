package com.robot.apocalypse.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public final class ReportUtil {
	
	//generate pdf report
	public static byte[]  generatePDFReport(List<?> objectList,String sourceFile,HashMap <String,Object>map) throws FileNotFoundException, JRException {
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(objectList);
		JasperReport compileReport = JasperCompileManager.compileReport(
				      new FileInputStream(sourceFile));
		JasperPrint report=JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		            
	    byte[] data=JasperExportManager.exportReportToPdf(report);	
      
	    return data;
	}
}
