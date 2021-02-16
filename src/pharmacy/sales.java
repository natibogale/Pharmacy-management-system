/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;


public class sales {
    String medicine_id;
    int sold_quantity;
    float total;
    String sold_by;
    String sold_on;
public sales(  String medicine_id,
    int sold_quantity,
    float total,
    String sold_by,
    String sold_on)
{
    
    this.medicine_id = medicine_id;
    this.sold_quantity = sold_quantity;
    this.total = total;
    this.sold_by=sold_by;
    this.sold_on=sold_on;
}
    public String getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(String medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getSold_by() {
        return sold_by;
    }

    public void setSold_by(String sold_by) {
        this.sold_by = sold_by;
    }

    public String getSold_on() {
        return sold_on;
    }

    public void setSold_on(String sold_on) {
        this.sold_on = sold_on;
    }

}
