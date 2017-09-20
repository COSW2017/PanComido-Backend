package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private RestaurantService restaurantService;

    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        User user = new User( "test@mail.com", "password", "Andres", "Perez", "https://cdn-images-1.medium.com/max/796/1*juPyda3wq9uz_SNFRLuANg@2x.png", "test", "123456" );
        ArrayList<Dish> dishes = new ArrayList<>();
        Dish dish = new Dish(0, "Pollo", 25000, "un pollo muy rico");
        dishes.add(dish);
        ArrayList<User> userss = new ArrayList<>();
        userss.add(user);
        Order order = new Order(0, new ArrayList<>(), new ArrayList<>(), dishes, 0);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        Restaurant restaurant = new Restaurant(0, "Perter pan", 1.12, 2.36, 5, 2, 3, 1, orders, new ArrayList<>());
        user.setRestaurant(restaurant);
        users.put(0l, user);

        restaurantService.addRestaurant(restaurant);
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
        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            Long key = entry.getKey();
            User value = entry.getValue();
            if(value.getEmail().equals(email)) {
                found = value;
                break;
            }
        }
        return found;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        User found = null;
        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            Long key = entry.getKey();
            User value = entry.getValue();
            if(value.getEmail().equals(email) && value.getPassword().equals(password)){
                found = value;
                break;
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
