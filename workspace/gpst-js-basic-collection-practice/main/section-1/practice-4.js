'use strict';

module.exports = function collectSameElements(collectionA, objectB) {

    var collectionA_array = getCollectionValue(collectionA);
    var collectionB_array = objectB.value;
    var result =[];
    for(var i = 0; i < collectionA_array.length; i++) {
        if (isExist(collectionA_array[i], collectionB_array)) {
            result.push(collectionA_array[i]);
        }
    }
    return result;
}

function getCollectionValue(collection) {
    var collection_array = [];
    for(var i = 0;i < collection.length; i++) {
        collection_array.push(collection[i].key);
    }
    return collection_array;
}


function isExist(element,collection) {
    for(var i = 0; i < collection.length; i++){
        if(element == collection[i]) {
            return true;
        }
    }
    return false;
}