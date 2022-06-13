package br.com.zup.simcitysaojoao.produtos.valorTotal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.databinding.ActivityValorTotalBinding
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity
import br.com.zup.simcitysaojoao.produtos.adapter.ProdutoAdapter
import br.com.zup.simcitysaojoao.produtos.detalhes.DetalhesProdutoActivity
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.utilitaria.*


class ValorTotalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValorTotalBinding

    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalheDoProdutoClicado)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorTotalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirValorTotal()

        binding.btnCadastrarNovoValorTotal.setOnClickListener {
            onBackPressed()
        }

        binding.btnVerProdutosValorTotal.setOnClickListener {
            produtoAdapter.atualizarLista(recuperarDados())
            exibirRecycler()
        }
    }

    private fun recuperarDados(): ArrayList<Produto> {
        val bundleRecuperado = intent.getBundleExtra(CHAVE_BUNDLE)

        return bundleRecuperado?.getParcelableArrayList(CHAVE_LISTA)!!
    }

    private fun calcularTotal(): Int {
        var soma = 0

        recuperarDados().forEach { produto ->
            soma += produto.getValorTotal()
        }
        return soma
    }

    private fun exibirValorTotal(){
        val valorTotal = calcularTotal()

        val textoExibido = buildString {
            append("O valor total de todos os produtos é de: R$")
            append(valorTotal)
            append(",00")
        }

        binding.tvTotalProdutos.text = textoExibido
    }

    private fun exibirRecycler(){
        binding.rvListaProdutosEmValorTotal.adapter = produtoAdapter
        binding.rvListaProdutosEmValorTotal.layoutManager = LinearLayoutManager(this)
    }

    private fun irParaDetalheDoProdutoClicado(produto: Produto){
        val intent = Intent(this, DetalhesProdutoActivity::class.java)
        intent.putExtra(CHAVE_PRODUTO, produto)
        startActivity(intent)
    }
}