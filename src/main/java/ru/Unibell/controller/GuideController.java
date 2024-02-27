package ru.Unibell.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Unibell.DTO.ClientDTO;
import ru.Unibell.model.Client;
import ru.Unibell.model.Contact;
import ru.Unibell.repository.GuideRepository;
import ru.Unibell.service.GuideService;

import java.util.List;

/**
 * Класс-кондроллер для работы со складом c справочником
 */
@RestController
@RequestMapping("/api/guide")
@Data
@RequiredArgsConstructor
public class GuideController {
    @Autowired
    private final GuideService guideService;
    @Autowired
    private final GuideRepository guideRepository;

    /**
     * №1
     * Метод добавляет нового клиента
     */
    @PostMapping("/add")
    public void addClient(@RequestBody ClientDTO clientDTO) {
        guideService.addClient(clientDTO);
    }

    /**
     * №2
     * Метод добавление нового контакта клиента (телефон или email)
     */
    @PostMapping("{id}/addPhone")
    public void addContactClient(
            @PathVariable Long id,
            @RequestBody Contact contact) {
        guideService.addContact(id, contact);
    }

    /**
     * №3
     * Получение списка клиентов
     */
    @GetMapping("/getAll")
    public List<Client> getAllClients() {
        return guideService.getAllClient();
    }

    /**
     * №4
     * Получение информации по заданному клиенту (по id)
     */
    @GetMapping("/{id}/getClient")
    public Client getClientId(
            @PathVariable("id") Long id) {
        return guideService.getClientId(id);
    }

    /**
     * №5
     * Получение списка контактов заданного клиента
     */
    @GetMapping("/{id}/getContact")
    public List<Contact> getContactClientByName(
            @PathVariable("id") Long id) {
        return guideService.getContactClientByName(id);
    }

    /**
     * №6
     * Получение списка контактов заданного типа заданного клиента
     */
    @GetMapping("/{id}/getClient/{contactType}")
    public List<Contact> getContactClientByName(
            @PathVariable("id") Long id,
            @PathVariable("contactType") String contactType) {
        return guideService.getContactClientByName(id, contactType);
    }
}
