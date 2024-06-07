package luz.gaspario.validaciones_lu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. Mandar a llamar a todos los elementos de la vista
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2. Programamos el botón
        btnAgregar.setOnClickListener {
            //Validamos que los campos no esten vacíos
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty() || txtContrasena.text.isEmpty() || txtEdad.text.isEmpty() || txtDUI.text.isEmpty()) {
                Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            } else {
                //Comprobar que solo ingrese números
                if (!txtEdad.text.matches("[0-9]+".toRegex())) {

                } else {
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.[a-z]+".toRegex())) {
                    } else {
                        //Validar que la contraseña tenga mínimo 6 carácteres
                        if (txtContrasena.text.length < 6 || txtContrasena.text.matches("[0-9]+".toRegex())) {
                            Toast.makeText(
                                this,
                                "La contraseña debe contener más de 6 dígitos",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (txtDUI.text.length > 9 && !txtDUI.text.matches("[0-9]+-?[0-9]".toRegex())) {
                                Toast.makeText(
                                    this,
                                    "Ingrese un DUI que sea válido",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                }
            }

        }
    }
}