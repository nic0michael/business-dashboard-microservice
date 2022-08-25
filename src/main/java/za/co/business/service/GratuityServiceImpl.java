package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.Gratuity;
import za.co.business.repositories.GratuityRepository;

@Service
public class GratuityServiceImpl implements GratuityService {

	@Autowired
	GratuityRepository gratuityRepository;

	@Override
	public Gratuity findByGratuityId(Long gratuityId) {
		return gratuityRepository.findByGratuityId(gratuityId) ;
	}

	@Override
	public List<Gratuity> findAll(Sort sortByDateCreatedDesc) {
		return gratuityRepository.findAll( sortByDateCreatedDesc) ;
	}

	@Override
	public void save(Gratuity gratuity) {
		gratuityRepository.save( gratuity) ;
		
	}

	@Override
	public void delete(Gratuity gratuity) {
		gratuityRepository.delete(gratuity) ;
		
	}

}
