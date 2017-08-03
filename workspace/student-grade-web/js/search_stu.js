/**
 * Created by rsma on 03/08/2017.
 */
$(function () {
    if (localStorage.getItem('stu_info_list')) {
        var stu_info_list = jQuery.parseJSON(localStorage.getItem('stu_info_list'));
        var search_result = {"data": stu_info_list};
        $('#search_result_template').tmpl(search_result).appendTo('#search_result');
    }
});