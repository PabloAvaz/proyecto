package com.domain.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.domain.entity.user.Daily;

public interface DailyRepository extends JpaRepository<Daily,Integer>{
    @Transactional
	@Modifying
	@Query(
			value = "UPDATE daily SET reclamado=false",
			nativeQuery = true
			)
	public void reset();
    /*
    @Transactional
	@Modifying
	@Query(
			value = "UPDATE daily SET reclamado=true WHERE idUsuario=?1",
			nativeQuery = true
			)
	public void reclamar(Integer idUsuario);
	*/
}
