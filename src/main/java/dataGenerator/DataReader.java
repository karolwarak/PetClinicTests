package dataGenerator;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class DataReader {
    public static void main(String[] args) throws IOException {

/*        ObjectMapper mapper = new ObjectMapper();

        // read data from json using array without special class
        Owner[] owners = mapper.readValue(new File("testData.json"), Owner[].class);

        System.out.println(owners);

        for(int i = 0; i < owners.length; i++){
            System.out.println(owners[i]);
        }*/

        ObjectMapper mapper = new ObjectMapper();

        //read data from json using list and special class ListOfOwners
        ListOfOwners owners = mapper.readValue(new File("testData.json"), ListOfOwners.class);

        for(Owner o : owners.getTestObjects()){
            System.out.println(o);
        }


    }
}
