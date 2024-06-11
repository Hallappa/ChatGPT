package com.ChatGPt.ChatGPT.repository;

import com.ChatGPt.ChatGPT.doa.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsRepository extends JpaRepository<Records,String> {
}
