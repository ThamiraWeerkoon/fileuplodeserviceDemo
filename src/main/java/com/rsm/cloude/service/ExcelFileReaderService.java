package com.rsm.cloude.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.rsm.cloude.model.factory.helper.FactoryDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ExcelFileReaderService {
	
	
	public File exportFile(File exportFile) {
		
		
		return exportFile;
		
	}// End exportFile ()

}
