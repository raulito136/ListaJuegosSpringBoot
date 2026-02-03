package org.example.hellowordspringboot.controllers;

import org.example.hellowordspringboot.entity.Game;
import org.example.hellowordspringboot.exceptions.GameNotFoundException;
import org.example.hellowordspringboot.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador web principal para la gestión de la biblioteca de videojuegos.
 * Maneja las peticiones HTTP relacionadas con la visualización, creación y edición de juegos.
 */
@Controller
@RequestMapping("/")
class WebController {

    private final GameService gameService;

    /**
     * Constructor para la inyección de dependencias del servicio de juegos.
     * @param gameService Servicio que gestiona la lógica de negocio de los videojuegos.
     */
    public WebController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Muestra la vista de detalles de un videojuego específico.
     * @param id Identificador único del juego.
     * @param model Modelo para pasar los datos a la vista.
     * @return El nombre de la plantilla HTML "juego".
     * @throws GameNotFoundException si el ID no existe en la base de datos.
     */
    @GetMapping("/juego/{id}")
    public String juego(@PathVariable Integer id, Model model){
        Game game = gameService.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        List<String> platforms = gameService.obtenerPlataformas();
        model.addAttribute("platforms", platforms);
        model.addAttribute("juego", game);
        return "juego";
    }

    /**
     * Muestra la página principal con el listado de juegos, permitiendo filtrar por plataforma.
     * @param platform (Opcional) Nombre de la plataforma para filtrar los resultados.
     * @param model Modelo para la vista.
     * @return La plantilla "index" con la lista de juegos y plataformas disponibles.
     */
    @GetMapping("/")
    public String index(@RequestParam(required = false) String platform, Model model) {
        List<Game> filteredGames;
        List<String> platforms = gameService.obtenerPlataformas();

        if (platform != null && !platform.isEmpty()) {
            filteredGames = gameService.findGamesByPlatform(platform);
            model.addAttribute("selectedPlatform", platform);
        } else {
            filteredGames = gameService.listarTodos();
        }

        model.addAttribute("games", filteredGames);
        model.addAttribute("platforms", platforms);
        return "index";
    }

    /**
     * Prepara el modelo para mostrar el formulario de creación de un nuevo juego.
     * @param model Modelo para la vista.
     * @param game Objeto juego vacío inicializado por Spring.
     * @return La plantilla "formulario".
     */
    @GetMapping("/formulario")
    public String formulario(Model model, @ModelAttribute Game game){
        model.addAttribute("platforms", gameService.obtenerPlataformas());
        return "formulario";
    }

    /**
     * Procesa la recepción de datos del formulario para guardar un videojuego.
     * @param game Objeto mapeado con los datos del formulario.
     * @return Redirección a la página principal tras guardar con éxito.
     */
    @PostMapping("/juego/nuevo")
    public String guardarJuego(@ModelAttribute Game game) {
        gameService.guardar(game);
        return "redirect:/";
    }

    /**
     * Carga los datos de un juego existente en el formulario para su modificación.
     * @param id Identificador del juego a editar.
     * @param model Modelo para la vista.
     * @return La plantilla "formulario" con los datos cargados o redirección si no existe.
     */
    @GetMapping("/juego/editar/{id}")
    public String editarJuego(@PathVariable Integer id, Model model) {
        Game game = gameService.findById(id).orElse(null);

        if (game == null) {
            return "redirect:/";
        }
        model.addAttribute("game", game);
        model.addAttribute("platforms", gameService.obtenerPlataformas());

        return "formulario";
    }
}