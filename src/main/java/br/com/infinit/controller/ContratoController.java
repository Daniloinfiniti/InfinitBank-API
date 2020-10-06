package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.Contrato;
import br.com.infinit.repository.ContratoRepository;

@RestController
@RequestMapping("/Contrato")
public class ContratoController {

    @Autowired
    private ContratoRepository contratoRepository;
    
    @GetMapping("/listarContrato")
    public List<Contrato> listarContrato(){
        return contratoRepository.findAll();
    }
    
    @PostMapping("/criarContrato")
    public ResponseEntity<Contrato> salvarContrato(@RequestBody Contrato contrato, HttpServletResponse response){
        Contrato contratoSalvo = contratoRepository.save(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoSalvo);
    }

    @DeleteMapping("/removerContrato/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContrato(@PathVariable Long id) {
        this.contratoRepository.deleteById(id);
    }

    @PutMapping("/atualizarContrato/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato){
        Contrato contratoSalvo = contratoRepository.save(contrato);
        return ResponseEntity.ok(contratoSalvo);
    }
}
