package com.example.TODO_List.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TODO_List.Model.Historico;
import com.example.TODO_List.Repository.HistoricoRepository;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoRepository historicoRepository;

    @GetMapping
    public List<Historico> getAllHistoricos() {
        return historicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historico> getHistoricoById(@PathVariable Long id) {
        Optional<Historico> historico = historicoRepository.findById(id);
        return historico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Historico createHistorico(@RequestBody Historico historico) {
        return historicoRepository.save(historico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historico> updateHistorico(@PathVariable Long id, @RequestBody Historico historicoDetails) {
        Optional<Historico> optionalHistorico = historicoRepository.findById(id);

        if (optionalHistorico.isPresent()) {
            Historico historico = optionalHistorico.get();
            historico.setDescricaoMudanca(historicoDetails.getDescricaoMudanca());
            historico.setDataMudanca(historicoDetails.getDataMudanca());
            Historico updatedHistorico = historicoRepository.save(historico);
            return ResponseEntity.ok(updatedHistorico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorico(@PathVariable Long id) {
        if (historicoRepository.existsById(id)) {
            historicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

