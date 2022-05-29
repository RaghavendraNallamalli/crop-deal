package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;


@Document(collection = "farmers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuppressWarnings("unused")
public class Farmer {


    @MongoId
    private String id;
	private String firstName;
    private String lastName;
    private String password;
    private Date dob;
    private String email;
    private String address;

}