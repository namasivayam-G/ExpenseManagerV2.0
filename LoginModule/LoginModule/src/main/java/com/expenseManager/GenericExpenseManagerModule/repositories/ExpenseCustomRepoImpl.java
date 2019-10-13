package com.expenseManager.GenericExpenseManagerModule.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;

@Repository
@Transactional
public class ExpenseCustomRepoImpl implements ExpenseCustomRepo {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<ExpenseItem> getAllItemsSortedByDate(long userId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery();
		Root<ExpenseItem> root = query.from(ExpenseItem.class);
		CriteriaQuery<Object> criteriaQuery = query.select(root).where(cb.equal(root.get("userId"),userId )).orderBy(cb.asc(root.get("expenseDate")));
		Query q =  em.createQuery(criteriaQuery);
		System.out.println("Result of Expense By UserID"+ q.getResultList());
		return q.getResultList();
	}

}
