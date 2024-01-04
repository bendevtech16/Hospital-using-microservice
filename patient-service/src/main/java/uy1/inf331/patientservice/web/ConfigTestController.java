package uy1.inf331.patientservice.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p1}")
    private int p2;
    @Value("${patient.params.x1}")
    private int x1;
    @Value("${patient.params.x2}")
    private int x2;

    @GetMapping("/config-test")
    public Map<String, Integer> configTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("p1", p1);
        map.put("p2", p2);
        map.put("x1", x1);
        map.put("x2", x2);
        return map;
    }
}