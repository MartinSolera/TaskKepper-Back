package com.main.TaskKeeper.Service;
import com.main.TaskKeeper.Model.Dolar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DolarService {

    private final String apiUrl = "https://dolarapi.com/v1/dolares";

    @Autowired
    private RestTemplate restTemplate;

    public List<Dolar> getDolarInfoAllDevices(){
        return Arrays.asList(restTemplate.getForObject(apiUrl, Dolar[].class));
    }

    public List<Dolar> getDolarInfoFiltered(){
        List<Dolar> listDolarFiltered = new ArrayList<>();
        List<Dolar> listDolar = Arrays.asList(restTemplate.getForObject(apiUrl, Dolar[].class));

        String casaFiltered = "contadoconliqui";

        for (Dolar dolar : listDolar ){
            if (!dolar.getCasa().equals(casaFiltered)){
                if (dolar.getFechaActualizacion() != null){
                    LocalDateTime dateUpdated = setHour(dolar.getFechaActualizacion());

                    Dolar dolarFiltered = new Dolar(dolar.getMoneda(),dolar.getCasa(),dolar.getCompra(),dolar.getVenta(),dateUpdated);

                    listDolarFiltered.add(dolarFiltered);

                }
            }


        }

        return listDolarFiltered;
    }

    public LocalDateTime setHour(LocalDateTime time){
        return time.minusHours(2);
    }




}