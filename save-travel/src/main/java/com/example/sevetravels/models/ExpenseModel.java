package com.example.sevetravels.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class ExpenseModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull(message = "Name may not be null")
    @Size(min = 5, max = 20)
    private String name;
    
    @NotNull (message = "Vendor may not be null")
    @Size(min = 5, max = 20)
    private String vendor;
    
    @NotNull(message = "Amount may not be null")
    private double amount;
    
    @NotBlank
    @Size(min = 5, max = 200)
    private String description;
    
    public ExpenseModel() {}
    
    
    
    
    // GETTERS & SETTERS
    public Long getId() {
		return id;
	}
       
	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getVendor() {
		return vendor;
	}



	public void setVendor(String vendor) {
		this.vendor = vendor;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
