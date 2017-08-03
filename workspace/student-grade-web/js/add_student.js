/**
 * Created by rsma on 03/08/2017.
 */
$(function () {
    $("#add-student-form").submit(function () {
        event.preventDefault();
    });

    $("#add-student-form").validate({
        rules: {
            stu_name: {
                required: true
            },
            stu_email: {
                required: true,
                email: true
            },
            stu_phone_num: {
                required: true,
                maxlength: 11,
                minlength: 11
            },
            stu_id_card_num: {
                required: true,
                maxlength: 18,
                minlength: 18
            },
            stu_native_place: {
                required: true
            }
        },
        messages: {
            stu_name: "请输入名字",
            stu_email: {
                required: "请输入邮箱",
                email: "请输入正确的邮箱"
            },
            stu_id_card_num: {
                required: "请输入身份证号",
                maxlength: "请输入正确的身份证号",
                minlength: "请输入正确的身份证号"
            },
            stu_phone_num: {
                required: "请输入电话号码",
                maxlength: "请输入正确的电话号码",
                minlength: "请输入正确的电话号码"
            },
            stu_native_place: {
                required: "请选择籍贯"
            }
        },
        errorLabelContainer: ".err_msg",
        wrapper: "li",
        submitHandler: function (form) {
            if (localStorage.getItem('stu_info_list')) {
                var stu_info_list = JSON.parse(localStorage.getItem('stu_info_list'));
                stu_info_list.push(get_stu_info());
                localStorage.setItem("stu_info_list", JSON.stringify(stu_info_list));
            } else {
                var stu_info_list = [];
                stu_info_list.push(get_stu_info());
                localStorage.setItem("stu_info_list", JSON.stringify(stu_info_list));
            }

            show_success_msg();
            clean_input();
        }
    });

});

get_stu_info = function () {
    var form_data = $('#add-student-form').serializeArray();
    var values = {};
    for (x in form_data) {
        values[form_data[x].name] = form_data[x].value.trim();
    }
    return values;
};

show_success_msg = function () {
    $(".success_msg").css("visibility", "visible");
};

clean_input = function () {
    $("#add-student-form").trigger('reset');
}
