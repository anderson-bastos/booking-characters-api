package com.claudio_personagens.bookingcharactersapi.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping(ClientController.URL)
class ClientController {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(ClientController::class.java)
        const val URL = "/clients"
    }

//    @Autowired
    //    private ClientService clientService;
    //
    //    @PostMapping
    //    public @ResponseBody
    //    User salvar(@RequestBody User user) {
    //        return clientService.save(user);
    //    }
    //
    //    @GetMapping
    //    public @ResponseBody
    //    List<User> getUsers() {
    //        return clientService.findAll();
    //    }
}