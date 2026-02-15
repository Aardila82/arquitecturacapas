package com.relacionales.persona.Controller;


import com.relacionales.persona.DTO.MedicamentoDTO;
import com.relacionales.persona.Service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> listar(){
        return ResponseEntity.ok(medicamentoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(medicamentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> guadar(@RequestBody MedicamentoDTO medicamentoDTO){
        return new ResponseEntity<>(medicamentoService.guardar(medicamentoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> editar(
            @PathVariable Long id,
            @RequestBody MedicamentoDTO medicamentoDTO) {

        return ResponseEntity.ok(medicamentoService.editar(id, medicamentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
