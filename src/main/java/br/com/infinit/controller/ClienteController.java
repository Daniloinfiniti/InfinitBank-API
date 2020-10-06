package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.Cliente;
import br.com.infinit.repository.ClientRepository;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/listaCliente")
    public List<Cliente> listarCliente(){
        return clientRepository.findAll();
    }

    @PostMapping(path = "/criarCliente")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente, HttpServletResponse response){
        Cliente clienteSalvo = clientRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @DeleteMapping("/removerCliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Long id) {
        this.clientRepository.deleteById(id);
    }

    @PutMapping("/alterarCliente/{id}")
    public ResponseEntity<Cliente> atualizarBoleto(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteSalvo = clientRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }
}
