package org.mammadov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class Communication {
    @Autowired
    RestTemplate restTemplate;
    private final String URL="http://localhost:8080/springREST_war_exploded/child";
    public List<Child> getChildren(){
        ResponseEntity<List<Child>> response=restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Child>>() {});
        return response.getBody();
    };
    public void deleteChild(int id){
        restTemplate.delete(URL+"/"+id);

    };
    public void saveChild(Child child){
        if(child.getId()==0) {
            ResponseEntity<String> response = restTemplate.postForEntity(URL, child, String.class);
            System.out.println("saved");
            System.out.println(response.getBody());
        }else {
            restTemplate.put(URL, child);
            System.out.println("updated");
        }
    };
    public Child getChildById(int id){
     Child child=restTemplate.getForObject(URL+"/"+id,Child.class);
     return child;
    };
}
