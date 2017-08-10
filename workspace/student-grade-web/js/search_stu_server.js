/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    show_all_stu();

    $("#search-id-button").click(function () {
        var stu_num = $("#stu_id").val().trim();
        search_stu(stu_num);
        $("#stu_name").val("");
    });


    // $("#search-name-button").click(function(){
    //     var stu_name = $("#stu_name").val().trim();
    //     search_stu("stu_name",stu_name);
    //     $("#stu_id").val("");
    // });

});



function find_stu_by_id(stu_id) {
    for(var i = 0;i < stu_data.length;i++){
        if(stu_data[i].id = stu_id){
            return stu_data[i];
        }
    }
};

function show_all_stu() {

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students",
        type: "GET",
        contentType: "application/json; charset=utf-8",
    }).then(function (data, status, jqxhr) {
        if (status == "success") {
            append_to_search_result_table(data);
        }
    });
};

function append_to_search_result_table(stu_info_list) {
    $('#search_result').html("");
    var search_result = {"data": stu_info_list};
    $('#search_result_template').tmpl(search_result).appendTo('#search_result');
};


function search_stu(stu_num) {

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students/" + stu_num,
        contentType: "application/json; charset=utf-8",
        type: 'GET',
        success: function (data, textStatus) {
            var stu_arr = [];
            stu_arr.push(data);
            append_to_search_result_table(stu_arr);
        },
        error: function () {
            $('#search_result').html("");
        }
    });

};