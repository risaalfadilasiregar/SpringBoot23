package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.Categories;
import id.sinaukoding23.latihan.model.dto.CategoriesDTO;
import id.sinaukoding23.latihan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoris")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<CategoriesDTO> data = service.findAll();

        return new RestResult(data,data.size() == 0 ? "Data Tidak Ditemukan" : "MEnampilakn Data", data.size(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public RestResult createDate(@RequestBody CategoriesDTO param){
        CategoriesDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data,"Data Berhasil Disimpan", HttpStatus.OK);
        }

        return new RestResult("Data Gagal Disimpan",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public RestResult updateData(@RequestBody CategoriesDTO param,
                                        @RequestParam(name = "id") int id){
        CategoriesDTO data = service.updateData(param, id);

        if (data != null){
            return new RestResult(data,"Data Berhasil Diupdate", HttpStatus.OK);
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
