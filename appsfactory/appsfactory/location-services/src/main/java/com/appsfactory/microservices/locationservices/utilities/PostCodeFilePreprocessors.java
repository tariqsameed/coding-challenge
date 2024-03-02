package com.appsfactory.microservices.locationservices.utilities;

import org.springframework.stereotype.Component;

@Component
public class PostCodeFilePreprocessors {

    public String removeTrailingAndLeadingCharacters(String value){

        if(value.length() > 0 && value != null){
            StringBuilder builder = new StringBuilder(value);
            if(builder.length() > 0)
                builder.deleteCharAt(0);

            if(builder.length() > 0)
                builder.deleteCharAt(builder.length() - 1);

            if(builder.length() > 0)
                builder.deleteCharAt(0);

            return builder.toString();
        }
        return "";
    }

    public String getCountryISOPreprocessedValue(String value){

        if(value.length() > 0 && value != null){
            StringBuilder builder = new StringBuilder(value);
            if(builder.length() > 0)
                builder.deleteCharAt(0);

            if(builder.length() > 0)
                builder.deleteCharAt(builder.length() - 1);

            return builder.toString();
        }
        return "";
    }

    public String getPostLietZahlValue(String value){

        return value.replaceAll("[^0-9]", "");
    }
}
