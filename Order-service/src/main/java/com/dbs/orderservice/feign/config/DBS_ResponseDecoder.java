package com.dbs.orderservice.feign.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class DBS_ResponseDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return null;
    }
}
