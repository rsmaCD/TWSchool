'use strict';

module.exports = function countSameElements(collection) {

    var result = [];
    for(var i = 0;i < collection.length; i++){
        var keyAndNum = getkeyAndNum(collection[i]);
        if(!isExist(keyAndNum.key,result)){
            result.push({"key":keyAndNum.key,"count":0});
        }
    }


    for(var i = 0;i < collection.length; i++){
        var keyAndNum = getkeyAndNum(collection[i]);
        result = countAdd(result,keyAndNum.key,keyAndNum.Num);
    }

    return result;
}

function getkeyAndNum(element){

    if(element.indexOf('-') != -1){
        return {key:element.substring(0,element.indexOf('-')),Num:parseInt(element.substring(element.indexOf('-')+1,element.length))};
    }

    return {key:element,Num:1};
}


function isExist(element,collection){

    for(var i = 0; i < collection.length; i++){
        if(collection[i].key == element){
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
        if(collection[i].key == key){
            collection[i].count += num;
        }
    }
    return collection;
}

