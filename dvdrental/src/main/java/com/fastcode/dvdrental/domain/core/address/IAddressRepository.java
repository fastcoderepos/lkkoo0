package com.fastcode.dvdrental.domain.core.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.*;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@Repository("addressRepository")
public interface IAddressRepository extends JpaRepository<AddressEntity, Integer>,QuerydslPredicateExecutor<AddressEntity> {

}

