package com.falcongames.utils;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.falcongames.constant.SystemConstant;


public class JWTToken {
	
	
	public static String createJWT(String userId, String role, byte[] secretKey) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
            .setSubject(userId)
            .claim("role", role)
            .setIssuedAt(new Date(currentTimeMillis))
            .setExpiration(new Date(currentTimeMillis + SystemConstant.EXPIRATION_TIME)) // Thời gian hết hạn: 
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }
	
	public static Claims parseJWT(String jwtToken, byte[] secretKey) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
        } catch (ExpiredJwtException e) {
        	System.out.println(e.getMessage());
            System.out.println("JWT Token hết hạn.");
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            System.out.println("Lỗi xác thực JWT.");
        }
        return null;
    }

}
