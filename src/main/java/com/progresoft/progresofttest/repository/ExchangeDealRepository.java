package com.progresoft.progresofttest.repository;

import com.progresoft.progresofttest.entity.ExchangeDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeDealRepository extends JpaRepository<ExchangeDeal, String> {
}
