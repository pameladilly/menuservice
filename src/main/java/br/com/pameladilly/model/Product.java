package br.com.pameladilly.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends PanacheEntity {

    Long idProduct;
    Integer position;

    @ManyToOne
    @JoinColumn(name = "preferences_id")
    private Preferences preferences;
}
