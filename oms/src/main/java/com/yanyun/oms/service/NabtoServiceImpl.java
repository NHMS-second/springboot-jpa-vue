package com.yanyun.oms.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class NabtoServiceImpl implements NabtoService {

    private String URL = "https://api.cloud.nabto.com/v1/";

    private Client c;

    public NabtoServiceImpl(){
        c = Client.create();
    }

    public void getBuilder(){
        WebResource r = c.resource(URL);
        WebResource.Builder b = r.getRequestBuilder();
        b.header("Authorization","Bearer "+"L84sP4mHtWX4I2BmSCdwrVzgDuMtvfQRcJZFFYPZdzksHYoCUQDrNbdfOCRUnyOz");
    }

}
