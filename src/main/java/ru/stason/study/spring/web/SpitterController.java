package ru.stason.study.spring.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stason.study.spring.logic.SpitterRepository;
import ru.stason.study.spring.model.Spitter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    public SpitterController() {
        SpitterRepository mockRepository =
                mock(SpitterRepository.class);
        Spitter unsaved =
                new Spitter("slivotov", "password", "Stanislav", "Livotov");
        Spitter saved =
                new Spitter(24L, "slivotov", "password", "Stanislav", "Livotov");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        when(mockRepository.findByUsername("slivotov")).thenReturn(saved);
        spitterRepository = mockRepository;

    }

//    @Autowired
    public SpitterController(
            SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

//    @RequestMapping(value = "/register", method = GET)
//    public String showRegistrationForm() {
//        return "registerForm";
//    }

    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(Spitter spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" +
                spitter.getUsername();
    }

//todo
//    @RequestMapping(value="/register", method=POST)
//    public String processRegistration(
//            @Valid Spitter spitter,
//            Errors errors) {
//        if (errors.hasErrors()) {
//            return "registerForm";
//        }
//        spitterRepository.save(spitter);
//        return "redirect:/spitter/" + spitter.getUsername();
//    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
