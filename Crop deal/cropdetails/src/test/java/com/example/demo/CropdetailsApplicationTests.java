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
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CropControllerTest {

	@InjectMocks
	public CropController CropController= Mockito.mock(CropController.class);

	Crop F =new Crop("1","1","Apple",100,5,"tons");

	public List<Crop> getlist(){

		Crop s = new Crop("2","1","Apple",100,5,"tons");
		Crop p = new Crop("3","2","Grapes",80,15,"tons");
		// Creating A Crop List
		List<Crop> testCrops = new ArrayList<Crop>();
		testCrops.add(F);      // adding a Crop
		testCrops.add(s);
		testCrops.add(p);
		return  (testCrops);    //generating & Returning Response
	}

	@Test
	public void getCrops(){
		List<Crop> result = getCropsdetails();
		when(CropController.getCrops()).thenReturn(result);
		List<Crop> Response = CropController.getCrops();
		assertThat(Response).isNotNull();
		assertThat(Response).isEqualTo(result);

	}
	public List<Crop> getCropsdetails(){

		List<Crop> testCrops = new ArrayList<Crop>();
		testCrops.add(F);
		Crop s = new Crop("2","1","Apple",100,5,"tons");
		testCrops.add(s);
		Crop k = new Crop("2","1","Apple",100,5,"tons");
		testCrops.add(k);
		return testCrops;
	}



//	@Test
//	void getListByFarmerId() {
//		List<Crop> f = getList().stream().filter(
//				crop -> crop.getFarmerid().equals("1")).collect(Collectors.toList());
//		when(CropController.getListByFarmerId("1")).thenReturn(f);               //  Setting The Response
//		when(CropController.getListByFarmerId("3")).thenReturn("NO_CONTENT");
//		// Getting The Response
//		ResponseEntity<List<Crop>>  result = CropController.getListByFarmerId("1");
//		ResponseEntity<List<Crop>>  result1 = CropController.getListByFarmerId("3");
//		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(result1.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//		assertThat(result.getBody().toString()).isEqualTo((f.toString()));
//	}

//	@Test
//	void getListByname() {
//		ResponseEntity<List<Crop>> Response = getlist() ;
//		List<Crop> f = Response.getBody().stream().filter(
//				crop -> crop.getName().equals("Apple")).collect(Collectors.toList());
//		when(CropController.getListByname("Apple")).thenReturn(new ResponseEntity<>(f,HttpStatus.OK));               //  Setting The Response
//		when(CropController.getListByname("Grapes")).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
//		// Getting The Response
//		ResponseEntity<List<Crop>>  result = CropController.getListByname("Apple");
//		ResponseEntity<List<Crop>>  result1 = CropController.getListByname("Grapes");
//		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(result1.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//		assertThat(result.getBody().toString()).isEqualTo((f.toString()));
//	}
//
//
	@Test
	void findById() {
		List<Crop> f = getlist();
		Crop f1 = f.stream()
				.filter(Crop -> "2".equals(Crop.getId()))
				.findAny().orElse(null);
		assertThat(f1).isNotSameAs(F);
		assertThat(f1.getId()).isNotNull();
	}

	@Test
	void addCrop() {
		Crop s = new Crop("4","2","Apple",1000,5,"tons");
		when(CropController.addCrop(s)).thenReturn(s);
		when(CropController.addCrop(F)).thenReturn(null);
		Crop result1 = CropController.addCrop(F);
		Crop result = CropController.addCrop(s);
		assertThat(result).isEqualTo(s);
		assertThat(result1).isNull();
	}

	@Test
	void updateCrop() {
		Crop s = new Crop("4","2","Apple",100,3,"tons");
		when(CropController.updateCrop(s)).thenReturn(s);
		when(CropController.updateCrop(F)).thenReturn(null);
		Crop result1 = CropController.updateCrop(F);
		Crop result = CropController.updateCrop(s);
		assertThat(result).isEqualTo(s);
		assertThat(result1).isNull();
		assertThat(result).isNotEqualTo(F);
	}

	@Test
	void deleteCrop() {
		when(CropController.deleteCrop("1")).thenReturn("Deleted SuccessFully");
		when(CropController.deleteCrop("2")).thenReturn("NOT_FOUND");
		String result1 = CropController.deleteCrop("1");
		String result = CropController.deleteCrop("2");
		assertThat(result1).isEqualTo("Deleted SuccessFully");
		assertThat(result).isEqualTo("NOT_FOUND");
	}
}