package br.com.zup.simcitysaojoao.produtos.valorTotal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.databinding.ActivityValorTotalBinding

class ValorTotalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValorTotalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorTotalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}