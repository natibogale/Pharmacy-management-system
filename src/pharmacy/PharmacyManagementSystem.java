/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import static pharmacy.progress.prog;


public class PharmacyManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
                 //login1 tg = new login1();
      progress rt = new progress();
        try
    {
        rt.setVisible(true);
        for(int x=0;x<=100;x++)
        {
            Thread.sleep(10);
            prog.setValue(x);
        }
          //rt.setVisible(false);
         
       login1 th = new login1();
       th.setVisible(true);
      //admin_window ad = new admin_window();
      //ad.setVisible(true);
        //employeew ep = new employeew();
        //ep.setVisible(true);
    }
        
    catch(Exception e)
    {
        
    }
        finally
        {
            rt.setVisible(false);
        }
        
        
        
        
    }
    
}
