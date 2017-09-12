package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Restaurant;

/**
 * Created by 2100038 on 9/12/17.
 */
public interface RestaurantService {

    Dish addDish(Restaurant r, Dish d);

    Dish deleteDish(Restaurant r, Dish d);

    Dish modifyDish(Restaurant r, Dish d);

}
