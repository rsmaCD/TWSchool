package studentScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import studentScore.entity.Reports;
import studentScore.service.ReportsService;

/**
 * Created by rsma on 07/08/2017.
 */
@RestController
@RequestMapping("/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportsService reportsService;

    @RequestMapping(method = RequestMethod.GET)
    public Reports get() {
        return reportsService.createReportsAll();
    }
}


