package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FarmerController {
    @Autowired
    private FarmerService farmerService;
//    @GetMapping("/f")
//    public String s() {
//    	return "hello";
//    }
    @GetMapping("/farmers")
    public List<Farmer> getFarmers() {
        return farmerService.getAllFarmers();
    }

    @GetMapping("/farmer/{Id}")
    public Farmer findById(@PathVariable String Id) {
        return farmerService.findById(Id);
    }

    @PostMapping("/farmer/add")
    public Farmer addFarmer(@RequestBody Farmer s) {
        return farmerService.AddFarmer(s);
    }

    @PutMapping("/farmer/update")
    public Farmer updateFarmer(@RequestBody Farmer s) {
        return farmerService.updateFarmer(s);
    }
    @GetMapping("/getdetails/{Id}")
    public User Farmerdetails(@PathVariable String Id) {
        return farmerService.getdetails(Id);
    }

    @DeleteMapping("/farmer/delete/{Id}")
    public String deleteFarmer(@PathVariable String Id){
        return farmerService.deleteById(Id);
    }

    @GetMapping("/farmer/check/{Id}")
    public Boolean FarmerExits(@PathVariable String Id)
    {return farmerService.Checkexits(Id);}

}