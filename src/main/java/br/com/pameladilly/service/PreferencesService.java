package br.com.pameladilly.service;

import br.com.pameladilly.DTO.MenuDTOResponse;
import br.com.pameladilly.DTO.PreferencesDTO;
import br.com.pameladilly.model.Preferences;
import br.com.pameladilly.model.Product;
import br.com.pameladilly.repository.PreferencesRepository;
import br.com.pameladilly.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class PreferencesService {

    @Inject
    PreferencesRepository preferencesRepository;

    @Inject
    ProductRepository productRepository;

    public Boolean savePreferences(PreferencesDTO preferencesDTO){

        Optional<Preferences> preferencesFound = preferencesRepository.findByIdPessoa(preferencesDTO.getIdPessoa());

        preferencesFound.ifPresent(value -> preferencesRepository.delete(preferencesFound.get()));

        Preferences preferences = new Preferences();
        preferences.setIdPessoa(preferencesDTO.getIdPessoa());
        preferences.setIdMenu(preferencesDTO.getIdMenu());

        preferencesDTO.getProducts().forEach( p -> {
            Product product = new Product();

            product.setIdProduct(p.getId());
            product.setPosition(p.getPosition());
            preferences.getProducts().add(product);

            product.persistAndFlush();
        });


        preferences.persist();

        return preferences.isPersistent();


    }

    public MenuDTOResponse mergePreferences(Long idPessoa, MenuDTOResponse menuDTOResponse){

        Optional<Preferences> preferences = preferencesRepository.findByIdPessoa(idPessoa);


        if (preferences.isPresent()){


            MenuDTOResponse newMenu = MenuDTOResponse.builder().build();
            newMenu.setProducts(new ArrayList<>());

            menuDTOResponse.getProducts().forEach( p -> {
                if (preferences.get().getProducts().stream().anyMatch( pref -> pref.getIdProduct() == p.getId()  )){
                    newMenu.getProducts().add(p);

                }
            });

            newMenu.setName(menuDTOResponse.getName());
            return newMenu;
        }else {
            return menuDTOResponse;
        }
    }
}
