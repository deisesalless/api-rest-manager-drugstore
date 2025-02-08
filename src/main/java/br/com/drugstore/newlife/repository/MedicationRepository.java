package br.com.drugstore.newlife.repository;

import br.com.drugstore.newlife.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, UUID> {

    @Modifying
    @Query("UPDATE tb_medication m SET m.is_active = false WHERE m.id = :id")
    void softDelete(@Param("id") UUID id);

    @Modifying
    @Query("UPDATE tb_medication m SET m.is_active = true WHERE m.id = :id")
    void reactivate(@Param("id") UUID id);

    @Query("SELECT m FROM MedicationEntity m WHERE m.isActive = true")
    List<MedicationEntity> findAllActiveMedications();

    @Query("SELECT * FROM tb_medication m WHERE m.is_active = 0")
    List<MedicationEntity> findAllSoftDeletedMedications();
    // testar de outra forma aqui
    List<MedicationEntity> findAllByActiveFalse();
}
