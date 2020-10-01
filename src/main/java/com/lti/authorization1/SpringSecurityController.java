package com.lti.authorization1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.authorization1.Model.AuthenticationResponse;
import com.lti.authorization1.Model.AuthenticationRequest;
import com.lti.authorization1.Util.JwtUtil;
import com.lti.authorization1.service.MyUserDetailsService;


@RestController
public class SpringSecurityController {
@Autowired
private MyUserDetailsService myuserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil JwtTokenUtil;
	    @RequestMapping("/hello")
		public String hello() {
			return "Hello World";
		}
	    @GetMapping("/")
	    public String home() {
	        return ("<h1>Welcome</h1>");
	    }

	    @GetMapping("/user")
	    public String user() {
	        return ("<h1>Welcome User</h1>");
	    }

	    @GetMapping("/admin")
	    public String admin() {
	        return ("<h1>Welcome Admin</h1>");
	    }
	
	@RequestMapping(value= "/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
	} catch (BadCredentialsException e) {
		// TODO: handle exception
		throw new Exception("invalid username or passord",e);
	}
	final UserDetails userDetails= myuserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	final String jwt=JwtTokenUtil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticationResponse(jwt));
	
	
	}
}


