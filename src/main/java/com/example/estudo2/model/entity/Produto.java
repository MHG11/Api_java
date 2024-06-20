package com.example.estudo2.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="tb_produto")
public class Produto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String descricao;
    private BigDecimal valor;

    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itensVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ItemVenda> getItensVenda() {
    return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
     this.itensVenda = itensVenda;
    }
}
