package com.springbatch.demobatch.persistence;

import com.springbatch.demobatch.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person,Long> {
}
