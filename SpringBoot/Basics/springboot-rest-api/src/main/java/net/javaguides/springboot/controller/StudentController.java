package net.javaguides.springboot.controller;



import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    //Returns Java Beans as JSON
@GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Deepak",
                "Kumar");
        return ResponseEntity.ok(student);

    }
//@GetMapping("students")
@GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students= new ArrayList<>();
        students.add(new Student(
                1,"Deepak","Kumar"));
        students.add(new Student(
                2,"Atharva","Kumar"));
        students.add(new Student(
                3,"Suraj","Kumar"));
        students.add(new Student(
                4,"Aashish","Kumar"));
        //return new ResponseEntity<>(students,HttpStatus.OK);
    return ResponseEntity.ok(students);
    }

    //Spring Boot Rest API with Path Variables.
    //{id} URI Template variable
    //@PathVariable is used on a method argument to Bind it to the value of a URI template variable
    //http://localhost:8080/students/1
//@GetMapping("students/{id}")
@GetMapping("{id}")
    public  ResponseEntity<Student> studentPathVariable(@PathVariable  int id){
        //return new Student(id,"Deepak","Kumar");
        Student student=new Student(id,"Deepak","Kumar");
        return ResponseEntity.ok(student);
    }

   //Spring Boot Rest API with @RequestParam
    //http://localhost:8080/students/query?id=1&firstName="Deepak"&lastName="Kumar"

   @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable (@RequestParam  int id,
                                           @RequestParam String firstName,
                                           @RequestParam  String lastName){
        //return new Student(id,"Deepak","Kumar");
       Student student= new Student(id,firstName,lastName);
       return ResponseEntity.ok(student);

   }
//Spring Boot RestAPI that handles HTTP Post request
// @PostMapping and @RequestBody
//@RequestBody is responsible for retrieving the HTTP request body and automatically converting it to the Java Object
//@PostMapping is used for mapping HTTP Post request onto specific handler method
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("ID :"+ student.getId());
        System.out.println("FirstName :"+ student.getFirstName());
        System.out.println("LastName :"+ student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
//Spring Boot Rest API that handles HTTP Put request(Updating existing resource)
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println("FirstName :"+ student.getFirstName());
        System.out.println("LastName :"+ student.getLastName());
        return ResponseEntity.ok(student);
    }
//Spring Boot Rest API that handles HTTP Delete request(Deleting existing resource)
   @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
       System.out.println(studentId);
                return ResponseEntity.ok("Student deleted successfully");
    }

}
