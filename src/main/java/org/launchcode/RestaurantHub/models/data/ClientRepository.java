package org.launchcode.RestaurantHub.models.data;

import org.launchcode.RestaurantHub.models.Client;
import org.launchcode.RestaurantHub.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Integer> {


        Client findByClientName(String clientName);

}
