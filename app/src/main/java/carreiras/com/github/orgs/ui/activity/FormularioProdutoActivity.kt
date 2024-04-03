package carreiras.com.github.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.model.Produto
import java.math.BigDecimal

/*
    Classe que gerencia o formulário de cadastro de novos produtos
*
*/

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    /*
    A classe FormularioProdutoActivity herda da classe AppCompatActivity

    R.layout.activity_formulario_produto: define o layout da activity
    o layout definido em activity_formulario_produto.xml será usado para exibir a interface
*
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            /*
      Este método é chamado quando a activity é criada
      Ele chama o método super.onCreate(savedInstanceState)
    *
    */

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val campoValor = findViewById<EditText>(R.id.valor)


            /*
            val campoNome = findViewById<EditText>(R.id.nome): Campo para inserção do nome
            val campoDescricao = findViewById<EditText>(R.id.descricao): Campo para inserção da descrição
            val campoValor = findViewById<EditText>(R.id.valor): Campo para inserção do valor
        *
        */
            val nome = campoNome.text.toString()
            val descricao = campoDescricao.text.toString()
            val valorEmTexto = campoValor.text.toString()

            /*
          val nome = campoNome.text.toString(): Criação de variável para armazenar o texto "nome"
          val descricao = campoDescricao.text.toString(): Criação de variável para armazenar o texto "descricao"
          val valorEmTexto = campoValor.text.toString(): Criação de variável para armazenar o texto "valor"
      *
      */

            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProduto", "onCreate: $produtoNovo")
            val dao = ProdutosDao()
            dao.adiciona(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

            finish()
        }
    }
}