package com.scott.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scott.waterbnb.models.Pool;

public interface PoolRepo extends CrudRepository<Pool, Long> {

}
