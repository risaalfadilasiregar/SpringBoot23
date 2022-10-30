package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllData(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createDate(@RequestBody Orders param){
        Orders data = service.createData(param);

        if (data != null){
            return new ResponseEntity<>(data,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody Orders param,
                                        @RequestParam(name = "id") int id){
        Orders data = service.updateData(param, id);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new ResponseEntity<>("Delete Sukses", HttpStatus.OK);
        }

        return new ResponseEntity<>("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}
