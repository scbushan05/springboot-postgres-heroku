package in.bushansirgur.herokupostgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.herokupostgres.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
