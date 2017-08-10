/**
 * Created by rsma on 03/08/2017.
 */
$(function () {

    // $(".stu-navtive-place").citySelect({
    //     nodata:"none",
    //     required:false
    // });


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

function get_random_num(n){
    var rnd="";
    for(var i=0;i<n;i++)
        rnd+=Math.floor(Math.random()*10);
    return rnd;
}

function get_stu_info() {
    var form_data = $('#add-student-form').serializeArray();
    var values = {};
    for (x in form_data) {
        values[form_data[x].name] = form_data[x].value.trim();
    }
    var stu_id = get_random_num(10);
    values["stu_id"] = stu_id;
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
