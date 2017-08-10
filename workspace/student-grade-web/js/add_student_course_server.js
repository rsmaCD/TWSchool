"use strict";
/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    show_stu_score()

    $("#add-student-course-form").submit(function () {
        event.preventDefault();
    });

    $("#add-student-course-form").validate({
        rules: {
            math: {
                required: true,
                number: true
            },
            english: {
                required: true,
                number: true
            },
            program: {
                required: true,
                number: true
            },
            language: {
                required: true,
                number: true
            }
        },
        messages: {
            math: {
                required: "请输入数学成绩",
                number: "请输入正确的数学成绩"
            },
            english: {
                required: "请输入英语成绩",
                number: "请输入正确的英语成绩"
            },
            program: {
                required: "请输入编程成绩",
                number: "请输入正确的编程成绩"
            },
            language: {
                required: "请输入语文成绩",
                number: "请输入正确的语文成绩"
            }
        },
        errorLabelContainer: ".err_msg",
        wrapper: "li",
        submitHandler: function (form) {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "http://localhost:8080/students/" + stu_id + "/courses",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(get_course_info()),
                success: function (data, textStatus) {
                    console.log(data);
                    console.log(status);
                    show_success_msg();
                },
                error: function () {
                    show_failed_msg();
                }
            });
        }
    });

});

var stu_id = getUrlParam("id");

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    } else {
        return null;
    }
}

function append_score_to_form(course) {

        $("#math").val(course.find(course => course.courseName === "math").courseScore);
        $("#language").val(course.find(course => course.courseName === "language").courseScore);
        $("#english").val(course.find(course => course.courseName === "english").courseScore);
        $("#program").val(course.find(course => course.courseName === "program").courseScore);
}

function show_stu_score() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students/" + stu_id,
        contentType: "application/json; charset=utf-8",
        type: 'GET',
        success: function (data, textStatus) {
            console.log(data.courseList);
            if(data.courseList.length != 0){
                append_score_to_form(data.courseList);
            }
        },
        error: function () {

        }
    });
};

function get_course_info() {
    var form_data = $('#add-student-course-form').serializeArray();
    var values = [];
    $.each(form_data, function (i, field) {
        var value = {};
        value["courseName"] = field.name;
        value["courseScore"] = field.value.trim();
        values.push(value);
    });
    return values;
};

function show_success_msg() {
    $(".success_msg").css("visibility", "visible");
    $(".failed_msg").css("visibility", "hidden");
};

function show_failed_msg() {
    $(".failed_msg").css("visibility", "visible");
    $(".success_msg").css("visibility", "hidden");
};

function clean_input() {
    $("#add-student-course-form").trigger('reset');
};


