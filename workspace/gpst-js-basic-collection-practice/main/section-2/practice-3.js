'use strict';

module.exports = function countSameElements(collection) {
    var key = [];
    var value = [];
    for(var i = 0;i < collection.length;i++){
        var reg1 = '[A-Za-z]-[0-9]+';
        var reg2 = '[A-Za-z]\[[0-9]+\]';
        var reg3 = '[A-Za-z]\:[0-9]+';
        var temp_key ;
        var temp_value;
        if(collection[i].match(reg1)){
            temp_key = collection[i].split("-")[0];
            temp_value = collection[i].split("-")[1];
        }else if(collection[i].match(reg2)){
          temp_key = collection[i].split("[")[0];
          temp_value = collection[i].split("[")[1].split("]")[0];
        }else if(collection[i].match(reg3)){
          temp_key = collection[i].split(":")[0];
          temp_value = collection[i].split(":")[1];
        }else{
            temp_key = collection[i];
            temp_value = 1;
        }

        var flag = -1;
        for(var j = 0; j < key.length; j++){

            if(temp_key == key[j]) {
                flag = j;
                break;

            }
        }
        if(flag != -1){
            value[flag] += parseInt(temp_value);

        }else{
            key[key.length] = temp_key;
            value[key.length-1] = parseInt(temp_value);
        }


    }

    var result = [];
    for(var i = 0;i < key.length; i++){
        result.push({"name":key[i],"summary":value[i]});

    }

    return result;
}
