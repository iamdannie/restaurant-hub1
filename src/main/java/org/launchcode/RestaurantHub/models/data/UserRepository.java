package org.launchcode.RestaurantHub.models.data;

import org.launchcode.RestaurantHub.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

        User findByUsername(String username);

    }

