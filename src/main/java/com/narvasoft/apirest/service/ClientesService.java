package com.narvasoft.apirest.service;

import com.narvasoft.apirest.models.Clientes;
import com.narvasoft.apirest.models.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientesService {
    public Iterable <Clientes> findAll();
    public Page<Clientes> findAll(Pageable pageable);
    public Optional<Clientes> findById(Long id);
    public Clientes save(Clientes clientes);
    public void deleteById(Long id);
}




