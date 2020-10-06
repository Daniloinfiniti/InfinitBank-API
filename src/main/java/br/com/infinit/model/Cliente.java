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
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Contrato contrato;

    @Column(nullable = false, length = 18)
    private String cnpj;

    @Column(nullable = false, length = 200)
    private String razaoSocial;

    @Column(nullable = false, length = 200)
    private String nomeFantasia;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 200)
    private String complemento;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 10)
    private String cep;

    @Column(nullable = false, length = 50)
    private String telefone;

    @Column(nullable = false, length = 50)
    private String celular;

}
