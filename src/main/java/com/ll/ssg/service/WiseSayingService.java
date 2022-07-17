package com.ll.ssg.service;

import com.ll.ssg.WiseSaying;
import com.ll.ssg.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying add(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }

    public void update(int id, String content, String author) {
        wiseSayingRepository.update(id, content, author);
    }

    public void delete(int id) {
        wiseSayingRepository.delete(id);
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }
}
