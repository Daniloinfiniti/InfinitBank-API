package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.FormaDePagamento;
import br.com.infinit.repository.FormaDePagamentoRepository;

@RestController
@RequestMapping("/formadepagamento")
public class FormaDePagamentoController {

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;
    
    @GetMapping("/listarFormaDePagamento")
    public List<FormaDePagamento> listarFormaDePagamaneto(){
        return formaDePagamentoRepository.findAll();
    }
    
    @PostMapping("/criarFormaDePagamento")
    public ResponseEntity<FormaDePagamento> salvarFormaDePagamento(@RequestBody FormaDePagamento formaDePagamento, HttpServletResponse response){
        FormaDePagamento formaDePagamentoSalvo = formaDePagamentoRepository.save(formaDePagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(formaDePagamentoSalvo);
    }

    @DeleteMapping("/removerFormaDePagamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFormaDePagamento(@PathVariable Long id) {
        this.formaDePagamentoRepository.deleteById(id);
    }

    @PutMapping("/atualizarFormaDePagamento/{id}")
    public ResponseEntity<FormaDePagamento> atualizarFormaDePagamento(@PathVariable Long id, @RequestBody FormaDePagamento formaDePagamento){
        FormaDePagamento formaDePagamentoSalvo = formaDePagamentoRepository.save(formaDePagamento);
        return ResponseEntity.ok(formaDePagamentoSalvo);
    }
}
