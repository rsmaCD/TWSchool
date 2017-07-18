'use strict';

module.exports = function countSameElements(collection) {

  var key = [];
  var value = [];
  for(var i = 0;i < collection.length;i++){
    var flag = -1;
    for(var j = 0; j < key.length; j++){

      if(collection[i] == key[j]) {
          flag = j;
          break;

      }
    }
    if(flag != -1){
          value[flag] += 1;

    }else{
          key[key.length] = collection[i];
          value[key.length-1] = 1;
    }


  }

  var result = [];
  for(var i = 0;i < key.length; i++){
    result.push({"key":key[i],"count":value[i]});
  }

   return result;
}
