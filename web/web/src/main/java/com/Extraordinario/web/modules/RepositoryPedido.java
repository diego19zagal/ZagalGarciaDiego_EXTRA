package com.Extraordinario.web.modules;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPedido extends JpaRepository<BeanPedido, Integer> {
}
