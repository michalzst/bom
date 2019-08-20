package bom.service;

import bom.entity.ZgloszenieBigbag;
import bom.repository.ZgloszenieBigbagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigbagiService {
    @Autowired
    private ZgloszenieBigbagRepo<ZgloszenieBigbag> zgloszenieBigbagRepo;

    public List<ZgloszenieBigbag> findAll(){
        return zgloszenieBigbagRepo.findAll();
    };
}
