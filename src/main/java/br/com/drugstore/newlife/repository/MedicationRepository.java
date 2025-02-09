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

    @Query("SELECT m FROM MedicationEntity m WHERE (:active IS NULL OR m.isActive = :active)")
    List<MedicationEntity> findByActive(@Param("active") Boolean active);

    @Modifying
    @Query("UPDATE tb_medication m SET m.is_active = false WHERE m.id = :id")
    void softDelete(@Param("id") UUID id);

    @Modifying
    @Query("UPDATE tb_medication m SET m.is_active = true WHERE m.id = :id")
    void reactivate(@Param("id") UUID id);
}
