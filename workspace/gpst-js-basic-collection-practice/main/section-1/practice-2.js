'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {

    var collectionB_array = collectionB[0];
    var result =[];
    for(var i = 0; i < collectionA.length; i++){
        if(isExist(collectionA[i],collectionB_array)){
            result.push(collectionA[i]);
        }
    }
    return result;
}

function isExist(element,collection) {
    for(var i = 0; i < collection.length; i++){
        if(element == collection[i]) {
            return true;
        }
    }
    return false;
}