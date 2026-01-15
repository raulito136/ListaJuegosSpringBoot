package org.example.hellowordspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class MainController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    public List<String> index(){
        return List.of("Hello World!","DAM2");
    }

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola Mundo";
    }

    @GetMapping("/saludar/{nombre}/{apellido}")
    public String saludar(@PathVariable String nombre, @PathVariable String apellido){
        return "Hola "+nombre+" "+apellido;
    }

    @GetMapping("/saludarJson")
    public String saludar2(@RequestBody Persona data){
        System.out.println(data);
        return "Jelou "+data.getNombre()+" "+data.getApellido();
    }

    @GetMapping("/test3")
    public Persona test3(@RequestBody Persona data){
    Persona salida=new Persona();
    salida.setNombre(data.getNombre().toUpperCase());
    salida.setApellido(data.getApellido().toUpperCase());
    return salida;
    }
    @GetMapping("/test4")
    public Boolean test4(@RequestBody Persona data){
        if (data.getNombre().isEmpty() || data.getApellido().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    @GetMapping("/saludar3/{idioma}")
    public String saludar3(@PathVariable String idioma,@RequestParam String nombre){
        switch (idioma){
            case "es": return "Hola "+nombre;
            case "en": return "Hello "+nombre;
            case "gitano": return "Jelou "+nombre;
            default: return "hi "+nombre;
        }
    }

    @GetMapping("/games")
    public List<Game> findAll(){
        return  gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game findById(@PathVariable Integer id){
        return gameRepository.findById(id).get();
    }

    @PostMapping("/games")
    public Game save(@RequestBody Game game){
        return gameRepository.save(game);
    }








}
