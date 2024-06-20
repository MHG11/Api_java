package com.example.estudo2.model.repository;

import com.example.estudo2.model.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager en;

    public void save(Produto produto){
        en.persist(produto);
    }

    public Produto produto(Long id){
        return en.find(Produto.class, id);
    }

    public List<Produto> produtos(){
        Query query = en.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(Long id){
        Produto p = en.find(Produto.class, id);
        en.remove(p);
    }

    public void update(Produto produto){
        en.merge(produto);
    }
}
