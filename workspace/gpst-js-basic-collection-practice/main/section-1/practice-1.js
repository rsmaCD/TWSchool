'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {

   let result =[];
   for(let i = 0; i < collectionA.length; i++){
     if(isExist(collectionA[i],collectionB)){
         result.push(collectionA[i]);
     }
   }
  return result;
};


function isExist(element,collection) {
    for(let i = 0; i < collection.length; i++){
        if(element === collection[i]) {
            return true;
        }
    }
    return false;
}