package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import za.co.business.dtos.FileImageDto;

@Controller
@RequestMapping("/business-dashboard/fileuploads")
public class UploadController {
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);

	
	
	@GetMapping("/list")
	public String listFileImages(Model model) {
		log.info("ANTENNA | UploadController | listFileImages | called");
//		
//		List<FileImageDto> fileImages = uploadServiceManager.findAllFileImages();
//		String fileImagesListMessage = "";
//
//		if (fileImages == null) {
//			fileImagesListMessage = "Could not retrieve any uploaded files.";
//			log.error("ANTENNA | UploadController | listFileImages | File image list is null");
//		}
//		else {
//			fileImagesListMessage = " " + fileImages.size() + " uploaded files retrieved.";
//			log.info("ANTENNA | UploadController| listFileImages | Number of file images retrieved: " + fileImages.size());
//		}
//
//		model.addAttribute("fileImagesList", fileImages);
//		model.addAttribute("fileImagesListMessage", fileImagesListMessage);
		return "fileuploads/list-fileuploads";
	}



	@PostMapping("/upload")
	public String uploadCsvFile(MultipartFile file, Model model) {
		log.info("ANTENNA | UploadController | uploadCsvFile | called");
//		String csvFileUploadMessage = "";
//
//		if (file == null || file.isEmpty())  {
//			csvFileUploadMessage = "Please choose a CSV file to upload.";
//			model.addAttribute("csvFileUploadMessage", csvFileUploadMessage);
//			log.info("ANTENNA | UploadController| uploadCsvFile | Null or empty CSV file received");
//			return "fileuploads/new-fileuploads";
//		}
//
//		boolean isCsvSuccessfullyProcessed = uploadServiceManager.processCsvRecords(file);
//
//		if (isCsvSuccessfullyProcessed) {
//			csvFileUploadMessage = "CSV file successfully uploaded.";
//			log.error("ANTENNA | UploadController | uploadCsvFile | CSV file successfully uploaded");
//		}
//		else {
//			csvFileUploadMessage = "CSV file upload did not succeed. Check for possible file structure errors.";
//			log.info("ANTENNA | UploadController| uploadCsvFile | CSV file upload did not succeed");
//		}
//
//		model.addAttribute("csvFileUploadMessage", csvFileUploadMessage);
		return "fileuploads/new-fileuploads";
	}

	

}
