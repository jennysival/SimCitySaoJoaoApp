package br.com.zup.simcitysaojoao.produtos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.produtos.model.Produto

class ProdutoAdapter(
    private var listaDeProdutos: MutableList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit
): RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProdutoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun exibirProdutoDaLista(produto: Produto){
            val exibirNomeCard = buildString {
                append(produto.getQtd())
                append(" - ")
                append(produto.getNome())
            }
            binding.tvNomeProdutoCard.text = exibirNomeCard
        }
    }

    fun atualizarLista(novaLista: ArrayList<Produto>){
        if(listaDeProdutos.size == 0){
            listaDeProdutos = novaLista
        }
        else{
            listaDeProdutos.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaDeProdutos[position]
        holder.exibirProdutoDaLista(produto)
        holder.binding.cvItemLista.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int {
        return listaDeProdutos.size
    }
}