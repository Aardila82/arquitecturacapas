package com.relacionales.persona.Repository;

import com.relacionales.persona.Entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {
}
