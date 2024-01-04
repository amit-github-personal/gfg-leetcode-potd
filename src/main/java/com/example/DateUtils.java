package com.example;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;

public class DateUtils {

    public static void main(String[] args) {
        var date = "2023-12-12T08:56:35.1Z";
        java.util.Date from = Date.from(Instant.parse(date));
        System.out.println(from.toInstant().atZone(ZoneId.of("America/Los_Angeles")));
    }
}
