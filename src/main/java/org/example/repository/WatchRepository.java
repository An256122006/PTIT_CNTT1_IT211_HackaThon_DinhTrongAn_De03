package org.example.repository;

import org.example.entity.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WatchRepository extends JpaRepository<Watch, Long> {
    @Query("select w from Watch w where lower(w.model_name) like lower(concat('%',:search,'%') ) or lower(w.brand) like lower(concat('%',:search,'%') ) ")
    Page<Watch> findBySearch(@Param("search") String search, Pageable pageable);
}
