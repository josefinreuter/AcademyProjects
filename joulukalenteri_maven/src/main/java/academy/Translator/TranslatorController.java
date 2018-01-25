//Written by Hennileena Calonius 2017
package academy.Translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/translator")
public class TranslatorController {

    @Autowired
    private SanakirjaRepository sanakirjaRepository;

    @GetMapping
    public String sentencelinks(Model model) {
        Map<URI, String> urls = new HashMap<>();
        urls.put(createnewURI("sentence1"), sanakirjaRepository.findBySentenceIdAndSuomi(1));
        urls.put(createnewURI("sentence2"), sanakirjaRepository.findBySentenceIdAndSuomi(2));
        urls.put(createnewURI("sentence3"), sanakirjaRepository.findBySentenceIdAndSuomi(3));
        urls.put(createnewURI("sentence4"), sanakirjaRepository.findBySentenceIdAndSuomi(4));
        urls.put(createnewURI("sentence5"), sanakirjaRepository.findBySentenceIdAndSuomi(5));
        urls.put(createnewURI("sentence6"), sanakirjaRepository.findBySentenceIdAndSuomi(6));
        urls.put(createnewURI("sentence7"), sanakirjaRepository.findBySentenceIdAndSuomi(7));
        urls.put(createnewURI("sentence8"), sanakirjaRepository.findBySentenceIdAndSuomi(8));
        model.addAttribute("urls", urls);
        return "translator";
    }

    @GetMapping("/sentence{lauseid}")
    public String firstSentences (@PathVariable(name = "lauseid") int lauseid, Model model) {
        model.addAttribute("sentences", sanakirjaRepository.findSanakirjaByLauseid(lauseid));
        return "sentences";
    }

    private URI createnewURI(String url) {
        return UriComponentsBuilder.newInstance()
                .scheme("http").host("localhost").port(8080)
                .pathSegment("translator", url).build().toUri();
    }
}
