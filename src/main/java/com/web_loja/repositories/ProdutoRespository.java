package com.web_loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_loja.domain.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Integer>{


}
