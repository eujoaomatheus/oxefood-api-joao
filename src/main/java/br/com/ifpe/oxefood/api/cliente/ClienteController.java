package br.com.ifpe.oxefood.api.cliente;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {

        List<Cliente> clientes = clienteService.listarTodos();

        return new ResponseEntity<>(clientes, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterPorID(@PathVariable Long id) {

        Cliente cliente = clienteService.obterPorID(id);

        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }



    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

        Cliente cliente = clienteService.save(request.build());
        System.out.printf(request.build().toString());
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }
}

