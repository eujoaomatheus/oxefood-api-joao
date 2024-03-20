package br.com.ifpe.oxefood.api.entregador;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @GetMapping
    public ResponseEntity<List<Entregador>> listarTodos() {

        List<Entregador> entregadores = service.listarTodos();

        return new ResponseEntity<>(entregadores, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> obterPorID(@PathVariable Long id) {

        Entregador entregador = service.obterPorID(id);

        if(entregador == null)
            return new ResponseEntity<>("Não existe: ", HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(entregador, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Entregador> save (@RequestBody EntregadorRequest request) {

        Entregador entregador = service.save(request.build());

        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }

}
