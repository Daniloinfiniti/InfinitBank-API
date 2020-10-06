package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.Boleto;
import br.com.infinit.repository.BoletoRepository;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    private BoletoRepository boletoRepository;
    
    @GetMapping("/listarBoleto")
    public List<Boleto> listarBoleto(){
        return boletoRepository.findAll();
    }

    @PostMapping("/criarBoleto")
    public ResponseEntity<Boleto> salvarBoleto(@RequestBody Boleto boleto, HttpServletResponse response){
        Boleto boletoSalvo = boletoRepository.save(boleto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boletoSalvo);
    }

    @DeleteMapping("/removerBoleto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerBoleto(@PathVariable Long id) {
        this.boletoRepository.deleteById(id);
    }

    @PutMapping("/atualizarBoleto/{id}")
    public ResponseEntity<Boleto> atualizarBoleto(@PathVariable Long id, @RequestBody Boleto boleto){
        Boleto boletoSalvo = boletoRepository.save(boleto);
        return ResponseEntity.ok(boletoSalvo);
    }
}
