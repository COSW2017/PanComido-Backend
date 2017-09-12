package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NGS on 9/12/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    public RestaurantServiceImpl()
    {
    }

    @Override
    public Dish addDish(Restaurant r, Dish d) {
        return null;
    }

    @Override
    public Dish deleteDish(Restaurant r, Dish d) {
        return null;
    }

    @Override
    public Dish modifyDish(Restaurant r, Dish d) {
        return null;
    }
}
