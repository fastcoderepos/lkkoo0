package com.fastcode.dvdrental.domain.core.language;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.film.FilmEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LANGUAGE")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class LanguageEntity extends AbstractEntity {

    @Id
    @EqualsAndHashCode.Include()
    @Column(name = "LANGUAGE_ID", nullable = false)
    private Integer languageId;
    
    @Basic
    @Column(name = "name", nullable = false,length =20)
    private String name;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
        private Set<FilmEntity> filmsSet = new HashSet<FilmEntity>();

}



