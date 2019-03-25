
import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Proveedor;
import com.mycompany.soshome2.utils.Utils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manga
 */
public class jwtutils {
    
    
    static String crearTokenC(Cliente cli) throws NoSuchAlgorithmException{
       
      return "";  
    }
    
    static String crearTokenP(Proveedor p){
        String c =Utils.toJson(p);
      return "";  
    }
}
