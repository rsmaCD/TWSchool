/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    $("#add-student-form").submit(function () {
        event.preventDefault();
    });

    $("#add-student-form").validate({
        rules: {
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            phoneNum: {
                required: true,
                maxlength: 11,
                minlength: 11
            },
            idCardNum: {
                required: true,
                maxlength: 18,
                minlength: 18
            },
            nativePlace: {
                required: true
            }
        },
        messages: {
            name: "请输入名字",
            email: {
                required: "请输入邮箱",
                email: "请输入正确的邮箱"
            },
            idCardNum: {
                required: "请输入身份证号",
                maxlength: "请输入正确的身份证号",
                minlength: "请输入正确的身份证号"
            },
            phoneNum: {
                required: "请输入电话号码",
                maxlength: "请输入正确的电话号码",
                minlength: "请输入正确的电话号码"
            },
            nativePlace: {
                required: "请选择籍贯"
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
                url: "http://localhost:8080/students",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(get_stu_info()),
                success: function (data, textStatus) {
                    console.log(data);
                    console.log(status);
                    show_success_msg();
                    clean_input();
                },
                error: function () {
                    show_failed_msg();
                }
            });
        }
    });

});


function get_stu_info() {
    var form_data = $('#add-student-form').serializeArray();
    var values = {};
    for (x in form_data) {
        values[form_data[x].name] = form_data[x].value.trim();
    }
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
    $("#add-student-form").trigger('reset');
}
