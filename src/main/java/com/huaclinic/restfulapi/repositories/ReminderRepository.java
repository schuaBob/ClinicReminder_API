package com.huaclinic.restfulapi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.huaclinic.restfulapi.models.Reminder;

public interface ReminderRepository extends CrudRepository<Reminder, Integer> {

}
