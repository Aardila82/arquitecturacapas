package com.relacionales.persona.Service;

import com.relacionales.persona.DTO.MedicamentoDTO;

import java.util.List;

public interface MedicamentoService {

    public List<MedicamentoDTO> listar();
    public MedicamentoDTO buscarPorId(Long id);
    public MedicamentoDTO guardar(MedicamentoDTO medicamentoDTO);
    public MedicamentoDTO editar(Long id, MedicamentoDTO medicamentoDTO);
    public void eliminar(Long id);


}
