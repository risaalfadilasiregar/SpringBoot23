package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.Stores;
import id.sinaukoding23.latihan.model.dto.StoreDTO;
import id.sinaukoding23.latihan.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<StoreDTO> data = service.findAll();

        return new RestResult(data,data.size() == 0 ? "Data Tidak Ditemukan" : "Menampilkan Data",data.size(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public RestResult createDate(@RequestBody StoreDTO param){
        StoreDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data, "Data Disimpan" ,HttpStatus.OK);
        }

        return new RestResult("Data Gagal Disimpan" ,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public RestResult updateData(@RequestBody StoreDTO param,
                                        @RequestParam(name = "id") int id){
        StoreDTO data = service.updateData(param, id);

        if (data != null){
            return new RestResult(data,"Data Berhasil Di Update",HttpStatus.OK);
        }

        return new RestResult("Data Gagal Di Update",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult deleteData(@PathVariable int id){

        if (service.deleteData(id)){
            return new RestResult("Delete Sukses", HttpStatus.OK);
        }

        return new RestResult("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}
