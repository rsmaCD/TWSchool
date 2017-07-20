'use strict';

function printReceipt(tags) {


    console.log(`***<没钱赚商店>收据***
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`);

}



function calcTotalPriceAndTotalSaving(cartItemsInfo) {
    let totalPrice = 0;
    let totalSaving = 0;
    for(let i = 0; i < cartItemsInfo.length;i++){
        totalPrice += cartItemsInfo[i].itemPrice;
        totalSaving += (cartItemsInfo[i].itemProperty.price)*cartItemsInfo[i].count - cartItemsInfo[i].itemPrice;
    }
    return {"totalPrice":totalPrice,"totalSaving":totalSaving};
}



function calcCartItemsInfo(itemsAndCount) {
    let cartItemsInfo = [];
    let itemsProperty = buildItemsProperty(itemsAndCount);
    for(let i = 0;i < itemsProperty.length;i++){
        let count = getItemCountById(itemsProperty[i].barcode,itemsAndCount);
        cartItemsInfo[cartItemsInfo.length] = {"itemProperty":itemsProperty[i],"count":count
            ,"itemPrice":calcCartItemPrice(itemsProperty[i].price,count,itemsProperty[i].isDiscount)};
    }
    return cartItemsInfo;
}

function getItemCountById(itemId,itemsAndCount) {
    for(let i = 0; i < itemsAndCount.length;i++){
        if(itemsAndCount[i].itemId === itemId){
            return itemsAndCount[i].count;
        }
    }
}

function calcCartItemPrice(price,count,isDiscount) {
    if(isDiscount && count >= 3){
        return price*(count-1);
    }
    return price*count;
}


function buildItemsProperty(itemsAndCount) {
    let itemsProperty = [];
    for(let i = 0;i < itemsAndCount.length;i++){
        let item = getItemById(itemsAndCount[i].itemId);
        console.log("itemsAndCount[i].itemId"+itemsAndCount[i].itemId);
        let discount = isDiscount(itemsAndCount[i].itemId);
        itemsProperty[itemsProperty.length] = {"barcode":item.barcode,"name":item.name,
                "unit":item.unit,"price":item.price,"isDiscount":discount};
    }
    return itemsProperty;
}

function isDiscount(itemId){
    console.log("sadadwes");
    const promotions = Promotion.all();
    for(let i = 0 ;i < promotions[0].barcodes.length;i++){
        if(promotions[0].barcodes[i] === itemId){
            return true;
        }
    }
    return false;
}

function getItemById(itemId) {
    const items = Item.all();
    for(let i = 0;i < items.length;i++){
        if(items[i].barcode === itemId){
            return items[i];
        }
    }
}



function countItemsCount(tags) {
    let itemsAndCount = [];
    for(let i = 0; i < tags.length; i++){
        let itemAndCount = getOneTagItemAndCount(tags[i]);
        itemsAndCount = buildItemsAndCount(itemAndCount,itemsAndCount);
    }
    return itemsAndCount;
}


function getOneTagItemAndCount(tag) {
    let itemId = tag.split("-")[0];
    let count = parseFloat(tag.split("-")[1] || 1);
    return {"itemId":itemId,"count":count};
}

function buildItemsAndCount(itemAndCount,itemsAndCount){
    for(let i = 0; i < itemsAndCount.length;i++){
        if(itemsAndCount[i].itemId === itemAndCount.itemId){
            itemsAndCount[i].count += itemAndCount.count;
            return itemsAndCount;
        }
    }
    itemsAndCount[itemsAndCount.length] = itemAndCount;
    return itemsAndCount;
}