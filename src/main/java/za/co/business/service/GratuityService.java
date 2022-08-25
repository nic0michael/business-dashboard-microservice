package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.Gratuity;

public interface GratuityService {

	public Gratuity findByGratuityId(Long gratuityId);

	public List<Gratuity> findAll(Sort sortByDateCreatedDesc);

	public void save(Gratuity gratuity);

	public void delete(Gratuity gratuity);

}
