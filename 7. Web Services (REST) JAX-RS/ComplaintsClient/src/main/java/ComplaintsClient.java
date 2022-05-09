
import entities.Complaint;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.glassfish.jersey.client.ClientConfig;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author Bartek
 */
public class ComplaintsClient {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        config.register(new ObjectMapper().registerModule(new JavaTimeModule()));
        Client client = ClientBuilder.newClient(config);
        
        String count =
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints/count")
            .request(MediaType.TEXT_PLAIN)
            .get(String.class);

        System.out.println("Count: " + count);

        Complaint[] complaints = client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .request(MediaType.APPLICATION_JSON)
            .get(Complaint[].class);
        System.out.println("All complaints: ");
        for (int i = 0; i < complaints.length; i++) {
            System.out.println(complaints[i].getComplaintText());
        }

        Complaint complaint = client.target("http://localhost:8080/Complaints/" + "resources/complaints/100")
            .request(MediaType.APPLICATION_JSON)
            .get(Complaint.class);
        System.out.println("Complaint nr 100: " + complaint.getComplaintText());
        
        complaint.setStatus("closed");
        client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .request(MediaType.APPLICATION_JSON)
            .put(Entity.json(complaint));
        
        Complaint[] openedComplaints = client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .queryParam("status", "open")
            .request(MediaType.APPLICATION_JSON)
            .get(Complaint[].class);
        System.out.println("All open complaints: ");
        for (int i = 0; i < openedComplaints.length; i++) {
            System.out.println(openedComplaints[i].getComplaintText());
        }
        client.close();
    }
}
