package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com", "password", "Andres", "Perez", "https://cdn-images-1.medium.com/max/796/1*juPyda3wq9uz_SNFRLuANg@2x.png", "test" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        return users.get( 0 );
    }

    @Override
    public User createUser( User user )
    {
        users.add(user);
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
        return users.get( 0 );
    }

}
