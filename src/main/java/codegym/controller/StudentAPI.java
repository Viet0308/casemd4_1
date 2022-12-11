package codegym.controller;

import codegym.model.Student;
import codegym.service.impl.IStudentService;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static codegym.controller.SlackAPI.web_hook_url;

@RestController
@CrossOrigin("*")
@RequestMapping("students")
public class StudentAPI {
    @Autowired
    IStudentService iStudentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity save(@RequestBody Student student){

        iStudentService.save(student);

        SendEmailAPI sendEmailAPI = new SendEmailAPI();

        sendEmailAPI.sendMail( student.getName(), "chuc mung ban da dang ki thanh cong", "Tai khoan va mat khau " + student.getName() +" " + student.getImg());

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(web_hook_url);

        try {
            String json = "{Xin chuc mung, ban vua dang ki thanh cong tai hoan moi}";
            System.out.println(json);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            client.execute(httpPost);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/fee")
    public ResponseEntity<List<Student>> findStudentExpireFee(){
        List<Student> data = iStudentService.findStudentExpireFee();
        System.out.println(data);
        for (Student student:data) {
            SendEmailAPI sendEmailAPI = new SendEmailAPI();
            sendEmailAPI.sendMail( student.getName(), "Hoc phi qua han", "Ban den han dong hoc phi roi");
        }

        return new ResponseEntity<>(iStudentService.findStudentExpireFee(), HttpStatus.OK);
    }




    @GetMapping("/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name){
        return new ResponseEntity<>(iStudentService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/avg-score")
    public ResponseEntity<List<Student>> getStudentAvgScore(){
        return new ResponseEntity<>(iStudentService.getClassAvgScores(), HttpStatus.OK);
    }

    @GetMapping ("/edit/{id}")
    public  ResponseEntity<Student> edit(@PathVariable Long id ){
        return new ResponseEntity<>(iStudentService.findById(id),HttpStatus.OK);
    }
    @PostMapping ("/edit")
    public ResponseEntity<Student> update(@RequestBody Student student ){
        iStudentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id ){
        iStudentService.delete(id);
    }
}
