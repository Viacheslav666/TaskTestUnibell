package ru.Unibell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Unibell.model.Client;
@Repository
public interface GuideRepository extends JpaRepository<Client, Long>{
}
