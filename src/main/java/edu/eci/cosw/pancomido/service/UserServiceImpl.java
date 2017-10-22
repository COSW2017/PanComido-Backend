package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.FriendRepository;
import edu.eci.cosw.pancomido.repositories.OrderRepository;
import edu.eci.cosw.pancomido.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService
{

    //private HashMap<Long, User> users = new HashMap<>();

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CommandRepository commandRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    public UserServiceImpl() { }

    /*@PostConstruct
    private void populateSampleData()
    {
        User user = new User( "test@mail.com", "password", "Andres", "Perez", "https://cdn-images-1.medium.com/max/796/1*juPyda3wq9uz_SNFRLuANg@2x.png", "test", "123456" );
        Restaurant restaurant = new Restaurant(0, "Perter pan", 1.12, 2.36, 5, 2, 3, 1);
        ArrayList<Dish> dishes = new ArrayList<>();
        Dish dish = new Dish(0, "Arroz con pollo", 25000, "Arroz con pollo y papas a la francesa", restaurant);
        //restaurant.addDish(dish);
        Command command = new Command(0, dishes);
        ArrayList<Command> commands = new ArrayList<>(); commands.add(command);
        Order order = new Order(0, user);
        order.setCommands(commands);
        ArrayList<Order> orders = new ArrayList<>();
        //user.setOrders(orders);
        //user.setRestaurant(restaurant);
        //restaurant.setDishes(dishes);
        users.put(1l, user);

        restaurantService.addRestaurant(restaurant);
    }*/
    
    @Override
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id)
    {
        return userRepository.getOne(id);
    }

    @Override
    public User createUser( User user ){
        userRepository.saveAndFlush(user);
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
        User found = userRepository.findUsersByEmailAndPassword(email, password).get(0);
        return found;
    }

    @Override
    public User updateUser(User user) {
        User oldUser = this.findUserByEmail(user.getEmail());
        oldUser.setCellphone(user.getCellphone());
        oldUser.setCity(user.getCity());
        oldUser.setUser_password(user.getUser_password());
        oldUser.setImage(user.getImage());
        return oldUser;
    }

    @Override
    public Boolean addFriend(Integer user, Integer friend) {
        Friend friendship = friendRepository.checkIfAFriendshipExist(user, friend);
        Friend f = null;
        if(friendship==null){
            friendship = friendRepository.checkIfAPendingFriendshipExist(user, friend);
            if(friendship==null) {
                f = new Friend(getUser(user), getUser(friend), 0);
                friendRepository.saveAndFlush(f);
            }
        }
        return f!=null;
    }

    //Pensar si es mejor pasar las ordenes del usuario a un HashMap
    @Override
    public Order getOrder(Integer id_order) {
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
        return orderRepository.getOne(id_order);
    }

    @Override
    public List<Order> getOrders(Integer id_user) {
        return orderRepository.getOrdersByUser(id_user);
    }

    @Override
    public User modifyUserData(String email, String user_pas, String city, String cellphone){
        User prev = this.findUserByEmail(email);
        prev.setEmail(email);
        prev.setUser_password(user_pas);
        prev.setCity(city);
        prev.setCellphone(cellphone);

        return prev;
    }

}
