package com.arolla.train.services;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by aminebechraoui, on 10/02/2021, in com.arolla.train.services
 */
public class BookingRefService {
    public String generateRef() {
        return RandomStringUtils.random(7, true, true);
    }
}
