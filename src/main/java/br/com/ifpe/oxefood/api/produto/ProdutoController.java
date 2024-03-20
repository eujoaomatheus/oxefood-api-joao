package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {

        List<Produto> produtos = service.listarTodos();

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterPorID(@PathVariable  Long id) {

        Produto produto = service.obterPorID(id);

        if (produto == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(produto,HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Produto> save (@RequestBody ProdutoRequest request) {

        Produto produto = service.save(request.build());

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

}
