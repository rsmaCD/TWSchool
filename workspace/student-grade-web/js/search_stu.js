/**
 * Created by rsma on 03/08/2017.
 */
$(function () {
    show_all_stu();

    $("#search-id-button").click(function(){
        var stu_num = $("#stu_id").val().trim();
        if(localStorage.getItem('stu_info_list') && stu_num != ""){
            var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
            var stu_arr = [];
            $.each(stu_info_list, function(i,stu){
                if(stu.stu_id == stu_num){
                    stu_arr.push(stu);
                }
            });
            remove_student_from_result_table();
            append_to_search_result_table(stu_arr);
        }

    });

    $("#search-name-button").click(function(){
        var stu_name = $("#stu_name").val().trim();
        if(localStorage.getItem('stu_info_list') && stu_name != ""){
            var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
            var stu_arr = [];
            $.each(stu_info_list, function(i,stu){
                if(stu.stu_name == stu_name){
                    stu_arr.push(stu);
                }
            });
            remove_student_from_result_table();
            append_to_search_result_table(stu_arr);
        }

    });

});

show_all_stu = function () {
    if (localStorage.getItem('stu_info_list')) {
        var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
        remove_student_from_result_table();
        append_to_search_result_table(stu_info_list);
    }
};

append_to_search_result_table = function (stu_info_list) {
    var search_result = {"data": stu_info_list};
    $('#search_result_template').tmpl(search_result).appendTo('#search_result');
};

remove_student_from_result_table = function () {
    $('#search_result').html("");
}