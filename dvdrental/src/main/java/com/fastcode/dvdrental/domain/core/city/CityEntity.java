package com.fastcode.dvdrental.domain.core.city;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.country.CountryEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CITY")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CityEntity extends AbstractEntity {

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID", nullable = false)
    private Integer cityId;
    
    @Basic
    @Column(name = "city", nullable = false,length =50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
        private Set<AddressEntity> addressSet = new HashSet<AddressEntity>();

}



