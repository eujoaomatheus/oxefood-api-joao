package br.com.ifpe.oxefood.api.cliente;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(
            summary = "Serviço responsável por salvar um cliente no sistema."
    )
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Serviço responsável por listar todos os clientes do sistema."
    )
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(
            summary = "Serviço responsável por recuperar um cliente do sistema através do ID."
    )
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @Operation(
            summary = "Serviço responsável por alterar um cliente do sistema através do ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Serviço responsável por deletar um cliente do sistema através do ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }


}
