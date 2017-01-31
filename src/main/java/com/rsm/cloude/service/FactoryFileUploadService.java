package com.rsm.cloude.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsm.cloude.model.factory.Factory;
import com.rsm.cloude.model.factory.FactoryChecklist;
import com.rsm.cloude.model.factory.FactoryJob;
import com.rsm.cloude.model.factory.FactoryLot;
import com.rsm.cloude.model.factory.FactoryLotCount;
import com.rsm.cloude.model.factory.helper.FactoryDto;
import com.rsm.cloude.repository.factory.FactoryChecklistRepository;
import com.rsm.cloude.repository.factory.FactoryJobRepository;
import com.rsm.cloude.repository.factory.FactoryLotCountRepository;
import com.rsm.cloude.repository.factory.FactoryRepository;
import com.rsm.cloude.utiis.DirectoryUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FactoryFileUploadService {

	@Autowired
	private FileConverterService fileConverterService;

	@Autowired
	private FactoryChecklistRepository chaklistRepository;

	@Autowired
	private FactoryJobRepository jobRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private FactoryLotCountRepository factoryLotCountRepository;

	public ResponseEntity<?> processFactoryChecklist(MultipartFile file) throws NumberFormatException, IOException {
		File uploadedFile = fileConverterService.multipartToFile(DirectoryUtils.FACTORY_CHECKLISTS_IMPORTS, file,
				false);
		FactoryChecklist checklist = new FactoryChecklist();
		checklist.setFileName(uploadedFile.getName());
		chaklistRepository.save(checklist);
		ArrayList<FactoryDto> checklistDto = getRecordsFromFile(uploadedFile);
		ArrayList<Factory> f = new ArrayList<>();
		for (FactoryDto factoryDto : checklistDto) {
			FactoryJob factoryJob = new FactoryJob();
			factoryJob.setChecklist(checklist);
			jobRepository.save(factoryJob);

			try {
				Factory factory = factoryRepository.findFirstByTickerIdNameAndFactoryId(factoryDto.getTicker(),
						factoryDto.getFactoryId());
				 System.out.println(factoryDto.getTicker() + " " +
				 factoryDto.getFactoryId());
				 System.out.println(factory.getFactoryId());
				
				Collection c = factory.getFactoryLotCollection();
				ArrayList<FactoryLot> l = new ArrayList<>(c);
				for (FactoryLot factoryLot : l) {
					FactoryLotCount factoryLotCount = new FactoryLotCount();
					factoryLotCount.setFactoryLotId(factoryLot);
					factoryLotCount.setFactoryJobId(factoryJob);
					factoryLotCountRepository.save(factoryLotCount);
					
				}
			} catch (IllegalArgumentException e) {
				System.out.println(factoryDto.getTicker() + "        " + factoryDto.getFactoryId());
			}

		}

		// jobRepository.save();

//		chaklistRepository.save(checklist);
		log.info("File " + uploadedFile.getName() + " Uploaded By ");
		return ResponseEntity.ok(checklistDto);

	}

	private String formatDouble(double d) {
		if (d == (long) d)
			return String.format("%d", (long) d);
		else
			return String.format("%s", d);
	}// End formatDouble()

	private ArrayList<FactoryDto> getRecordsFromFile(File source) throws NumberFormatException, IOException {
		log.info("Reading file started");
		ArrayList<FactoryDto> entities = new ArrayList<FactoryDto>();

		XSSFWorkbook workbook = null;
		FileInputStream file = null;

		try {
			file = new FileInputStream(source);
			// Get the workbook instance for XLSX file
			workbook = new XSSFWorkbook(file);
			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator: while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				FactoryDto entity = new FactoryDto();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
							entity.setTicker(cell.getStringCellValue());
						// If header is there continue
						if (entity.getTicker().equalsIgnoreCase("Ticker")) {
							log.info("Header found:" + source.getName());
							continue rowIterator;
						}
						break;
					case 1:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							String cellValue = cell.getStringCellValue().trim();
							int factoryID = 0;
							try {
								factoryID = Integer.parseInt(cellValue.substring(cellValue.indexOf("_") + 1));
								entity.setFactoryId(factoryID);
							} catch (NumberFormatException e) {
								String msg = "Can't find store Id:" + cellValue;
								log.info(msg);
								throw new NumberFormatException(msg);
							}
						}
						break;
					case 2:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
							entity.setAddress(cell.getStringCellValue());
						break;
					case 3:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
							entity.setState(cell.getStringCellValue());
						break;
					case 4:
						// ZIP should be in String as in the EXCEL file.
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							entity.setZip(Long.parseLong(cell.getStringCellValue()));
						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setZip((long) cell.getNumericCellValue());
						}
						break;
					case 5:
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setLatitude(cell.getNumericCellValue());
						}
						break;
					case 6:
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setLongtitude(cell.getNumericCellValue());
						}
						break;
					case 7:
						// Match ID should be in String as in the EXCEL file.
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
							entity.setMatchID(cell.getStringCellValue());
						break;
					case 8:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							entity.setName(cell.getStringCellValue());
						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setName(formatDouble(cell.getNumericCellValue()));
						}
						break;
					case 9:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							entity.setDirectory(cell.getStringCellValue());
						}
						break;
					// *************************************************************
					// These cases are for uploading already counted Excel files
					// *************************************************************
					case 10:
						// If not numeric then just ignore
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setCars((int) cell.getNumericCellValue());
						}
						break;
					case 11:
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setSpaces((int) cell.getNumericCellValue());
						}
						break;
					case 12:
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							entity.setComment(cell.getStringCellValue());
						}
						break;
					case 13:
						// If it is numeric then it should be a side car
						// parks(extra cars)
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							entity.setSideCarParks((int) cell.getNumericCellValue());
						}
						// If the type is String then it should be the mall type
						else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							entity.setMallType(cell.getStringCellValue());
						}
						break;
					}// End switch
				} // End columns while

				// If the File is some thing already done then
				if (entity.getCars() > 0 || entity.getComment() != null) {
					entity.setStatus("done");
				}
				// Add the modified entity to the list
				entities.add(entity);
			} // End row while
				// Remove the title row (Deprecated as common way is
				// implemented)
				// entities.remove(0);
				// close the file
			log.info("Reading file Completed!");
			return entities;
		} finally {
			try {
				workbook.close();
				file.close();
			} catch (IOException e) {
				log.warn("Error closing file:" + source.getName());
			}
		}
	}// End read File

}
