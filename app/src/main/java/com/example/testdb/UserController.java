package com.example.testdb;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.List;

public class UserController {
    private final DaoUser daoUser;

    //Constructor del controlador
    public UserController(Context context){
        AppDatabase db = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "testdb"
        ).allowMainThreadQueries().build();
        this.daoUser = db.daoUser();
    }
    // Validar login
    public boolean validarLogin(String email, String password){
        User usuario = daoUser.obtenerUser(email);

        return usuario != null && usuario.getPassword().equals(password);
    }

    // Metodo para obtener la lista de usuarios
    public List<User> obtenerUsuarios() {
        return daoUser.obtenerUser();
    }

    // Metodo para insertar un nusuario especifico
    public User obtenerUsuarioPorNombre(String user) {
        User usuario = daoUser.obtenerUser(user);
        if (usuario == null) {
            Log.d("UserController", "Usuario no encontrado: " + user);
        } else {
            Log.d("UserController", "Usuario encontrado: " + usuario.getUser());
        }
        return usuario;
    }

    // Metodo para inserar un nuevo usuario
    public void insertarUsuario(String user, String password){
        User nuevoUsuario = new User(user, password);
        daoUser.insertarUser(nuevoUsuario);
    }
    //Metoido para actualizar la informacion de un usuario
    public void actualizarUsuario(String user, String password){
        daoUser.actualizaruser(user, password);
    }
    //Metodo para borrar un usuario
    public void borrarUsuario(String user) {
        daoUser.borrarUser(user);
    }
}
