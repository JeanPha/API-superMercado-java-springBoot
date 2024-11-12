package com.Jean.Supermercado.service;

import Entity.Cliente;
import com.Jean.Supermercado.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    // Inyección del repositorio de Cliente
    @Autowired
    private ClienteRepository clienteRepository;

    // Método para obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Método para obtener un cliente por su ID
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Método para obtener un cliente por su nombre (sobrecargado)
    public Cliente getClienteByNombre(String apellidoNombre) {
        return clienteRepository.findByApellidoNombre(apellidoNombre).orElse(null);
    }

    // Método para crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para actualizar un cliente existente
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id).orElse(null);
        if (existingCliente != null) {
            existingCliente.setApellidoNombre(cliente.getApellidoNombre());
            existingCliente.setDni(cliente.getDni());
            existingCliente.setFechaNacimiento(cliente.getFechaNacimiento());
            existingCliente.setCorreoElectronico(cliente.getCorreoElectronico());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    // Método para eliminar un cliente por su ID
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
