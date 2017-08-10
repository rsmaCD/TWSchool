/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    $.ajax({
        url: "http://localhost:8080/reports"
    }).then(function(data, status, jqxhr) {
        console.log(data);
        console.log(status);
        show_report(data);
    });
});

function show_report(report_info) {

    var report_info_json = report_info;
    $('#report_result').html("");
    $('#report_template').tmpl(report_info_json).appendTo('#report_result');
    $('#report_total_and_average').html("");
    $('#report_total_and_average_template').tmpl(report_info_json).appendTo('#report_total_and_average');

};
