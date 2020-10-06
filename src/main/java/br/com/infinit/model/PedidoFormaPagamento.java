package br.com.infinit.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class PedidoFormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idPedido;
    
    @ManyToOne
    private FormaDePagamento formaDePagamento;

    @OneToOne
    private Boleto boleto;

    @OneToOne
    private Pedido pedido;
}
