package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuturoCandidatoController {
    /*O controller deve expôr os seguintes endpoints para futuro candidato:

/candidatos (GET): Listar todos OK
/candidatos/{setor} (GET): Filtrar por setor, usar RequestParam OK
/candidatos/email (GET): Filtrar por email, usar RequestParam OK
/ccandidatos/nome (GET): Filtrar por nome, usar RequestParam OK
/candidatos (POST): Adicionar colaborador (método público sem login) OK
/candidatos (DELETE): Deletar colaborador OK
*/

    @Autowired
    private FuturoCandidatoService futuroCandidadoService;

    @GetMapping("/futuros-candidatos")
    public List<FuturoCandidato> listarFuturosCandidatos(){
        return this.futuroCandidadoService.listarCandidatos();
    }

    @GetMapping("/futuro-candidato/{idFuturoCandidato}")
    public FuturoCandidato getFuturoCandidato(@PathVariable Integer idFuturoCandidato) {
        return this.futuroCandidadoService.getFuturoCandidato(idFuturoCandidato);
    }

    // /localhost:8080/futurocandidato/buscar?setor=MARKETING
    @GetMapping("/futuro-candidato/buscar")
    public List<FuturoCandidato> listarPorSetor(@RequestParam Setor setor) {
        return this.futuroCandidadoService.listarPorSetor(setor);
    }

   @GetMapping("/futuro-candidato/email")
   public FuturoCandidato buscarPorEmail(@RequestParam String buscaremail) {
      return this.futuroCandidadoService.buscarPorEmail(buscaremail);
   }

    @GetMapping("/futuro-candidato/nome-completo")
    public List<FuturoCandidato> listarPorNome(@RequestParam String nomeCompleto) {
        return this.listarPorNome(nomeCompleto);
    }

    @PostMapping("/futuro-candidato/")
    public FuturoCandidato salvar(@RequestBody FuturoCandidatoDTO dto) {
        return this.futuroCandidadoService.salvar(dto);
    }

    @DeleteMapping("futuro-candidato/{idFuturoCandidado}")
    public void deletar(@PathVariable Integer idFuturoCandidato) {
        this.futuroCandidadoService.deletar(idFuturoCandidato);
    }

}
