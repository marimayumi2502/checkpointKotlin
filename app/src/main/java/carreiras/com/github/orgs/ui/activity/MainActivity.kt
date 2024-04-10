package carreiras.com.github.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    /*
   Classe MainActivity herda da classe AppCompatActivity (a activity irá utilizar o layout
   de AppCompatActivity)
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
    }


    /*
 Método OnResume: realiza as ações da Activity
*
*/
    override fun onResume() {
        super.onResume()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()

        Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscaTodos()
        )

                /*
              /*
   recyclerView.adapter = ListaProdutosAdapter: recebe a lista de prodtos obtidas no DAO
*
*/
        *
        */

  

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}