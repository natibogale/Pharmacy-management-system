/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

/**
 *
 * @author NathanaelB
 */
public class med {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private String id;	
    private String medname;	
    private String type;	
    private String dose;	
    private int quantity;	
    private float price;	
    private String expiration;	
    private String description;
    
    public med(String id,String medname,String type,String dose, int quantity,float price,String expiration,String description	)
    {
        this.id= id;
        this.medname=medname;
        this.type=type;
        this.dose=dose;
        this.quantity=quantity;
        this.price=price;
        this.expiration=expiration;
        this.description=description;
    }
   
   public void medd(String id,String medname,String type,String dose, int quantity,float price,String description)
    {
        this.id= id;
        this.medname=medname;
        this.type=type;
        this.dose=dose;
        this.quantity=quantity;
        this.price=price;
        this.description=description;
    }
}
