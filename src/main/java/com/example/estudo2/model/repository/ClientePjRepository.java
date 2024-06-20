package com.example.estudo2.model.repository;

import com.example.estudo2.model.entity.ClientePJ;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientePjRepository {
    @PersistenceContext
    private EntityManager en;

    public void save(ClientePJ clientePF){
        en.persist(clientePF);
    }

    public ClientePJ clientePJ(Long id){
        return en.find(ClientePJ.class, id);
    }

    public List<ClientePJ> ivendas(){
        Query query = en.createQuery("from ClientePJ");
        return query.getResultList();
    }

    public void remove(Long id){
        ClientePJ p = en.find(ClientePJ.class, id);
        en.remove(p);
    }

    public void update(ClientePJ clientePJ){
        en.merge(clientePJ);
    }
}
