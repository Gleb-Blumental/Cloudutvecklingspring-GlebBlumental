package org.glebindustries.veterinary_application.service;

import lombok.RequiredArgsConstructor;
import org.glebindustries.veterinary_application.models.Client;
import org.glebindustries.veterinary_application.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository repository;


    public Iterable<Client> getAllClients() {
        return repository.findAll();
    }

    public Optional<Client> getClientById(@PathVariable Long clientId) {
        return repository.findById(String.valueOf(clientId));
    }

    public boolean createClient(Client client) {
        try {
            repository.save(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateClient(Long clientId, Client updatedClient) {

        Optional<Client> existingClient = repository.findById(String.valueOf(clientId));

        if (existingClient.isPresent()) {
            Client client = existingClient.get();

            client.setName(updatedClient.getName());
            client.setPhoneNumber(updatedClient.getPhoneNumber());
            client.setClinic(updatedClient.getClinic());

            repository.save(updatedClient);
            return true;

        }else{
            return false;
        }
    }

    public boolean deleteClient(Long clientId) {
        Optional<Client> existingClient = repository.findById(String.valueOf(clientId));

        if (existingClient.isPresent()){
            repository.deleteById(String.valueOf(clientId));
            return true;
        }else {
            return false;
        }

    }


}
