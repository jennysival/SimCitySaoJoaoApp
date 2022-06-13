package br.com.zup.simcitysaojoao.produtos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityProdutosBinding
import br.com.zup.simcitysaojoao.produtos.fragments.cadastroProdutos.CadastroFragment
import br.com.zup.simcitysaojoao.produtos.fragments.listaProdutos.ListaFragment
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_BUNDLE2
import br.com.zup.simcitysaojoao.utilitaria.CHAVE_LISTA2

class ProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getParcelableArrayListExtra<Produto>(CHAVE_LISTA2)

        supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_activity_produtos)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
