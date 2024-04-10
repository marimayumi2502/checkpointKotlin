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

    R.layout.activity_formulario_produto é uma referência a um recurso de layout XML dentro do projeto Android.

    quando a FormularioProdutoActivity é iniciada, ela usa o layout definido em activity_formulario_produto.xml como sua interface de usuário.
*
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            /*
     O método onCreate() é chamado quando a atividade é criada.
     savedInstanceState é um parâmetro que contém dados salvos do estado anterior da atividade, como quando a atividade é recriada após uma mudança de configuração.
     O Bundle é uma coleção de dados chave-valor que podem ser usados para passar informações entre componentes do Android, como atividades.
     Neste contexto, savedInstanceState é usado para restaurar o estado anterior da atividade, se disponível.
     super.onCreate(savedInstanceState) chama a implementação do método onCreate() da classe pai (AppCompatActivity), garantindo que o ciclo de vida da atividade seja gerenciado corretamente.
}
    *
    */

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        /*
       O código define um listener para o botão botaoSalvar, que é ativado quando o botão é clicado. Isso captura os dados inseridos nos campos de
       texto e cria um objeto Produto com esses dados.
*/

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