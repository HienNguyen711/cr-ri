package project.userservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.userservice.entity.Address;
import project.userservice.entity.Organisation;
import project.userservice.entity.UserDetail;
import project.userservice.repo.AddressRepository;
import project.userservice.repo.OrganisationRepository;
import project.userservice.repo.UserDetailRepository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class UserDetailService {

    @Resource
    AddressRepository addressRepo;

    @Resource
    OrganisationRepository organisationRepository;

    @Resource
    UserDetailRepository userRepo;

    /**
     * SAVE ADDRESS
     * @param address
     */

    public void saveAddress(Address address) {
        addressRepo.save(address);

    }

    /**
     * save Organisation
     * @param org
     */

    public void saveOrganisation(Organisation org){
        organisationRepository.save(org);

    }

    /**
     * save user
     * @param userDetail
     */

    public void saveUser(UserDetail userDetail) {
        userRepo.save(userDetail);


    }

    /**
     * get address
     * @param userId
     * @return
     */
    public Address getAddress(UUID userId) {
        Address returnAddressObject = addressRepo.findByUserId(userId.toString());
        return returnAddressObject;

    }

    /**
     * get Organisation by user id
     * @param userId
     * @return
     */
    public Organisation getOrganisationByUserId(UUID userId){
        return organisationRepository.findByUserId(userId.toString());
    }

    /**
     * get user detail by user id
     * @param userId
     * @return
     */
    public UserDetail getUser(UUID userId) {
        UserDetail userObjectToRetrun = userRepo.findByUserId(userId.toString());
        return userObjectToRetrun;
    }

    /**
     * delete user
     * @param userId
     */
    public void deleteUser(UUID userId) {
        Address addressObject = addressRepo.findByUserId(userId.toString());
        addressObject.setDeletedOn(new Date());
        addressRepo.saveAndFlush(addressObject);

        Organisation organisationObject = organisationRepository.findByUserId(userId.toString());
        // set deleted is true
        organisationObject.setDeletedOn(new Date());
        organisationRepository.saveAndFlush(organisationObject);

        // user detail
        UserDetail userObject = userRepo.findByUserId(userId.toString());
        userObject.setDeletedOn(new Date());
        userRepo.saveAndFlush(userObject);


    }


}
