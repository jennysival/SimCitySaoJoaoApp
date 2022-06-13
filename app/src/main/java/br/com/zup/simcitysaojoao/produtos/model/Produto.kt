package br.com.zup.simcitysaojoao.produtos.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Produto(private var nome: String,
              private var quantidade: Int,
              private var valorUn: Int,
              private var receita: String
): Parcelable {
    private var valorTotal = 0

    fun getNome() = this.nome
    fun getQtd() = this.quantidade
    fun getValorUn() = this.valorUn
    fun getReceita() = this.receita
    fun getValorTotal() = calcularTotal()

    private fun calcularTotal(): Int{
        valorTotal = quantidade*valorUn

        return valorTotal
    }
}