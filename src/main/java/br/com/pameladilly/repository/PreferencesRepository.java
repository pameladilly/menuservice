package br.com.pameladilly.repository;

import br.com.pameladilly.model.Preferences;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PreferencesRepository implements PanacheRepository<Preferences> {
}
