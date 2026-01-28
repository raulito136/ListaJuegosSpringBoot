package org.example.hellowordspringboot;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
class WebController {
    GameRepository gameRepository;
    public WebController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/juego/{id}")
    public String juego(@PathVariable Integer id, Model model){
        List<String> platforms = gameRepository.findPlatformGames();
        model.addAttribute("platforms", platforms);


        if(gameRepository.findById(id).isPresent()) {
            model.addAttribute("juego", gameRepository.findById(id).get());
            return "juego";
        }else{
            model.addAttribute("descripcion", "No existe el juego con el id: "+id);
            return "error";
        }
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String platform, Model model) {
        List<Game> filteredGames;
        List<String> platforms = gameRepository.findPlatformGames();

        if (platform != null && !platform.isEmpty()) {
            filteredGames = gameRepository.findGamesByPlatform(platform, Sort.by("id"));
            model.addAttribute("selectedPlatform", platform);
        } else {
            filteredGames = gameRepository.findAll();
        }

        model.addAttribute("games", filteredGames);
        model.addAttribute("platforms", platforms);
        return "index";
    }
}
