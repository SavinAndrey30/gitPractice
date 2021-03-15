package ru.savin.minicrm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.savin.minicrm.dao.EmployeeRepository;
import ru.savin.minicrm.entity.Employee;
import ru.savin.minicrm.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new EmployeeNotFoundException("Employee with the id " + theId + " is not found");
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void delete(Long theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        if (result.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with the id " + theId + " is not found");
        }

        employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> searchBy(String theName) {

        List<Employee> results = null;

        if (theName != null && theName.trim().length() > 0) {
            results = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
        } else {
            results = findAll();
        }

        return results;
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }
}
