'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释
//商品信息
const promotions = loadPromotions();
//打折信息
const allItems = loadAllItems();

function printReceipt(tags) {

    posV1(tags);

    console.log(`***<没钱赚商店>收据***
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`)
}

function posV1(tags){
    let itemsAndCountList = getItemsAndCount(tags);

    //itemsAndCountList = disCount(itemsAndCountList);

};


function getOneItemsById(ID) {
    for(let i = 0; i < allItems.length; i++){
        if(allItems[i].barcode === ID){
            return allItems[i];
        }
    }
}

function isDiscountById(ID){
    if(typeof promotions[ID]){
        return true;
    }
    return false;
}

function getItemsAndCount(tags) {

    let itemsAndCountList = [];
    for(let i = 0; i < tags.length; i++){
        let ItemAndCount = getOneItemAndCount(tags[i]);
        itemsAndCountList = pushItemAndCount(itemsAndCountList,ItemAndCount.itemId,ItemAndCount.count);
    }
    return itemsAndCountList;
}


function disCount(itemsAndCountList) {
    for(let i = 0; i < itemsAndCountList.length; i++){
        itemsAndCountList[i].itemPriace = getItemTotalPrice(itemsAndCountList[i].item,itemsAndCountList[i].count);
    }
    return itemsAndCountList;
}
//商品小计
function getItemTotalPrice(itemId,itemCount){
    if(!isDiscountById(itemId)){
        return (getOneItemsById(itemId).price)*itemCount;
    }
    return getDiscountItemTotalPrice(itemId,itemCount);
}

function getDiscountItemTotalPrice(itemId,itemCount){
    let disCountNum = itemCount/3;
    return (getOneItemsById(itemId).price)*(itemCount-disCountNum);
}


function getOneItemAndCount(tags){
    if(tags.indexOf('-') === -1){
        return {itemId:tags,count:1};
    }
    //处理特殊情况
    return getItemAndCountSp(tags);
}

function getItemAndCountSp(tags) {
    return {itemId:tags.substring(0,tags.indexOf('-')),count:parseFloat(tags.substring(tags.indexOf('-')+1,tags.length))};
}


function pushItemAndCount(itemsAndCountList,itemId,count) {
    for(let i = 0; i < itemsAndCountList.length; i++){
        if(itemsAndCountList[i].itemId === itemId){
            itemsAndCountList[i].count += count;
            return itemsAndCountList;
        }
    }
    itemsAndCountList[itemsAndCountList.length] = {itemId:itemId,count:count};
    return itemsAndCountList;
}