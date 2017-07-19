'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释
//商品信息
const promotions = loadPromotions();
//打折信息
const allItems = loadAllItems();

function printReceipt(tags) {

    posV1(tags);

//     console.log(`***<没钱赚商店>收据***
// 名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
// 名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
// 名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
// ----------------------
// 总计：58.50(元)
// 节省：7.50(元)
// **********************`);

}

function posV1(tags){
    let itemsIdAndCountList = getItemsAndCount(tags);

    let itemsAndCountList = addItemsProperty(itemsIdAndCountList);

    itemsAndCountList = countItemsTotalPrice(itemsAndCountList);

    let totalPriceAndSavePrice = countTotalPriceAndSavePrice(itemsAndCountList);

    printResult(itemsAndCountList,totalPriceAndSavePrice);

}

function printResult(itemsAndCountList,totalPriceAndSavePriace) {
    let result = "";
    result += "***<没钱赚商店>收据***\r\n";
    for(let i = 0;i < itemsAndCountList.length;i++){
        result += "名称：" + itemsAndCountList[i].itemProperty.name
            + "，数量：" + itemsAndCountList[i].count + itemsAndCountList[i].itemProperty.unit
            +"，单价：" + itemsAndCountList[i].itemProperty.price.toFixed(2) + "(元)"
            +"，小计：" + itemsAndCountList[i].itemPrice.toFixed(2) + "(元)\r\n";
    }
    result += "----------------------\r\n";

    result += "总计：" + totalPriceAndSavePriace.totalPrice.toFixed(2) + "(元)\r\n";
    result += "节省：" + totalPriceAndSavePriace.savePrice.toFixed(2) + "(元)\r\n";

    result += "**********************";
    console.log(result);
}

function countTotalPriceAndSavePrice(itemsAndCountList) {
    let totalPrice = 0;
    let savePrice = 0;
    for(let i = 0;i < itemsAndCountList.length;i++){
        totalPrice += itemsAndCountList[i].itemPrice;
        savePrice += (itemsAndCountList[i].itemProperty.price *itemsAndCountList[i].count) -itemsAndCountList[i].itemPrice;
    }
    return {"totalPrice":totalPrice,"savePrice":savePrice};
}

function addItemsProperty(itemsIdAndCountList){
    for(let i = 0; i < itemsIdAndCountList.length; i++){
        itemsIdAndCountList[i].itemProperty = getOneItemsById(itemsIdAndCountList[i].itemId);
        itemsIdAndCountList[i].isDiscount = isDiscountById(itemsIdAndCountList[i].itemId);
    }
    return itemsIdAndCountList;
}

function getOneItemsById(Id) {
    for(let i = 0; i < allItems.length; i++){
        if(allItems[i].barcode === Id){
            return allItems[i];
        }
    }
}

function isDiscountById(Id){
    for(let i = 0 ;i < promotions[0].barcodes.length;i++){
        if(promotions[0].barcodes[i] === Id){
            return true;
        }
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


function countItemsTotalPrice(itemsAndCountList) {
    for(let i = 0; i < itemsAndCountList.length; i++){
        itemsAndCountList[i].itemPrice = getItemTotalPrice(itemsAndCountList[i]);
    }
    return itemsAndCountList;
}
//商品小计
function getItemTotalPrice(item){
    if(!item.isDiscount){
        return item.itemProperty.price*item.count;
    }
    return getDiscountItemTotalPrice(item);
}

function getDiscountItemTotalPrice(item){
    if(item.count >= 2){
        return item.itemProperty.price*(item.count-1);
    }
    return item.itemProperty.price*item.count;
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