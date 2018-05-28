package glyn.fun.heart_stone.repositories;

import glyn.fun.heart_stone.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
