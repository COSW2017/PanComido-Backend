package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private HashMap<Long, User> users = new HashMap<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.put(0l, new User( "test@mail.com", "password", "Andres", "Perez", "https://cdn-images-1.medium.com/max/796/1*juPyda3wq9uz_SNFRLuANg@2x.png", "test", "123456" ) );
    }


    @Override
    public HashMap<Long, User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        return users.get(id);
    }

    @Override
    public User createUser( User user )
    {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User findUserByEmail( String email )
    {
        User found = null;
        for(int i = 0 ; i < users.size() && found == null; i++){
            User u = users.get(i);
            if(u.getEmail().equals(email)){
                found = u;
            }
        }
        return found;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        User found = null;
        for(int i = 0 ; i < users.size() && found == null; i++){
            User u = users.get(i);
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                found = u;
            }
        }
        return found;
    }

    @Override
    public User updateUser(User user) {
        User oldUser = this.findUserByEmail(user.getEmail());
        oldUser.setCellphone(user.getCellphone());
        oldUser.setCity(user.getCity());
        oldUser.setPassword(user.getPassword());
        oldUser.setImage(user.getImage());
        return oldUser;
    }

    @Override
    public Boolean addFriend(Long user, Long friend) {
        User user1 = this.getUser(user);
        User user2 = this.getUser(friend);
        List<User> pending1 = user1.getPendingFriends();
        boolean retval = false;
        if(!pending1.contains(user2)) {
            pending1.add(user2);
            retval = true;
        }

        return retval;

    }

    //Pensar si es mejor pasar las ordenes del usuario a un HashMap
    @Override
    public Order getOrder(Long id_user, Integer id_order) {
        List<Order> orders = getUser(id_user).getOrders();
        Boolean found = false;
        Order order = null;
        for(int i = 0; i < orders.size() & !found;i++){
            if(orders.get(i).getId() == id_order){
                order=orders.get(i);
                found = true;
            }
        }
        return order;
    }

}
