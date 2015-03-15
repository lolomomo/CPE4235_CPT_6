/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpe4235.almz.webreader;

import java.io.IOException;
import java.util.Set;

/**
 *
 * @author GunDesstiiniizz
 */
public class WebReaderTest {
    public static void main(String[] args) throws IOException {
        WebReader reader = new WebReader("https://www.google.co.th/");
        Set<String> links = reader.getLinks();
        for(String link : links){
            System.out.println(link);
        }
    }
    
}
