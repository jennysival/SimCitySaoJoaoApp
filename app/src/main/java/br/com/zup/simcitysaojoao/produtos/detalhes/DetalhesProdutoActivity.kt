package br.com.zup.simcitysaojoao.produtos.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.databinding.ActivityDetalhesProdutoBinding

class DetalhesProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesProdutoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}