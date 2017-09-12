package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.model.User;
import edu.eci.cosw.pancomido.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.findUserByEmail(email);

        if ( user == null )
        {
            throw new ServletException( "User email not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( email ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @RequestMapping( value = "/items", method = RequestMethod.GET )
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping( value = "/search", method = RequestMethod.GET )
    public User searchUsersByEmail(String email)
            throws ServletException{

        User u = userService.findUserByEmail(email);
        if(u == null){
            throw new ServletException( "No user found with the email address." );
        }else{
            return u;
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public User registerUser( @RequestBody User toRegister )
            throws ServletException
    {
        return userService.createUser(toRegister);
    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
