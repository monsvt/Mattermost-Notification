package com.wizeline;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Convert {

    public static String cidrToMask(String cidr) {
        try {
            if ( Integer.parseInt(cidr) < 1 || Integer.parseInt(cidr) > 32 )
                return "Invalid";
            final int bits = 32 - Integer.parseInt(cidr);
            //final int mask = (bits == 32) ? 0 : 0xFFFFFFFF - ((1 << bits) - 1); This line could take /0 as 0.0.0.0.
            final int mask = 0xFFFFFFFF - ((1 << bits) - 1);

            return (Integer.toString(mask >> 24 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 16 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 8 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 0 & 0xFF, 10));

        } catch (NumberFormatException e) {
                return "Invalid";
        }
    }

    public static String maskToCidr(String maskNetwork) throws UnknownHostException {
        if(maskNetwork.equals("0.0.0.0"))
            return "Invalid";
        try {
            InetAddress netmask = InetAddress.getByName(maskNetwork);
            byte[] netmaskBytes = netmask.getAddress();
            int cidr = 0;
            boolean zero = false;
            for (byte b : netmaskBytes) {
                int mask = 0x80;
                
                for (int i = 0; i < 8; i++) {
                    int result = b & mask;
                    if (result == 0) {
                        zero = true;
                    } else if (zero) {
                        return "Invalid";
                    } else {
                        cidr++;
                    }
                    mask >>>= 1;
                }
            }
            return String.valueOf(cidr);
        } catch (UnknownHostException e) {
            return "Invalid";
        }
        
    }

    public static Boolean ipv4Validation(String ipv4) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        
        return ipv4.matches(PATTERN);
    }
}
