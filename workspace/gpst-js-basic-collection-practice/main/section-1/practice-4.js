'use strict';

module.exports = function collectSameElements(collectionA, objectB) {

   var collectionA_value = [];
   for(var i = 0;i < collectionA.length; i++){
      collectionA_value.push(collectionA[i].key);
   }
   

    var collectionB_array = objectB.value;
    var result =[];
    for(var i = 0; i < collectionA_value.length; i++){
        for(var j = 0; j < collectionB_array.length; j++){
            if(collectionA_value[i] == collectionB_array[j]){

                result.push(collectionA_value[i]);
            }
        }
    }

    return result;
}
