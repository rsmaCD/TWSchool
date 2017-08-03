/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    var report_info = {};

    var report_item_list = [];

    var report_item_1 = {
        "stu_name":"lili",
        "math":"89",
        "language":"89",
        "program":"89",
        "english":"89",
        "average":"89",
        "total":"89",
    };
    var report_item_2 = {
        "stu_name":"tom",
        "math":"89",
        "language":"22",
        "program":"29",
        "english":"09",
        "average":"69",
        "total":"39",
    };
    var report_item_3 = {
        "stu_name":"liu",
        "math":"89",
        "language":"89",
        "program":"89",
        "english":"89",
        "average":"89",
        "total":"89",
    };
    report_item_list.push(report_item_1);
    report_item_list.push(report_item_2);
    report_item_list.push(report_item_3);

    report_info = {
        "report_item_list":report_item_list,
        "average":33,
        "median":244
    }

    localStorage.setItem("report_info", JSON.stringify(report_info));

    show_report();

});

show_report = function () {
    if (localStorage.getItem('stu_info_list')) {
        var report_info = jQuery.parseJSON(localStorage.getItem('report_info'));
        $('#report_result').html("");
        $('#report_template').tmpl(report_info).appendTo('#report_result');
        $('#report_total_and_average_template').tmpl(report_info).appendTo('#report_total_and_average');
    }
};
