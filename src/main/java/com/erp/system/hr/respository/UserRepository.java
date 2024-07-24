package com.erp.system.hr.respository;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.hr.Model.basic_information_management.User;

import java.util.List;


public interface UserRepository extends GenericRepository<User> {
    @Override
    void save(User entity);

    @Override
    List<User> findAll();
}
