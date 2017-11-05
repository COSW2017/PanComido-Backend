package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.Friend;
import edu.eci.cosw.pancomido.model.PaymentMethod;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.User;
import edu.eci.cosw.pancomido.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

        if ( login.getEmail() == null || login.getUser_password() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String email = login.getEmail();
        String password = login.getUser_password();

        User user = userService.findUserByEmail(email);

        if ( user == null )
        {
            throw new ServletException( "User email not found." );
        }

        String pwd = user.getUser_password();

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

    @RequestMapping( value = "/search", method = RequestMethod.POST )
    public User searchUsersByEmail(@RequestBody String email)
            throws ServletException{
        email=email.replaceAll("\"", "");
        User u = userService.findUserByEmail(email);
        if(u == null){
            throw new ServletException( "No user found with the email address." );
        }else{
            return u;
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public User registerUser( @RequestBody User toRegister )
            throws ServletException {
        return userService.createUser(toRegister);
    }

    public class Token {
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

    @RequestMapping( value = "/update", method = RequestMethod.PUT )
    public User update( @RequestBody User user )
            throws ServletException
    {
        return userService.updateUser(user);
    }

    @RequestMapping( value = "/order/{id_order}", method = RequestMethod.GET )
    public Order getOrder(@PathVariable Integer id_order)
            throws ServletException {
        return userService.getOrder(id_order);

    }

    @RequestMapping( value = "/payment", method = RequestMethod.POST )
    public PaymentMethod addPaymentMethod(@RequestBody Integer idUser, PaymentMethod metodo)
            throws ServletException {
        return userService.addPaymentMethod(idUser, metodo);
    }

    @RequestMapping( value = "/{id_user}/order/", method = RequestMethod.PUT )
    public Order cancelOrder(@PathVariable Long id_user, @RequestBody Order order)
            throws ServletException {
        try {
            return userService.cancelOrder(order);
        } catch (PanComidoServicesException e) {
            throw new ServletException(e.getMessage());
        }
    }

    @RequestMapping( value = "/{idUser}/order", method = RequestMethod.GET )
    public List<Order> getOrdersByUser(@PathVariable Integer idUser)
            throws ServletException {
        return userService.getOrders(idUser);
    }

    @RequestMapping( value = "/friendship", method = RequestMethod.POST )
    public boolean insertPendingFriendship(@RequestBody Map<String, Integer> json)
            throws ServletException {
        return userService.addFriend(json.get("id_user"), json.get("id_friend"));
    }

    @RequestMapping( value = "/{email}/friends", method = RequestMethod.GET )
    public List<User> getFriends(@PathVariable String email)
            throws ServletException {
        return userService.getFreinds(email);
    }

    @RequestMapping( value = "/order", method = RequestMethod.POST )
    public Order addOrder(@RequestBody Order order)
            throws ServletException {
        return userService.addOrder(order);
    }

}