package br.com.infinit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infinit.model.PedidoItem;
import br.com.infinit.repository.PedidoItemRepository;

@RestController
@RequestMapping("pedidoitem")
public class PedidoItemController {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @GetMapping("/listarPedidoItem")
    public List<PedidoItem> listarPedidoItem(){
        return pedidoItemRepository.findAll();
    }
    
    @PostMapping("/criarPedidoItem")
    public ResponseEntity<PedidoItem> salvarNotaFiscal(@RequestBody PedidoItem pedidoItem, HttpServletResponse response){
    	PedidoItem pedidoItemSalvo = pedidoItemRepository.save(pedidoItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoItemSalvo);
    }

    @DeleteMapping("/removerPedidoItem/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedidoItem(@PathVariable Long id) {
        this.pedidoItemRepository.deleteById(id);
    }

    @PutMapping("/atualizarPedidoItem/{id}")
    public ResponseEntity<PedidoItem> atualizarPedidoItem(@PathVariable Long id, @RequestBody PedidoItem pedidoItem){
        PedidoItem pedidoItemSalvo = pedidoItemRepository.save(pedidoItem);
        return ResponseEntity.ok(pedidoItemSalvo);
    }
}
