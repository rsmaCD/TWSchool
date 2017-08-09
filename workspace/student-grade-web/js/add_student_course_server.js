/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    $("#add-student-course-form").submit(function () {
        event.preventDefault();
    });

    $("#add-student-course-form").validate({
        rules: {
            math: {
                required: true,
                number:true
            },
            english: {
                required: true,
                number:true
            },
            program: {
                required: true,
                number:true
            },
            language: {
                required: true,
                number:true
            }
        },
        messages: {
            math: {
                required: "请输入数学成绩",
                number:"请输入正确的数学成绩"
            },
            english: {
                required: "请输入英语成绩",
                number:"请输入正确的英语成绩"
            },
            program: {
                required: "请输入编程成绩",
                number:"请输入正确的编程成绩"
            },
            language: {
                required: "请输入语文成绩",
                number:"请输入正确的语文成绩"
            }
        },
        errorLabelContainer: ".err_msg",
        wrapper: "li",
        submitHandler: function (form) {
            var id = getUrlParam("id");
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "http://localhost:8080/students/" + id + "/courses",
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

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }else{
        return null;
    }
}

get_course_info = function () {
    var form_data = $('#add-student-course-form').serializeArray();
    var values = [];
    for (x in form_data) {
        var value = {};
        value["courseName"] = form_data[x].name;
        value["courseScore"] = form_data[x].value.trim();
        values.push(value);
    }
    return values;
};

show_success_msg = function () {
    $(".success_msg").css("visibility", "visible");
};

show_failed_msg = function () {
    $(".failed_msg").css("visibility", "visible");
};

clean_input = function () {
    $("#add-student-course-form").trigger('reset');
}
