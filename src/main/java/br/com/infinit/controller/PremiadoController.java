package br.com.infinit.controller;

import br.com.infinit.model.Premiado;
import br.com.infinit.repository.PremiadoRepository;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("premiado")
public class PremiadoController {

    @Autowired
    private PremiadoRepository premiadoRepository;
    
    @GetMapping("/listarPremiado")
    public List<Premiado> listarPremiado(){
        return premiadoRepository.findAll();
    }
    
    @PostMapping("/criarPremiado")
    public ResponseEntity<Premiado> salvarPremiado(@RequestBody Premiado premiado, HttpServletResponse response){
    	Premiado premiadoSalvo = premiadoRepository.save(premiado);
        return ResponseEntity.status(HttpStatus.CREATED).body(premiadoSalvo);
    }

    @DeleteMapping("/removerPremiado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPremiado(@PathVariable Long id) {
        this.premiadoRepository.deleteById(id);
    }

    @PutMapping("/atualizarPremiado/{id}")
    public ResponseEntity<Premiado> atualizarPremiado(@PathVariable Long id, @RequestBody Premiado premiado){
        Premiado premiadoItemSalvo = premiadoRepository.save(premiado);
        return ResponseEntity.ok(premiadoItemSalvo);
    }
}
