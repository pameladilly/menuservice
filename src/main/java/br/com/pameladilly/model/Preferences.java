package br.com.pameladilly.model;

import io.quarkus.arc.impl.Identified;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Preferences extends PanacheEntity {


    private Long idPessoa;


    private Long idMenu;

    @OneToMany
    @JoinColumn(name = "preferences_id")
    private List<Product> products = new ArrayList<>();

}
