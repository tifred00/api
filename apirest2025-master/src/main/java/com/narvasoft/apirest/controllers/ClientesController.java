package com.narvasoft.apirest.controllers;

import com.narvasoft.apirest.models.Clientes;
import com.narvasoft.apirest.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;//principio de Inversión de Dependencias (IoD)

    //Create a new user
    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Clientes clientes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.save(clientes));
    }

    //Get a user
    @GetMapping("/{id}")
    public ResponseEntity<?> readOne(@PathVariable(value = "id") Long id) {
        Optional<Clientes> oClientes= clientesService.findById(id);
        //si no se encuentra el usuario(el id) se retorna un not found
        if (!oClientes.isPresent()) {
            return ResponseEntity.notFound().build();
        }//de locontrario se retorna el usuario
        return ResponseEntity.ok(oClientes);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Clientes clientesDetails, @PathVariable(value = "id") Long id) {
        Optional<Clientes> cliente = clientesService.findById(id);
        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(userDetails, user.get());
        cliente.get().setPassword(clientesDetails.getPassword());
        cliente.get().setDireccion(clientesDetails.getDireccion());
        cliente.get().setCorreo(clientesDetails.getCorreo());
        cliente.get().setTelefono(clientesDetails.getTelefono());
        cliente.get().setUsuario(clientesDetails.getUsuario());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.save(cliente.get()));
    }

    //Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if (!clientesService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clientesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Get all users
    @GetMapping
    public List<Clientes> readAll() {
        List<Clientes> clientes = StreamSupport//<--hereda de Object y me trae los stream
                .stream(clientesService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return clientes;
    }
}