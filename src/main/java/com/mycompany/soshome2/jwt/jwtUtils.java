/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.jwt;

import com.mycompany.soshome2.utils.Utils;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

/**
 *
 * @author manga
 */
public class jwtUtils {

    static  RsaJsonWebKey rsaJsonWebKey;

    public jwtUtils() throws JoseException {
        this.rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        rsaJsonWebKey.setKeyId("k1");
    }
         
    
    static String createToken (Object c) throws JoseException{
        
         
         JwtClaims claims = new JwtClaims();
         claims.setIssuer("Issuer");
         claims.setAudience("Audience");
         claims.setExpirationTimeMinutesInTheFuture(200);
         claims.setGeneratedJwtId();
         claims.setIssuedAtToNow();
         claims.setNotBeforeMinutesInThePast(2);
         claims.setSubject("validar");
         claims.setClaim("usuario", Utils.toJson(c));
         
         
         JsonWebSignature jws = new JsonWebSignature();
         
         jws.setPayload(claims.toJson());
         jws.setKey(rsaJsonWebKey.getPrivateKey());
         jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
         jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_PSS_USING_SHA256);
         String jwt = jws.getCompactSerialization();
         
        return jwt;
    }
    
    
    static String readToken(String jwt){
       
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setAllowedClockSkewInSeconds(30)
                .setRequireSubject()
                .setExpectedIssuer("Issuer")
                .setExpectedAudience("Audience")
                .setVerificationKey(rsaJsonWebKey.getKey())
                .setJwsAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST, AlgorithmIdentifiers.RSA_PSS_USING_SHA256))
                .build();
        
        try{
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            return "validaton success";
        }
        catch(InvalidJwtException e){
            
            return e.getMessage();
            
        }
               
        
    }
}
