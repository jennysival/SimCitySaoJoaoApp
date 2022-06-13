package br.com.zup.simcitysaojoao.produtos.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityDetalhesProdutoBinding
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_PRODUTO

class DetalhesProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesProdutoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarDados()
        favoritarProduto()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_activity_detalhes)
    }

    private fun recuperarDados(){
        val produto = intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)

        if(produto != null){
            val valor = buildString {
                append("R$")
                append(produto.getValorUn().toString())
                append(",00")
            }

            binding.tvNomeProdutoDetalhe.text = produto.getNome()
            binding.tvInserirQtd.text = produto.getQtd().toString()
            binding.tvInserirValor.text = valor
            binding.tvInserirReceita.text = produto.getReceita()
        }

    }

    private fun favoritarProduto(){
        binding.iconeFav.setOnClickListener {
            Toast.makeText(this,getString(R.string.toast_favoritado), Toast.LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}