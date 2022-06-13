package br.com.zup.simcitysaojoao.produtos.fragments.listaProdutos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentListaBinding
import br.com.zup.simcitysaojoao.produtos.adapter.ProdutoAdapter
import br.com.zup.simcitysaojoao.produtos.detalhes.DetalhesProdutoActivity
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_BUNDLE2
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_LISTA
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_LISTA2
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_PRODUTO

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalheDoProdutoClicado)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adicionarProdutosNaLista()
    }

    private fun adicionarProdutosNaLista(){
        var listaProdutos = mutableListOf<Produto>()
        var listaRecebida = arguments?.getParcelableArrayList<Produto>(CHAVE_LISTA)

        if(listaRecebida != null){

            if(listaProdutos.size == 0){
                listaProdutos = listaRecebida
            }
            else{
                listaProdutos.addAll(listaRecebida)
            }
        }

        produtoAdapter.atualizarLista(listaProdutos)
        exibirRecycler()
    }

    private fun exibirRecycler(){
        binding.rvListaProdutos.adapter = produtoAdapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)
    }

    private fun irParaDetalheDoProdutoClicado(produto: Produto){
        val intent = Intent(context, DetalhesProdutoActivity::class.java)
        intent.putExtra(CHAVE_PRODUTO, produto)
        startActivity(intent)
    }

}