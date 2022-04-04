package com.addi.challenge.externalsystem.judicialnationalarchivessystem.controller;

import com.addi.challenge.externalsystem.judicialnationalarchivessystem.entity.Score;
import com.addi.challenge.externalsystem.judicialnationalarchivessystem.service.ScoreCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator/score")
public class ScoreCalculatorController {

    private final ScoreCalculatorService scoreCalculatorService;

    public ScoreCalculatorController(ScoreCalculatorService scoreCalculatorService) {
        this.scoreCalculatorService = scoreCalculatorService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Score> calculateScoreByNationalIdentificationNumber() {
        Score score = scoreCalculatorService.calculateScoreByNationalIdentificationNumber();
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

}
