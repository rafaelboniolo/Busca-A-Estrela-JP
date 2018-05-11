/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aestrela.Controller;

/**
 *
 * @author nogueira
 */
public class Tools {
    
    
    
    public String getOs(){
       String os = System.getProperty("os.name");
       
       return os;
    }
    
    public String barra(){
        String barra = getOs();
        String bar;
        if(barra.equals("Linux")){
            return bar = "/";
        }else{
            
            return bar = "\\";
           
        }
    }
    public String barraSalvar(){
        String barra = getOs();
        String bar;
        if(barra.equals("Linux")){
            return bar = "/*\n";
        }else{
            
            return bar = "\\*.*\n";
           
        }
    }
    public String python(){
        String python;
        if(getOs().equals("Linux")){
            return python = "python3";
        }else{
            return python = "python";
        }
    }
    
}
