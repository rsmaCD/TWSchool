'use strict';

describe('pos', () => {

  it('should print text', () => {

    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];

    const dateDigitToString = num => (num < 10 ? `0${num}` : num);

    spyOn(console, 'log');

    printReceipt(tags);

    const currentDate = new Date(),
      year = dateDigitToString(currentDate.getFullYear()),
      month = dateDigitToString(currentDate.getMonth() + 1),
      date = dateDigitToString(currentDate.getDate()),
      hour = dateDigitToString(currentDate.getHours()),
      minute = dateDigitToString(currentDate.getMinutes()),
      second = dateDigitToString(currentDate.getSeconds()),
      formattedDateString = `${year}年${month}月${date}日 ${hour}:${minute}:${second}`;

    const expectText = `***<没钱赚商店>收据***
打印时间：${formattedDateString}
----------------------
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    expect(console.log).toHaveBeenCalledWith(expectText);
  });
});


describe('getOneTagItemAndCount', () => {

    it('should print text', () => {

        const tag = 'ITEM000003-2.5';
        const getOneItemAndCountExpectText = {"itemId":'ITEM000003',"count":2.5};
        const oneItemAndCount = getOneTagItemAndCount(tag);
        expect(oneItemAndCount).toEqual(getOneItemAndCountExpectText);
    });

    it('should print text', () => {

        const tag = 'ITEM000003';
        const getOneItemAndCountExpectText = {"itemId":'ITEM000003',"count":1};
        const oneItemAndCount = getOneTagItemAndCount(tag);
        expect(oneItemAndCount).toEqual(getOneItemAndCountExpectText);
    });
});

describe('buildItemsAndCount', () => {

    it('should print text', () => {

        const itemAndCount = {"itemId":'ITEM000005',"count":3};
        const buildItemsAndCountExpectText = [{"itemId":'ITEM000003',"count":2.5},{"itemId":'ITEM000001',"count":1},{"itemId":'ITEM000005',"count":3}];
        const itemsAndCount = buildItemsAndCount(itemAndCount,[{"itemId":'ITEM000003',"count":2.5},{"itemId":'ITEM000001',"count":1}]);
        expect(itemsAndCount).toEqual(buildItemsAndCountExpectText);
    });
});

describe('countItemsCount', () => {

    it('should print text', () => {

        const tags = [
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000003-2.5',
            'ITEM000005',
            'ITEM000005-2',
        ];
        const countItemsCountExpectText = [{"itemId":'ITEM000001',"count":5},
            {"itemId":'ITEM000003',"count":2.5},{"itemId":'ITEM000005',"count":3}];
        const itemsAndCount = countItemsCount(tags);
        expect(itemsAndCount).toEqual(countItemsCountExpectText);
    });
});

describe('buildItemsProperty', () => {

    it('should print text', () => {

        const itemsAndCount = [{"itemId":'ITEM000000',"count":5}];
        const buildItemsPropertyExpectText = [{"barcode":'ITEM000000',"name":'可口可乐',"unit":'瓶',"price":3.00,"isDiscount":true}];
        const itemsProperty = buildItemsProperty(itemsAndCount);
        expect(itemsProperty).toEqual(buildItemsPropertyExpectText);
    });
});

describe('calcCartItemsInfo', () => {

    it('should print text', () => {

        const itemsAndCount = [{"itemId":'ITEM000000',"count":5}];
        const calcCartItemsInfoExpectText = [{"itemProperty":{ "barcode": 'ITEM000000', "name": '可口可乐', "unit": '瓶', "price": 3, "isDiscount": true }, "count": 5, "itemPrice": 12}];
        const cartItemsInfo = calcCartItemsInfo(itemsAndCount);
        expect(cartItemsInfo).toEqual(calcCartItemsInfoExpectText);
    });
});