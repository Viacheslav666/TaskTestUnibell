package ru.Unibell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Unibell.DTO.ClientDTO;
import ru.Unibell.model.Client;
import ru.Unibell.model.Contact;
import ru.Unibell.repository.GuideRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {
    private final GuideRepository guideRepository;

    @Override
    public void addClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setNameClient(clientDTO.getName());
        guideRepository.save(client);
    }

    @Override
    public void addContact(Long id, Contact contact) {
        Client client = guideRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        contact.setClient(client);
        client.getContacts().add(contact);
        guideRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return guideRepository.findAll();
    }


    @Override
    public Client getClientId(Long id) {
        return guideRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

    }

    @Override
    public List<Contact> getContactClientByName(Long id) {
        Client client = guideRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getContacts();
    }

    @Override
    public List<Contact> getContactClientByName(Long id, String contactType) {
        Client client = guideRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getContacts().stream()
                .filter(contact -> contact.getEmailAddresses().equalsIgnoreCase(contactType))
                .filter(contact -> contact.getPhoneNumbers().equalsIgnoreCase(contactType))
                .collect(Collectors.toList());
    }
    }

