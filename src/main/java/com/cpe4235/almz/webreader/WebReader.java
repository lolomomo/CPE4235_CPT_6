/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpe4235.almz.webreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GunDesstiiniizz
 */
public class WebReader {

    private String url;

    public WebReader(String url) {
        this.url = url;
    }

    public String getHtml() throws IOException {
        InputStream inputStream = null;
        Reader reader = null;
        BufferedReader bff = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            inputStream = urlObject.openStream();
            reader = new InputStreamReader(inputStream); // convert stream into reader(chracter)
            bff = new BufferedReader(reader);

            String data;
            while ((data = bff.readLine()) != null) {
                builder.append(data);
            }
        } finally {
            if (bff != null) {
                bff.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

        }
        return builder.toString();
    }

    public Set<String> getLinks() throws IOException {
        String pattern = "href=\"(http|https)://(.*?)\"";
        Pattern compiled = Pattern.compile(pattern);
        Matcher matcher = compiled.matcher(getHtml());
        Set<String> set = new HashSet<>();
        while(matcher.find()){
            set.add(matcher.group().split("href=")[1]);
        }
        return set;
    }
}
