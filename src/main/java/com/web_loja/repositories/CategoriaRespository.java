package com.web_loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_loja.domain.Categoria;

@Repository
public interface CategoriaRespository extends JpaRepository<Categoria, Integer>{


}
