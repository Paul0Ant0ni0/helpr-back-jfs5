
package org.soulcodeacademy.helpr.controllers;
import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.services.FuturoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuturoClienteController {

    @Autowired
    private FuturoClienteService futuroClienteService;


    @GetMapping("/futuros-clientes")
    public List<FuturoCliente> listarTodos() {
        return this.futuroClienteService.listarTodos();
    }

    @GetMapping("/futuros-clientes/{idFuturoCliente}")
    public FuturoCliente getFuturoCliente(@PathVariable Integer idFuturoCliente) {
        return this.futuroClienteService.getFuturoCliente(idFuturoCliente);
    }


    @GetMapping("/futuros-clientes/email")
    public FuturoCliente buscarPorEmail(@RequestParam String buscaremail) {
        return this.futuroClienteService.buscarPorEmail(buscaremail);
    }



    @GetMapping("/futuros-clientes/cpf")
    public FuturoCliente buscarPorCpf(@RequestParam String buscarcpf) {
        return this.futuroClienteService.buscarPorCpf(buscarcpf);
    }


    @PostMapping("/futuros-clientes")
    public FuturoCliente salvar(@Valid @RequestBody FuturoClienteDTO dto) {
        return this.futuroClienteService.salvar(dto);
    }


    @PutMapping("/futuros-clientes/{idFuturoCliente}")
    public FuturoCliente atualizar(@PathVariable Integer idFuturoCliente, @Valid @RequestBody FuturoClienteDTO dto) {
        return this.futuroClienteService.atualizar(idFuturoCliente, dto);
    }


    @DeleteMapping("/futuros-clientes/{idFuturoCliente}")
    public void deletar(@PathVariable Integer idFuturoCliente) {
        this.futuroClienteService.deletar(idFuturoCliente);
    }
}
