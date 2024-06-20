package com.example.estudo2.model.repository;

import com.example.estudo2.model.entity.ClientePF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientePfRepository {
    @PersistenceContext
    private EntityManager en;

    public void save(ClientePF clientePF){
        en.persist(clientePF);
    }

    public ClientePF clientePF(Long id){
        return en.find(ClientePF.class, id);
    }

    public List<ClientePF> clientePFS(){
        Query query = en.createQuery("from ClientePF");
        return query.getResultList();
    }

    public void remove(Long id){
        ClientePF p = en.find(ClientePF.class, id);
        en.remove(p);
    }

    public void update(ClientePF clientePF){
        en.merge(clientePF);
    }
}
