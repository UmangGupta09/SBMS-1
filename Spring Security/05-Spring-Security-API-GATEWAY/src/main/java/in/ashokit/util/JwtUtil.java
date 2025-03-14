package in.ashokit.util;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";
	
	  public void validateToken(String token) {
	     
	        Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token);
	    }

	  private SecretKey getSignKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
}
