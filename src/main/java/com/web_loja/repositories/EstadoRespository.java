package com.web_loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_loja.domain.Estado;


@Repository
public interface EstadoRespository extends JpaRepository<Estado, Integer>{


}
