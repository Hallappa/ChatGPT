package com.ChatGPt.ChatGPT.serviceimpl;

import com.ChatGPt.ChatGPT.doa.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChatGPt.ChatGPT.repository.RecordsRepository;
import com.ChatGPt.ChatGPT.service.RecordService;

import java.util.List;
import java.util.Optional;
@Service
public class RecordsImpl implements RecordService {
    @Autowired
    private RecordsRepository recordsRepository;
    @Override
    public Records createRecords(Records records) {
        return recordsRepository.save(records);
    }

    @Override
    public List<Records> getRecords() {
        return recordsRepository.findAll();
    }

    @Override
    public Optional<Records> findById(String id) {
        return recordsRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        recordsRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        recordsRepository.deleteById(id);
    }
}
