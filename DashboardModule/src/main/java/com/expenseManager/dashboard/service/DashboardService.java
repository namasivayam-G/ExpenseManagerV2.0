package com.expenseManager.dashboard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expenseManager.dashboard.exception.DashboardException;
import com.expenseManager.dashboard.models.ExpenseItem;
import com.expenseManager.dashboard.models.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DashboardService implements IDashboardService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@SuppressWarnings("unchecked")
	public Map<String, List<ExpenseItem>> getMonthlyExpensesByCategory(long userId, String year, String month) {

		Map<String, List<ExpenseItem>> expenseCategoryMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		List<ServiceInstance> instances = discoveryClient.getInstances("Generic-Expense-Manager-Module");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();
		JsonNode nodeList = restTemplate
				.getForObject(baseUrl + "expense/monthly-expense/" + userId + "/" + year + "/" + month, JsonNode.class);
		ArrayList<ExpenseItem> expenseItemList = mapper.convertValue(nodeList,
				new TypeReference<ArrayList<ExpenseItem>>() {
				});
	
		for (ExpenseItem expenseItem : expenseItemList) {
			if (expenseCategoryMap.containsKey(expenseItem.getItemCategory())) {
				expenseCategoryMap.get(expenseItem.getItemCategory()).add(expenseItem);
				expenseCategoryMap.put(expenseItem.getItemCategory(),
						expenseCategoryMap.get(expenseItem.getItemCategory()));
			} else {
				List<ExpenseItem> expenseList = new ArrayList<>();
				expenseList.add(expenseItem);
				expenseCategoryMap.put(expenseItem.getItemCategory(), expenseList);
			}
		}
		return expenseCategoryMap;
	}

	public Map<String, List<ExpenseItem>> getweeklyExpensesByCategory(long userId, String year, String month,
			String fromDate, String toDate, String category) {
		Map<String, List<ExpenseItem>> expenseCategoryMAp = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		List<ExpenseItem> expenseList = new ArrayList<>();
		try {
			List<ServiceInstance> instances = discoveryClient.getInstances("Generic-Expense-Manager-Module");
			ServiceInstance serviceInstance = instances.get(0);

			String baseUrl = serviceInstance.getUri().toString();
			JsonNode nodeList = restTemplate.getForObject(baseUrl + "expense/weekly-expense/" + userId + "/" + year
					+ "/" + month + "/" + fromDate + "/" + toDate, JsonNode.class);
			ArrayList<ExpenseItem> expenseItemList = mapper.convertValue(nodeList,
					new TypeReference<ArrayList<ExpenseItem>>() {
					});
			for (ExpenseItem expenseItem : expenseItemList) {
				if (category.equalsIgnoreCase(expenseItem.getItemCategory())) {
					expenseList.add(expenseItem);
					expenseCategoryMAp.put(category, expenseList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expenseCategoryMAp;
	}

	public Map<String, List<ExpenseItem>> getDailyExpensesByCategory(long userId, String year, String month, String day,
			String category) {
		Map<String, List<ExpenseItem>> expenseCategoryMAp = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		List<ExpenseItem> expenseList = new ArrayList<>();
		try {
			List<ServiceInstance> instances = discoveryClient.getInstances("Generic-Expense-Manager-Module");
			ServiceInstance serviceInstance = instances.get(0);

			String baseUrl = serviceInstance.getUri().toString();
			JsonNode nodeList = restTemplate.getForObject(
					baseUrl + "expense/daily-expense/" + userId + "/" + year + "/" + month + "/" + day, JsonNode.class);
			ArrayList<ExpenseItem> expenseItemList = mapper.convertValue(nodeList,
					new TypeReference<ArrayList<ExpenseItem>>() {
					});
			for (ExpenseItem expenseItem : expenseItemList) {
				if (category.equalsIgnoreCase(expenseItem.getItemCategory())) {
					expenseList.add(expenseItem);
					expenseCategoryMAp.put(category, expenseList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expenseCategoryMAp;
	}



}
