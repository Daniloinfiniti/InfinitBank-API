package br.com.infinit.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numPedido;

    @ManyToOne
    private Empresa empresa;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Contrato contrato;

    private String status;

    private LocalDateTime dtPedido;

    private BigDecimal vlPremiacao;

    private BigDecimal vlTaxaAdm;

    private BigDecimal vlTotal;

    @OneToOne
    private NotaFiscal notaFiscal;

    @OneToMany
    private List<PedidoFormaPagamento> pedidoFormaPagamentos;

    @OneToMany
    private List<PedidoItem> pedidoItem;
}
