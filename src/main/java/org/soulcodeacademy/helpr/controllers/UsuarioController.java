package org.soulcodeacademy.helpr.controllers;


import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.dto.UsuarioDTO;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios/email/{emailUsuario}")
    public Usuario getEmail(@PathVariable String emailUsuario) { return this.usuarioService.getEmailUsuario(emailUsuario); }

    @GetMapping("/usuarios/cpf/{cpf}")
    public Usuario getCpf(@PathVariable String cpf) { return this.usuarioService.getCpf(cpf);}

    @GetMapping("/usuarios/busca")
    public List<Usuario> listarUsuario(@RequestParam String nome) { return this.usuarioService.getNome(nome);}

    @GetMapping("/usuarios/{idUsuario}/perfil")
    public Perfil getPerfil(@PathVariable Integer idUsuario ) { return this.usuarioService.getUsuarioById(idUsuario);}

    }



