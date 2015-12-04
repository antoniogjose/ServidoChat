/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidochat;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class BaseDados {
    
     private ArrayList<Cliente> clientes = new ArrayList<>();
     
     
     
     
     public void AdicionaCliente(Cliente x){
         
         clientes.add(x);   
     }
     
     
      public void RemoveCliente(Cliente x){
         
         clientes.remove(x);
     }
     
    
}
