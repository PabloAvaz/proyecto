package com.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.entity.producto.Skin;

@Repository
public interface SkinRepository extends JpaRepository<Skin, Integer>{

}
