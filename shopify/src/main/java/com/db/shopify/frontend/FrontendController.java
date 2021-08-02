package com.db.shopify.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {
    @GetMapping("/index")
    public String getIndexPage(Model model){
        model.addAttribute("name", "Cristi");
        return "index";
    }
}
