package org.glebindustries.veterinary_application.controllers;

import lombok.RequiredArgsConstructor;

import org.glebindustries.veterinary_application.models.Client;
import org.glebindustries.veterinary_application.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @GetMapping
    public String clientPage(){
        return "client";
    }

    @PostMapping("/add")
    public ResponseEntity<String> createClient(@RequestBody Client client){

        var created = clientService.createClient(client);

        if(created){
            return new ResponseEntity<>("Client created successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Error creating client", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Client>> getAllClients(){
        var clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("getby/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId){
        var client = clientService.getClientById(clientId);

        if(client.isPresent()){
            return new ResponseEntity<>(client.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long clientId, @RequestBody Client client){
        var isUpdated = clientService.updateClient(clientId, client);

        if(isUpdated){
            return new ResponseEntity<>("Client updated", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Client not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@PathVariable Long clientId){
        var isDeleted = clientService.deleteClient(clientId);

        if(isDeleted){
            return new ResponseEntity<>("Client ID is deleted", HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity("Could not find the client by ID", HttpStatus.NOT_FOUND);
        }
    }

}
