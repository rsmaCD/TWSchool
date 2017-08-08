package studentScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentScore.entity.Reports;
import studentScore.service.ReportsService;

/**
 * Created by rsma on 07/08/2017.
 */
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportsService reportsService;

    @RequestMapping(method = RequestMethod.GET)
    public Reports post() {
        return reportsService.createReportsAll();
    }
}


