'use strict';

module.exports = function countSameElements(collection) {

    var result = [];
    for(var i = 0;i < collection.length; i++){
        if(!isExist(collection[i],result)){
            result.push({"key":collection[i],"count":0});
        }
    }

    for(var i = 0;i < collection.length; i++){
        if(isExist(collection[i],result)){
            result = countAdd(result,collection[i],1);
        }

    }

    return result;
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

