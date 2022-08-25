package za.co.business.service;

import java.util.List;

import za.co.business.model.Configuration;

public interface ConfigurationService {

	public Configuration save(Configuration configuration);

	public List<Configuration> findAll();

	public Configuration findByConfigurationId(Long configurationId);

	public void delete(Configuration configuration);

}
