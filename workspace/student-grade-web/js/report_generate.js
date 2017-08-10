/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    var report_info_all = {};
    var report_info_one = {};

    var report_item_list = [];
    var report_item_list_one = [];

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

    report_info_all = {
        "report_item_list":report_item_list,
        "average":33,
        "median":244
    }


    report_item_list_one.push(report_item_1);

    report_info_one = {
        "report_item_list":report_item_list_one,
        "average":89,
        "median":89
    }

    localStorage.setItem("report_info_all", JSON.stringify(report_info_all));
    localStorage.setItem("report_info_one", JSON.stringify(report_info_one));

    show_report("report_info_all");

    $("#search-id-button").click(function(){
        var stu_num = $("#stu_id").val().trim();
        if(localStorage.getItem('stu_info_list') && stu_num != ""){
            var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
            var stu_arr = [];
            $.each(stu_info_list, function(i,stu){
                if(stu.stu_id == stu_num){
                    show_report("report_info_one");
                }
            });
        }

    });

});

function show_report(report_info) {
    if (localStorage.getItem(report_info)) {
        var report_info = jQuery.parseJSON(localStorage.getItem(report_info));
        $('#report_result').html("");
        $('#report_template').tmpl(report_info).appendTo('#report_result');
        $('#report_total_and_average').html("");
        $('#report_total_and_average_template').tmpl(report_info).appendTo('#report_total_and_average');
    }
};
