package br.com.drugstore.newlife.repository;

import br.com.drugstore.newlife.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, UUID> {
}
