'use strict';

module.exports = function countSameElements(collection) {

    var result = [];
    for(var i = 0;i < collection.length; i++){
        var keyAndNum = getkeyAndNum(collection[i]);
        if(!isExist(keyAndNum.key,result)){
            result.push({"name":keyAndNum.key,"summary":0});
        }
    }


    for(var i = 0;i < collection.length; i++){
        var keyAndNum = getkeyAndNum(collection[i]);
        result = countAdd(result,keyAndNum.key,keyAndNum.Num);
    }

    return result;
}

function getkeyAndNum(element){

    // if(element.indexOf('-') != -1){
    //     return {key:element.substring(0,element.indexOf('-')),Num:parseInt(element.substring(element.indexOf('-')+1,element.length))};
    // }else if(element.indexOf(":") != -1){
    //     return {key:element.substring(0,element.indexOf(':')),Num:parseInt(element.substring(element.indexOf(':')+1,element.length))};
    // }else if(element.indexOf("[") != -1){
    //     return {key:element.substring(0,element.indexOf('[')),Num:parseInt(element.substring(element.indexOf('[')+1,element.length-1))}
    // }
    //
    // return {key:element,Num:1};
    var reg_key = '[A-Za-z]';
    var reg_num = '[0-9]+';
    


}


function isExist(element,collection){

    for(var i = 0; i < collection.length; i++){
        if(collection[i].name == element){
            return true;
        }
    }
    return false;
    // console.log("-----------collection");
    // console.log(collection);
    // console.log(element);
    // if(typeof collection[element] == "undefined"){
    //     return false;
    // }
    // return true;
}

function countAdd(collection,key,num) {

    for(var i = 0; i < collection.length; i++){
        if(collection[i].name == key){
            collection[i].summary += num;
        }
    }
    return collection;
}

