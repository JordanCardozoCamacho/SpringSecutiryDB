package com.jordan.SpringSecutiryDB.controller;

import com.jordan.SpringSecutiryDB.model.User;
import com.jordan.SpringSecutiryDB.repository.UserRepository;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    //Attributes
    private UserRepository userRepository;

    //Constructor
    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Métodos

        //Método para validar l configuración de entorno
    @Value("${app.message}")
    String message;
    @Value("${app.varexample}")
    String varexample;

    @GetMapping("/hola")
    public String saludo(){
        System.out.println("message: " + message);
        System.out.println("Perfil: " + varexample);
        return "Hola desde controller User";
    }

    /**
     * Crear un Usuario
     * @param user
     * @return
     */
    @PostMapping("/user/created")
    public ResponseEntity<User> created(@RequestBody User user){
        if(user.getId() != null){
            return ResponseEntity.badRequest().build();

        } else{
            User ResultCreated = userRepository.save(user);
            return ResponseEntity.ok(ResultCreated);
        }
    }

    /**
     * Buscar todos los Usuarios
     * @return
     */
    @GetMapping("/User")
    public List<User> list(){
        Long resultCount = userRepository.count();
        if(resultCount > 0){
            return userRepository.findAll();
        } else{
            return null;
        }
    }

    /**
     * Buscar un Usuario en Especifico
     * @param id
     * @return
     */
    @GetMapping("/User/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> resultId = userRepository.findById(id);
        if(resultId.isPresent()){
            User result = userRepository.getById(id);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Actualizar un Usuario
     * @param user
     * @return
     */
    @PutMapping("/user/update")
    public ResponseEntity<User> update(@RequestBody User user){
        if(user.getId() != null){
            User update = userRepository.save(user);
            return ResponseEntity.ok(update);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Eliminar un Usuario
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id){
        Optional<User> resultId = userRepository.findById(id);
        if(resultId.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar todos los Usuarios
     * @return
     */
    @DeleteMapping("/user")
    public ResponseEntity<User> DeleteAll(){
        Long countDelete = userRepository.count();
        if(countDelete > 0 ){
            userRepository.deleteAll();
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
