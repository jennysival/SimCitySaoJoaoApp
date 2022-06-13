package br.com.zup.simcitysaojoao.produtos.valorTotal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityValorTotalBinding
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity
import br.com.zup.simcitysaojoao.produtos.fragments.cadastroProdutos.CadastroFragment
import br.com.zup.simcitysaojoao.produtos.fragments.listaProdutos.ListaFragment
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_BUNDLE
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_BUNDLE2
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_LISTA
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_LISTA2


class ValorTotalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValorTotalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorTotalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirValorTotal()

        binding.btnCadastrarNovoValorTotal.setOnClickListener {
            irParaCadastro()
        }

        binding.btnVerProdutosValorTotal.setOnClickListener {
            irParaLista()
        }
    }

    private fun recuperarDados(): ArrayList<Produto>? {
        val bundleRecuperado = intent.getBundleExtra(CHAVE_BUNDLE)

        return bundleRecuperado?.getParcelableArrayList(CHAVE_LISTA)
    }

    private fun calcularTotal(): Double {
        var soma = 0.0

        recuperarDados()?.forEach { produto ->
            soma += produto.getValorTotal()
        }
        return soma
    }

    private fun exibirValorTotal(){
        val valorTotal = calcularTotal()

        val textoExibido = buildString {
            append("O valor total de todos os produtos é de: R$")
            append(valorTotal)
        }

        binding.tvTotalProdutos.text = textoExibido
    }

    private fun irParaCadastro(){
        onBackPressed()
    }

    private fun irParaLista(){

    }
}