package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) {

        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return repository.save(produto);
    }

    public Produto obterPorID(Long id) {

        Optional<Produto> produto = repository.findById(id);

        return produto.orElse(null);

    }

    public List<Produto> listarTodos() {

        List<Produto> produtos = repository.findAll();

        return produtos;
    }
}
