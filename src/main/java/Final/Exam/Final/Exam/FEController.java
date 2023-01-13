package Final.Exam.Final.Exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import Final.Exam.Final.Exam.Jpa.JpaController;
import Final.Exam.Final.Exam.model.entity.kk;

/**
* @author Muhammad Farid Gilang Nuswantoro 20200140065
*/ 

@RestController("/KK")
@CrossOrigin
public class FEController{

    kk mykk = new kk();
    JpaController jctrl = new JpaController();

    @GetMapping("{id}")
    public String getId()
    {
        try{
            mykk = jctrl.findId(1);
        }
        catch (Exception e){

        }
    }

    @GetMapping
    public List<kk> getAll(){

        List<kk> dcy = new ArrayList();
        try{
            dcy =jctrl.findkkEntities();
        }
        catch (Exception e){
            dcy = List.of();
        }
        return dcy;        
    }
    @PostMapping()
    public String createkk(HttpEntity<String> obj){

        String message ="";

        try{
            String json_receive = pkt.getBody();
            ObjectMapper map =new ObjectMapper();
            kk newkk = new kk();
            
            newkk = map.readvalue(json_receive, kk.class);

            jctrl.create(newkk);
            message = newkk.getNama() + "Saved";
        }
        catch (Exception e) {
            message = "error";
        }

        return message;
    }
    @PutMapping()
    public String editkk(HttpEntity<String> obj){
        String message = "";
        try{
            String json_receive = obj.getBody();
            ObjectMapper map = new ObjectMapper();

            kk newkk = new kk();
            
            newkk = map.readValue(json_receive, kk.class);
            jctrl.edit(newkk);
            message = newkk.getNama() + "updated";
        }catch (Exception e){}
        return message;
    }
    @DeleteMapping()
    public String deletekk(HttpEntity<String> obj) {
        String message ="";
        
        try {
            String json_receive = obj.getBody();
            ObjectMapper map = new ObjectMapper();

            kk newkk = new kk();

            newkk = map.readValue(json_receive, kk.class);
            jctrl.destroy(newkk.getId());

            message = "Deleted";
        } catch (Exception e) {
            // TODO: handle exception
        }

        return message;
    }
}