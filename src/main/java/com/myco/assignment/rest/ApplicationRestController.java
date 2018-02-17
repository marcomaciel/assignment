/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myco.assignment.rest;

import com.myco.assignment.entity.MessageDataDAO;
import com.myco.assignment.service.DiffService;
import java.util.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to provide the REST ending points
 *
 * @author Marco Maciel
 */
@RestController()
@RequestMapping("/v1/diff/{id}")
public class ApplicationRestController {
        
    DiffService diffService = new DiffService();
    MessageDataDAO messageDAO = new MessageDataDAO();
    String messageDecoded = null;
    
    /**
     * Get the result of comparison between the left and right data of a MessageData
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "")
    public String getDiffResultById(@PathVariable(value = "id") final String id) {
            return diffService.getMessageDataDifferences(id);
    }
    
    /**
     * Service to show the content of a MessageData object by Id
     * 
     * @param id Id of the message
     * @return String with the content of a MessageData object
     */
    @GetMapping(value = "/data")
    public String getMessageDataById(@PathVariable(value = "id") final String id) {
            return diffService.getMessageDataById(id).toString();
    }
    
    /**
     * Provides the service used to save the right value
     * 
     * @param id
     * @param data
     * @return
     */
    @PostMapping(value = "/right")
    public Boolean saveRightData(@PathVariable(value = "id") String id, @RequestBody byte[] data) { 
        //messageDecoded = decodeData(data);
        //diffService.saveRightData(id, decodeData(data));
        return diffService.saveRightData(id, decodeData(data));
    }
    
    /**
     * Provides the service used to save the left value
     * 
     * @param id Id of the message
     * @param data Data of the left message
     * @return
     */
    @PostMapping(value = "/left")
    public Boolean saveLeftData(@PathVariable(value = "id") String id, @RequestBody byte[] data) { 
        //messageDecoded = decodeData(data);
        //diffService.saveLeftData(id, messageDecoded);
        return diffService.saveLeftData(id, decodeData(data));
    }    
    
    /**
     * Used to decode Base64 value
     * 
     * @param encodedValue Base64 value
     * @return Decoded value
     */
    private String decodeData(final byte[] encodedValue) {
        return new String(Base64.getDecoder().decode(encodedValue));
    }
}
