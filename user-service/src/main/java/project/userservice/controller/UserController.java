package project.userservice.controller;
import java.util.UUID;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.userservice.entity.Address;
import project.userservice.entity.Organisation;
import project.userservice.entity.UserDetail;
import project.userservice.repo.UserDetailRepository;
import project.userservice.service.UserDetailService;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

//    @Resource
    @Autowired
    UserDetailService userDetailService;

    @Resource
    ObjectMapper mapper;

    @Autowired
    UserDetailRepository userDetailRepository;


    /**
     * Method is responsible for adding new address.
     *
     * @param address
     * @param userId
     * @return
     */


    @RequestMapping(method = RequestMethod.POST, value = "{userId}/address", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createUserAddress(@RequestBody Address address, @PathVariable("userId") UUID userId) {
        logger.debug( " Address for user Id " + userId + " is updated as " + address);
        address.setUserId(userId.toString());
        userDetailService.saveAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * CREATE ORGANISATION BY USER ID
     * @param org
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "{userId}/organisation", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createUserOrganisation(@RequestBody Organisation org, @PathVariable("userId") UUID userId) {

        org.setUserId(userId.toString());
        userDetailService.saveOrganisation(org);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    /**
     * Method is responsible for creating a user.
     *
     * @param userDetail
     * @return
     */


    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody UserDetail userDetail) {
        logger.debug( " CREATING USER  and details : " + userDetail);
        String userEntityLength=""+userDetailRepository.count();
        userDetail.setUserId(userEntityLength);

        userDetailService.saveUser(userDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * DELETE USER BY USER ID
     * @param userId
     * @return
     */


    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") UUID userId) {
        logger.debug( " deleting user with Id " + userId);
        userDetailService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Get user detail by user id
     *
     * @param userId
     * @return
     */

    @RequestMapping(method = RequestMethod.GET, value = "{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDetail> getUser(@PathVariable("userId") UUID userId) {
        logger.debug("GET USER DETAIL BY USER ID " + userId);
        UserDetail objectToReturn = userDetailService.getUser(userId);
        if (objectToReturn == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(objectToReturn, HttpStatus.OK);
    }

    /**
     * GET ADDRESS BY USER ID
     *
     * @param userId
     * @return
     */


    @RequestMapping(method = RequestMethod.GET, value = "{userId}/address", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Address> getAddress(@PathVariable("userId") UUID userId) {
        logger.debug( " getting address for user Id: " + userId);
        Address objectToReturn = userDetailService.getAddress(userId);
        if (objectToReturn == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(objectToReturn, HttpStatus.OK);
    }

    /**
     * Get organisation by user id
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "{userId}/organisation", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Organisation> getOrganisation(@PathVariable("userId") UUID userId) {
        logger.info("Get organisation by user id");
        Organisation org = userDetailService.getOrganisationByUserId(userId);
        if(org == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(org, HttpStatus.OK);

        }

    }


}
