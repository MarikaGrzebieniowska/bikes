package pl.marika.pjatk.mas.bikes.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.repository.ClientRepository;

@Service
public class ClientService {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void saveAll(Collection<Client> clients) {
        clientRepository.saveAll(clients);
    }

    @Transactional
    public Client findClient(String email) {
        return clientRepository.findByEmail(email);
    }
}
