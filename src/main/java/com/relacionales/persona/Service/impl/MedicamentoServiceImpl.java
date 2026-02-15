package com.relacionales.persona.Service.impl;

import com.relacionales.persona.DTO.MedicamentoDTO;
import com.relacionales.persona.Entity.MedicamentoEntity;
import com.relacionales.persona.Mapper.MedicamentoMapper;
import com.relacionales.persona.Repository.MedicamentoRepository;
import com.relacionales.persona.Service.MedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    // private final MedicamentoRepository repository;   mejor practica

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicamentoMapper medicamentoMapper;

    @Override
    public List<MedicamentoDTO> listar() {
        return medicamentoMapper.medicamentosEntityAMedicamentosDTO(medicamentoRepository.findAll());
    }

    @Override
    public MedicamentoDTO buscarPorId(Long id) {
        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medicamento no encontrado con id: " + id));
        return medicamentoMapper.medicamentoEntityAMedicamentoDTO(medicamentoEntity);
    }


    @Override
    public MedicamentoDTO guardar(MedicamentoDTO medicamentoDTO) {
        return medicamentoMapper.medicamentoEntityAMedicamentoDTO(
                medicamentoRepository.save(
                        medicamentoMapper.medicamentoDTOAMedicamentoEntity(medicamentoDTO)
                )
        );
    }

    @Override
    public MedicamentoDTO editar(Long id, MedicamentoDTO medicamentoDTO) {

        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Medicamento no encontrado con id: " + id));

        medicamentoEntity.setNombre(medicamentoDTO.getNombre());
        medicamentoEntity.setDescripcion(medicamentoDTO.getDescripcion());
        medicamentoEntity.setPrecio(medicamentoDTO.getPrecio());
        medicamentoEntity.setStock(medicamentoDTO.getStock());
        medicamentoEntity.setFechaVencimiento(medicamentoDTO.getFechaVencimiento());

        MedicamentoEntity updated = medicamentoRepository.save(medicamentoEntity);

        return medicamentoMapper.medicamentoEntityAMedicamentoDTO(updated);
    }


    @Override
    public void eliminar(Long id) {

        MedicamentoEntity medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Medicamento no encontrado con id: " + id));

        medicamentoRepository.delete(medicamento);
    }

}
