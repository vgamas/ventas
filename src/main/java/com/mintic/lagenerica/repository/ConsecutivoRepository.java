package com.mintic.lagenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.lagenerica.model.Consecutivo;

public interface ConsecutivoRepository extends MongoRepository<Consecutivo, String> {

}
