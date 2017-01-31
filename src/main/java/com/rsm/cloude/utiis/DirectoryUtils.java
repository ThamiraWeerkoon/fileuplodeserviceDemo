package com.rsm.cloude.utiis;

import java.io.File;
import java.lang.reflect.Field;

public class DirectoryUtils {

	// Common
	public final static File DATA = new File("data");
	public final static File IMAGES = new File(DATA, "images");
	public final static File IMAGES_PROFILE = new File(IMAGES, "profile");

	// temporary files
	public final static File TMP = new File(DATA, "tmp");
	public final static File HOURS = new File(DATA, "User_Hours");

	public final static File DOWNLOADS = new File(DATA, "downloads");
	public final static File DOWNLOADS_TIFFS = new File(DOWNLOADS, "tiffs");
	public final static File DOWNLOADS_REMOTE_TIFFS = new File(DOWNLOADS, "remote_tiffs");
	public final static File STOCK_PRICE = new File(DOWNLOADS, "stock_prices");
	public final static File EMAILS = new File(DATA, "emails");
	public final static File EMAILS_ATTACHMENTS = new File(EMAILS, "attachments");
	public final static File EMAILS_GENERATED = new File(EMAILS, "generated");

	// Revenues
	public final static File REVENUES = new File(DATA, "revenues");
	public final static File REVENUES_FTM = new File(REVENUES, "ftm");
	public final static File REVENUES_QUARTERLY = new File(REVENUES, "quarterly");
	public final static File REVENUES_ACTUAL_QUARTERLY = new File(REVENUES, "actual_quarterly");

	// Quarter End Dates
	public final static File QUARTER_END_DATES = new File(DATA, "quarter_end_dates");

	// Retailer
	public final static File RETAILER = new File(DATA, "retailers");
	public final static File RETAILER_SHAPE_FILES = new File(RETAILER, "shape_files");
	public final static File RETAILER_SHAPE_BUFFERED = new File(RETAILER_SHAPE_FILES, "buffered");
	public final static File RETAILER_SHAPE_BORDERED = new File(RETAILER_SHAPE_FILES, "bordered");
	public final static File RETAILER_SHAPE_SPACES = new File(RETAILER_SHAPE_FILES, "spaces");

	public final static File RETAILER_CHECKLISTS = new File(RETAILER, "check_lists");
	public final static File RETAILER_CHECKLISTS_IMPORTS = new File(RETAILER_CHECKLISTS, "imports");
	public final static File RETAILER_CHECKLISTS_EXPORTS = new File(RETAILER_CHECKLISTS, "exports");
	public final static File RETAILER_CHECKLISTS_CALENDAR = new File(RETAILER_CHECKLISTS, "calendar");
	
	public final static File RETAILER_REPORT_EXPORT = new File(RETAILER, "report_exports");
	
	public final static File RETAILER_REPORTS = new File(RETAILER, "reports");
	
	public final static File RETAILER_DAILY_REPORTS = new File(RETAILER, "daily_reports");

	public final static File RETAILER_JOBS = new File(RETAILER, "jobs");

	public final static File RETAILER_IMAGES = new File(RETAILER, "images");
	public final static File RETAILER_IMAGES_MAP = new File(RETAILER_IMAGES, "reference");
	public final static File RETAILER_IMAGES_BORDER = new File(RETAILER_IMAGES, "border");
	public final static File RETAILER_IMAGES_CROPPED = new File(RETAILER_IMAGES, "cropped");
	public final static File RETAILER_IMAGES_PROCESSED = new File(RETAILER_IMAGES, "processed");
	public final static File RETAILER_IMAGES_MASK_CROPPED = new File(RETAILER_IMAGES, "mask_cropped");

	// Uploaded images
	public final static File RETAILER_IMAGES_UPLOADS = new File(RETAILER_IMAGES, "uploads");
	public final static File RETAILER_IMAGES_MASK_CROPPED_UPLOADS = new File(RETAILER_IMAGES_UPLOADS, "masked");

	public final static File RETAILER_SPACES = new File(RETAILER, "spaces");

	// Factory
	public final static File FACTORY = new File(DATA, "factories");
	
	public final static File FACTORY_IMAGES = new File(FACTORY, "images");
	public final static File FACTORY_LOT_IMAGES_MAP = new File(FACTORY_IMAGES, "reference");
	public final static File FACTORY_LOT_IMAGES_BORDER = new File(FACTORY_IMAGES, "border");
	public final static File FACTORY_LOT_IMAGES_CROPPED = new File(FACTORY_IMAGES, "cropped");
	public final static File FACTORY_LOT_IMAGES_PROCESSED = new File(FACTORY_IMAGES, "processed");
	public final static File FACTORY_LOT_IMAGES_MASK_CROPPED = new File(FACTORY_IMAGES, "mask_cropped");
	
	public final static File FACTORY_LOT_SHAPE_FILES = new File(FACTORY, "shape_lot_files");
	public final static File FACTORY_LOT_SHAPE_BORDERED = new File(FACTORY_LOT_SHAPE_FILES, "bordered");
	public final static File FACTORY_LOT_SHAPE_BUFFERED = new File(FACTORY_LOT_SHAPE_FILES, "buffered");
	public final static File FACTORY_LOT_SHAPE_SPACES = new File(FACTORY_LOT_SHAPE_FILES, "spaces");
	
	public final static File FACTORY_CHECKLISTS = new File(FACTORY, "check_lists");
	public final static File FACTORY_CHECKLISTS_IMPORTS = new File(FACTORY_CHECKLISTS, "imports");
	public final static File FACTORY_CHECKLISTS_EXPORTS = new File(FACTORY_CHECKLISTS, "exports");
	
	public final static File FACTORY_LOT_JOBS = new File(FACTORY, "jobs");
	
	// Metal
	public final static File METAL = new File(DATA, "metal");
	
	public final static File METAL_JOBS = new File(METAL, "jobs");
	
	public final static File METAL_CHECKLISTS = new File(METAL, "check_lists");
	public final static File METAL_CHECKLISTS_IMPORTS = new File(METAL_CHECKLISTS, "imports");
	public final static File METAL_CHECKLISTS_EXPORTS = new File(METAL_CHECKLISTS, "exports");
	
	public final static File METAL_SHAPE_FILES = new File(METAL, "shape_files");
	public final static File METAL_SHAPE_BUFFERED = new File(METAL_SHAPE_FILES, "buffered");
	public final static File METAL_SHAPE_BORDERED = new File(METAL_SHAPE_FILES, "bordered");
	public final static File METAL_SHAPE_SPACES = new File(METAL_SHAPE_FILES, "spaces");
	
	public final static File METAL_IMAGES = new File(METAL, "images");
	public final static File METAL_IMAGES_MAP = new File(METAL_IMAGES, "reference");
	public final static File METAL_IMAGES_BORDER = new File(METAL_IMAGES, "border");
	public final static File METAL_IMAGES_CROPPED = new File(METAL_IMAGES, "cropped");
	public final static File METAL_IMAGES_PROCESSED = new File(METAL_IMAGES, "processed");
	public final static File METAL_IMAGES_MASK_CROPPED = new File(METAL_IMAGES, "mask_cropped");
	
	//Traffic Signals
	public final static File EMAIL_ATTACHMENT_UPDRADE_DOWNGRADE_DIR = new File(
			"data/emails/attachments/upgrade_downgrade");
	
	//Balancing 
	public final static File BALANCING = new File(DATA, "balancing");
	public final static File BALANCED = new File(BALANCING, "balanced");
	public final static File UNBALANCED = new File(BALANCING, "unbalanced");
	public final static File UNBALANCED_CSV = new File(BALANCING, "unbalanced_csv");
	

	public static void createDirectories() {
		Field[] fields = DirectoryUtils.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			if (f.getType().isAssignableFrom(File.class)) {
				try {
					File file = (File) f.get(File.class);
					if (!file.exists()) {
						file.mkdirs();
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			;
		} // End for loop
	}// End createDirectories ()

}// End DirectoryUtils clas̰s
