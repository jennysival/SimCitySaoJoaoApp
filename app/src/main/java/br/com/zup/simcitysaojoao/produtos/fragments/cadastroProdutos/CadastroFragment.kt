package br.com.zup.simcitysaojoao.produtos.fragments.cadastroProdutos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroBinding
import br.com.zup.simcitysaojoao.produtos.model.Produto
import br.com.zup.simcitysaojoao.produtos.valorTotal.ValorTotalActivity
import br.com.zup.simcitysaojoao.utilitaria.*

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var nomeProduto: String
    private lateinit var qtdProduto: String
    private lateinit var valorProduto: String
    private lateinit var receitaProduto: String
    private var listaDeProdutos = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrarNovo.setOnClickListener {

            adicionarProdutoNaLista()
            limparCampos()
        }

        binding.btnVerProdutos.setOnClickListener {
            irParaVerProdutosFragment()
        }

        binding.btnValorTotal.setOnClickListener {
            irParaValorTotalActivity()
        }
    }

    private fun irParaVerProdutosFragment(){
        if(listaDeProdutos.isEmpty()){
            Toast.makeText(context, getString(R.string.toast_listaVazia),Toast.LENGTH_LONG).show()
        }
        else{
            val bundle = bundleOf(CHAVE_LISTA to listaDeProdutos)
            NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_listaFragment, bundle)
        }
    }

    private fun irParaValorTotalActivity(){
        if(listaDeProdutos.isNotEmpty()){
            val bundle = bundleOf(CHAVE_LISTA to listaDeProdutos)

            val intent = Intent(context, ValorTotalActivity::class.java)
            intent.putExtra(CHAVE_BUNDLE, bundle)
            startActivity(intent)
        }
        else{
            Toast.makeText(context, getString(R.string.toast_listaVazia),Toast.LENGTH_LONG).show()
        }

    }

    private fun recuperarDadosDigitados(){
            this.nomeProduto = binding.etNomeProduto.text.toString()
            this.qtdProduto = binding.etQtdProduto.text.toString()
            this.valorProduto = binding.etValorProduto.text.toString()
            this.receitaProduto = binding.etReceita.text.toString()
    }

    private fun adicionarProdutoNaLista(){
        recuperarDadosDigitados()
        if(!validarCampos()){
            listaDeProdutos.add(Produto(this.nomeProduto, this.qtdProduto.toInt(), this.valorProduto.toInt(), this.receitaProduto))
            Toast.makeText(context, getString(R.string.toast_cadastrado),Toast.LENGTH_LONG).show()
        }
    }

    private fun validarCampos(): Boolean{
        return when{

            this.nomeProduto.isEmpty() -> {
                binding.etNomeProduto.error = CAMPO_OBRIGATORIO
                true
            }

            this.qtdProduto.isEmpty() -> {
                binding.etQtdProduto.error = CAMPO_OBRIGATORIO
                true
            }

            this.valorProduto.isEmpty() -> {
                binding.etValorProduto.error = CAMPO_OBRIGATORIO
                true
            }

            this.receitaProduto.isEmpty() -> {
                binding.etReceita.error = CAMPO_OBRIGATORIO
                true
            }

            else -> false
        }
    }

    private fun limparCampos(){
        binding.etNomeProduto.text.clear()
        binding.etQtdProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceita.text.clear()
    }

}