package br.com.infinit.controller;

import br.com.infinit.model.Pedido;
import br.com.infinit.model.PedidoFormaPagamento;
import br.com.infinit.repository.PedidoFormaPagamentoRepository;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formapagamento")
public class PedidoFormaPagamentoController {

    @Autowired
    private PedidoFormaPagamentoRepository pedidoFormaPagamentoRepository;
    
    @GetMapping("/listarPedidoFormaPagamento")
    public List<PedidoFormaPagamento> listarPedidoFormaPagamento(){
        return pedidoFormaPagamentoRepository.findAll();
    }
    
    @PostMapping("/criarPedidoFormaPagamento")
    public ResponseEntity<PedidoFormaPagamento> salvarPedidoFormaPagamento(@RequestBody PedidoFormaPagamento pedidoFormaPagamento, HttpServletResponse response){
    	PedidoFormaPagamento pedidoFormaPagamentoSalvo = pedidoFormaPagamentoRepository.save(pedidoFormaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoFormaPagamentoSalvo);
    }

    @DeleteMapping("/removerPedidoFormaPagamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedidoFormaPagamento(@PathVariable Long id) {
        this.pedidoFormaPagamentoRepository.deleteById(id);
    }

    @PutMapping("/atualizarvPedidoFormaPagamento/{id}")
    public ResponseEntity<PedidoFormaPagamento> atualizarPedidoFormaPagamento(@PathVariable Long id, @RequestBody PedidoFormaPagamento pedidoFormaPagamento){
        PedidoFormaPagamento pedidoFormaPagamentoSalvo = pedidoFormaPagamentoRepository.save(pedidoFormaPagamento);
        return ResponseEntity.ok(pedidoFormaPagamentoSalvo);
    }
}
