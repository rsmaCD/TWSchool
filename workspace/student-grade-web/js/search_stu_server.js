/**
 * Created by rsma on 03/08/2017.
 */
$(function () {
    show_all_stu();

    $("#search-id-button").click(function(){
        var stu_num = $("#stu_id").val().trim();
        search_stu("stu_id",stu_num);
        $("#stu_name").val("");
    });

    $("#search-name-button").click(function(){
        var stu_name = $("#stu_name").val().trim();
        search_stu("stu_name",stu_name);
        $("#stu_id").val("");
    });

});

show_all_stu = function () {

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students",
        type: "GET",
        contentType: "application/json; charset=utf-8",
    }).then(function(data, status, jqxhr) {
        console.log(data);
        console.log(status);
        if(status =="success"){
            append_to_search_result_table(data);
        }
    });
};

append_to_search_result_table = function (stu_info_list) {
    $('#search_result').html("");
    var search_result = {"data": stu_info_list};
    $('#search_result_template').tmpl(search_result).appendTo('#search_result');
};


search_stu = function (stu_filed_name,stu_filed_value) {
    if(localStorage.getItem('stu_info_list') && stu_filed_value != ""){
        var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
        var stu_arr = [];
        $.each(stu_info_list, function(i,stu){
            if(stu[stu_filed_name] == stu_filed_value){
                stu_arr.push(stu);
            }
        });
        append_to_search_result_table(stu_arr);
    }
}