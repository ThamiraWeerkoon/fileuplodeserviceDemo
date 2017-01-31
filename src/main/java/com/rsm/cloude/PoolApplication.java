package com.rsm.cloude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rsm.cloude.utiis.DirectoryUtils;



@SpringBootApplication
public class PoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoolApplication.class, args);
		DirectoryUtils.createDirectories();
	}
}
