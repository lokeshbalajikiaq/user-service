package in.balu.service;

import in.balu.dto.CredentialDto;
import in.balu.helper.CredentialMapper;
import in.balu.repository.CredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private CredentialMapper credentialMapper;

    public CredentialDto findByUsername(String username) {

        return credentialRepository.findByUsername(username)
                .map(credentialMapper :: toCredentialDto)
                .orElseThrow(() -> new RuntimeException("Username not found in DB"));
    }
}