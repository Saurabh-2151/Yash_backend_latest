package com.company.attendance.service;

import com.company.attendance.dto.ClientDto;
import com.company.attendance.entity.Client;
import com.company.attendance.mapper.ClientMapper;
import com.company.attendance.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {
    
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDto createClient(ClientDto clientDto) {
        log.info("Creating new client: {}", clientDto.getName());
        
        // Check if email already exists
        if (clientDto.getEmail() != null && clientRepository.findByEmail(clientDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + clientDto.getEmail());
        }
        
        Client client = clientMapper.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        
        log.info("Client created successfully with ID: {}", savedClient.getId());
        return clientMapper.toDto(savedClient);
    }

    public ClientDto updateClient(Long id, ClientDto clientDto) {
        log.info("Updating client with ID: {}", id);
        
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        
        // Check if email already exists for another client
        if (clientDto.getEmail() != null && !clientDto.getEmail().equals(existingClient.getEmail())) {
            Optional<Client> clientWithEmail = clientRepository.findByEmail(clientDto.getEmail());
            if (clientWithEmail.isPresent() && !clientWithEmail.get().getId().equals(id)) {
                throw new RuntimeException("Email already exists: " + clientDto.getEmail());
            }
        }
        
        clientMapper.updateEntityFromDto(clientDto, existingClient);
        Client updatedClient = clientRepository.save(existingClient);
        
        log.info("Client updated successfully with ID: {}", updatedClient.getId());
        return clientMapper.toDto(updatedClient);
    }

    public ClientDto getClientById(Long id) {
        log.info("Fetching client with ID: {}", id);
        
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        
        return clientMapper.toDto(client);
    }

    public List<ClientDto> getAllClients() {
        log.info("Fetching all clients");
        
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toDtoList(clients);
    }

    public List<ClientDto> getActiveClients() {
        log.info("Fetching active clients");
        List<Client> clients = clientRepository.findByIsActive(true);
        return clientMapper.toDtoList(clients);
    }

    public List<ClientDto> searchClients(String search) {
        log.info("Searching clients with term: {}", search);
        
        // Simple implementation using findAll and filtering
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream()
                .filter(client -> client.getName().toLowerCase().contains(search.toLowerCase()) ||
                               (client.getEmail() != null && client.getEmail().toLowerCase().contains(search.toLowerCase())))
                .map(clientMapper::toDto)
                .toList();
    }

    public void deleteClient(Long id) {
        log.info("Deleting client with ID: {}", id);
        
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        
        // Soft delete by setting isActive to false
        client.setIsActive(false);
        clientRepository.save(client);
        
        log.info("Client deleted successfully with ID: {}", id);
    }

    public long getActiveClientsCount() {
        return clientRepository.countActiveClients();
    }
}
