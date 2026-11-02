package in.balu.controller;
import in.balu.dto.CredentialDto;
import in.balu.service.CredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credentials")
@Slf4j
public class CredentialController {

    @Autowired
    public CredentialService credentialService;

    @GetMapping("/username/{uname}")
    @ResponseStatus(code = HttpStatus.OK)
    public CredentialDto findByUsername(@PathVariable("uname") String username) {

        log.info("CredentialController findByUsername");

        return credentialService.findByUsername(username);

    }
}