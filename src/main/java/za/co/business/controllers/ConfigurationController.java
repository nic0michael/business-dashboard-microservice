package za.co.business.controllers;

import java.sql.Timestamp;
import java.util.Date;
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

import za.co.business.dtos.ConfigurationRequest;
import za.co.business.helper.BusinessHelper;
import za.co.business.model.Configuration;
import za.co.business.model.Employee;
import za.co.business.utils.RequestResponseUtils;

@Controller
@RequestMapping("/business-dashboard/configuration")
public class ConfigurationController {
	private static final Logger log = LoggerFactory.getLogger(ConfigurationController.class);
	

	@Autowired
	BusinessHelper processor;
	
	@GetMapping
	public String displayConfigurationHome(Model model) {
		List<Configuration> configurations = processor.findAllConfigurations();
		model.addAttribute("configurationList", configurations);

		return "configuration/list-configurations";
	}

	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Configuration> configurations = processor.findAllConfigurations();
		model.addAttribute("configurationList", configurations);

		return "configuration/list-configurations";
		
	}

	@GetMapping(value = "/new")
	public String newCConfiguration(Model model) {
		ConfigurationRequest request =new ConfigurationRequest();

		log.info("ConfigurationController | newCConfiguration | ConfigurationRequest : "+request);
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		model.addAttribute("configurationRequest", request);

		return "configuration/new-configuration";		
	}
	


	@PostMapping(value = "/save")
	public String saveConfiguration(ConfigurationRequest request,Model model) {
		log.info("ConfigurationController | saveConfiguration | request : "+request);
		Configuration configuration =processor.saveConfiguration(request);
		log.info("Saved configuration : "+configuration);
		model.addAttribute("configurationRequest", request);


		List<Configuration> configurations = processor.findAllConfigurations();
		model.addAttribute("configurationList", configurations);
		return "configuration/list-configurations";	
	}


	@PostMapping(value = "/update")
	public String updateConfiguration(ConfigurationRequest request,Model model) {
		log.info("ConfigurationController | saveConfiguration | request : "+request);
		if(request!=null) {
			Long configurationId=request.getConfigurationId();
			Configuration configuration =processor.findConfigurationByConfigurationId(configurationId);
			configuration =processor.updateConfiguration(configuration,request);
		}
		model.addAttribute("configurationRequest", request);


		List<Configuration> configurations = processor.findAllConfigurations();
		model.addAttribute("configurationList", configurations);
		return "configuration/list-configurations";	
	}

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long configurationId,Model model) {
		Configuration configuration =processor.findConfigurationByConfigurationId( configurationId);
		ConfigurationRequest request =RequestResponseUtils.makeConfigurationRequest(configuration);

		model.addAttribute("configurationRequest", request);
		return "configuration/edit-configuration";
		
	}

	@GetMapping("/maakdood")
	public String deleteConfiguration(@RequestParam(value = "id") Long configurationtId,Model model) {
		log.info("BUSINESS : ProductController : deleteProduct : with project_id : "+configurationtId);
		processor.deleteConfiguration(configurationtId);

		return listall(model) ;
		
	}

}
