package com.fastcode.dvdrental.domain.core.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.*;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@Repository("paymentRepository")
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Integer>,QuerydslPredicateExecutor<PaymentEntity> {

}

