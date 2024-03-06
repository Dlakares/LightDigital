package ru.rustam.LightDigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rustam.LightDigital.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
