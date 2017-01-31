package com.rsm.cloude.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsm.cloude.model.factory.helper.FactoryDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileConverterService {


	public File multipartToFile(File base, MultipartFile multipart, boolean randomName) {
		
		log.info("Converting Mutlipart File to File");
		try {
			File convFile;
			String fileName = multipart.getOriginalFilename();

			if (base != null) {
				if (randomName) {
					fileName = "_" + new Date().getTime();
				}
				convFile = new File(base, fileName);
			} else {
				convFile = base;
			}

			// Create parent file if not exists
			if (!convFile.getParentFile().exists()) {
				convFile.getParentFile().mkdirs();
			}

			// Create the directory and the file
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(multipart.getBytes());
			fos.close();
			log.info("File saved to :" + convFile.getAbsolutePath());
			return convFile;
		} catch (IOException e) {
			log.error("Converting File Error", e);
			return null;
		}
	}// End multipartToFile()
	
	
}// End FileConverterService()
