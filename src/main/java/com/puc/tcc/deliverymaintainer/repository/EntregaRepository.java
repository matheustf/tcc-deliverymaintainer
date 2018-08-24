package com.puc.tcc.deliverymaintainer.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.deliverymaintainer.model.Entrega;


@Repository
public interface EntregaRepository extends MongoRepository<Entrega, String> {

	Optional<Entrega> findByCodigoDeRastreio(String codigoDeRastreio);

}
