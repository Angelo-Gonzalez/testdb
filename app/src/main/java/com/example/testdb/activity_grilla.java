package com.example.testdb;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class activity_grilla extends AppCompatActivity {

    TextView tvUsers;
    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grilla);

        tvUsers = findViewById(R.id.tvUsers);

        // Inicializar el controlador
        userController = new UserController(this);

        // Obtener y mostrar la lista de usuarios
        mostrarUsuarios();
    }
    private void mostrarUsuarios(){
        List<User> listUsers = userController.obtenerUsuarios();
        StringBuilder texto = new StringBuilder();
        for(int i = 0; i < listUsers.size() ; i++) {
            texto.append("User ").append(i).append(" = ")
                    .append(listUsers.get(i).getUser()).append(", ")
                    .append(listUsers.get(i).getPassword()).append("\n");
        }
        tvUsers.setText(texto.toString());
    }
}