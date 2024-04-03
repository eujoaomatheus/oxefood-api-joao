package br.com.ifpe.oxefood.api.produto;


import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(
            summary = "Serviço responsável por salvar um produto no sistema."
    )
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

        Produto produto = produtoService.save(request.build());

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Serviço responsável por listar todos os produtos do sistema."
    )
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @Operation(
            summary = "Serviço responsável por recuperar um produto do sistema através do ID."
    )
    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }

    @Operation(
            summary = "Serviço responsável por alterar um produto do sistema através do ID."
    )

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

        produtoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Serviço responsável por deletar um produto do sistema através do ID."
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}