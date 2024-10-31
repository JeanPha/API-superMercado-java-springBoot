package com.Jean.Supermercado.controllers;


import com.Jean.Supermercado.persistence.entities.Cliente;
import com.Jean.Supermercado.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController // Encargado de resolver la peticiones
@RequestMapping("/api/clientes") // Mappear la ruta
@PreAuthorize("denyAll()") // denegar el acceso a todo el mundo
public class ClienteController {

    @Autowired //Generar automatica objecto del Repository
    private ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*") //Para poder consumirla con aplicaciones externas (front)
    @GetMapping
    @PreAuthorize("hasAuthority('CREATE')")
    public List<Cliente> getAllClientes(){

        return clienteRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){ //pathVariable es para avisar que el valor lo recibimos de id que nos pasa el user
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("/buscarPorNombre/{nombre}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<List<Cliente>> getClientesByNombre(@PathVariable String nombre) {
        List<Cliente> clientes = clienteRepository.findByApellidoNombreContainingIgnoreCase(nombre);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @CrossOrigin
    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){ // requestboody, es decir toma todos los datos del formulario en el body
        Cliente saveCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCliente); // 201

    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if(!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); //404
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @CrossOrigin
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedCliente.setId_cliente(id);
        Cliente savedCliente = clienteRepository.save(updatedCliente);
        return ResponseEntity.ok(savedCliente);
    }


}
