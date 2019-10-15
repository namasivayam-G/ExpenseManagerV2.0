package com.expenseManager.GenericExpenseManagerModule.repositories;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.expenseManager.GenericExpenseManagerModule.modals.ExpenseItem;
import com.expenseManager.GenericExpenseManagerModule.utility.Constants;

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
		CriteriaQuery<Object> criteriaQuery = query.select(root).where(cb.equal(root.get("userId"), userId))
				.orderBy(cb.asc(root.get("expenseDate")));
		Query q = em.createQuery(criteriaQuery);
		System.out.println("Result of Expense By UserID" + q.getResultList());
		return q.getResultList();
	}

	@Override
	public Collection<ExpenseItem> getExpenseByDate(String fromDay, String toDay, String month, String year,
			long UserId, String criteria) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery();
		Root<ExpenseItem> root = query.from(ExpenseItem.class);

		// get year, day and month
		Expression<Integer> yearOfDate = cb.function("year", Integer.class, root.get("expenseDate"));
		Expression<Integer> monthOfYear = cb.function("month", Integer.class, root.get("expenseDate"));
		Expression<Integer> dayOfMonth = cb.function("day", Integer.class, root.get("expenseDate"));
		CriteriaQuery<Object> criteriaQuery = null;
		if (criteria.equals(Constants.DAILY)) {
			criteriaQuery = query.select(root).where(cb.equal(root.get("userId"), UserId), cb.equal(yearOfDate, year),
					cb.equal(monthOfYear, month), cb.equal(dayOfMonth, fromDay));
		} else if (criteria.equals(Constants.MONTHLY)) {
			criteriaQuery = query.select(root).where(cb.equal(root.get("userId"), UserId), cb.equal(yearOfDate, year),
					cb.equal(monthOfYear, month));
		} else if (criteria.equals(Constants.WEEKLY)) {
			criteriaQuery = query.select(root).where(cb.equal(root.get("userId"), UserId), cb.equal(yearOfDate, year),
					cb.equal(monthOfYear, month),
					cb.between(dayOfMonth, Integer.parseInt(fromDay), Integer.parseInt(toDay)));
		}
		Query q = em.createQuery(criteriaQuery);
		System.out.println("Result of Expense By UserID" + q.getResultList());
		return q.getResultList();
	}

}
