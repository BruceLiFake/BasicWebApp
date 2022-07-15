package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        else if (query.contains("name")) {
           return "BruceLiFake";
        }
        else if (query.contains("largest")) {
            query = query.substring(query.indexOf(':') + 1);
            String[] temp = query.split(",");
            int result = 0;
            int stringValue = 0;
            for (String s: temp) {
                s = s.trim();
                stringValue = Integer.parseInt(s);
                if (stringValue > result) {
                    result = stringValue;
                }
            }
            return String.valueOf(result);
        }
        else if (query.contains("plus")) {
            query = query.substring(query.indexOf('s') + 1);
            String[] temp =  query.split("plus");
            int result = 0;
            for (String s: temp) {
                s = s.trim();
                result += Integer.parseInt(s);
            }
            return String.valueOf(result);
        }
        else if (query.contains("multiplied")) {
            String number1 = query.substring(query.indexOf('s') + 1).trim();
            String number2 = query.substring(query.indexOf('y') + 1).trim();
            int result = Integer.parseInt(number1) * Integer.parseInt(number2);
            return String.valueOf(result);
        }
        else {
            return "";
        }
    }
}
