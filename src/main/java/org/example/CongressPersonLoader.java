package org.example;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;


public class CongressPersonLoader {
    public static CongressPerson[] load_from_file(String file_path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  //this will let our code work even if we don't write properties for every single field from the file
        mapper.registerModule(new JavaTimeModule()); //this will let us use LocalDate properties
        InputStream Congress_resource_location = CongressPersonLoader.class.getResourceAsStream(file_path);

        CongressPerson[] memberList = mapper.readValue(Congress_resource_location, CongressPerson[].class);
        return memberList;

    }
}
