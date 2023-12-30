package com.main.TaskKeeper.Controller;

import com.main.TaskKeeper.Model.Dolar;
import com.main.TaskKeeper.Service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DolarController {

    @Autowired
    private DolarService dolarService;

    @GetMapping("/dolar")
    public List<Dolar> dolarAllDevices(){
        return dolarService.getDolarInfoAllDevices();
    }
}
