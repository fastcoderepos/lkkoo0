package com.fastcode.dvdrental.domain.core.payment;

import javax.persistence.*;
import java.time.*;
import java.math.BigDecimal;
import com.fastcode.dvdrental.domain.core.rental.RentalEntity;
import com.fastcode.dvdrental.domain.core.customer.CustomerEntity;
import com.fastcode.dvdrental.domain.core.staff.StaffEntity;
import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PaymentEntity extends AbstractEntity {

    @Basic
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    
    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID", nullable = false)
    private Integer paymentId;
    
    @Basic
    @Column(name = "PAYMENT_DATE", nullable = true)
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "RENTAL_ID")
    private RentalEntity rental;


}



