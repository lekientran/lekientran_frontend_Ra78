package com.vti.helloworldspringboot.repository;

import com.vti.helloworldspringboot.modal.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// có sẵn các chức năng cơ bản
public interface AccountRepository extends JpaRepository<Account, Long> {

}
