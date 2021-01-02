package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.model.Employee;
import edu.arf4.motivationbalance.model.Factor;
import edu.arf4.motivationbalance.model.Result;
import edu.arf4.motivationbalance.model.enums.Estimation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyService {

    private final FactorDao factorDao;
    private final ResultDao resultDao;
    private final EmployeeDao employeeDao;

    public SurveyService(FactorDao factorDao, ResultDao resultDao, EmployeeDao employeeDao) {
        this.factorDao = factorDao;
        this.resultDao = resultDao;
        this.employeeDao = employeeDao;
    }

    @Transactional
    public Long saveResult(ResultDto dto) {
        Employee emp = employeeDao.getEmployeeById(dto.getEmployeeId(), true);
        Result prevRelevantResult = resultDao.getRelevantResultByEmpId(dto.getEmployeeId());
        prevRelevantResult.setRelevant(false);
        Result result = new Result(emp, LocalDateTime.now());

    // обращение к бд каждый раз за фактором по имени, зато не будет ошибки, если удалить фактор во время заполнения
        Map<Factor, Estimation> estimations = new HashMap<>();
        dto.getFactorNameToEstimMap()
                .forEach((factorName, estim) -> estimations.put(
                        factorDao.getFactorByName(factorName),
                        Estimation.valueOf(estim)              )
        );
        result.setEstimations(estimations);
        return resultDao.saveResult(result);
    }

    private ResultDto convertResultToResultDto(Result result) {
        ResultDto dto = new ResultDto();
        dto.setEmployeeId(result.getEmployee().getId());
        dto.setPassingDatetime(result.getPassingDatetime());



        return null;
    }

    public List<ResultDto> getAllResultsByEmpId(Long empId) {

        List<Result> results = resultDao.getAllResultsByEmpId(empId);
        List<ResultDto> resultDtoList = new ArrayList<>();
        results.forEach(r -> resultDtoList.add(convertResultToResultDto(r)));
        return resultDtoList;
    }




}
