package com.erp.system.hr.respository;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;
import com.erp.system.hr.Model.basic_information_management.User;

@Component
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

    private UserRepositoryImpl() {
        super(User.class);
    }
}
