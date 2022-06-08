package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
class FarmerControllerTest {
    @InjectMocks
    public FarmerController farmerController= Mockito.mock(FarmerController.class);


    //Creating A Farmer
    Farmer F  = new Farmer("1","ragh","nallamalli","power",new Date(),"kamal@gmail.com"
            ,"t nagar");


    public List<Farmer> getlist(){
        // Creating A Farmer List
        List<Farmer> testfarmers = new ArrayList<Farmer>();
        testfarmers.add(F);      // adding a farmer
        Farmer s = new Farmer("2","ragh","nallamalli","power",new Date(),"kamal@gmail.com"
                ,"t nagar");
        testfarmers.add(s);
        return (testfarmers);    //generating & Returning Response

    }

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getFarmers() {
        List<Farmer> Response = getlist() ;
        when(farmerController.getFarmers()).thenReturn(Response);               //  Setting The Response
        // Getting The Response
        List<Farmer>  result = farmerController.getFarmers();
        assertThat(result).isEqualTo(Response);
        assertThat(result).isNotEqualTo(null);
    }

    @Test
    void findById() {
        List<Farmer> f = getlist();
        Farmer f1 = f.stream()
                .filter(farmer -> "2".equals(farmer.getId()))
                .findAny().orElse(null);
        assertThat(f1).isNotSameAs(F);
        assertThat(f1.getId()).isNotNull();

    }

    @Test
    void addFarmer() {
        Farmer s = new Farmer("1","ragh","nallamalli","power",new Date(),"kamal@gmail.com"
                ,"t nagar");
        when(farmerController.addFarmer(s)).thenReturn(s);
        when(farmerController.addFarmer(F)).thenReturn(null);
        Farmer result1 = farmerController.addFarmer(F);
        Farmer result = farmerController.addFarmer(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
    }

    @Test
    void updateFarmer() {
        Farmer s = new Farmer("1","ragh","nallamalli","power",new Date(),"kamal@gmail.com"
                ,"t nagar");
        when(farmerController.updateFarmer(s)).thenReturn(s);
        when(farmerController.updateFarmer(F)).thenReturn(null);
        Farmer result1 = farmerController.updateFarmer(F);
        Farmer result = farmerController.updateFarmer(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
        assertThat(result).isNotEqualTo(F);
    }

    @Test
    void deleteFarmer() {
        when(farmerController.deleteFarmer("1")).thenReturn("Deleted SuccessFully");
        when(farmerController.deleteFarmer("2")).thenReturn("NOT_FOUND");
        String result1 = farmerController.deleteFarmer("1");
        String result = farmerController.deleteFarmer("2");
        assertThat(result1).isEqualTo("Deleted SuccessFully");
        assertThat(result).isEqualTo("NOT_FOUND");
    }

    @Test
    void farmerExits() {
        List<Farmer> f = getlist();
        Farmer f1 = f.stream()
                .filter(farmer -> "1".equals(farmer.getId()))
                .findAny().orElse(null);
        assertThat(f1.toString()).isEqualTo(F.toString());
        assertThat(f1.getId()).isEqualTo("1");
    }
}