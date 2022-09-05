package com.mapa.mapadobrasil.controller;

import com.mapa.mapadobrasil.model.EstadoModel;
import com.mapa.mapadobrasil.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estado")

    public ResponseEntity<List<EstadoModel>> buscarPorEstado() {
        return ResponseEntity.ok(estadoService.buscarPorTodos());

    }

    @GetMapping(path = "/estado/{codigo}")
    public ResponseEntity<Optional<EstadoModel>> buscarId(@PathVariable Integer codigo) {
        return ResponseEntity.ok(estadoService.buscarId(codigo));
    }

    @PostMapping(path = "/estado")
    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody EstadoModel estadoModel) {
        EstadoModel estado = estadoService.cadastrar(estadoModel);
        return new ResponseEntity<>(estado, HttpStatus.CREATED);
    }

    @PutMapping(path = "/estado/{codigo}")
    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estadoModel, @PathVariable Integer codigo) {
        return ResponseEntity.ok(estadoService.alterar(estadoModel, codigo));
    }

    @DeleteMapping(path = "/estado/{codigo}")
    public void deletarEstado(@PathVariable Integer codigo) {
        estadoService.deletar(codigo);


    }
}

