package com.fastcode.dvdrental.domain.core.address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.customer.CustomerEntity;
import com.fastcode.dvdrental.domain.core.staff.StaffEntity;
import com.fastcode.dvdrental.domain.core.city.CityEntity;
import com.fastcode.dvdrental.domain.core.store.StoreEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class AddressEntity extends AbstractEntity {

    @Basic
    @Column(name = "address", nullable = false,length =50)
    private String address;

    @Basic
    @Column(name = "address2", nullable = true,length =50)
    private String address2;

    @Basic
    @Column(name = "phone", nullable = false,length =20)
    private String phone;

    @Basic
    @Column(name = "district", nullable = false,length =20)
    private String district;

    @Basic
    @Column(name = "POSTAL_CODE", nullable = true,length =10)
    private String postalCode;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID", nullable = false)
    private Integer addressId;
    
    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private CityEntity city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
        private Set<StaffEntity> staffsSet = new HashSet<StaffEntity>();
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
        private Set<StoreEntity> storesSet = new HashSet<StoreEntity>();
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
        private Set<CustomerEntity> customersSet = new HashSet<CustomerEntity>();

}



