package br.com.infinit.model;

import br.com.infinit.model.Cliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.core.sym.Name;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Premiado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cliente cliente;

    private String cpf_cnpj;

    private String nome;

    private String email;

    private String celular;

    private String statusConta;
}
