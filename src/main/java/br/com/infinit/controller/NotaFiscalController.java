package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.NotaFiscal;
import br.com.infinit.repository.NotaFiscalRepository;

@RestController
@RequestMapping("/notafiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;
    
    @GetMapping("/listarNotaFiscal")
    public List<NotaFiscal> listarNotaFiscal(){
        return notaFiscalRepository.findAll();
    }
    
    @PostMapping("/criarNotaFiscal")
    public ResponseEntity<NotaFiscal> salvarNotaFiscal(@RequestBody NotaFiscal notaFiscal, HttpServletResponse response){
    	NotaFiscal notaFiscalSalvo = notaFiscalRepository.save(notaFiscal);
        return ResponseEntity.status(HttpStatus.CREATED).body(notaFiscalSalvo);
    }

    @DeleteMapping("/removerNotaFIscal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerNotaFiscal(@PathVariable Long id) {
        this.notaFiscalRepository.deleteById(id);
    }

    @PutMapping("/atualizarNotaFiscal/{id}")
    public ResponseEntity<NotaFiscal> atualizarNotaFiscal(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal){
        NotaFiscal notaFiscalSalvo = notaFiscalRepository.save(notaFiscal);
        return ResponseEntity.ok(notaFiscalSalvo);
    }
}
