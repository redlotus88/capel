package com.c8n.time;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by dragon on 2019/9/10.
 */
@Controller
@RequestMapping("/time")
public class TimeController {


    @RequestMapping("/passDate")
    public ResponseEntity<String> passDateParams(DateParams date) {
        return ResponseEntity.ok(date.toString());
    }
}

@Data
class DateParams {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
}
