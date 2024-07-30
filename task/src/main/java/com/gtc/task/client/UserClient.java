package com.gtc.task.client;

import org.springframework.cloud.openfeign.FeignClient;

//programar la comunicacion hacia otros servidores
@FeignClient(name = "gtc-user", url = "localhost:9010/api/user")
public interface UserClient {
}
