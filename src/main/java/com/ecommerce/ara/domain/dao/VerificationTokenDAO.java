package com.ecommerce.ara.domain.dao;

import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);


}
