package com.narvasoft.apirest.service;

import com.narvasoft.apirest.models.Clientes;
import com.narvasoft.apirest.repository.ClientesRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClientesService{

    @Autowired
    private ClientesRepository clientesRepository;//inyección de dependencias

    @Transactional(readOnly = true)
    public Iterable<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> findAll(Pageable pageable) {
        return clientesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Clientes save(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        clientesRepository.deleteById(id);
    }

}
