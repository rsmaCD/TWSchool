'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {

  var result = collectionA;
  for(var i = 0; i < result.length; i++){
      if(isExist(result[i].key,objectB.value)){
          result[i].count--;
      }
  }
  return result;
}

function isExist(element,collection) {
    for(var i = 0; i < collection.length;i++) {
        if (element == collection[i]) {
            return true;
        }
    }
    return false;
}