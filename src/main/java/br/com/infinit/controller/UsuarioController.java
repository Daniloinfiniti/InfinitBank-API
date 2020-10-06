package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.Usuario;
import br.com.infinit.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping(path = "/listarUsuario")
    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }
    
    @PostMapping(path = "/criarUsuario")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario, HttpServletResponse response){
    	Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @DeleteMapping("/removeUsuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsuario(@PathVariable Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @PutMapping("/atualizaUsuario/{id}")
    public ResponseEntity<Usuario> atualizarPremiado(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }
}
