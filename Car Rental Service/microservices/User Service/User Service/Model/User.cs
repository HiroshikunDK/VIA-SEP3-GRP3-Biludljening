﻿using System.ComponentModel.DataAnnotations;

namespace User_Service;
public class User
{
 
    public int id { get; set; }
        
    public string userName { get; set; }
        
    public string email { get; set; }
        
    public string password { get; set; }  
        
    public string role { get; set; }
    
   

  
}