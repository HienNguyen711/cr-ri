package project.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.userservice.repo.AddressRepository;

@Service
@Transactional
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
}
