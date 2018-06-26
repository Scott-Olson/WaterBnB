package com.scott.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.waterbnb.models.Pool;
import com.scott.waterbnb.repositories.PoolRepo;

@Service
public class PoolService {
	private final PoolRepo poolRepo;
	
	public PoolService(PoolRepo poolRepo) {
		this.poolRepo = poolRepo;
	}
	
	public Pool createPool(Pool pool) {
		return poolRepo.save(pool);
	}
	
	public List<Pool> findAllPools(){
		return (List<Pool>) poolRepo.findAll();
	}
	
	public Optional<Pool> findById(Long id) {
		return poolRepo.findById(id);
	}
		
}
