package com.example.estudo2.model.repository;

import java.util.List;

import com.example.estudo2.model.entity.Produto;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.estudo2.model.entity.Venda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class VendaRepository {
   
    @PersistenceContext
    private EntityManager em;

    public void save(Venda venda){
        em.persist(venda);
    }

    public Venda venda(Long id){
        return em.find(Venda.class, id);
    }

    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    public void remove(Long id){
        Venda ve = em.find(Venda.class, id);
        em.remove(ve);
    }

    public void update(Venda venda){
        em.merge(venda);
    }

}
