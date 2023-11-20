package com.vti.helloworldspringboot.service;

import com.vti.helloworldspringboot.modal.dto.AccountCreateRequest;
import com.vti.helloworldspringboot.modal.dto.AccountUpdateRequest;
import com.vti.helloworldspringboot.modal.entity.Account;
import com.vti.helloworldspringboot.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> getAllV2(int page, int size) {
        // tạo đối tượng phân trang trong spring boot
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return accountRepository.findAll(pageable);
    }

    @Override
    public Account findById(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        // Kiểu dữ liệu optional giúp kiểm ta có kết quả trả về hay không 1 cách dễ dàng hơn
        boolean isAccountExist = accountOptional.isPresent();
        if(isAccountExist){
            return accountOptional.get();
        }
        return null; // về sau sẽ học cách xử lý khi k có data trả về
    }

    @Override
    public void delete(long id) {
        // kiểm tra sự tồn tại của Id

        // Nếu id có tồn tại => xóa
        accountRepository.deleteById(id);
        // Nếu id không tồn tại =>
    }

    @Override
    public Account create(AccountCreateRequest request) {
        // convert dto => entity
        // Cách 1: dùng getter/setter
        Account account = new Account();
//        account.setName(request.getName()); // lấy dữ liệu request truyền vào gán cho account name
        // Cách 2: dùng đối tượng BeanUtils của Spring boot
        // object thứ nhất: đối tượng muốn lấy giá trị
        // object thứ 2: đối tượng muốn gán giá trị vào
        // Điều kiện:  gán giá trị nếu obj1 và 2 có cùng tên và kiểu dữ liệu
        BeanUtils.copyProperties(request, account);
        return accountRepository.save(account);
    }

    @Override
    public Account update(AccountUpdateRequest request) {
        Account account = accountRepository.findById(request.getId()).get();
        BeanUtils.copyProperties(request, account);

        return accountRepository.save(account);
    }



}
