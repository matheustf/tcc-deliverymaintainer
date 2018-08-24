package com.puc.tcc.deliverymaintainer.mockcorreios;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MockCorreiosRepository extends MongoRepository<MockCorreios, String> {

	Optional<MockCorreios> findByCodigo(String codigo);

}
