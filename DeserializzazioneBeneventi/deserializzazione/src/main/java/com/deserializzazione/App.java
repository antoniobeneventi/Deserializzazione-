package com.deserializzazione;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        File file = new File("src/main/java/com/deserializzazione/classe.xml");
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);

        System.out.println("La classe"+value.getClasse() + value.getSpecializzazione() + "si trova nell'aula" + value.getAula().getNome()+" dai seguenti studenti");
            for(int i=0;i<value.getStudenti().size();i++)
            {
                System.out.println(" - " + value.getStudenti().get(i).getCognome());

    }
    //serializzazione
    String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
    System.out.println(xml);

    //json deserializzazione
     ObjectMapper mapper= new ObjectMapper();
     String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
     System.out.println(json);

    //json serializzazione
    
    root user = mapper.readValue(json,root.class);
    System.out.println("La classe"+value.getClasse() + value.getSpecializzazione() + "si trova nell'aula" + value.getAula().getNome()+" dai seguenti studenti");

}
}
