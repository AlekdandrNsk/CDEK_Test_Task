package CDEK.web;

import CDEK.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private TableService service;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/create")
    public String createForm() {
        return "createForm";
    }

    @GetMapping("/table")
    public String getAll(Model model) {
        model.addAttribute("table", service.getAll());
        return "table";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request) {
        service.save(request.getParameter("name"));
        return "redirect:table";
    }

    @PostMapping("/filter")
    public String getByName(HttpServletRequest request, Model model) {
        model.addAttribute("table", service.getByName(request.getParameter("name")));
        return "table";
    }
}
