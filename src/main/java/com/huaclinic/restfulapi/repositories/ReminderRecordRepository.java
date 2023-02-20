package com.huaclinic.restfulapi.repositories;
import org.springframework.data.repository.CrudRepository;
import com.huaclinic.restfulapi.models.ReminderRecord;
import com.huaclinic.restfulapi.models.ReminderRecordKey;
public interface ReminderRecordRepository extends CrudRepository<ReminderRecord, ReminderRecordKey> {
    
}
