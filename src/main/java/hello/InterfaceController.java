package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfaceController {
    @Autowired
    private BuddyInfoRepository repository;

    @GetMapping("/")
    public String gui(Model model){
        model.addAttribute("buddies", repository.findAll());
        return "index";
    }
}
