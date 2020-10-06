package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.Pedido;
import br.com.infinit.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public List<Pedido> listarPedido(){
        return pedidoRepository.findAll();
    }
    
    @PostMapping("/criarPedido")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido, HttpServletResponse response){
    	Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @DeleteMapping("/removerPedido/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedido(@PathVariable Long id) {
        this.pedidoRepository.deleteById(id);
    }

    @PutMapping("/atualizarPedido/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }
}
