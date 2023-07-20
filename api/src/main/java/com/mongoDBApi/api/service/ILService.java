package com.mongoDBApi.api.service;

import com.mongoDBApi.api.repository.ILRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.mongoDBApi.api.model.IL;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ILService {
    private final ILRepository ilRepository;
    public List<IL> getIller() {
        return ilRepository.findAll();
    }

    public IL createIl(IL newCity) {
        return ilRepository.save(newCity);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public IL getIlById(String id) {
        return ilRepository.findById(id).orElseThrow(()->new RuntimeException("Il not found"));
    }
}
