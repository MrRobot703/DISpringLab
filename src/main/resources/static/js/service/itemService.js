class Item {
    constructor(id, name, price, description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    static getMockItems(n) {
        let items = []
        for (let i = 1; i < n + 1; i++)
            items.push(new this(i, "name" + i, i + 0.99, "description" + i));
        return items;
    }

    static getAllItemsPromise() {
        return get("/getAllItems");
    }

    static addItemPromise(item) {
        return post("/saveItem", item);
    }

    static deleteItemByNamePromise(item) {
        return post("/deleteItem", item);
    }

    static editItemPromise(item) {
        return post("/updateItem", item);
    }

    static addItemToCart(item) {
        return post("/addItemToCart", item);
    }

    static removeItemFromCart(item) {
        return post("/removeItemFromCart", item);
    }

    static getItemsInCart() {
        return get("/getItemsInCart");
    }
}

function post(url, object) {
    return fetch(url, {
                           method: 'POST',
                           headers: {
                               'Content-Type': 'application/json;charset=utf-8',
                               [csrfToken.headerName]: [csrfToken.token]
                           },
                           body: JSON.stringify(object)
                       }).then(response => handle(response));
}

function get(url) {
     return fetch(url, {
             method: 'GET',
             headers: {
                 'Accept': 'application/json;charset=utf-8'
             }
         }).then(responce => responce.json());
}

function handle(text) {
    console.log(text);
}