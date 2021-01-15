package com.fastcode.dvdrental.domain.core.rental;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;
import com.fastcode.dvdrental.domain.core.staff.StaffEntity;
import com.fastcode.dvdrental.domain.core.inventory.InventoryEntity;
import com.fastcode.dvdrental.domain.core.customer.CustomerEntity;
import com.fastcode.dvdrental.domain.core.payment.PaymentEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RENTAL")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class RentalEntity extends AbstractEntity {

    @Basic
    @Column(name = "RENTAL_DATE", nullable = true)
    private LocalDate rentalDate;

    @Basic
    @Column(name = "RETURN_DATE", nullable = true)
    private LocalDate returnDate;

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID", nullable = false)
    private Integer rentalId;
    
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
        private Set<PaymentEntity> paymentsSet = new HashSet<PaymentEntity>();
    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "INVENTORY_ID")
    private InventoryEntity inventory;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;


}



