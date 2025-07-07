package com.springbatch.demobatch.service;

import com.springbatch.demobatch.entities.Person;
import com.springbatch.demobatch.persistence.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO personDAO;

    @Transactional
    public void saveAll(List<Person> personsList) {

    }
}
