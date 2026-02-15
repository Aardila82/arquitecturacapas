package com.relacionales.persona.Mapper;

import com.relacionales.persona.DTO.MedicamentoDTO;
import com.relacionales.persona.Entity.MedicamentoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {

    MedicamentoDTO medicamentoEntityAMedicamentoDTO(MedicamentoEntity medicamentoEntity);
    MedicamentoEntity medicamentoDTOAMedicamentoEntity (MedicamentoDTO medicamentoDTO);
    List<MedicamentoDTO>medicamentosEntityAMedicamentosDTO(List<MedicamentoEntity> medicamentoEntity);
}
