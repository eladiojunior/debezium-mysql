package br.com.eladiojunior.debezium.infra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date toDate(String stringDate) {
        Date date = null;
        try {
            date = (java.util.Date)dateFormat.parse(stringDate);
        } catch (ParseException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
        return date;
    }
}
