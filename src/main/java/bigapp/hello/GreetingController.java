package bigapp.hello;

import bigapp.calc.Calculator;
import bigapp.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class GreetingController {

    @RequestMapping(value = "/", method = GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println(Calculator.debug());
        model.addAttribute("name", name);
        model.addAttribute("debug", Util.get());
        return "greeting";
    }

}
