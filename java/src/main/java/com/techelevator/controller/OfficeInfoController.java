package com.techelevator.controller;

import com.techelevator.dao.OfficeInfoDao;
import com.techelevator.model.OfficeInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/officeinfo")
public class OfficeInfoController {

    private final OfficeInfoDao officeInfoDao;

    public OfficeInfoController(OfficeInfoDao officeInfoDao) {
        this.officeInfoDao = officeInfoDao;
    }

    @GetMapping("/all")
    public List<OfficeInfo> viewOfficeInfo() {
        List officeInfo = officeInfoDao.getOfficeLists();
        if (officeInfo != null) {

        } else {
            System.out.println("No Offices Found");
        }
        return officeInfo;
    }

    @GetMapping("/{id}")
    public OfficeInfo getOfficeInfoById(@PathVariable int id){
        OfficeInfo officeInfo = officeInfoDao.getOfficeById(id);
        if (officeInfo != null) {

        } else {
            System.out.println("No Office Found For Selected ID");
        }
        return officeInfo;
    }

    // Error: 500 Internal Server Error - does not create office
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public OfficeInfo createOffice(@RequestBody OfficeInfo office) {
        return officeInfoDao.createOffice(office);
    }

    // Not working
    @PutMapping("/updateOfficeInfo")
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
