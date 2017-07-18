'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {

  var collectionB_array = collectionB[0];
    var result =[];
    for(var i = 0; i < collectionA.length; i++){
        for(var j = 0; j < collectionB_array.length; j++){
            if(collectionA[i] == collectionB_array[j]){

                result.push(collectionA[i]);
            }
        }
    }

    return result;

}
