package br.com.pameladilly.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductRepository> {

    public void deleteByIdPreferences(Long id){
        delete("preferences_id", id);
    }
}
