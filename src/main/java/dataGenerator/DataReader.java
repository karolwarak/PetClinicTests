package dataGenerator;

import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class DataReader {

        /*ObjectMapper mapper = new ObjectMapper();

        // read data from json using array without special class
        Owner[] owners = mapper.readValue(new File("testData.json"), Owner[].class);

        System.out.println(owners);

        for(int i = 0; i < owners.length; i++){
            System.out.println(owners[i]);
        }*/

        /*
        for(Owner o : owners.getTestObjects()){
        System.out.println(o);
        }*/

        Owner oneOwner;
        Random random = new Random();
        ObjectMapper mapper = new ObjectMapper();

        public Owner randomOwnerObjectFromJson(){

        try {

            //read data from json using list and special class ListOfOwners
            ListOfOwners owners = mapper.readValue(new File("testData.json"), ListOfOwners.class);

            oneOwner = owners.getTestObjects()
                    .get(random.nextInt(owners.getTestObjects().size()));

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oneOwner;
    }
}
