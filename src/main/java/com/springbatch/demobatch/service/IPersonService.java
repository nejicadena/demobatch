package com.springbatch.demobatch.service;

import com.springbatch.demobatch.entities.Person;

import java.util.List;

public interface IPersonService {
    void saveAll(List<Person> personsList);

}
