package luz.gaspario.validaciones_lu

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Creamos una corrutina, tiene que ser el hilo Main porque se muestra cosas en la pantalla
        GlobalScope.launch(Dispatchers.Main) {
            //Espera 3 segundos
            delay(3000)

            //Iniciar la activity principal
            val pantallaInicio = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(pantallaInicio)

            //Finalizar la activity actual
            finish()
        }
    }
}
