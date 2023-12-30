package com.main.TaskKeeper.Service;
import com.main.TaskKeeper.Model.Dolar;
import com.main.TaskKeeper.Repository.DolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class DolarService {

    private final String apiUrl = "https://dolarapi.com/v1/dolares";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DolarRepository dolarRepository;

    public List<Dolar> getDolarInfoAllDevices(){
        return Arrays.asList(restTemplate.getForObject(apiUrl, Dolar[].class));
    }




}
