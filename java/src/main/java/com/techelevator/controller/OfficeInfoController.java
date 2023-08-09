package com.techelevator.controller;

import com.techelevator.dao.OfficeInfoDao;
import com.techelevator.model.OfficeInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/OfficeInfo")
public class OfficeInfoController {

    private final OfficeInfoDao officeInfoDao;

    public OfficeInfoController(OfficeInfoDao officeInfoDao) {
        this.officeInfoDao = officeInfoDao;
    }

    @GetMapping("/OfficeInfo")
    public ResponseEntity<OfficeInfo> viewOfficeInfo(@PathVariable int id) {
        OfficeInfo officeInfo = officeInfoDao.getOfficeById(id);
        if (officeInfo != null) {
            return new ResponseEntity<>(officeInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OfficeInfo> createOffice(@RequestBody OfficeInfo office) {
        OfficeInfo createdOffice = officeInfoDao.createOffice(office);
        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
    }

    @PutMapping("/OfficeInfo")
    public ResponseEntity<OfficeInfo> updateOffice(@PathVariable int id, @RequestBody OfficeInfo officeInfo) {
        officeInfo.setId(id);
        OfficeInfo updatedOffice = officeInfoDao.updateOffice(officeInfo);
        if (updatedOffice != null) {
            return new ResponseEntity<>(updatedOffice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
