package ru.stason.study.spring.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stason.study.spring.logic.SpittleRepository;
import ru.stason.study.spring.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String DEFAULT_PAGE_SIZE = "20";
    private static final String MAX_LONG_STRING = "1000";

    public SpittleController() {
        //todo remove this crap
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < 50; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        when(mockRepository.findSpittles(1000, 50)).thenReturn(spittles);

        spittles = new ArrayList<Spittle>();
        for (int i = 0; i < 20; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        when(mockRepository.findSpittles(1000, 20))
                .thenReturn(spittles);
        spittleRepository = mockRepository;
    }

    //    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max",
            defaultValue=MAX_LONG_STRING) Long max, @RequestParam(value = "count", defaultValue = DEFAULT_PAGE_SIZE) Integer
            count, Model model) {
        String.valueOf(Long.MAX_VALUE);
        SecurityContextHolder.getContext(); //This great feature
        model.addAttribute(
                spittleRepository.findSpittles(
                        max, count));
        return "spittles";
    }

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId, // ("spittleId") can be omitted
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    //another way
//    @RequestMapping(method=RequestMethod.GET)
//    public List<Spittle> spittles() {
//        return spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//    }
}
