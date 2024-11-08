package com.example.testdb;// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = findViewById(R.id.EmailText);
        passwordText = findViewById(R.id.PasswordText);
        Button loginButton = findViewById(R.id.btn_log);

        // Inicializar el controlador de usuarios
        userController = new UserController(this);

        // Configurar el evento del botón de login
        loginButton.setOnClickListener(v -> {
            String email = emailText.getText().toString();
            String password = passwordText.getText().toString();

            // Verificar si el usuario existe en la base de datos
            User usuario = userController.obtenerUsuarioPorNombre(email);

            if (usuario != null && usuario.getPassword().equals(password)) {
                // Si el usuario y contraseña son correctos, navega a ActivityPlan
                Intent intent = new Intent(MainActivity.this, activity_grilla.class);
                startActivity(intent);
            } else {
                // Mostrar mensaje de error si las credenciales son incorrectas
                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

