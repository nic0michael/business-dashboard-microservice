package za.co.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

	public Configuration findByConfigurationId(Long configurationId);

}
