package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class HomeController {


    @GetMapping("/" )
    public String Menu(){
        //ConnectionManager.();

        return "Menu";

}}
