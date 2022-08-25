package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.business.helper.BusinessHelper;
import za.co.business.model.Gratuity;

@Controller
@RequestMapping("/business-dashboard/graduity")
public class GratuityController {	
	private static final Logger log = LoggerFactory.getLogger(GratuityController.class);

	@Autowired
	BusinessHelper processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Gratuity> gratuities = processor.findAllGraduities();
		if(gratuities!=null) {
			log.info("gratuities has "+gratuities.size()+" records");
		} else {
			log.info("gratuities is null ");			
		}
		
		model.addAttribute("gratuityList", gratuities);
		return "graduity/list-graduity";
		
	}
	
	@GetMapping("/maakdood")
	public String deleteProduct(@RequestParam(value = "id") Long gratuityId,Model model) {
		log.info("BUSINESS : GratuityController : delete graduity : with project_id : "+gratuityId);
		processor.deleteGratuity(gratuityId);

		return listall(model) ;
		
	}

}
