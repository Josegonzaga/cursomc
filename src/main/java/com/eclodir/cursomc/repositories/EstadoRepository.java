package com.eclodir.cursomc.repositories;

import org.assertj.core.internal.Longs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eclodir.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
