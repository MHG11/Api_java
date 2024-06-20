package com.example.estudo2.model.repository;

import java.util.List;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.estudo2.model.entity.ItemVenda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ItemVendaRepository {
    
    @PersistenceContext
    private EntityManager en;

    public void save(ItemVenda itemVenda){
        en.persist(itemVenda);
    }

    public ItemVenda itemVenda(Long id){
        return en.find(ItemVenda.class, id);
    }

    public List<ItemVenda> ivendas(){
        Query query = en.createQuery("from ItemVenda");
        return query.getResultList();
    }

    public void remove(Long id){
        ItemVenda p = en.find(ItemVenda.class, id);
        en.remove(p);
    }

    public void update(ItemVenda itemVenda){
        en.merge(itemVenda);
    }

}
