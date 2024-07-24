package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {

        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return produtoRepository.save(produto);

    }
    public List<Produto> listarTodos() {

    return produtoRepository.findAll();
    }

    public Produto obterPorID(Long id) {

    return produtoRepository.findById(id).get();
    }
    @Transactional
    public void update(long id, Produto produtoAlterado){

        Produto produto = produtoRepository.findById(id).get();
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        produto.setCategoria(produtoAlterado.getCategoria());
        produtoRepository.save(produto);
    }
    @Transactional
    public void delete(Long id) {

       Produto produto = produtoRepository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);
       produto.setVersao(produto.getVersao() + 1);

       produtoRepository.save(produto);
   }

}