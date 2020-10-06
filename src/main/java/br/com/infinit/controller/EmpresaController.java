package br.com.infinit.controller;

import br.com.infinit.model.Empresa;
import br.com.infinit.repository.EmpresaRepository;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
    
    @GetMapping("/listarEmpresas")
    public List<Empresa> listarEmpresa(){
        return empresaRepository.findAll();
    }
    
    @PostMapping("/criarEmpresa")
    public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa empresa, HttpServletResponse response){
        Empresa empresaSalvo = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalvo);
    }

    @DeleteMapping("/removeEmpresa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmpresa(@PathVariable Long id) {
        this.empresaRepository.deleteById(id);
    }

    @PutMapping("/atualizaEmpresa/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
        Empresa empresaSalvo = empresaRepository.save(empresa);
        return ResponseEntity.ok(empresaSalvo);
    }
}