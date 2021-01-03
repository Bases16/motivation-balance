package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.dto.EstimationPairDto;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.model.Employee;
import edu.arf4.motivationbalance.model.EstimationPair;
import edu.arf4.motivationbalance.model.Factor;
import edu.arf4.motivationbalance.model.Result;
import edu.arf4.motivationbalance.model.enums.Estimation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        List<Factor> relevantFactors = factorDao.getRelevantFactors(); // to avoid excessive SELECT's
        Set<EstimationPair> estimPairs = new HashSet<>();
        dto.getEstimationDtoPairs()
                .forEach(dtoPair -> {
                    EstimationPair pair = new EstimationPair();
                    pair.setResult(result);
                    pair.setFactor(getOptFactorByNameFromGivenList(dtoPair.getFactorName(), relevantFactors)
                            .orElseGet( () -> factorDao.getFactorByName(dtoPair.getFactorName()) )
                    );
                    pair.setEstim(Estimation.valueOf(dtoPair.getEstimation()));
                    estimPairs.add(pair);
                });
        result.setEstimationPairs(estimPairs);
        return resultDao.saveResult(result);
    }

    private Optional<Factor> getOptFactorByNameFromGivenList(String factorName, List<Factor> factors) {
        return factors.stream()
                .filter(f -> f.getName().equals(factorName))
                .findFirst();
    }


    @Transactional(readOnly = true)
    public List<ResultDto> getAllResultsDtoByEmpId(Long empId) {
        List<Result> results = resultDao.getAllResultsByEmpId(empId);
        List<ResultDto> resultDtoList = new ArrayList<>();
        results.forEach(r -> resultDtoList.add(convertResultToResultDto(r)));
        return resultDtoList;
    }

    private ResultDto convertResultToResultDto(Result result) {
        ResultDto dto = new ResultDto();
        dto.setEmployeeId(result.getEmployee().getId());
        dto.setPassingDatetime(result.getPassingDatetime());

        Set<EstimationPair> estimationPairs = result.getEstimationPairs();
        List<EstimationPairDto> estimDtoPairs = new ArrayList<>();

        estimationPairs.forEach( (pair) -> estimDtoPairs.add(             // subselect here
                new EstimationPairDto(pair.getFactor().getName(), pair.getEstim().name()) //batch here
        ));
        dto.setEstimationDtoPairs(estimDtoPairs);
        return dto;
    }



    public List<ResultDto> getAllRelevResultsDtoByManagerId(Long id) {
        return null;
    }
    public List<ResultDto> getAllRelevResultsDto() {
        return null;
    }


    private List<ResultDto> getAllRelevResultsDtoByEmpIds(List<Long> ids) {

        String q = " select e.id from Employee e ";
        return null;
    }



}
