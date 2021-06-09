/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.account.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author gevorga
 */
@Service
public class Client {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ADRESS_ALL_ADRESS = "http://account:9091/api/v2/accounts/getAllUsers";

}
