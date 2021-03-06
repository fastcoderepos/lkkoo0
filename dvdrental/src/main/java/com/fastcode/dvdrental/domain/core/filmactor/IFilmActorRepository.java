package com.fastcode.dvdrental.domain.core.filmactor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.*;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@Repository("filmActorRepository")
public interface IFilmActorRepository extends JpaRepository<FilmActorEntity, FilmActorId>,QuerydslPredicateExecutor<FilmActorEntity> {

}

