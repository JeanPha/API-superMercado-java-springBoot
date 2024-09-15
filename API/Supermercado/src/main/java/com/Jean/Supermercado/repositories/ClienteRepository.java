package com.Jean.Supermercado.repositories;

import com.Jean.Supermercado.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByApellidoNombreContainingIgnoreCase(String nombre);

}
