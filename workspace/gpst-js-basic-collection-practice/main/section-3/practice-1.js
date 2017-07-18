'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {

  for(var i = 1; i < collectionA.length; i++){
    for(var j = i; j < objectB.value.length;j++){
      console.log("1.-----------------");
      console.log(collectionA[i].key);
      console.log(objectB.value[j]);

      if(collectionA[i].key == objectB.value[j]){
        console.log("!!!!!!!");
        collectionA[i].count --;
      }
    }
  }

  return collectionA;


}
