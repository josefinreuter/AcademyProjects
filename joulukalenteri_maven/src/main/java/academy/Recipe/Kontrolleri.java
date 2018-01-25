package academy.Recipe;

//Written by Riina Purovesi 2017

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Kontrolleri {
    @Autowired
    ReseptitRepository reseptitRepository;

/*    @GetMapping(path="/recipes")
    public String reseptit(Model model) {
        model.addAttribute("recipes", reseptitRepository.findAll());
        return "recipes";
    }*/
    @RequestMapping (path="/recipes")
    public String recipe (Model model, Pageable pageable) {
        int sivu = pageable.getPageNumber();
        Page<Reseptit> page = reseptitRepository.findAll(pageable);
        int sivuja = page.getTotalPages();
        //String ohje = page.

        model.addAttribute("users", page);
        model.addAttribute("sivu", sivu);
        model.addAttribute("sivuja", sivuja);

        return "recipes";
    }

}
