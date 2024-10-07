package com.web_loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_loja.domain.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{


}
