'use strict';

function HashMap(){

    var length = 0;

    var obj = new Object();

    this.isEmpty = function(){
        return length == 0;
    };

    this.containsKey = function(key){
        return (key in obj);
    };

    this.put = function(key,value){
        if(!this.containsKey(key)){
            length ++;
        }
        obj[key] += value;
    };

    this.get = function(key){
        return this.containsKey(key)?obj[key]:null;
    };

    this.toArray = function(){
      var array = [];
      if(this.isEmpty()){
        return array;
      }

      for(var i = 0;i < this.length;i++){
        array.push(this[i]);
      }
      return array;
    }
}

module.exports = function countSameElements(collection) {

  var hashMap = HashMap();
  for(var i = 0;i < collection.length;i++){
    hashMap.put(collection[i],1);
  }

   return hashMap.toArray();
}
