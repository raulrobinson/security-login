package co.com.telefonica.ws.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController {

    @GetMapping("")
    public ResponseEntity<Object> allAccess() {
        var res = new HashMap<String, String>();
        res.put("code", "200 OK");
        res.put("access", "Public Access.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Object> userAccess() {
        var res = new HashMap<String, String>();
        res.put("code", "200 OK");
        res.put("access", "User Content.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Object> moderatorAccess() {
        var res = new HashMap<String, String>();
        res.put("code", "200 OK");
        res.put("access", "Moderator Content.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> adminAccess() {
        var res = new HashMap<String, String>();
        res.put("code", "200 OK");
        res.put("access", "Admin Content.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
