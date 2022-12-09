package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    public FuturoCandidato getFuturoCandidato(Integer idFuturoCandidato) {
        return this.futuroCandidatoRepository.findById(idFuturoCandidato)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Nenhum futuro candidato encontrado por este ID."));
    }

    public List<FuturoCandidato> listarCandidatos() {
        return this.futuroCandidatoRepository.findAll();
    }

    public List<FuturoCandidato> getNomeCompleto(String nomeCompleto) {
        List<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findByNomeCompletoContaining(nomeCompleto);
        if (futuroCandidato.isEmpty()) {
            throw new RecursoNaoEncontradoError("Nenhum futuro candidato encontrado por este nome.");
        }
        return futuroCandidato;
    }

    public List<FuturoCandidato> listarPorSetor(Setor setor) {
        return this.futuroCandidatoRepository.findBySetor(setor);
    }


    public List<FuturoCandidato> buscarPorEmail(String email) {
        List<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findByEmail(email);
        if (futuroCandidato.isEmpty()) {
            throw new RecursoNaoEncontradoError("Nenhum futuro candidato referente a este email foi encontrado.");
        }
        return futuroCandidato;
    }

    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato futuroCandidato = new FuturoCandidato(null, dto.getNomeCompleto(), dto.getEmail(), dto.getDescricaoDasHabilidades(), dto.getSetor());
        FuturoCandidato salvo = this.futuroCandidatoRepository.save(futuroCandidato);
        return salvo;
    }

    public void deletar(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.getFuturoCandidato(idFuturoCandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }

}
