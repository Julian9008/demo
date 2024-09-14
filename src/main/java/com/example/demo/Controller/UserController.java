package com.example.demo.Controller;

import com.example.demo.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Define la ruta base de este controlador: todas las URLs que empiecen con "/users"
@RequestMapping("/users")
public class UserController {

    // Define que este método manejará solicitudes GET en "/users/{name}/{age}/{email}/{sex}"
    @GetMapping("/{name}/{age}/{email}/{sex}")
    // Método que recibe un nombre como parámetro desde la URL y lo muestra en la vista
    public String showUser(@PathVariable String name, @PathVariable int age, @PathVariable String email,
                           @PathVariable String sex, Model model) {


        // Crea un nuevo objeto User con el nombre proporcionado
        User user = new User(name, age, email, sex);

        // Agrega el objeto user al modelo para que pueda ser accedido desde la vista
        model.addAttribute("user", user);

        // Retorna el nombre de la vista (user.html) para mostrar los datos
        return "user";  // La vista se ubicará en src/main/resources/templates/user.html
    }
}
