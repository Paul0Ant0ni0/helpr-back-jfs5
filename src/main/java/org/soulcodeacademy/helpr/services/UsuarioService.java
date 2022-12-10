package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.dto.UsuarioDTO;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Perfil getUsuarioById(Integer idUsuario) {
        Usuario usuario = this.usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return this.getPerfilByEmail(usuario.getEmail());
    }

    public Usuario getEmailUsuario(String emailUsuario) {
        Usuario usuario = this.usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return usuario;
    }


    public Usuario getCpf(String cpf) {
        Usuario usuario = this.usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return usuario;
    }

    public List<Usuario> getNome(String nome) {
        List<Usuario> usuario = this.usuarioRepository.findByNomeContaining(nome);
        if (usuario.isEmpty()) {
            throw new RuntimeException("Não existe usuário cadastrado com esse nome");
        }
        return usuario;
    }

    public Perfil getPerfilByEmail(String email) {
        Usuario usuario = this.getEmailUsuario(email);
        return usuario.getPerfil();
    }
}



