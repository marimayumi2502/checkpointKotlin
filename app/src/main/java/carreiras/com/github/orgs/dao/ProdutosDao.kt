package carreiras.com.github.orgs.dao

import carreiras.com.github.orgs.model.Produto

/*
    Classe DAO (Data Access Object) usada para acessar os dados e gerenciar a lista de produtos
    Possui métodos que adicionam e buscam todos os produtos cadastrados
*
*/


class ProdutosDao {

    fun adiciona(produto: Produto) {
        Companion.produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}