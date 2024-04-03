package br.com.ifpe.oxefood.api.entregador;


import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;


    @Operation(
            summary = "Serviço responsável por salvar um entregador no sistema."
    )
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

        Entregador entregador = entregadorService.save(request.build());

        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Serviço responsável por listar todos os entregadores do sistema."
    )

    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @Operation(
            summary = "Serviço responsável por recuperar um entregador do sistema através do ID."
    )
    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

    @Operation(
            summary = "Serviço responsável por alterar um entregador do sistema através do ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Serviço responsável por deletar um entregador do sistema através do ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        entregadorService.delete(id);
        return ResponseEntity.ok().build();
    }

}