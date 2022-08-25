package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.business.model.Configuration;
import za.co.business.repositories.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	ConfigurationRepository confRep;

	@Override
	public Configuration save(Configuration configuration) {
		return confRep.save( configuration) ;
	}

	@Override
	public List<Configuration> findAll() {
		return confRep.findAll() ;
	}

	@Override
	public Configuration findByConfigurationId(Long configurationId) {
		return confRep.findByConfigurationId( configurationId) ;
	}

	@Override
	public void delete(Configuration configuration) {
		confRep.delete(configuration) ;
		
	}
	

}
