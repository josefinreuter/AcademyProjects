/* Written by Josefin Reuter 2017*/

package academy.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class QuizController {

    @Autowired
    private KysymyksetRepository kysymyksetRepository;

    //Retrieves the questions from the database Joulukalenteri
    @GetMapping("/jouluvisa")
    public String quiz (Pageable pageable, Model model){
        Page<Kysymykset> quiz = kysymyksetRepository.findAll(pageable);
        model.addAttribute("num", pageable.getPageNumber() + 1);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("total", quiz.getTotalPages());
        model.addAttribute("quiz", quiz);
        model.addAttribute("page", quiz);
        return "quiz";
    }

    //Handles the answers from quiz.html
    @PostMapping("/jouluvisa")
    public String checkAnswer(@RequestParam(value = "option") boolean correct, @RequestParam(value = "currentpg") Integer value, Model model) {
        model.addAttribute("next", value);
        model.addAttribute("correct", correct);
        return "quiz";
    }

}
