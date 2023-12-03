package br.com.pameladilly.repository;

import br.com.pameladilly.model.Preferences;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.Optional;

@ApplicationScoped
public class PreferencesRepository implements PanacheRepository<Preferences> {
//    public Optional<Preferences> findByIdPessoa(Long idPessoa) {
//        return findByIdPessoa(idPessoa);
//    }

//    public Preferences findByIdPessoa(Long idPessoa){
//        return findByIdPessoa(idPessoa);

//    }



    public Optional<Preferences> findByIdPessoa(Long idPessoa){
        return find("idPessoa", idPessoa).firstResultOptional();
    }
}
