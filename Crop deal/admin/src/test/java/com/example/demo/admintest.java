package com.example.demo;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AdminControllerTest {

    @InjectMocks
    public AdminController AdminController= Mockito.mock(AdminController.class);



    Admin F =new Admin("1","ragh","lll","ragh@mail.com");

    public List<Admin> getlist(){
        // Creating A Admin List
        List<Admin> testAdmins = new ArrayList<Admin>();
        testAdmins.add(F);      // adding a Admin
        Admin s = new Admin("2","kamal","ll","kamal@mail.com");
        testAdmins.add(s);
        return (testAdmins);    //generating & Returning Response
    }
    @Test
    void findById() {
        List<Admin> f = getlist();
        Admin f1 = f.stream()
                .filter(Admin -> "2".equals(Admin.getId()))
                .findAny().orElse(null);
        assertThat(f1).isNotSameAs(F);
        assertThat(f1.getId()).isNotNull();

    }

    @Test
    void addAdmin() {
        Admin s = new Admin("3","ragh","ll","ragh@mail.com");
        when(AdminController.addAdmin(s)).thenReturn(s);
        when(AdminController.addAdmin(F)).thenReturn(null);
        Admin result1 = AdminController.addAdmin(F);
        Admin result = AdminController.addAdmin(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
    }

    @Test
    void updateAdmin() {
        Admin s = new Admin("1","ragh","ll","ragh@mail.com");
        when(AdminController.updateAdmin(s)).thenReturn(s);
        when(AdminController.updateAdmin(F)).thenReturn(null);
        Admin result1 = AdminController.updateAdmin(F);
        Admin result = AdminController.updateAdmin(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
        assertThat(result).isNotEqualTo(F);
    }



    @Test
    void deleteAdmin() {
        when(AdminController.deleteAdmin("1")).thenReturn("Deleted SuccessFully");
        when(AdminController.deleteAdmin("2")).thenReturn("NOT_FOUND");
        String result1 = AdminController.deleteAdmin("1");
        String result = AdminController.deleteAdmin("2");
        assertThat(result1).isEqualTo("Deleted SuccessFully");
        assertThat(result).isEqualTo("NOT_FOUND");
    }
}