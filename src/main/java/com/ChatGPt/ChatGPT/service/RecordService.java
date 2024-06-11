package com.ChatGPt.ChatGPT.service;

import com.ChatGPt.ChatGPT.doa.Records;

import java.util.List;
import java.util.Optional;

public interface RecordService {
 Records   createRecords(Records record);
 List<Records>getRecords();
 Optional<Records> findById(String id);
 void deleteAll();
 void deleteById(String id);

}
