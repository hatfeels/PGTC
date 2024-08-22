package com.gtc.task.client;

import com.gtc.task.dto.UserEntityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


//programar la comunicacion hacia otros servidores
@FeignClient(name = "gtc-user", url = "localhost:8080/api/user")
public interface UserClient {

    @PutMapping("/update")
    void updateUser(@RequestBody UserEntityDTO user);


    @GetMapping("/search/{idUser}")
    UserEntityDTO getUserById(@PathVariable Long idUser);

}
