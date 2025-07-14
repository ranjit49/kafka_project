package com.at.model;

public class Order {
    private String dishName;
    private int quantity;
    private double price;

    // Constructors
    public Order() {}
    public Order(String dishName, int quantity, double price)
    {
        this.dishName = dishName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public String getDishName()
    { 
    	return dishName; 
    }
    public void setDishName(String dishName) 
    { 
    	this.dishName = dishName;
    }

    public int getQuantity()
    { 
    	return quantity; 
    }
    public void setQuantity(int quantity)
    {
    	this.quantity = quantity;
    }

    public double getPrice()
    {
    	return price; 
    }
    public void setPrice(double price)
    { 
    	this.price = price; 
    }
}
