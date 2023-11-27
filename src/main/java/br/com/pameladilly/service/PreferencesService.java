package br.com.pameladilly.service;

import br.com.pameladilly.DTO.PreferencesDTO;
import br.com.pameladilly.model.Preferences;
import br.com.pameladilly.model.Product;
import br.com.pameladilly.repository.PreferencesRepository;
import br.com.pameladilly.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PreferencesService {

    @Inject
    PreferencesRepository preferencesRepository;

    @Inject
    ProductRepository productRepository;

    public Boolean savePreferences(PreferencesDTO preferencesDTO){
        Preferences preferences = new Preferences();
        preferences.setIdPessoa(preferencesDTO.getIdPessoa());
        preferences.setIdMenu(preferencesDTO.getIdMenu());

        preferencesDTO.getProducts().forEach( p -> {
            Product product = new Product();

            product.setIdProduct(p.getId());
            product.setPosition(p.getPosition());
            preferences.getProducts().add(product);
        });

        preferences.persist();

        return preferences.isPersistent();


    }
}
