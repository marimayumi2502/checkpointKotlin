package carreiras.com.github.orgs.model

import java.math.BigDecimal

/*
    Classe que define os atributos de "Produto"
*
*/

data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
