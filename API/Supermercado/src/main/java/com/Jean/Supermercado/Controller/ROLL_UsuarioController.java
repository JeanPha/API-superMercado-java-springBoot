package com.Jean.Supermercado.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class ROLL_UsuarioController {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/hola")
    public String saludos() {
        return "hola";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/tu")
    public String salu() {
        return "hola tu";
    }
}

