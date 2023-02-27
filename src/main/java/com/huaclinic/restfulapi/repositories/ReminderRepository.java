package com.huaclinic.restfulapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.huaclinic.restfulapi.models.Reminder;
import java.util.List;

public interface ReminderRepository extends CrudRepository<Reminder, Integer> {

    @Query(value = """
                Select patient_id, pname,
                (array_agg(unfinished) filter (where priority = 'HIGH'))[1] as high,
                (array_agg(unfinished) filter (where priority = 'MIDDLE'))[1] as middle,
                (array_agg(unfinished) filter (where priority = 'LOW'))[1] as low
                From (
                Select rr.patient_id, p.pname, r.priority, count(r.priority) AS unfinished
                FROM reminder AS r
                LEFT JOIN reminder_record AS rr
                ON r.id = rr.reminder_id
                LEFT JOIN patient AS p
                ON rr.patient_id = p.id
                WHERE rr.doctor_id = ?1 AND r.done = ?2
                GROUP BY rr.patient_id, r.priority, p.pname
                ) as c group by patient_id, pname
                ORDER BY high DESC NULLS LAST, middle DESC NULLS LAST, low DESC NULLS LAST
            """, nativeQuery = true)
    List<Object[]> findAllOrderByPriorityDESC(Integer doctorId, boolean done);

    @Query(value = """
                SELECT r.id, r.description, r.priority, r.due_time, r.done
                FROM reminder AS r
                LEFT JOIN reminder_record AS rr
                ON r.id = rr.reminder_id
                WHERE rr.patient_id = ?1
                ORDER BY r.create_time DESC
            """, nativeQuery = true)
    List<Object[]> findAllByPatientId(Integer patientId, boolean done);

    @Query(value = """
            SELECT
                CREATE_TIME\\:\\:date,
                COUNT(CREATE_TIME\\:\\:date)
            FROM REMINDER AS R
            LEFT JOIN REMINDER_RECORD AS RR ON RR.REMINDER_ID = R.ID
            WHERE RR.DOCTOR_ID = ?1
                AND RR.PATIENT_ID = ?2
                AND CREATE_TIME\\:\\:date BETWEEN (NOW() - (interval '7d'))\\:\\:date AND (NOW() - (interval '1d'))\\:\\:date
                AND (DUE_TIME < NOW() AND (DUE_TIME < DONE_TIME or DONE_TIME IS NULL))
            GROUP BY CREATE_TIME\\:\\:date
                    """, nativeQuery = true)
    List<Object[]> findAllinLast7days(Integer doctorId, Integer patientId);
}
