package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.Exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.OrderRepository;
import edu.eci.cosw.pancomido.repositories.UserRepository;
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
public class UserServiceImpl implements UserService
{
    //public static Long consucutive = 1l; //hay que quitar esto cuando se implemente la base de datoss!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    private HashMap<Long, User> users = new HashMap<>();

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CommandRepository commandRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl() { }

    @PostConstruct
    private void populateSampleData()
    {
        User user = new User( "test@mail.com", "password", "Andres", "Perez", "https://cdn-images-1.medium.com/max/796/1*juPyda3wq9uz_SNFRLuANg@2x.png", "test", "123456" );
        Restaurant restaurant = new Restaurant(0, "Perter pan", 1.12, 2.36, 5, 2, 3, 1);
        ArrayList<Dish> dishes = new ArrayList<>();
        Dish dish = new Dish(0, "Arroz con pollo", 25000, "Arroz con pollo y papas a la francesa", restaurant);
        //restaurant.addDish(dish);
        Command command = new Command(0, dishes);
        ArrayList<Command> commands = new ArrayList<>(); commands.add(command);
        Order order = new Order(0, user, commands);
        ArrayList<Order> orders = new ArrayList<>();
        //user.setOrders(orders);
        //user.setRestaurant(restaurant);
        //restaurant.setDishes(dishes);
        users.put(1l, user);

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
    public User createUser( User user ){
        //consucutive++;
        //user.setId(consucutive); // Arreglar esto cuando se implemente la base de datos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //users.put(consucutive, user);
        return user;
    }

    @Override
    public User findUserByEmail( String email )
    {
        /*User found = null;
        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            Long key = entry.getKey();
            User value = entry.getValue();
            if(value.getEmail().equals(email)) {
                found = value;
                break;
            }
        }
        return found;*/
        return userRepository.findUsersByEmail(email);
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
        //List<User> pending1 = user1.getPendingFriends();
        /*boolean retval = false;
        if(!pending1.contains(user2)) {
            pending1.add(user2);
            retval = true;
        }*/
        return null;

    }

    //Pensar si es mejor pasar las ordenes del usuario a un HashMap
    @Override
    public Order getOrder(Long id_user, Integer id_order) {
        List<Order> orders = new ArrayList<>();
        Boolean found = false;
        Order order = null;
        for(int i = 0; i < orders.size() & !found;i++){
            if(orders.get(i).getId_order() == id_order){
                order=orders.get(i);
                found = true;
            }
        }
        return order;
    }

    @Override
    public PaymentMethod addPaymentMethod(Integer idUser, PaymentMethod paymentMethod) {
        //users.get(idUser).addMetodoPago(paymentMethod);
        return paymentMethod;
    }

    @Override
    public Order cancelOrder(Order order) throws PanComidoServicesException {
        List<Command> commands = commandRepository.getCommandsByOrder(order.getId_order());
        int state = 0;
        for(int i=0; i <commands.size() && (state<1); i++){
            state+=commands.get(i).getState();
        }
        if(state<1){
            for(Command command : commands){
                command.setState(-1);
            }
        }else{
            throw new PanComidoServicesException(PanComidoServicesException.NO_SE_PUEDE_CANCELAR_ORDEN);
        }
        return order;
    }


    @Override
    public Order getOrderById(Integer id_order) {
        HashMap<Integer, Order> ordenes = getAllOrders();
        return ordenes.get(id_order);
    }

    public List<Command> getPedidosByRestaurant(Integer id_restaurant){
        HashMap<Integer, Order> ordenes = getAllOrders();
        List<Command> commands = new ArrayList<>();
        List<Command> commandPorOrden; Dish d;
        for(Integer i : ordenes.keySet()){
            commandPorOrden = ordenes.get(i).getCommands();
            /*if(commandPorOrden.get(i).getPlatos().get(0).getRestaurant().getId_restaurant()==id_restaurant){
                commands.add(commandPorOrden.get(i));
            }*/
        }
        return commands;
    }


    private HashMap<Integer, Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        HashMap<Integer, Order> allOrders = new HashMap<>();
        for(Long u : users.keySet()){
            orders =  new ArrayList<>();
            for(Order o : orders){
                if(!allOrders.containsKey(o.getId_order())){
                    allOrders.put(o.getId_order(), o);
                }
            }
        }
        return allOrders;
    }


}
