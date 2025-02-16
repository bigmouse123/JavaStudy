package com.situ.web.pojo.query;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/16 20:04
 */
public class EmployeeQuery {
    Integer page;
    Integer limit;
    String name;
    String salary;
    String minSalary;
    String maxSalary;

    public EmployeeQuery() {
    }

    public EmployeeQuery(Integer page, Integer limit, String name, String salary) {
        this.page = page;
        this.limit = limit;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeQuery(Integer page, Integer limit, String name, String salary, String minSalary, String maxSalary) {
        this.page = page;
        this.limit = limit;
        this.name = name;
        this.salary = salary;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "EmployeeQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                '}';
    }
}
