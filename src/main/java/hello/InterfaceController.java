package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InterfaceController {
    @Autowired
    private BuddyInfoRepository repository;

    @GetMapping("/")
    public String gui(Model model){
        model.addAttribute("newBuddy", new BuddyInfo());
        model.addAttribute("buddies", repository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addBuddy(@ModelAttribute BuddyInfo newBuddy, Model model) {
        repository.save(newBuddy);
        return this.gui(model);
    }
}
