package ru.netology.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateDelivery {

    String dateDeliveryCalculate(int dateInc){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime date = LocalDateTime.now();

        String dateDelivery = date.plusDays(dateInc).format(formatter);

        return dateDelivery;
    }
}
