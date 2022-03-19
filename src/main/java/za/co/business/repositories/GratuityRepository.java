package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Gratuity;

public interface GratuityRepository extends JpaRepository<Gratuity, Long> {

	public Gratuity findByGratuityId(Long gratuityId);

}
