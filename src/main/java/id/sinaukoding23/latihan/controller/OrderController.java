package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<OrderDTO> data = service.findAll();

        return new RestResult(data,data.size() == 0 ? "Data Tidak Ditemukan" : "Menampilkan Data",data.size(),HttpStatus.OK);

    }

    @PostMapping("/add")
    public RestResult createDate(@RequestBody OrderDTO param){
        OrderDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data,"Data Berhasil Tersimpan",HttpStatus.OK);
        }

        return new RestResult("Data Gagal Disimpan",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public RestResult updateData(@RequestBody OrderDTO param,
                                        @RequestParam(name = "id") int id){
        OrderDTO data = service.updateData(param, id);

        if (data != null){
            return new RestResult(data,"Data Berhasil Di Update", HttpStatus.OK);
        }

        return new RestResult("Data Gagal Diupdate",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new RestResult("Delete Sukses", HttpStatus.OK);
        }

        return new RestResult("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}
