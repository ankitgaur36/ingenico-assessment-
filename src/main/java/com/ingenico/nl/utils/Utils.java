package com.ingenico.nl.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.log4j.Logger;


public class Utils {
	
	 //zero amount with scale 4 and financial rounding mode
    public static final BigDecimal zeroAmount = new BigDecimal(0).setScale(4, RoundingMode.HALF_EVEN);
    static Logger log = Logger.getLogger(Utils.class);  
    

}