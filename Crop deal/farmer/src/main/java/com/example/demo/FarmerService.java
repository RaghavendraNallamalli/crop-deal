package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService  {
    @Autowired
    private SequenceGenerator sg;
    @Autowired
    private FarmerRepository farmerRepository;
    public List<Farmer> getAllFarmers(){
        return  farmerRepository.findAll();
    }

    public Farmer findById(String Id){

        return farmerRepository.findById(Id).get();
    }
    public Farmer AddFarmer(Farmer F){
        F.setId(sg.getSequenceNumber("Farmer_Sequence"));
        return  farmerRepository.save(F);
    }

    public Farmer updateFarmer(Farmer F){
        
            return  farmerRepository.save(F);
        
      
    }
    public String deleteById(String Id) {

        if(farmerRepository.existsById(Id)){
            farmerRepository.deleteById(Id);
            return "Deleted SuccessFully";
        }

        else {
            return "FarmerNotFound";
        }
    }
    public boolean Checkexits(String Id){
        return farmerRepository.existsById(Id);
    }

}