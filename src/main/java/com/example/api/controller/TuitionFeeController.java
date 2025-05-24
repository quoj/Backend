package com.example.api.controller;

import com.example.api.model.TuitionFee;
import com.example.api.service.TuitionFeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuition")
public class TuitionFeeController {
    private final TuitionFeeService tuitionFeeService;

    public TuitionFeeController(TuitionFeeService tuitionFeeService) {
        this.tuitionFeeService = tuitionFeeService;
    }
    @GetMapping
    public List<TuitionFee> getAllTuitionFees() {
        return tuitionFeeService.getAllTuitionFees();
    }
    @PostMapping("/add")
    public TuitionFee addTuitionFee(@RequestBody TuitionFee tuitionFee) {
        return tuitionFeeService.addTuitionFee(tuitionFee);
    }
    @PutMapping("update/{id}")
    public TuitionFee updateTuitionFee(@PathVariable Long id, @RequestBody TuitionFee tuitionFee) {
        return tuitionFeeService.updateTuitionFee(id, tuitionFee);
    }
    @GetMapping("/{id}")
    public TuitionFee getTuitionFeeById(@PathVariable Long id) {
        return tuitionFeeService.getTuitionFeeById(id);
    }
}
