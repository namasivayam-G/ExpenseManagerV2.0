package com.expenseManager.GenericExpenseManagerModule.modals;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

import com.expenseManager.GenericExpenseManagerModule.utility.ExpenseSequenceGenerator;


@Entity(name="EXPENSE_ITEM_TABLE")
public class ExpenseItem {
	@Id
	@Column(name="EXPENSE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="expenseSeq")
	@GenericGenerator(name="expenseSeq",
					strategy="com.expenseManager.GenericExpenseManagerModule.utility.ExpenseSequenceGenerator",
					 parameters = {
					            @Parameter(name = ExpenseSequenceGenerator.INCREMENT_PARAM, value = "1"),
					            @Parameter(name = ExpenseSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "EXP_"),
					            @Parameter(name = ExpenseSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String expenseId;
	@Column(name="EXPENSE_DATE")
	private Date expenseDate;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column (name="ITEM_COST")
	private String itemCost;
	@Column(name="ITEM_CATEGORY")
	private String itemCategory;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="USER_ID")
	private long userId;
	
	public String getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}	
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getItemCost() {
		return itemCost;
	}
	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}

}
