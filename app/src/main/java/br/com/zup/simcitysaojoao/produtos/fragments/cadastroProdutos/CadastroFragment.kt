package br.com.zup.simcitysaojoao.produtos.fragments.cadastroProdutos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var nomeProduto: String
    private lateinit var qtdProduto: String
    private lateinit var valorProduto: String
    private lateinit var receitaProduto: String

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

        }

        binding.btnVerProdutos.setOnClickListener {

        }

        binding.btnValorTotal.setOnClickListener {

        }
    }

}