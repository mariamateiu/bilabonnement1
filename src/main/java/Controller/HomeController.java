package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
@Controller
public class HomeController {

    @GetMapping("/MenuBusiness" )
    public String MenuBusiness(){
        //ConnectionManager.();

        return "MenuBusiness";
    }

    @GetMapping("/LeasingTable" )
    public String Le(Model model){
        //ConnectionManager.();

        return "LejeRepository";
    }


}
