package ru.Unibell.service;

import ru.Unibell.DTO.ClientDTO;
import ru.Unibell.model.Client;
import ru.Unibell.model.Contact;

import java.util.List;

public interface GuideService {
  void addClient(ClientDTO clientDTO);
  void addContact(Long id, Contact contact);

 List<Client> getAllClient();
  Client getClientId(Long id);
  List <Contact> getContactClientByName(Long id);
  List <Contact> getContactClientByName(Long id,String contactType);
}
