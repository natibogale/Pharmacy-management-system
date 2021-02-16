/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;


public class myex extends Exception
{
    public myex(String a)
    {
      super(a);  
    }
    
    
    public static void exception (String age)throws myex
    {
        if(!age.matches("^\\d+(\\.\\d+)?"))
        {
            throw new myex("Age can only be a number!");
        }
    }
    
}
