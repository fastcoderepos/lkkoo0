package com.fastcode.dvdrental.domain.core.country;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.city.CityEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COUNTRY")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CountryEntity extends AbstractEntity {

    @Basic
    @Column(name = "country", nullable = false,length =50)
    private String country;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;
    
    @Basic
    @Column(name = "LAST_UPDATE", nullable = true)
    private LocalDate lastUpdate;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
        private Set<CityEntity> citysSet = new HashSet<CityEntity>();

}



