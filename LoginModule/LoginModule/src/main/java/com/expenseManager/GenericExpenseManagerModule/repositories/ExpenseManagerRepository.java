package com.expenseManager.GenericExpenseManagerModule.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.CrudRepository;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;

public interface ExpenseManagerRepository extends CrudRepository<ExpenseItem, Long>, ExpenseCustomRepo {

	


}
