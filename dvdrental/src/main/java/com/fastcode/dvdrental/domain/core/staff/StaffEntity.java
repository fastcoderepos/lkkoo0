package com.fastcode.dvdrental.domain.core.staff;

import javax.persistence.*;
import java.time.*;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STAFF")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class StaffEntity extends AbstractEntity {

    @Basic
    @Column(name = "LAST_NAME", nullable = false,length =45)
    private String lastName;

    @Basic
    @Column(name = "active", nullable = false)
    private Boolean active;
    
    @Basic
    @Column(name = "STORE_ID", nullable = false)
    private Short storeId;
    
    @Basic
    @Column(name = "FIRST_NAME", nullable = false,length =45)
    private String firstName;

    @Basic
    @Column(name = "password", nullable = true,length =40)
    private String password;

    @Basic
    @Column(name = "email", nullable = true,length =50)
    private String email;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID", nullable = false)
    private Integer staffId;
    
    @Basic
    @Column(name = "username", nullable = false,length =16)
    private String username;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;


}



