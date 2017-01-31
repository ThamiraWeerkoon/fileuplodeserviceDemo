package com.rsm.cloude.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rsm.cloude.service.FactoryFileUploadService;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/factory-checklist")
public class UplodeController {
	
	@Autowired
	private FactoryFileUploadService fileUploder;
	
	@RequestMapping(value = "addFile", method = RequestMethod.POST)
	public ResponseEntity<?> addChecklist(@RequestParam(value = "file", required = true) MultipartFile file){
		try {
			ResponseEntity<?> f=fileUploder.processFactoryChecklist(file);
			return f;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("null");
		
	}

}
