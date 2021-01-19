package com.fastcode.dvdrental.domain.core.customer;

import javax.persistence.*;
import java.time.*;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity {

    @Basic
    @Column(name = "FIRST_NAME", nullable = false,length =50)
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", nullable = false,length =50)
    private String lastName;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;
    
    @Basic
    @Column(name = "active", nullable = true)
    private Integer active;
    
    @Basic
    @Column(name = "activebool", nullable = false)
    private Boolean activebool;
    
    @Basic
    @Column(name = "STORE_ID", nullable = false)
    private Short storeId;
    
    @Basic
    @Column(name = "email", nullable = true,length =50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;


}



