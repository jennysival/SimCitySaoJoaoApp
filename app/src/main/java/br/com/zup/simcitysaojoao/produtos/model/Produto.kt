package br.com.zup.simcitysaojoao.produtos.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Produto(private var nome: String,
              private var quantidade: Double,
              private var valorUn: Double,
              private var receita: String
): Parcelable {
    private var valorTotal = 0.0

    fun getNome() = this.nome
    fun getQtd() = this.quantidade
    fun getValorUn() = this.valorUn
    fun getReceita() = this.receita
    fun getValorTotal() = calcularTotal()

    private fun calcularTotal(): Double{
        valorTotal = quantidade*valorUn

        return valorTotal
    }
}