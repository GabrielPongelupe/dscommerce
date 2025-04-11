package com.gabrielpongelupe.dscommerce.repositories;

import com.gabrielpongelupe.dscommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
