package tobiasjohansson.bloggheaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobiasjohansson.bloggheaven.model.Address;
import tobiasjohansson.bloggheaven.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address) {
        return saveAddress(address);
    }

    private Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

}
