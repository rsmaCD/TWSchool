'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {

   var result =[];
   for(var i = 0; i < collectionA.length; i++){
     for(var j = 0; j < collectionB.length; j++){
       if(collectionA[i] == collectionB[j]){

         result.push(collectionA[i]);
       }
     }
   }

  return result;
}
