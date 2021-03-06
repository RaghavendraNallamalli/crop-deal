package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private com.example.demo.AdminService AdminService;

    //Returns the data of The Admin by using id
    @GetMapping("/{Id}")
    public Admin findById(@PathVariable String Id) {
        return AdminService.findById(Id);
    }

    //Adds the Admin into the database
    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin s) {
        return AdminService.addAdmin(s);
    }

    //Updates the Admin data
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin s) {
        return AdminService.updateAdmin(s);
    }

    @GetMapping("/getdetails/{Id}")
    public User admindetails(@PathVariable String Id) {
        return  AdminService.getdetails(Id);
        }

    //Deletes the Admin data by using id
    @DeleteMapping("/delete/{Id}")
    public String deleteAdmin(@PathVariable String Id){
        return AdminService.deleteById(Id);
    }
}